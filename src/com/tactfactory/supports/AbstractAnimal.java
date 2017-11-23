package com.tactfactory.supports;

/* package */abstract class AbstractAnimal implements Animal {
    @Override
    public void heal() {
        System.out.println("Utilisation d'un stimpack !");
    }
}
