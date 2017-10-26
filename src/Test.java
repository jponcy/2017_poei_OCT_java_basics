import java.util.Scanner;

public class Test {

    /*
    - factoriel
    - carré avec que des additions
    - puissance avec que des additions
    - valeur absolue avec un x -1
    - écrire charactère/charactère les strings
      passés en paramètres
    */

    public static void main(String[] args) {
        System.out.println(square());
    }

    @SuppressWarnings("all")
    private static int square() {
        int input = getIntFromConsole();
        int result = 0;

        for (int i = 0; i < input; i ++) {
            result += input;
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
