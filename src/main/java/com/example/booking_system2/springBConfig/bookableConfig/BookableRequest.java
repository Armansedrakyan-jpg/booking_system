package com.example.booking_system2.springBConfig.bookableConfig;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record BookableRequest(
        @NotBlank
       String type,
       boolean hasBaggage,
       boolean withPet
) {
}
