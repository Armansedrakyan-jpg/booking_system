package com.example.booking_system2.handler;

import com.example.booking_system2.booking.Booking;
import com.example.booking_system2.exceptions.BookingBalanceException;
import com.example.booking_system2.exceptions.BookingConflictException;
import com.example.booking_system2.exceptions.BookingStatusException;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
     private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

     @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handlerException(Exception e){
         log.error("Handler exception" , e);
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                  .body(e.getMessage());
     }

    @ExceptionHandler(EntityNotFoundException.class)
     public ResponseEntity<String > handlerNotFoundEntityException(EntityNotFoundException e){

         log.error("Handler EntityNotFoundException",e);
           return ResponseEntity.status(HttpStatus.NOT_FOUND)
                   .body(e.getMessage());
    }
    @ExceptionHandler({IllegalArgumentException.class,
            IllegalStateException.class,
             MethodArgumentNotValidException.class })
     public  ResponseEntity<String> handlerIllegalArgument(Exception e){

         log.error("Handler IllegalArgument", e);
           return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                   .body(e.getMessage());
    }
    @ExceptionHandler(BookingConflictException.class)
     public ResponseEntity<String> handlerBookingConflict(BookingConflictException e){

         log.error("Handle conflict", e);
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(e.getMessage());
    }
    @ExceptionHandler(BookingStatusException.class)
     public ResponseEntity<String> handlerStatusConflicts(BookingStatusException e){

         log.error("Handle status conflict", e);
           return ResponseEntity.status(HttpStatus.CONFLICT)
                   .body(e.getMessage());
    }
    @ExceptionHandler(BookingBalanceException.class)
     public ResponseEntity<String> handlerBalance(BookingBalanceException e){

         log.error("Handle balance exception", e);
           return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                   .body(e.getMessage());

    }

}
