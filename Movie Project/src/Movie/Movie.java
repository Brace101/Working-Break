package Movie;

import java.util.Scanner;

public class Movie {

    static Scanner input = new Scanner(System.in);

    static String indent = "\t\t";
    static String indentOne = "\t";

    static String BLINK = "\u001B[5m";
    static String GREEN = "\u001B[32m";
    static String RED = "\u001B[31m";
    static String YELLOW = "\u001B[33m";
    static String RESET = "\u001B[0m";
    static String PURPLE = "\u001B[35m";
    static String CYAN = "\u001B[36m";
    static String WHITE = "\u001B[37m";
    static String BOLD = "\u001B[1m";
    static String ITALIC = "\u001B[3m";

    public static void main(String[] args) {

        String[] movies = new String[50];
        int[] totalRatings = new int[50];
        int[] ratingCount = new int[50];

        int movieIndex = 0;

        System.out.print(indent + "=================================================");
        System.out.println("\n" + indent + indent + BOLD + GREEN + "Welcome To SemiColon Movie Box Yaba" + RESET);
        System.out.print(indent + "=================================================" + "\n");

        while (true) {
            displayMenu();
            int choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                movieIndex = addMovie(movies, movieIndex);
            }
            else if (choice == 2) {
                rateMovie(movies, totalRatings, ratingCount, movieIndex);
            }
            else if (choice == 3) {
                viewRatings(movies, totalRatings, ratingCount, movieIndex);
            }
            else if (choice == 4) {
                System.out.println(RED + "Goodbye!" + RESET);
                break;
            }
            else {
                System.out.println(RED + "Invalid choice!" + RESET);
            }
        }
    }

    public static void displayMenu() {
        System.out.println("\n" + indentOne + CYAN + BOLD + "1. Add Movie" + RESET);
        System.out.println(indentOne + CYAN + BOLD + "2. Rate Movie" + RESET);
        System.out.println(indentOne + CYAN + BOLD + "3. View Average Ratings" + RESET);
        System.out.println(indentOne + CYAN + BOLD + "4. Exit" + RESET);

        System.out.print("\n" + indentOne + "Enter choice: ");
    }

    public static int addMovie(String[] movies, int movieIndex) {
        if (movieIndex >= movies.length) {
            System.out.println(YELLOW + "Movie list is full!" + RESET);
            return movieIndex;
        }

        System.out.print(indent + "Enter movie name: ");
        String name = input.nextLine();


        if (!name.matches("[a-zA-Z ]+")) {
            System.out.println(RED + "Invalid movie name! Use letters only." + RESET);
            return movieIndex;
        }

        movies[movieIndex] = name;

        System.out.print("Add a movie, (Yes Or No)?: ");
        String userResponse = input.nextLine();

        if (!userResponse.matches("[a-zA-Z ]+")) {
            System.out.println(RED + "Invalid movie name! Use letters only." + RESET);
            return movieIndex;
        }

        if (userResponse.equalsIgnoreCase("No")) {
            System.out.println("Mission Abort");
        }

        System.out.println(GREEN + "Movie added Successfully!" + RESET);
        return movieIndex + 1;
    }

    public static void rateMovie(String[] movies, int[] totalRatings, int[] ratingCount, int movieIndex) {
        if (movieIndex == 0) {
            System.out.println(RED + "No movies available to rate!" + RESET);
            return;
        }

        System.out.print("Enter movie name: ");
        String name = input.nextLine();

        int index = findMovie(movies, name, movieIndex);

        if (index == -1) {
            System.out.println(RED + "Movie not found!" + RESET);
            return;
        }

        System.out.print("Enter rating (1-5): ");
        int rating = input.nextInt();
        input.nextLine();

        if (rating < 1 || rating > 5) {
            System.out.println(RED + "Invalid rating! Must be 1-5." + RESET);
            return;
        }

        totalRatings[index] += rating;
        ratingCount[index]++;

        System.out.println(GREEN + "Rating added!" + RESET);
    }

    public static void viewRatings(String[] movies, int[] totalRatings, int[] ratingCount, int movieIndex) {
        if (movieIndex == 0) {
            System.out.println(YELLOW + "No movies added yet." + RESET);
            return;
        }

        for (int index = 0; index < movieIndex; index++) {
            if (ratingCount[index] == 0) {
                System.out.println(YELLOW + movies[index] + " has no ratings yet." + RESET);
            } else {
                double average = (double) totalRatings[index] / ratingCount[index];
                System.out.println(CYAN + movies[index] + " Average Rating: " + average + RESET);
            }
        }
    }

    public static int findMovie(String[] movies, String name, int movieIndex) {
        for (int index = 0; index < movieIndex; index++) {
            if (movies[index].equalsIgnoreCase(name)) {
                return index;
            }
        }
        return -1;
    }
}
