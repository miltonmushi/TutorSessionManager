package model;

import java.util.ArrayList;
import java.io.*;
import java.time.LocalDate;

// this class keeps track of all students and sessions "brain"
public class TutorManager {

    // lists to store students and sessions
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Session> sessions = new ArrayList<>();

    // counter to generate unique student IDs
    private int nextStudentId = 1;
    private int nextSessionId = 1;

    // add a new student
    public void addStudent(String name, String course) {
        Student existing = findStudentNameCourse(name, course);

        if (existing != null) {
            System.out.println("...student already exists...");
            return;
        }

        Student student = new Student(nextStudentId++, name, course);
        students.add(student);
        System.out.println("...student added sucessfully...");
    }

    // find a student by ID
    public Student findStudentID(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    // check if student already has a session on the same date
    private boolean hasSession(Student student, LocalDate date) {
        for (Session session : sessions) {
            if (session.getStudent().getId() == student.getId() && session.getDate().equals(date)) {
                return true;
            }
        }
        return false;
    }

    // schedule a new session
    public boolean scheduleSession(int studentId, LocalDate date) {
        Student student = findStudentID(studentId);

        // stop immediately if student does not exist
        if (student == null) {
            System.out.println("...student not found. session not scheduled...");
            return false;
        }

        // parse the date and check if it's in the past
        if (date.isBefore(LocalDate.now())) {
            System.out.println("...cannot schedule a session in the past...");
            return false;
        }

        // prevent same date booking
        if (hasSession(student, date)) {
            System.out.println("...this student has a session on that date...");
            return false;
        }

        sessions.add(new Session(nextSessionId++, student, date));
        System.out.println("...session scheduled successfully...");
        return true;
    }

    // mark a session as completed
    public void completeSession(int sessionId) {
        for (Session session : sessions) {
            if (session.getId() == sessionId) {
                if (session.isCompleted()) {
                    System.out.println("...session is already completed...");
                    return;
                }

                session.markCompleted();
                System.out.println("...session marked as completed...");
                return;
            }
        }
        System.out.println("...session not found...");
    }

    // view all students
    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("...no students found...");
            return;
        }

        for (Student student : students) {
            System.out.println(student);
        }
    }

    // view all sessions
    public void viewSessions() {
        if (sessions.isEmpty()) {
            System.out.println("...no sessions scheduled...");
            return;
        }

        for (Session session : sessions) {
            System.out.println(session);
        }
    }

    // load all data from file
    public void loadData() {
        File file = new File("src/database.txt");

        if (!file.exists())
            return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");

                int sessionId = Integer.parseInt(parts[0]);
                int studentId = Integer.parseInt(parts[1]);
                String name = parts[2];
                String course = parts[3];
                LocalDate date = LocalDate.parse(parts[4]);
                boolean completed = Boolean.parseBoolean(parts[5]);

                // check if student already exists
                Student student = findStudentID(studentId);
                if (student == null) {
                    student = new Student(studentId, name, course);
                    students.add(student);
                }

                Session session = new Session(sessionId, student, date);
                if (completed) session.markCompleted();
                sessions.add(session);

                nextStudentId = Math.max(nextStudentId, studentId + 1);
                nextSessionId = Math.max(nextSessionId, sessionId + 1);
            }
        } catch (IOException e) {
            System.out.println("...failed to load data...");
        }
    }

    // save all data to file
    public void saveData() {
        try (PrintWriter pw = new PrintWriter(new FileWriter("src/database.txt"))) {
            for (Session s : sessions) {
                pw.println(
                    s.getId() + ", " +
                    s.getStudent().getId() + ", " +
                    s.getStudent().getName() + ", " +
                    s.getStudent().getCourse() + ", " +
                    s.getDate() + ", " +
                    s.isCompleted()
                );
            }
        } catch (IOException e) {
            System.out.println("...failed to save data...");
        }
    }

    private Student findStudentNameCourse(String name, String course) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name) && student.getCourse().equalsIgnoreCase(course)) {
                return student;
            }
        }
        return null;
    }
}
