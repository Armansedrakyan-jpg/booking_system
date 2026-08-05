package com.example.booking_system2.bookable;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue( "Eco_class")
public class EcoClass extends Bookable {
    PlaceOfRow placeOfRow;
     int priceTicket = 10000;

    public int getPriceOfTicket() {
        return priceTicket;
    }

    @Override
    public int calculatePrice() {
        int sum = priceTicket;
        if (placeOfRow == PlaceOfRow.A) {
            sum += 2500;
        } else if (placeOfRow == PlaceOfRow.B) {
            sum += 2000;
        } else if (placeOfRow == PlaceOfRow.C) {
            sum += 1500;
        }
        if (hasBaggage) {
            sum += 5000;
        }
        return sum;
    }

}









