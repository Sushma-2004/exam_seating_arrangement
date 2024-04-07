package examseating.studentmanagement;

public class Student {
    private String name;
    private int id;
    private String studentClass;
    private int seatNumber;

    public Student(String name, int id, String studentClass) {
        this.name = name;
        this.id = id;
        this.studentClass = studentClass;
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
}
