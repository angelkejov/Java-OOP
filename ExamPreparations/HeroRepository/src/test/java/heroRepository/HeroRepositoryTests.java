package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class HeroRepositoryTests {
    HeroRepository heroes;
    Hero hero;

    @Before
    public void prepare() {
       heroes = new HeroRepository();
       hero = null;
    }

    @Test(expected = NullPointerException.class)
    public void testCreateShouldThrowExceptionWhenHeroIsNull() {
        heroes.create(hero);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateShouldThrowExceptionWhenHeroNameIsAlreadyInRepository() {
        Hero hero = new Hero("Angel", 16);
        heroes.create(hero);
        Hero hero1 = new Hero("Angel", 14);
        heroes.create(hero1);
    }

    @Test
    public void testCreateIsWorkingProperly() {
        Hero hero2 = new Hero("Lubcho", 24);
        heroes.create(hero2);
        Assert.assertEquals(heroes.getCount(), 1);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveShouldThrowExceptionWhenNameIsNull() {
        Hero hero = new Hero(null, 10);
        heroes.remove(hero.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveShouldThrowExceptionWhenNameIsWhitespace() {
        Hero hero = new Hero("     ", 19);
        heroes.remove(hero.getName());
    }

    @Test
    public void testRemoveShouldDisplayIfRemoveIsSuccess() {
        Hero hero = new Hero("4yk-Gek", 6);
        heroes.create(hero);
        heroes.remove(hero.getName());

        Assert.assertEquals(0, heroes.getCount());
    }

    @Test
    public void testGetHeroWithHighestLevel() {
        Hero hero = new Hero("Pesho", 90);
        Hero hero1 = new Hero("Gosho", 100);
        heroes.create(hero);
        heroes.create(hero1);
        Assert.assertEquals(heroes.getHeroWithHighestLevel(), hero1);
    }

    @Test
    public void testGetHeroReturnHero() {
        Hero hero = new Hero("Sracimir", 79);
        heroes.create(hero);
        Assert.assertEquals(heroes.getHero(hero.getName()), hero);
    }
}
