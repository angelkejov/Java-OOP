package com.company.Lab.RandomArrayList;

public class Main {

    public static void main(String[] args) {
        RandomArrayList<Integer> arrayList = new RandomArrayList<>();

        for (int i = 1; i <= 13; i++) {
            arrayList.add(i);
        }

        System.out.println(arrayList.getRandomElement());
    }
}
