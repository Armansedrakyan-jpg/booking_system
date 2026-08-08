package com.example.booking_system2.booking;

import com.example.booking_system2.exceptions.BookingStatusException;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "bookings")
public class Booking {
    @Column(name = "bookableId")
    UUID bookableId;
    @Column(name = "total_price_of_ticket")
    int totalPriceOfTicket;
    @Column(name = "create_at")
    LocalDate createdAt;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    UUID  id ;
    @Column(name = "user_id")
    UUID userId;

    public UUID getUserId() {
        return userId;
    }

    public  Booking(){
     }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public UUID getId() {
        return id;
    }
    BookingStatus bookingStatus;
    public Booking(UUID bookableId, UUID userId) {
        this.bookableId = bookableId;
        this.userId = userId;
        this.bookingStatus = BookingStatus.ACTIVE;
        this.createdAt = LocalDate.now();
    }
    public void setBookable(UUID bookableId) {
        this.bookableId = bookableId;
    }

    public void setTotalPriceOfTicket(int totalPriceOfTicket) {
        this.totalPriceOfTicket = totalPriceOfTicket;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setUser(UUID userId) {
        this.userId = userId;
    }


    public UUID getBookableId() {
        return bookableId;
    }
    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }


    public LocalDate getCreatedAt(){
        return createdAt;
    }


     public void cancel(){
        if(bookingStatus == BookingStatus.ACTIVE){
            bookingStatus = BookingStatus.CANCELLED;
        }
        else {
            throw new BookingStatusException("operation is not found");
        }
        }



    public int getTotalPriceOfTicket() {
        return totalPriceOfTicket;
    }
}

