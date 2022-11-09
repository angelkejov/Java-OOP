package com.company.Exercise.java.p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.Name;
import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ListIteratorTest {
    private ListIterator listIterator;
    private static final String[] NAMES = new String[]{"Evgenia, Teodor, Danail, Angel"};

    @Before
    public void prepare() throws OperationNotSupportedException {
        listIterator = new ListIterator(NAMES);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorShouldThrowException() throws OperationNotSupportedException {
        new ListIterator( null);
    }

    @Test
    public void testConstructorShouldCreateListIterator() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator(NAMES);
    }

    @Test
    public void testHasNext() {
        Assert.assertTrue(listIterator.hasNext());
        listIterator.move();
        Assert.assertTrue(listIterator.hasNext());
        listIterator.move();
        Assert.assertTrue(listIterator.hasNext());
        listIterator.move();
        Assert.assertFalse(listIterator.hasNext());
    }

    // Test for Move
    @Test
    public void testMove() {

    }

    // Test for print

}