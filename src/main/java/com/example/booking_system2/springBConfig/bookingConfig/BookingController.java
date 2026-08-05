package com.example.booking_system2.springBConfig.bookingConfig;


import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("/booking")
public class BookingController {

    private static final Logger log = LoggerFactory.getLogger(BookingController.class);
    private final BookingService bookingService;


    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }


    @GetMapping()
    public ResponseEntity<List<BookingResponse>> getAllBooking(
    ) {
        log.info("Called getAllBooking");
        return ResponseEntity.ok(bookingService.getAllBooking());
    }
    @PostMapping
     public ResponseEntity<BookingResponse> createBooking(
             @RequestBody @Valid BookingRequest bookingToCreate
    ){
         log.info("Called bookingToCreate");

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(bookingService.createBooking(bookingToCreate));
    }
    @GetMapping("/{id}")
     public ResponseEntity<BookingResponse> getBookingById(
          @PathVariable("id") UUID id
    ){
         log.info("Called getBookingById:" + id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(bookingService.getBookingById(id));
    }
    @DeleteMapping("/{id}")
      public ResponseEntity<Void> deleteBooking(
         @PathVariable("id") UUID id
    ){
        try {
             bookingService.cancelBooking(id);
            log.info("Called deleteBooking id = " + id);
            return ResponseEntity.ok().build();
        }catch (NoSuchElementException e){
            return ResponseEntity.status(404).build();
        }

    }
}

