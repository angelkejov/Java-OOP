package com.company.Exercises.Animals;

public class Tomcat extends Cat {
    private static final String GENDER = "Male";
    public Tomcat(String name, int age) {
        super(name, age, GENDER);
    }

    public Tomcat(String token, int age, String gender) {
        super(token, age, GENDER);
    }

    @Override
    public String produceSound() {
        return "MEOW";
    }
}
