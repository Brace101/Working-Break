package BookSuggestion;

import java.util.Scanner;
import java.util.ArrayList;

public class BookSuggestion {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList<String> bookTitle = new ArrayList<>();
        ArrayList<Integer> numberOfPages = new ArrayList<>();
        ArrayList<String> author = new ArrayList<>();

        bookTitle.add("The Hobbit");
        numberOfPages.add(320);
        author.add("J.R.R. Tolkien");

        String indent = "\t\t";
        String indentOne = "\t";

        String GREEN = "\u001B[32m";
        String RED = "\u001B[31m";
        String YELLOW = "\u001B[33m";
        String RESET = "\u001B[0m";
        String PURPLE = "\u001B[35m";
        String CYAN = "\u001B[36m";
        String BOLD = "\u001B[1m";

        while (true) {

            System.out.println(indent + BOLD + GREEN + "===== BOOK SUGGESTION SYSTEM =====" + RESET);

            System.out.println(indentOne + CYAN + "1. Get Suggestion" + RESET);
            System.out.println(indentOne + CYAN + "2. Add Book" + RESET);
            System.out.println(indentOne + CYAN + "3. Remove Book" + RESET);
            System.out.println(indentOne + CYAN + "4. Update Book" + RESET);
            System.out.println(indentOne + CYAN + "5. Show all books" + RESET);
            System.out.println(indentOne + CYAN + "0. Exit" + RESET);

            System.out.print(indent + YELLOW + BOLD + "Enter option: " + RESET);

            int option = input.nextInt();
            input.nextLine();

            switch (option) {

                case 1 -> {

                    System.out.println("\n" + indent + PURPLE + "===== BOOK SUGGESTION =====" + RESET);

                    while (true) {

                        System.out.print(indentOne + CYAN +
                                "Would you like another suggestion? (Yes/No): " + RESET);

                        String moreSuggest = input.nextLine();

                        if (moreSuggest.equalsIgnoreCase("yes")) {

                            System.out.println("\n" + indent + GREEN +
                                    "Title: The Mystery" + RESET);
                            System.out.println(indent + GREEN +
                                    "Author: Jeffrey Matthew" + RESET);
                            System.out.println(indent + GREEN +
                                    "Pages: 97\n" + RESET);

                        } else if (moreSuggest.equalsIgnoreCase("no")) {
                            break;
                        } else {
                            System.out.println(indent + RED + "Please enter Yes or No.\n" + RESET);
                        }
                    }
                }

                case 2 -> {

                    System.out.println("\n" + indent + PURPLE + "===== ADD BOOK =====" + RESET);

                    System.out.print(indentOne + CYAN + "Enter book title: " + RESET);
                    String title = input.nextLine();

                    System.out.print(indentOne + CYAN + "Enter author: " + RESET);
                    String bookAuthor = input.nextLine();

                    System.out.print(indentOne + CYAN + "Enter pages: " + RESET);
                    int page = input.nextInt();
                    input.nextLine();

                    bookTitle.add(title);
                    author.add(bookAuthor);
                    numberOfPages.add(page);

                    System.out.println("\n" + indent + GREEN + BOLD +
                            title + " added successfully!\n" + RESET);
                }

                case 3 -> {

                    System.out.println("\n" + indent + PURPLE + "===== REMOVE BOOK =====" + RESET);

                    System.out.print(indentOne + CYAN + "Enter book title: " + RESET);
                    String title = input.nextLine();

                    int index = bookTitle.indexOf(title);

                    if (index != -1) {

                        bookTitle.remove(index);
                        author.remove(index);
                        numberOfPages.remove(index);

                        System.out.println(indent + GREEN + title + " removed successfully!\n" + RESET);

                    } else {
                        System.out.println(indent + RED + "Book not found!\n" + RESET);
                    }
                }

                case 4 -> {

                    System.out.println("\n" + indent + PURPLE + "===== UPDATE BOOK =====" + RESET);

                    System.out.print(indentOne + CYAN + "Enter book title: " + RESET);
                    String title = input.nextLine();

                    int index = bookTitle.indexOf(title);

                    if (index != -1) {

                        System.out.print(indentOne + CYAN + "New title: " + RESET);
                        String newTitle = input.nextLine();

                        System.out.print(indentOne + CYAN + "New author: " + RESET);
                        String newAuthor = input.nextLine();

                        System.out.print(indentOne + CYAN + "New pages: " + RESET);
                        int newPages = input.nextInt();
                        input.nextLine();

                        bookTitle.set(index, newTitle);
                        author.set(index, newAuthor);
                        numberOfPages.set(index, newPages);

                        System.out.println("\n" + indent + GREEN + BOLD +
                                title + " updated successfully!\n" + RESET);

                    } else {
                        System.out.println(indent + RED + "Book not found!\n" + RESET);
                    }
                }

                case 5 -> {

                    System.out.println("\n" + indent + PURPLE + "===== ALL BOOKS =====" + RESET);

                    if (bookTitle.isEmpty()) {

                        System.out.println(indent + YELLOW + "No books available.\n" + RESET);

                    } else {

                        for (int i = 0; i < bookTitle.size(); i++) {

                            System.out.println(indent + CYAN + (i + 1) + ". " +
                                    bookTitle.get(i) + " | " +
                                    author.get(i) + " | " +
                                    numberOfPages.get(i) + " pages" + RESET);
                        }

                        System.out.println();
                    }
                }

                case 0 -> {

                    System.out.println("\n" + indent + RED + BOLD +
                            "Thank you for using Book Suggestion System!" + RESET + "\n");

                    System.exit(0);
                }

                default -> System.out.println(indent + RED + "Invalid option. Try again.\n" + RESET);
            }
        }
    }
}
