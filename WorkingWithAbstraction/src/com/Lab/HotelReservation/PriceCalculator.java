package com.Lab.HotelReservation;

public class PriceCalculator {

    private double pricePerDay;
    private int numberOfDays;
    private Seasons season;
    private Discounts discountType;

    public PriceCalculator(double pricePerDay, int numberOfDays, Seasons season, Discounts discountType) {
        this.pricePerDay = pricePerDay;
        this.numberOfDays = numberOfDays;
        this.season = season;
        this.discountType = discountType;
    }
}

