package com.company.Lab.RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<E> extends ArrayList<E> {

    public E getRandomElement() {
        int start = 0;
        int end = super.size();
        Random rnd = new Random();
        int i = rnd.nextInt(end);

        return remove(i);
    }
}
