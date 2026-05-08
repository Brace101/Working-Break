package UniversityRecord;

import java.util.*;

public class UniversityRecord {

    static Scanner input = new Scanner(System.in);

    static String indent = "\t\t";
    static String indentOne = "\t";
    static String userResponse = "";

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
    static String UNDERLINE = "\u001B[4m";

    static String[] usernames = new String[1000];
    static String[] names = new String[1000];
    static int[] ages = new int[1000];

    static String[][] courses = new String[1000][20];
    static String[] cities = new String[1000];
    static String[] zips = new String[1000];

    static int studentCount = 0;

    static String[] allowedCourses = {
            "Math", "Physics", "Computer Science", "Biology", "Chemistry",
            "Statistics", "English", "Economics", "History", "Philosophy",
            "Sociology", "Political Science", "Geography", "Psychology",
            "Art", "Music", "Engineering", "Law", "Medicine", "Business"
    };

    public static void main(String[] args) {

        System.out.println(indent + RED + "======================================" + RESET);
        System.out.println(indent + BOLD + " SemiColon University Of Lagos Portal " + RESET);
        System.out.println(indent + RED + "======================================" + "\n" + RESET);

        while (true) {

            if (studentCount >= 1000) {
                System.out.println("Student limit reached!");
                break;
            }

            createStudent();

            System.out.print("\n" + indent + CYAN + "Add more student? Yes or No: " + RESET);
            userResponse = input.nextLine();

            if (userResponse.equalsIgnoreCase("no")) break;
        }

        for (int studentIndex = 0; studentIndex < studentCount; studentIndex++) {
            displayStudent(studentIndex);
            System.out.println(indentOne + BOLD + GREEN + "-------------------" + RESET);
        }

        totalStudents();
    }

    static void createStudent() {

        System.out.print(indent + indentOne + BOLD + ITALIC + UNDERLINE + "STUDENT BIO\n" + RESET);

        while (true) {
            System.out.print("\n" + indentOne + CYAN + "Enter Student Username: " + RESET);
            usernames[studentCount] = input.nextLine();

            if (usernames[studentCount].matches("[a-zA-Z0-9]+")) {
                break;
            }

            System.out.println("\n" + indentOne + RED + "Invalid student username, Use only letters and numbers only." + RESET);
        }

        while (true) {
            System.out.print(indentOne + CYAN + "Enter Student Name: " + RESET);
            names[studentCount] = input.nextLine();

            if (names[studentCount].matches("[a-zA-Z ]+")) {
                break;
            }

            System.out.println("\n" + indentOne + RED + "Invalid student name, Use only letters." + RESET);
        }

        while (true) {
            System.out.print(indentOne + CYAN + "Enter Student Age: " + RESET);

            if (input.hasNextInt()) {
                ages[studentCount] = input.nextInt();
                input.nextLine();
                break;

            } else {
                System.out.println("\n" + indentOne + RED + "Invalid age, enter numbers only." + RESET);
                input.nextLine();
            }
        }

        System.out.println("\n" + indentOne + CYAN + "Enter Student courses (type done to stop):" + RESET);

        int courseSlot = 0;

        while (true) {

            String course = input.nextLine();

            if (course.equalsIgnoreCase("done")) break;

            if (!isValidCourse(course)) {
                System.out.println(indent + RED + BOLD + "Invalid course!" + RESET);
                continue;
            }

            if (courseSlot < courses[studentCount].length) {
                courses[studentCount][courseSlot++] = course;
            } else {
                System.out.println(RED + "Course limit reached!" + RESET);
                break;
            }
        }

        while (true){
            System.out.print(indentOne + CYAN + "Enter Student City: " + RESET);
            cities[studentCount] = input.nextLine();

            if (cities[studentCount].matches("[a-zA-Z ]+")) {
                break;
            }

            System.out.println("\n" + indentOne + RED + "Invalid student city, Use only letters." + RESET);
        }

        System.out.print(indentOne + CYAN + "Enter Student Zip Code: " + RESET);
        zips[studentCount] = input.nextLine();

        studentCount++;
    }

    static boolean isValidCourse(String course) {
        for (String allowed : allowedCourses) {
            if (allowed.equalsIgnoreCase(course)) {
                return true;
            }
        }
        return false;
    }

    static void displayStudent(int studentIndex) {

        System.out.println("\n" + indentOne + CYAN + "Username: " + usernames[studentIndex] + RESET);
        System.out.println(indentOne + CYAN + "Name: " + names[studentIndex] + RESET);
        System.out.println(indentOne + CYAN + "Age: " + ages[studentIndex] + RESET);

        System.out.print("\n" + indentOne + CYAN + "Courses:\n" + RESET);

        for (int courseIndex = 0; courseIndex < courses[studentIndex].length; courseIndex++) {
            if (courses[studentIndex][courseIndex] != null) {
                System.out.println("👉️ " + courses[studentIndex][courseIndex]);
            }
        }

        System.out.println("\n" + indentOne + CYAN + "City: " + cities[studentIndex] + RESET);
        System.out.println(indentOne + CYAN + "Zip: " + zips[studentIndex] + RESET);
    }

    static void addCourse(int studentIndex, String course) {

        if (!isValidCourse(course)) {
            System.out.println("Invalid course");
            return;
        }

        for (int courseIndex = 0; courseIndex < courses[studentIndex].length; courseIndex++) {
            if (courses[studentIndex][courseIndex] != null &&
                    course.equalsIgnoreCase(courses[studentIndex][courseIndex])) {
                System.out.println("Already exists");
                return;
            }
        }

        for (int slotIndex = 0; slotIndex < courses[studentIndex].length; slotIndex++) {
            if (courses[studentIndex][slotIndex] == null) {
                courses[studentIndex][slotIndex] = course;
                System.out.println("Added");
                return;
            }
        }

        System.out.println("Course list full");
    }

    static void removeCourse(int studentIndex, String course) {

        for (int courseIndex = 0; courseIndex < courses[studentIndex].length; courseIndex++) {
            if (courses[studentIndex][courseIndex] != null &&
                    course.equalsIgnoreCase(courses[studentIndex][courseIndex])) {

                courses[studentIndex][courseIndex] = null;
                System.out.println("Removed");
                return;
            }
        }

        System.out.println("Not found");
    }

    static void updateStudent(int studentIndex) {

        System.out.print("New name: ");
        names[studentIndex] = input.nextLine();

        System.out.print("New age: ");
        ages[studentIndex] = input.nextInt();
        input.nextLine();

        System.out.print("New city: ");
        cities[studentIndex] = input.nextLine();

        System.out.print("New zip: ");
        zips[studentIndex] = input.nextLine();
    }

    static void totalStudents() {
        System.out.println("Total students: " + studentCount);
    }
}
