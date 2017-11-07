package com.tactfactory.test;

import java.util.Scanner;

public class Test {

    /*
    - factoriel
    - carré avec que des additions
    - puissance avec que des additions
    - valeur absolue avec un x -1
    - écrire charactère/charactère les strings passés en paramètres
    */

    public static void main(String[] args) {
//        System.out.println(square(getIntFromConsole()));

        // Calls pow.
        for (int i = 0; i < 5; i++) {
            System.out.println(
                    String.format("2 ^ %d => %2d -- %2d",
                            i,
                            pow(2, i),
                            (int) Math.pow(2, i)));
        }

//        printCharByChar(args);
    }

    @SuppressWarnings("all")
    private static void printCharByChar(String[] args) {
        for (int index = 0; index < args.length; index ++) {
            String string = args[index];

            // Print word.
            for (int i = 0; i < string.length(); i++) {
                char c = string.charAt(i);
                System.out.println(c);
            }

            // Space between words -- if not last word.
            if (index < args.length - 1) {
                System.out.println("");
            }
        }

        // Or -- more simply -- without spaces.
        // for (String s : args) {
        //     for (char c : s.toCharArray()) {
        //         System.out.println(c);
        //     }
        // }
    }

    @SuppressWarnings("all")
    private static long pow(int number, int pow) {
        long a = number;

        if (pow == 0) {
            return 1;
        }

        for (int i = 0; i < pow - 1; i++) {
            a = mult(a, number);
        }

        return a;
    }

    private static long mult(long a, long b) {
        long result = 0;

        for (int i = 0; i < b; i++) {
            result += a;
        }

        return result;
    }

    @SuppressWarnings("all")
    private static long abs(long a) {
        long result = a;

        if (a < 0) {
            result *= -1;
        }

        return result;

        // OR inline.
        // return (a >= 0) ? a : a * -1;
    }

    @SuppressWarnings("all")
    private static int square(int number) {
        int result = 0;

        for (int i = 0; i < number; i ++) {
            result += number;
        }

        return result;
    }

    @SuppressWarnings("all")
    private static int getIntFromConsole() {
        System.out.println("Insert your number :");
        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();
        scanner.close();

        return input;
    }

    @SuppressWarnings("all")
    private static long fact(int f) {
        long result = 1;

        for (int i = f; i > 1; i --) {
            result *= i;
        }

        return result;
    }

    @SuppressWarnings("all")
    private static void help(String[] args) {
        for (String v : args) {
            System.out.println(
                String.format("%10s : %3d", v, v.length())
            );
        }
    }
}
