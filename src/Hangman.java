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
        String mistery = "mistery";
        boolean finished = false;

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\nInsert your try:");
            String s = scanner.nextLine();

            if (mistery.equals(s)) {
                System.out.println("OK");
                finished = true;
            } else {
                System.out.println("T'es vraiment trop nul !!!");
            }
        } while (!finished);

        scanner.close();
    }
}
