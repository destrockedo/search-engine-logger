package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        logAction("launch");
        while (true) {
            System.out.print("Enter a search term (X or x to exit): ");
            String searchTerm = scanner.nextLine();

            if (searchTerm.equalsIgnoreCase("x")) {
                logAction("exit");
                break;
            }
            logAction("search : " + searchTerm);
        }
        scanner.close();
    }
        public static void logAction (String action){
            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            String timestamp = LocalDateTime.now().format(formatter);

            // true appends new entries without erasing previous logs.
            try (BufferedWriter writer =
                         new BufferedWriter(new FileWriter("logs.txt", true))) {

                writer.write(timestamp + " " + action);
                writer.newLine();

            } catch (IOException e) {
                System.err.println("Error writing log: " + e.getMessage());
            }
        }
    }
