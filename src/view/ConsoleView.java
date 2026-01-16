package view;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ConsoleView {
    
    private Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.println("\n--- TUTOR SESSION MANAGEMENT ---");
        System.out.println("1. add student");
        System.out.println("2. view students");
        System.out.println("3. schedule session");
        System.out.println("4. view session");
        System.out.println("5. mark session as completed");
        System.out.println("6. exit");
    }

    // safe integer input which prevents letters
    public int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);

            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            }
            System.out.println("...invalid input. please enter a number...");
            scanner.nextLine();
        }
    }

    public int readMenuChoice() {
            
        while (true) {
            System.out.print("choose an option: ");

            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            } else {
                System.out.println("\n...invalid input. returning to menu...");
                scanner.nextLine();
                showMenu();
            }
        }
    }

    // non-empty text input
    public String readLine(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("...input cannot be empty...");
        }
    }

    // date validation basic
    public LocalDate readDate(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();

            try {
                return LocalDate.parse(input);
            } catch (DateTimeParseException e) {
                System.out.println("...invalid date. use format YYYY-MM-DD...");
            }
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
