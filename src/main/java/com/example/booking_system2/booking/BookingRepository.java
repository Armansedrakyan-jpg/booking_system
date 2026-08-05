package com.example.booking_system2.booking;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookingRepository extends JpaRepository<Booking, UUID> {
         boolean existsByBookableIdAndBookingStatus(UUID bookableId, BookingStatus bookingStatus);

     }
