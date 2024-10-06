package examseating.studentmanagement;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private int id;
    private String studentClass;
    private int seatNumber;
    private static List<Student> allStudents = new ArrayList<>();

    public Student(String name, int id, String studentClass) {
        this.name = name;
        this.id = id;
        this.studentClass = studentClass;
        allStudents.add(this);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
               "name='" + name + '\'' +
               ", id=" + id +
               ", studentClass='" + studentClass + '\'' +
               ", seatNumber=" + seatNumber +
               '}';
    }

    // Static method to get all students
    public static List<Student> getAllStudents() {
        return allStudents;
    }
}