package com.example.booking_system2.springBConfig.bookableConfig;

import java.util.UUID;

public record BookableResponse(
        boolean hasBaggage,
        boolean withPet,
        UUID bookableId
) {

}
