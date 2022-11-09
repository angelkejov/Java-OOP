package com.company.Lab.Shapes;

public class Circle extends Shape {
    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    public final Double  getRadius() {
        return this.radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    public double calculatePerimeter() {
        return Math.PI * (2 * this.radius);
    }

    @Override
    public double calculateArea() {
        return Math.PI * this.radius * this.radius;
    }
}
