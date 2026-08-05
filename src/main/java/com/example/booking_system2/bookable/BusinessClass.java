package com.example.booking_system2.bookable;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue( "Business_class")
public class BusinessClass extends Bookable {
    SeatType seatType;
    boolean withEat;
    boolean  privatePlace;
    int priceTicket = 45000;

    @Override
    public int calculatePrice() {
        int sum = priceTicket;
        if(seatType == SeatType.VELOUR){
            sum += 5000;
        }
        else if (seatType == SeatType.TEXTILES){
            sum += 4000;
        }
        if  (seatType == SeatType.LEATHER){
            sum += 8000;
        }
        if(withEat){
             sum += 5000;
         }
        if(withPet){
            sum += 5000;
        }
        if(hasBaggage){
             sum += 5000;
         }
        if(privatePlace){
             sum += 10000;
         }
        return sum;
    }
}
