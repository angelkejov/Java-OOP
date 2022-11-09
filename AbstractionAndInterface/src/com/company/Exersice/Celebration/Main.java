package com.company.Exersice.Celebration;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        List<Birthable> thingsWithBirthday = new ArrayList<>();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");

            String objectType = tokens[0];

            switch (objectType) {
                case "Citizen":
                    String citizenName = tokens[1];
                    int citizenAge = Integer.parseInt(tokens[2]);
                    String citizenId = tokens[3];
                    String citizenBirthDate = tokens[4];
                    Citizen citizen = new Citizen(citizenName, citizenAge,
                            citizenId, citizenBirthDate);

                    thingsWithBirthday.add(citizen);
                    break;

                case "Pet":
                    String petName = tokens[1];
                    String petBirthDate = tokens[2];
                    Pet pet = new Pet(petName, petBirthDate);
                    thingsWithBirthday.add(pet);
                    break;

                case "Robot":
                    String id = tokens[1];
                    String model = tokens[2];
                    Robot robot = new Robot(id, model);
                    break;
            }
            input = sc.nextLine();
        }

        String year = sc.nextLine();
        for (Birthable citizen : thingsWithBirthday) {
            if (citizen.getBirthDate().endsWith(year)) {
                System.out.println(citizen.getBirthDate());
            }
        }
    }
}
