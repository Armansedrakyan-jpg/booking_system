package com.example.booking_system2.readBookingFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookingFileReader {

      public List<String[]> loadFromFile() throws IOException {
          List <String[]> result = new ArrayList<>();
          File file = new File("booking.csv");

            if(!file.exists()){
                return result;
            }

          Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                 result.add(parts);
            }
                scanner.close();
            return result;

      }
}
