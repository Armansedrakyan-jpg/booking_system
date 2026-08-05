package com.example.booking_system2.springBConfig.bookingConfig;

import com.example.booking_system2.booking.BookingStatus;

import java.time.LocalDate;
import java.util.UUID;

public record BookingResponse(
        UUID bookableId,
        int totalPriceOfTicket,
        LocalDate createdAt,
        UUID userId,
        BookingStatus bookingStatus,
        UUID id
) {
}
