package com.Exersices.TrafficLights;

public class TrafficLight {

    private Color color;

    public TrafficLight(Color color) {
        this.color = color;
    }

    public void changeColor() {
        switch (this.color) {
            case RED -> this.color = Color.GREEN;
            case YELLOW -> this.color = Color.RED;
            case GREEN -> this.color = Color.YELLOW;
        }
    }
    @Override
    public String toString() {
        return this.color.toString();
    }
}
