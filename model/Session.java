package model;

import java.time.LocalDate;

public class Session {

    private int id;
    private Student student;
    private LocalDate date;
    private boolean completed;

    public Session(int id, Student student, LocalDate date) {
        this.id = id;
        this.student = student;
        this.date = date;
        this.completed = false; // default value
    }

    public int getId() {
        return id;
    }
    public Student getStudent() {
        return student;
    }
    public LocalDate getDate() {
        return date;
    }
    public boolean isCompleted() {
        return completed;
    }

    // mark the session as completed
    public void markCompleted() {
        this.completed = true;
    }

    // display session details
    @Override
    public String toString() {
        return  "session ID: " + id +
                " | student: " + student.getName() +
                " | course: " + student.getCourse() +
                " | date: " + date +
                " | status: " + (completed ? "Completed" : "Scheduled");
    }
}
