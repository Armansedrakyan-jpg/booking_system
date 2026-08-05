package com.example.booking_system2.bookable;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "bookable")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "bookable_type")

public abstract class Bookable {
    @Column(name = "has_baggage")
      protected boolean hasBaggage;
    @Column(name = "with_pet")
      protected boolean withPet;
      @Id
      @GeneratedValue(strategy = GenerationType.UUID)
      @Column(name = "bookable_id")
      protected UUID bookableId;

    public boolean isHasBaggage() {
        return hasBaggage;
    }

    public void setHasBaggage(boolean hasBaggage) {
        this.hasBaggage = hasBaggage;
    }

    public boolean isWithPet() {
        return withPet;
    }

    public void setWithPet(boolean withPet) {
        this.withPet = withPet;
    }

    public void setBookableId(UUID bookableId) {
        this.bookableId = bookableId;
    }

    public UUID getBookableId() {
        return bookableId;
    }

    public void reservationTicket() {
        System.out.println("reservation ticket");
    }
          public abstract int calculatePrice();

        }

