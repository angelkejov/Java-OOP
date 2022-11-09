package com.company.Exersice.Celebration;

public class Pet implements Birthable{
    private String birtDate;
    private String name;


    public Pet(String name, String birtDate) {
        this.birtDate = birtDate;
        this.name = name;
    }

    public String getBirtDate() {
        return birtDate;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getBirthDate() {
        return this.birtDate;
    }
}
