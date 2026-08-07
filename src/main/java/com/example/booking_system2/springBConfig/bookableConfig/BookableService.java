package com.example.booking_system2.springBConfig.bookableConfig;

import com.example.booking_system2.bookable.*;
import com.example.booking_system2.exceptions.BookingConflictException;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookableService {
    private static final Logger log = LoggerFactory.getLogger(BookableService.class);
    private final BookableRepository bookableRepository;

    public BookableService(BookableRepository bookableRepository) {
        this.bookableRepository = bookableRepository;
    }

    public BookableResponse createBookable(BookableRequest bookableToCreate) {
        if (bookableToCreate.type().equals("Eco_class")) {
            EcoClass ecoClass = new EcoClass();
            ecoClass.setHasBaggage(bookableToCreate.hasBaggage());
            ecoClass.setWithPet(bookableToCreate.withPet());
            Bookable savedBookable = bookableRepository.save(ecoClass);

            return new BookableResponse(
                    savedBookable.isHasBaggage(),
                    savedBookable.isWithPet(),
                    savedBookable.getBookableId()
            );

        } else if (bookableToCreate.type().equals("Business_class")) {
            BusinessClass businessClass = new BusinessClass();
            businessClass.setHasBaggage(bookableToCreate.hasBaggage());
            businessClass.setWithPet(bookableToCreate.withPet());
            Bookable savedBookable1 = bookableRepository.save(businessClass);
            return new BookableResponse(
                    savedBookable1.isHasBaggage(),
                    savedBookable1.isWithPet(),
                    savedBookable1.getBookableId()
            );
        } else if (bookableToCreate.type().equals("Premium_class")) {
            PremiumClass premiumClass = new PremiumClass();
            premiumClass.setHasBaggage(bookableToCreate.hasBaggage());
            premiumClass.setWithPet(bookableToCreate.withPet());
            Bookable savedBookable2 = bookableRepository.save(premiumClass);
            return new BookableResponse(
                    savedBookable2.isHasBaggage(),
                    savedBookable2.isWithPet(),
                    savedBookable2.getBookableId()
            );
        }
        throw new EntityNotFoundException("not found bookable");
    }
    public List<BookableResponse> getAllBookables() {
        List<Bookable> allBookables = bookableRepository.findAll();
        List<BookableResponse> result = new ArrayList<>();
        for (Bookable b : allBookables) {
            result.add(new BookableResponse(
                    b.isHasBaggage(),
                    b.isWithPet(),
                    b.getBookableId()
            ));
        }
        return result;
    }
    }
