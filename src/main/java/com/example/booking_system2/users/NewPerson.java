package com.example.booking_system2.users;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue( "New_Person")
public class NewPerson extends User {


@Override
     public int privilege (int priceOfTicket ){
         if(countBooking == 0 ){
           priceOfTicket /= 2;
         }
         return priceOfTicket ;
     }

}


