package com.company.Exercise.java.p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {
    private static final Integer[] NUMBERS = {1, 2, 3, 4};
    private static final int TOO_BIG_NUMBER = 17;
    private Database database;

    @Before
    public void prepare() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
    }

    @Test
    public void testConstructorShouldCreateValidDatabase() throws OperationNotSupportedException {
        Integer[] dbElements = database.getElements();

        Assert.assertEquals("Count of db elements is incorrect", dbElements.length, NUMBERS.length);

        for (int i = 0; i < NUMBERS.length; i++) {
            Assert.assertEquals("We have different elements in the database", dbElements[i], NUMBERS[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorShouldThrowExceptionForMoreThan16Elements() throws OperationNotSupportedException {
        Integer[] largeArray = new Integer[TOO_BIG_NUMBER];
        new Database(largeArray);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowsExceptionForLessThanOneElements() throws OperationNotSupportedException {
        Integer[] smallArr = new Integer[0];
        new Database(smallArr);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddThrowsExceptionWithNoArgument() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testShouldAddElement() throws OperationNotSupportedException {
        database.add(6);
        Integer[] dbElements = database.getElements();

        Assert.assertEquals(dbElements.length, NUMBERS.length + 1);

        Assert.assertEquals(dbElements[dbElements.length - 1], Integer.valueOf(6));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveShouldThrowException() throws OperationNotSupportedException {
        for (int i = 0; i < NUMBERS.length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test
    public void testRemoveShouldRemoveLastElement() throws OperationNotSupportedException {
        database.remove();
        Integer[] dbElements = database.getElements();
        Assert.assertEquals(NUMBERS.length - 1, dbElements.length);
        Assert.assertEquals(Integer.valueOf(3), dbElements[dbElements.length - 1]);
    }
}