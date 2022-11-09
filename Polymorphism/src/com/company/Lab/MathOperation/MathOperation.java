package com.company.Lab.MathOperation;

public class MathOperation {
    public int add(int first, int second) {
        return first + second;
    }

    public int add(int first, int second, int third) {
        return add(add(first, second), third);
    }

    public int add(int first, int second, int third, int fourth) {
        return add(add(first, second, third), fourth);
    }
}
