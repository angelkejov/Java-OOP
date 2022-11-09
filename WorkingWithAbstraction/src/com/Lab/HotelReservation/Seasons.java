package com.Lab.HotelReservation;

public enum Seasons {

    AUTUMN("Autumn", 1),
    SPRING("Spring", 2),
    WINTER("Winter", 3),
    SUMMER("Summer", 4);

    private String seasons;
    private int multi;

    Seasons(String seasons, int multi) {
        this.seasons = seasons;
        this.multi = multi;
    }

    public String getSeasons() {
        return seasons;
    }
}
