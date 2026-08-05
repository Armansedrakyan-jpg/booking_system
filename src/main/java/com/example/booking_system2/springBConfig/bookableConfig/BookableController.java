package com.example.booking_system2.springBConfig.bookableConfig;


import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/bookable")
public class BookableController {
     private final Logger log = LoggerFactory.getLogger(BookableController.class);
     private final BookableService bookableService;

    public BookableController(BookableService bookableService) {
        this.bookableService = bookableService;
    }
     @PostMapping
     public ResponseEntity<BookableResponse> createBookable(
             @RequestBody @Valid  BookableRequest bookableToCreate
     ){
          log.info("Called to createBookable");
           return ResponseEntity.status(HttpStatus.CREATED)
                   .body(bookableService.createBookable(bookableToCreate));
     }

}
