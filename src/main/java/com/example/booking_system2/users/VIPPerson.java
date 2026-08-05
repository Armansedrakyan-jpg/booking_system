package com.example.booking_system2.users;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue( "VIP_Person")
public class VIPPerson extends User {
    boolean priest;
    boolean president;
    boolean sportsman;
    @Override
    public int privilege(int priceOfTicket){
        if(president){
            priceOfTicket /= 100;
        }
         if (priest){
             priceOfTicket /= 100;

         }
         if(sportsman){
          priceOfTicket /= 100;
         }
          return priceOfTicket;
    }
}
