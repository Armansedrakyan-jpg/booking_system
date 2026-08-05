package com.example.booking_system2.springBConfig.bookingConfig;

import com.example.booking_system2.exceptions.BookingBalanceException;
import com.example.booking_system2.exceptions.BookingConflictException;
import com.example.booking_system2.bookable.Bookable;
import com.example.booking_system2.bookable.BookableRepository;
import com.example.booking_system2.booking.Booking;
import com.example.booking_system2.booking.BookingRepository;
import com.example.booking_system2.booking.BookingStatus;
import com.example.booking_system2.users.User;
import com.example.booking_system2.users.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookingService {
   private final    BookableRepository bookableRepository;
   private final BookingRepository bookingRepository;
   private final UserRepository userRepository;

    public BookingService(BookableRepository bookableRepository, BookingRepository bookingRepository, UserRepository userRepository) {
        this.bookableRepository = bookableRepository;
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
    }

    public List<BookingResponse> getAllBooking() {
        List<Booking> allEntities= bookingRepository.findAll();
        List<BookingResponse> bookingList = new ArrayList<>();
        for (Booking b : allEntities) {
           bookingList.add(toDomainBooking(b));
        }
        return bookingList;
    }

    public BookingResponse createBooking(BookingRequest bookingToCreate) {

       if(bookingToCreate.userId() == null){
            throw new IllegalArgumentException("userId is required ");
       }
         if (bookingToCreate.bookableId() == null){
             throw new IllegalArgumentException("bookableId is required ");
         }

        Bookable bookable = bookableRepository.findById(bookingToCreate.bookableId())
                .orElseThrow(() -> new EntityNotFoundException(" bookable not found by" + bookingToCreate.bookableId()));

        User user = userRepository.findById(bookingToCreate.userId())
                .orElseThrow(() -> new EntityNotFoundException("userId not found by" + bookingToCreate.userId()));


        if (bookingRepository.existsByBookableIdAndBookingStatus(bookingToCreate.bookableId(), BookingStatus.ACTIVE)){
            throw new BookingConflictException("entity already use");
        }

        Booking booking = new Booking(bookingToCreate.bookableId(), bookingToCreate.userId());
        booking.setTotalPriceOfTicket(bookable.calculatePrice());
        int price =  user.privilege(booking.getTotalPriceOfTicket());
        booking.setTotalPriceOfTicket(price);
        if(user.getBalance() < price){
            throw new BookingBalanceException("Insufficient funds");
        }
         Booking savedEntity = bookingRepository.save(booking);
          return toDomainBooking(savedEntity);
    }


    public BookingResponse getBookingById(UUID id) {
        Optional<Booking> bookingEntity = bookingRepository.findById(id);
         if(bookingEntity.isEmpty()){
              throw new EntityNotFoundException("entity is not found by id: " + id);
         }
          return toDomainBooking(bookingEntity.get());
    }

    public void cancelBooking(UUID id) {
      Booking booking = bookingRepository.findById(id)
              .orElseThrow(() ->  new EntityNotFoundException("not found entity"));
       booking.cancel();
        bookingRepository.save(booking);
       }



     private BookingResponse toDomainBooking(
             Booking booking
     ){
        return new BookingResponse(
             booking.getBookableId(),
             booking.getTotalPriceOfTicket(),
             booking.getCreatedAt(),
             booking.getUserId(),
             booking.getBookingStatus(),
             booking.getId()
        );
     }

}

