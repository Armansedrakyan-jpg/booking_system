package com.example.booking_system2.springBConfig.userConfig;

import java.util.UUID;

public record UserResponse(
        UUID userId,
        String email,
        int countBooking,
        int balance
){

}
