package controller;

import java.time.LocalDate;

import model.TutorManager;
import view.ConsoleView;

public class TutorController {
    
    private TutorManager manager;
    private ConsoleView view;

    public TutorController(TutorManager manager, ConsoleView view) {
        this.manager = manager;
        this.view = view;
    }

    public void start() {
        while (true) {

            view.showMenu();
            int choice = view.readMenuChoice();
            System.out.println();

            switch (choice) {
                case 1:
                    String name = view.readLine("enter name: ");
                    String course = view.readLine("enter course: ");

                    manager.addStudent(name, course);
                    break;

                case 2:
                    manager.viewStudents();
                    break;

                case 3:
                    // show all students first
                    System.out.println("current students: ");
                    manager.viewStudents();

                    System.out.println("\nenter student ID: ");
                    int studentId = view.readMenuChoice();

                    if (manager.findStudentID(studentId) == null) {
                        System.out.println("...invalid student ID. returning to menu...");
                        break;
                    }

                    LocalDate date = view.readDate("enter session date (YYYY-MM-DD): ");
                    
                    manager.scheduleSession(studentId, date);
                    break;

                case 4:
                    manager.viewSessions();
                    break;

                case 5:
                    // show sessions first
                    manager.viewSessions();

                    System.out.println("\nenter session ID: ");
                    int sessionId = view.readMenuChoice();

                    manager.completeSession(sessionId);
                    break;
            
                case 6:
                    manager.saveData();
                    System.out.println("exiting program...");
                    System.exit(0);

                default:
                    System.out.println("...invalid option. choose between 1 and 6...");
            }
        }
    }
}
