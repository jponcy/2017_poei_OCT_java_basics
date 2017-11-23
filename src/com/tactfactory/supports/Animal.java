package com.tactfactory.supports;

public class Animal {

    public void say(String sentence) {
        System.out.println(sentence);
    }

    //
    public void say(String s, String s2) {
       this.say(s + " " + s2);
    }
}
