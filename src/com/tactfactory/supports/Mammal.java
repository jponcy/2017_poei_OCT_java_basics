package com.tactfactory.supports;

public class Mammal extends Animal {
    @Override
    public void say(String sentence) {
        super.say("Mammal says " + sentence);
    }

    public void specificMammal() {
        System.out.println("Je suis un mammal, je suis trop fier !");
    }
}
