package com.company.Exercise.java.p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DatabaseTest {
    private static final  Person[] PEOPLE =
            {new Person(1,"First"),
                    new Person(2,"Second"),
                    new Person(3,"Third"),
                    new Person(4,"Fourth")};
    private Database database;

    @Before
    public void prepare() throws OperationNotSupportedException {
        database = new Database(PEOPLE);
    }

    @Test
    public void testConstructorShouldCreateValidDatabase() throws OperationNotSupportedException{
        Person[] dbElements = database.getElements();
        Assert.assertEquals("Count of db elements is incorrect",dbElements.length, PEOPLE.length);
        for (int i = 0; i < PEOPLE.length; i++) {
            Assert.assertEquals("We have different elements in the database", dbElements[i], PEOPLE[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorIfItsLarge() throws OperationNotSupportedException {
        Person[] large = new Person[17];
        new Database(large);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorIfItsSmall() throws OperationNotSupportedException {
        Person[] small = new Person[0];
        new Database(small);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddMethodThrowExceptionForNull() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testAddMethodForSuccessfullyAdd() throws OperationNotSupportedException {
        database.add(new Person(4,"Fourth"));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testRemoveMethodShouldReturnArrayIndexOutOfBounds() throws OperationNotSupportedException {
        for (int i = 0; i < PEOPLE.length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test
    public void testRemoveMethodShouldRemoveElement() throws OperationNotSupportedException {
        database.remove();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameThrowExceptionIfNull() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test
    public void testFindByUsername() throws OperationNotSupportedException {
        Person resultPerson = database.findByUsername("First");
        Assert.assertEquals(resultPerson.getUsername(), "First");
    }

}