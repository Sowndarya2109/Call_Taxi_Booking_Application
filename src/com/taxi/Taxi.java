package com.taxi;

import java.util.ArrayList;
import java.util.List;
import com.booking.Booking;

public class Taxi {
    private int id;
    private char currentPoint = 'A';
    private int totalEarnings = 0;
    private List<Booking> bookings = new ArrayList<>();
    public Taxi(int id) {
        this.id = id;
    }
    public boolean isAvailable(int requestTime) {
        if (bookings.isEmpty()) {
            return true;
        }
        Booking lastBooking = bookings.get(bookings.size() - 1);
        return lastBooking.getDropTime() <= requestTime;
    }
    public int calculateEarnings(char from, char to) {
        int distanceKm = Math.abs(to - from) * 15;
        return 100 + Math.max(0, (distanceKm - 5) * 10);
    }
    public void addBooking(Booking booking) {
        bookings.add(booking);
        totalEarnings += booking.getAmount();
        currentPoint = booking.getTo();
    }
    public int getId() {
        return id;
    }
    public char getCurrentPoint() {
        return currentPoint;
    }
    public int getTotalEarnings() {
        return totalEarnings;
    }
    public List<Booking> getBookings() {
        return bookings;
    }
}