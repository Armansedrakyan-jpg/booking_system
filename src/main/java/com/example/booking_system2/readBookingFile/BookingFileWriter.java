package com.example.booking_system2.readBookingFile;
import com.example.booking_system2.booking.Booking;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class BookingFileWriter {

     public void saveFile(List<Booking> bookings) throws IOException {
         FileWriter fileWriter = new FileWriter("booking.csv");
             for (Booking b : bookings){
                 String line = b.getUserId() + ","
                         + b.getTotalPriceOfTicket() + ","
                         + b.getBookingStatus() + ","
                         + b.getCreatedAt() + "\n";
                 fileWriter.write(line);
             }
             fileWriter.close();

     }
}