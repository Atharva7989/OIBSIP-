import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int random, num, close = 5, score = 10, tries = 0;
        Random rand = new Random();

        System.out.println("*************Welcome To Number Guessing Game*************");
        random = rand.nextInt(100); // takes up to 100
        System.out.println();
    
        System.out.println("1. Enter a Number between 0 to 100");
        System.out.println();
        while (true) {
            try {
                num = sc.nextInt();

                if (num < 0 || num >= 100) {
                    System.out.println("Please enter a valid number between 0 and 100.");
                    continue;
                }

                int value = Math.abs(random - num);

                if (num == random) {
                    score = score + 20;
                    System.out.println("You are a Winner");
                    System.out.println();
                    tries++;
                    break;
                } else {
                    if (num < random) {
                        System.out.println("Try Higher Values");
                        System.out.println();
                        score = score - 2;
                        tries++;
                    }
                    if (num > random) {
                        System.out.println("Try Lower Values");
                        System.out.println();
                        score = score - 2;
                        tries++;
                    }
                    if (value < close) {
                        System.out.println("Wow, you are too close");
                        System.out.println();
                        score = score - 2;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                sc.next(); // Clear the invalid input from the scanner
            }
        }

        sc.close();
        System.out.println("Your Score is: " + score);
        System.out.println("No of Tries: " + tries);
        System.out.println();
    }
}
