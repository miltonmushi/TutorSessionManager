package model;

public class Student {

    // private variables = encapsulation
    private int id;
    private String name;
    private String course;

    // constructor = used to create a new Student object
    public Student(int id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    // getter methods to access private data
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getCourse() {
        return course;
    }


    // converts the object to a readable string
    @Override
    public String toString() {
        return id + ". " + name + " (" + course + ")";
    }
}
