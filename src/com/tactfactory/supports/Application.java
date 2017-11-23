package com.tactfactory.supports;

public class Application {
    public static void main(String[] args) {
        Animal a = new Animal();
        Mammal m = new Mammal();
        Animal am = new Mammal();

//        String s = "coucou";
//
//        a.say(s);
//        m.say(s);
//
//        System.out.println("----------");
//
//        a.say(s, s);
//        m.say(s, s);

        say(a);
        say(m);
        say(am);
    }

    public static void say(Animal a) {
        a.say("méthode say");

        if (a instanceof Mammal) {
            Mammal am = (Mammal) a;
            am.specificMammal();
        }
    }
}
