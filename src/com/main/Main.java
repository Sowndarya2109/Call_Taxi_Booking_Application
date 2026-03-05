package com.main;

import com.booking.Booking;
import com.taxi.Taxi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final int TAXI_COUNT = 4;
    private static final List<Taxi> taxis = new ArrayList<>();
    private static int bookingIdCounter = 1;
    
    public static void main(String[] args) {
        initializeTaxi(TAXI_COUNT);
        while (true) {
            System.out.println("\n==== Taxi Management ====");
            System.out.println("1. Book Taxi");
            System.out.println("2. View Taxi Details");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    bookTaxi();
                    break;
                case 2:
                    displayTaxi();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
    private static void initializeTaxi(int n) {
        for (int i = 1; i <= n; i++) {
            taxis.add(new Taxi(i));
        }
        System.out.println(n + " taxis initialized at point A.");
    }
    private static void bookTaxi() {
        System.out.print("Customer ID: ");
        int customerId = sc.nextInt();
        System.out.print("Pickup (A-F): ");
        char pickup = sc.next().toUpperCase().charAt(0);
        System.out.print("Drop (A-F): ");
        char drop = sc.next().toUpperCase().charAt(0);
        System.out.print("Pickup Time (hour int, ex 9, 12): ");
        int pickupTime = sc.nextInt();
        Taxi selectedTaxi = null;
        int minDistance = Integer.MAX_VALUE;
        
        for (Taxi taxi : taxis) {
            if (!taxi.isAvailable(pickupTime)) {
                continue;
            }
            int distance = Math.abs(taxi.getCurrentPoint() - pickup);
            if (selectedTaxi == null
                    || distance < minDistance
                    || (distance == minDistance
                        && taxi.getTotalEarnings() < selectedTaxi.getTotalEarnings())
                    || (distance == minDistance
                        && taxi.getTotalEarnings() == selectedTaxi.getTotalEarnings()
                        && taxi.getId() < selectedTaxi.getId())) {
                selectedTaxi = taxi;
                minDistance = distance;
            }
        }
        if (selectedTaxi == null) {
            System.out.println("Booking Rejected: No taxi available.");
            return;
        }
        int dropTime = pickupTime + Math.abs(drop - pickup);
        int amount = selectedTaxi.calculateEarnings(pickup, drop);

        Booking booking = new Booking();
        booking.setBookingId(bookingIdCounter++);
        booking.setCustomerId(customerId);
        booking.setFrom(pickup);
        booking.setTo(drop);
        booking.setPickTime(pickupTime);
        booking.setDropTime(dropTime);
        booking.setAmount(amount);

        selectedTaxi.addBooking(booking);
        System.out.println("Taxi-" + selectedTaxi.getId() + " is Allocated");
    }
    private static void displayTaxi() {
        for (Taxi t : taxis) {
            System.out.println("\nTaxi-" + t.getId() + " Total Earnings: Rs. " + t.getTotalEarnings());
            System.out.println("BookingID   CustomerID   From  To  Pickup  Drop  Amount");
            if (t.getBookings().isEmpty()) {
                System.out.println("(No bookings)");
                continue;
            }
            for (Booking b : t.getBookings()) {
                System.out.printf("%-10d %-12d %-5c %-3c %-7d %-5d %-6d%n",
                        b.getBookingId(),
                        b.getCustomerId(),
                        b.getFrom(),
                        b.getTo(),
                        b.getPickTime(),
                        b.getDropTime(),
                        b.getAmount()
                );
            }
        }
    }
}