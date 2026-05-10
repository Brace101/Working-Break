package SimpleArithmetic;

import java.util.Date;
import java.time.LocalTime;
import java.util.Scanner;
import java.util.Random;

public class SimpleArithmetic {

    public static void main(String[] args) {

        Date now = new Date();
        LocalTime currentTime = LocalTime.now();
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        String indent = "\t\t";
        String indentOne = "\t";

        String GREEN = "\u001B[32m";
        String RED = "\u001B[31m";
        String YELLOW = "\u001B[33m";
        String RESET = "\u001B[0m";
        String PURPLE = "\u001B[35m";
        String CYAN = "\u001B[36m";
        String BOLD = "\u001B[1m";

        int totalQuestions = 10;
        int score = 0;

        System.out.println(indent + GREEN + BOLD + "===== SEMICOLON BRAIN-TEASER GAME =====" + RESET);
        System.out.println("\n" + CYAN + indent + "LOADING..............................................." + RESET);

        System.out.println("\n" + indent + "Hello, Kindly enter your name");
        String userName = input.nextLine();

        System.out.println("\n" + PURPLE + indent + "Welcome " + userName +
                " to Semi-Colon Brain-Teaser Game App" + RESET);

        System.out.println("\n" + YELLOW + indent +
                "You have 10 questions and 2 attempts per question" + RESET);

        System.out.println("\n" + GREEN + indent + "Press OK to start the game" + RESET);
        String userResponse = input.nextLine();

        if (!userResponse.equalsIgnoreCase("ok")) {
            System.out.println(RED + indent + "Invalid input. Starting anyway..." + RESET);
        }

        System.out.println("\n" + GREEN + indent + "Game Starting..." + RESET);

        for (int index = 1; index <= totalQuestions; index++) {

            int firstNumber = random.nextInt(100) + 1;
            int secondNumber = random.nextInt(50) + 1;

            if (firstNumber < secondNumber) {
                int temp = firstNumber;
                firstNumber = secondNumber;
                secondNumber = temp;
            }

            int correctAnswer = firstNumber - secondNumber;

            System.out.println("\n" + CYAN + indent + "Question " + index +
                    ": " + firstNumber + " - " + secondNumber + RESET);

            for (int attempt = 1; attempt <= 2; attempt++) {

                System.out.print(indentOne + "Attempt " + attempt + ": ");
                int userAnswer = input.nextInt();

                if (userAnswer == correctAnswer) {

                    System.out.println(GREEN + indent + "Correct!" + RESET + "\n");
                    score++;
                    break;

                } else {

                    if (attempt == 1) {
                        System.out.println(YELLOW + indent +
                                "Wrong answer, try again" + RESET + "\n");
                    }

                    if (attempt == 2) {
                        System.out.println(RED + indent +
                                "Still wrong. Correct answer is " + correctAnswer + RESET + "\n");
                    }
                }
            }
        }

        System.out.println("\n" + PURPLE + indent + now + RESET);
        System.out.println(CYAN + indent + "Current time: " + currentTime + RESET);

        System.out.println("\n" + GREEN + indent +
                "Dear " + userName + ", you have completed the game!" + RESET);

        System.out.println(YELLOW + indent +
                "Your score is: " + score + " out of " + totalQuestions + RESET);

        System.out.println(RED + BOLD + indent + "GAME OVER!!!" + RESET);
    }
}
