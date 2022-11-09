package com.company.Lab.rpg_lab;

import org.junit.Assert;
import org.junit.Test;

public class AxeTest {

    @Test
    public void testWeaponLosesDurabilityAfterAttack() {
        //Arrange
        Axe axe = new Axe(10, 10);
        Dummy dummy = new Dummy(100, 100);
        //Act
        axe.attack(dummy);
        //Assert
        Assert.assertEquals(9, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void testAxeAttackThrowsIfAxeIsBroken() {
        Axe brockenAxe = new Axe(10, 0);

        Dummy dummy = new Dummy(100, 100);
        brockenAxe.attack(dummy);
    }
}