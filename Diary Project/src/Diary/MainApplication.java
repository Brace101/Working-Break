package Diary;

import java.util.Scanner;

public class MainApplication {

    static String indent = "\t\t";
    static String indentOne = "\t";

    static String GREEN = "\u001B[32m";
    static String RED = "\u001B[31m";
    static String YELLOW = "\u001B[33m";
    static String RESET = "\u001B[0m";
    static String PURPLE = "\u001B[35m";
    static String CYAN = "\u001B[36m";
    static String BOLD = "\u001B[1m";

    private static Diaries diaries = new Diaries();

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        boolean running = true;

        while (running) {

            System.out.println(indent + BOLD + GREEN + "===== DIARY APPLICATION =====" + RESET);

            System.out.println(indentOne + CYAN + "1. Create Diary" + RESET);
            System.out.println(indentOne + CYAN + "2. Create Entry" + RESET);
            System.out.println(indentOne + CYAN + "3. View Entries" + RESET);
            System.out.println(indentOne + CYAN + "4. Lock Diary" + RESET);
            System.out.println(indentOne + CYAN + "5. Unlock Diary" + RESET);
            System.out.println(indentOne + CYAN + "6. Delete Entry" + RESET);
            System.out.println(indentOne + CYAN + "7. Exit" + RESET);

            System.out.print(indent + YELLOW + BOLD + "Choose an option: " + RESET);

            int option;

            try {
                option = input.nextInt();
                input.nextLine();
            } catch (Exception error) {
                System.out.println(indent + RED + BOLD + "Invalid input" + RESET + "\n");
                input.nextLine();
                continue;
            }

            try {

                switch (option) {

                    case 1 -> {

                        System.out.println("\n" + indent + PURPLE + "===== CREATE DIARY =====" + RESET);

                        System.out.print(indentOne + CYAN + "Enter username: " + RESET);
                        String username = input.nextLine();

                        System.out.print(indentOne + CYAN + "Enter password: " + RESET);
                        String password = input.nextLine();

                        diaries.add(username, password);

                        System.out.println("\n" + indent + GREEN + BOLD +
                                "Diary created successfully" + RESET + "\n");
                    }

                    case 2 -> {

                        System.out.println("\n" + indent + PURPLE + "===== CREATE ENTRY =====" + RESET);

                        System.out.print(indentOne + CYAN + "Enter username: " + RESET);
                        String username = input.nextLine();

                        Diary diary = diaries.findByUsername(username);

                        if (diary == null) {
                            System.out.println(indent + RED + "Diary not found\n" + RESET);
                            break;
                        }

                        System.out.print(indentOne + CYAN + "Enter password: " + RESET);
                        String password = input.nextLine();

                        diary.unlockDiary(password);

                        System.out.print(indentOne + CYAN + "Enter title: " + RESET);
                        String title = input.nextLine();

                        System.out.print(indentOne + CYAN + "Enter body: " + RESET);
                        String body = input.nextLine();

                        diary.createEntry(title, body);

                        System.out.println("\n" + indent + GREEN + BOLD +
                                "Entry created successfully" + RESET + "\n");
                    }

                    case 3 -> {

                        System.out.println("\n" + indent + PURPLE + "===== VIEW ENTRIES =====" + RESET);

                        System.out.print(indentOne + CYAN + "Enter username: " + RESET);
                        String username = input.nextLine();

                        Diary diary = diaries.findByUsername(username);

                        if (diary == null) {
                            System.out.println(indent + RED + "Diary not found\n" + RESET);
                            break;
                        }

                        System.out.print(indentOne + CYAN + "Enter password: " + RESET);
                        String password = input.nextLine();

                        diary.unlockDiary(password);

                        System.out.println("\n" + indent + YELLOW + BOLD + "===== YOUR ENTRIES =====" + RESET);

                        for (Entry entry : diary.getEntries()) {
                            System.out.println(entry);
                        }

                        System.out.println();
                    }

                    case 4 -> {

                        System.out.println("\n" + indent + PURPLE + "===== LOCK DIARY =====" + RESET);

                        System.out.print(indentOne + CYAN + "Enter username: " + RESET);
                        String username = input.nextLine();

                        Diary diary = diaries.findByUsername(username);

                        if (diary == null) {
                            System.out.println(indent + RED + "Diary not found\n" + RESET);
                            break;
                        }

                        diary.lockDiary();

                        System.out.println("\n" + indent + GREEN + BOLD +
                                "Diary locked successfully" + RESET + "\n");
                    }

                    case 5 -> {

                        System.out.println("\n" + indent + PURPLE + "===== UNLOCK DIARY =====" + RESET);

                        System.out.print(indentOne + CYAN + "Enter username: " + RESET);
                        String username = input.nextLine();

                        Diary diary = diaries.findByUsername(username);

                        if (diary == null) {
                            System.out.println(indent + RED + "Diary not found\n" + RESET);
                            break;
                        }

                        System.out.print(indentOne + CYAN + "Enter password: " + RESET);
                        String password = input.nextLine();

                        diary.unlockDiary(password);

                        System.out.println("\n" + indent + GREEN + BOLD +
                                "Diary unlocked successfully" + RESET + "\n");
                    }

                    case 6 -> {

                        System.out.println("\n" + indent + PURPLE + "===== DELETE ENTRY =====" + RESET);

                        System.out.print(indentOne + CYAN + "Enter username: " + RESET);
                        String username = input.nextLine();

                        Diary diary = diaries.findByUsername(username);

                        if (diary == null) {
                            System.out.println(indent + RED + "Diary not found\n" + RESET);
                            break;
                        }

                        System.out.print(indentOne + CYAN + "Enter password: " + RESET);
                        String password = input.nextLine();

                        diary.unlockDiary(password);

                        System.out.print(indentOne + CYAN + "Enter entry ID: " + RESET);
                        int id = input.nextInt();
                        input.nextLine();

                        diary.deleteEntry(id);

                        System.out.println("\n" + indent + GREEN + BOLD +
                                "Entry deleted successfully" + RESET + "\n");
                    }

                    case 7 -> {

                        running = false;

                        System.out.println("\n" + indent + RED + BOLD +
                                "Thank you for using the Diary App" + RESET + "\n");

                        continue;
                    }

                    default -> System.out.println(indent + RED + "Invalid option\n" + RESET);
                }

                System.out.print(indent + YELLOW + "Do you want to performe other activities? (yes/no): ");
                String answer = input.nextLine();

                if (!answer.equalsIgnoreCase("yes")) {

                    running = false;

                    System.out.println("\n" + indent + GREEN + BOLD +
                            "Thank you for using the Diary App" + RESET + "\n");
                }

            } catch (Exception error) {

                System.out.println("\n" + indent + RED + BOLD +
                        error.getMessage() + RESET + "\n");
            }
        }
    }
}