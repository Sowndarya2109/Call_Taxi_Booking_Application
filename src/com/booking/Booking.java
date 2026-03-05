package com.booking;

public class Booking {

    private int bookingId;
    private int customerId;
    private char from;
    private char to;
    private int pickTime;
    private int dropTime;
    private int amount;

    public int getBookingId() {
        return bookingId;
    }
    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public char getFrom() {
        return from;
    }
    public void setFrom(char from) {
        this.from = from;
    }
    public char getTo() {
        return to;
    }
    public void setTo(char to) {
        this.to = to;
    }
    public int getPickTime() {
        return pickTime;
    }
    public void setPickTime(int pickTime) {
        this.pickTime = pickTime;
    }
    public int getDropTime() {
        return dropTime;
    }
    public void setDropTime(int dropTime) {
        this.dropTime = dropTime;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
}