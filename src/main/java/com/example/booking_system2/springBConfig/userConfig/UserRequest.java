package com.example.booking_system2.springBConfig.userConfig;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record UserRequest(
        @NotBlank
        String typeOfPerson,
        @PositiveOrZero
        int balance,
        @Email
        @NotBlank
        String email
        ) {
}
