package com.tactfactory.supports;

import java.util.LinkedList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Animal> animals = initZoo();

        // Feed all animals.
        for (Animal a : animals) {
            a.feed();
        }

        // Print text separator.
        System.out.println("------------");

        // Heal all animals.
        animals.forEach(a -> a.heal());
    }

    /** Creates the animals object representation of our zoo. */
    private static List<Animal> initZoo() {
        List<Animal> result = new LinkedList<>();

        result.add(new GuineaPig());
        result.add(new Tiger());
        result.add(new Turtle());
        result.add(new Gali());
        result.add(new Whale());

        return result;
    }
}
