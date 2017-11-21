package com.tactfactory.generic;

public class Math {
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

        return min;
    }


    public static void main(String[] args) throws Exception {
//        System.out.println(Math.melanieMax(4242d, 42));
//
//        System.out.println(Math.min(3));
//        System.out.println(Math.min(3, 4, 3, 5, 3, 1, -104321));

        MathValue<Integer> mv = new MathValue<>(42);
        MathValue<Integer> min = mv.min(new MathValue<Integer>(3));

        System.out.println(min);
    }
}
