package com.example.booking_system2.springBConfig.bookingConfig;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.UUID;

public record BookingRequest(
        @NotNull
        UUID userId,
        @NotNull
        UUID bookableId
) {
}
