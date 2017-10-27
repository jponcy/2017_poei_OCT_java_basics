import java.util.Random;
import java.util.Scanner;

/**
 * Step:
 * 1) User fill one word and receive YES/NO if it correct word or not ;
 *    infinite tries
 * 2) The word will be choose from one hard coded array
 * 3) Allow 2 input types:
 *    - word --- same process than before
 *    - letter --- say if letter is into word or not
 * 4) Print for each turn the "found state",
 *    for example _iste__ with i, s, t, e as input and mistery to found
 * 5) Allow a number of tries (lifes)
 */
public class Hangman {
    public static void main(String[] args) {
        String[] possibilities = {"mistery", "coucou", "git"};

        Random rnd = new Random();
        int index = rnd.nextInt(possibilities.length);

        String mistery = possibilities[index];
        boolean finished = false;

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\nInsert your try:");
            String s = scanner.nextLine();

            if (s.length() > 1) {
                if (mistery.equals(s)) {
                    System.out.println("OK");
                    finished = true;
                } else {
                    System.out.println("T'es vraiment trop nul !!!");
                }
            } else if (!s.equals("")) {
                char c = s.charAt(0);
                boolean finded = false;

                for (char mc : mistery.toCharArray()) {
                    if (mc == c) {
                        System.out.println("La lettre est bien dans le mot");
                        finded = true;
                        break;
                    }
                }

                if (!finded) {
                    System.out.println("La lettre n'est pas dans le mot");
                }
            }
        } while (!finished);

        scanner.close();
    }
}
