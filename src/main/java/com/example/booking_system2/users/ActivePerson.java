package com.example.booking_system2.users;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Active_Person")
public class ActivePerson extends User {
 @Override
    public int privilege(int priceOfTicket) {
        int discount = 0;
            if (countBooking <= 5) {
                discount = 0;
            } else if (countBooking <= 10) {
                discount = 5;
            } else if (countBooking <= 15) {
                discount = 10;
            } else if (countBooking <= 20) {
                discount = 25;
            } else if (countBooking <= 30) {
                discount = 50;
            } else  {
                discount = 80;
            }
             priceOfTicket /= discount;
            return priceOfTicket;
        }
}