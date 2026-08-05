package com.example.booking_system2.bookable;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Premium_class")
public class PremiumClass extends Bookable {

    boolean hasPersonalTV;
    boolean hasPersonalBar;
    boolean hasPersonalEat;
    int priceTicket = 100000;

    public int calculatePrice() {
        int sum = priceTicket;
        if (hasPersonalBar && hasPersonalTV && hasPersonalEat) {
            sum += 40000;
        } else {
            if (hasPersonalTV) {
                sum += 15000;
            }
            if (hasPersonalEat) {
                sum += 15000;
            }
            if (hasPersonalBar) {
                sum += 15000;
            }
        }
        if (hasBaggage) {
            sum += 5000;
        }
        return sum;
    }
}


