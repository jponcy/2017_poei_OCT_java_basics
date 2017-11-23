package com.tactfactory.generic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/* package */ class Math {
    public static <K> boolean equals(K a, K b) {
        return a.equals(b);
    }

    public static <K extends Number> K min(K a, K b) {
        return (a.doubleValue() < b.doubleValue() ? a : b);
    }





    public static <K extends Number, V extends Number> Number melanieMax(K a, V b) {
        return (a.doubleValue() > b.doubleValue() ? a : b);
    }




    public static <K extends Number> K max(K a, K b) {
        return (a.doubleValue() > b.doubleValue() ? a : b);
    }

    @SafeVarargs
    public static <K extends Number> K min(K a, K... values) throws Exception {
        K min = a;

        for (K v : values) {
            if (v.doubleValue() < min.doubleValue()) {
                min = v;
            }
        }









        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter("/tmp/coucou.txt"))) {
            bw.write("Ceci est un fichier communautaire");
            bw.newLine();
            bw.write("Faites vous plaisir !");
        } catch (Exception e) {
            System.out.println("Bouhou : " + e);
        }
















        return min;
    }


    public static void main(String[] args) throws Exception {
        System.out.println(com.tactfactory.generic.Math.melanieMax(4242d, 42));
        System.out.println(java.lang.Math.PI);
//
//        System.out.println(Math.min(3));
//        System.out.println(Math.min(3, 4, 3, 5, 3, 1, -104321));

        MathValue<Integer> mv = new MathValue<>(42);
        MathValue<Integer> min = mv.min(new MathValue<Integer>(3));

        System.out.println(min);

        MathValue<MathValue<MathValue<Integer>>> fuckingDeclaration;
        MathValue<Double> coucou;
    }
}
