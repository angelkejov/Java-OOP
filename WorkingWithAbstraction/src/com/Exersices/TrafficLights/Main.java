package com.Exersices.TrafficLights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Color[] colors = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Color::valueOf).toArray(Color[]::new);

        List<TrafficLight> trafficLights = new ArrayList<>();

        for (Color color: colors) {
            TrafficLight trafficLight = new TrafficLight(color);

            trafficLights.add(trafficLight);
        }
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            for (TrafficLight trafficLight : trafficLights) {
                trafficLight.changeColor();
                System.out.print(trafficLight + " ");
            }
            System.out.println();
        }
    }
}
