package com.example.booking_system2.bookable;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookableRepository extends JpaRepository<Bookable, UUID> {
}
