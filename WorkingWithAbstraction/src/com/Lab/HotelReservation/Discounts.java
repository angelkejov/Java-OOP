package com.Lab.HotelReservation;

public enum Discounts {

    VIP("Vip", 20),
    SECONDVISIT("SecondVisit", 10),
    NONE("None", 0);

    private String discount;
    private int percentage;

    Discounts(String discount, int percentage) {
        this.discount = discount;
        this.percentage = percentage;
    }
}
