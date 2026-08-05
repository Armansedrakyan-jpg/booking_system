package com.example.booking_system2.bookable;

import com.example.booking_system2.bookable.PremiumClass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class PremiumClassTest {

     @Test
      void calculatePrice_OfThreeOptions_ComboBonus(){
         PremiumClass premiumClass = new PremiumClass();
         premiumClass.hasPersonalEat = true;
         premiumClass.hasPersonalBar = true;
         premiumClass.hasPersonalTV = true;

          int result = premiumClass.calculatePrice();
           assertEquals(140000, result);

     }

}
