package com.company.Exercises.Animals;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String type = sc.nextLine();
        while (!type.equals("Beast!")) {
            String input = sc.nextLine();
            String[] tokens = input.split("\\s+");
            try {
                switch (type) {
                    case "Cat":
                        Cat cat = new Cat(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                        System.out.println(cat);
                        break;

                    case "Dog":
                        Dog dog = new Dog(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                        System.out.println(dog);
                        break;

                    case "Frog":
                        Frog frog = new Frog(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                        System.out.println(frog);
                        break;

                    case "Kitten":
                        Kitten kitten = new Kitten(tokens[0], Integer.parseInt(tokens[1]));
                        System.out.println(kitten);
                        break;

                    case "Tomcat":
                        Tomcat tomcat = new Tomcat(tokens[0], Integer.parseInt(tokens[1]));
                        System.out.println(tomcat);
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            type = sc.nextLine();
        }
    }
}
