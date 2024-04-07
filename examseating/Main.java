package examseating;

import examseating.reporting.ReportGenerator;
import examseating.roommanagement.Room;
import examseating.roommanagement.RoomManager;
import examseating.seatingarrangement.SeatingArranger;
import examseating.studentmanagement.Student;
import examseating.studentmanagement.StudentManager;
import examseating.ui.UserInterface;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager studentManager = new StudentManager();
        RoomManager roomManager = new RoomManager();
        UserInterface userInterface = new UserInterface();
        SeatingArranger seatingArranger = new SeatingArranger();
        ReportGenerator reportGenerator = new ReportGenerator();

        while (true) {
            int choice = userInterface.getMenuChoice();

            switch (choice) {
                case 1:
                    addStudent(studentManager, scanner);
                    break;
                case 2:
                    addRoom(roomManager, scanner);
                    break;
                case 3:
                    studentManager.displayAllStudents();
                    break;
                case 4:
                    roomManager.displayAllRooms();
                    break;
                case 5:
                    seatingArranger.generateSeatingArrangement(studentManager.getStudents(), roomManager.getRooms());
                    setSeatNumbers(studentManager);
                    break;
                case 6:
                    reportGenerator.generateReports(studentManager, roomManager);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void addStudent(StudentManager studentManager, Scanner scanner) {
        System.out.print("Enter student name: ");
        String name = scanner.next();
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter student class: ");
        String studentClass = scanner.next();
        studentManager.addStudent(new Student(name, id, studentClass));
    }

    private static void addRoom(RoomManager roomManager, Scanner scanner) {
        System.out.print("Enter room number: ");
        int roomNumber = scanner.nextInt();
        System.out.print("Enter room capacity: ");
        int capacity = scanner.nextInt();
        roomManager.addRoom(new Room(roomNumber, capacity));
    }

    private static void setSeatNumbers(StudentManager studentManager) {
        int seatNumber = 1;
        for (Student student : studentManager.getStudents()) {
            student.setSeatNumber(seatNumber++);
        }
    }
}