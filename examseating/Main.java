package examseating;

import javax.swing.*;

import examseating.fileio.FileHandler;
import examseating.reporting.ReportGenerator;
import examseating.roommanagement.Room;
import examseating.roommanagement.RoomManager;
import examseating.seatingarrangement.SeatingArranger;
import examseating.studentmanagement.Student;
import examseating.studentmanagement.StudentManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private JFrame frame;
    private JTextField roomNumberField;
    private JTextField roomCapacityField;
    private List<Student> students;
    private List<Room> rooms;
    private StudentManager studentManager;
    private RoomManager roomManager;
    private SeatingArranger seatingArranger;
    private ReportGenerator reportGenerator;

    public Main() {
        students = new ArrayList<>();
        rooms = new ArrayList<>();
        studentManager = new StudentManager();
        roomManager = new RoomManager();
        seatingArranger = new SeatingArranger();
        reportGenerator = new ReportGenerator();

        createAndShowGUI();
    }

    private void createAndShowGUI() {
        frame = new JFrame("Exam Seating Arrangement");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JButton addButton = new JButton("Add Student");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });
        panel.add(addButton);

        JButton addRoomButton = new JButton("Add Room");
        addRoomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addRoom();
            }
        });
        panel.add(addRoomButton);

        JButton displayStudentsButton = new JButton("Display Students");
        displayStudentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayStudents();
            }
        });
        panel.add(displayStudentsButton);

        JButton displayRoomsButton = new JButton("Display Rooms");
        displayRoomsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayRooms();
            }
        });
        panel.add(displayRoomsButton);

        JButton arrangeSeatsButton = new JButton("Arrange Seats");
        arrangeSeatsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                arrangeSeats();
            }
        });
        panel.add(arrangeSeatsButton);

        JButton generateReportButton = new JButton("Generate Report");
        generateReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateReport();
            }
        });
        panel.add(generateReportButton);

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel.add(exitButton);

        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private void arrangeSeats() {
        seatingArranger.generateSeatingArrangement(students, rooms);
        setSeatNumbers();

        // Save seating arrangement to file
        FileHandler.writeSeatingArrangementToFile(students, rooms, "seating_arrangement.txt");
    }

    private void generateReport() {
        reportGenerator.generateReports(studentManager, roomManager);

        FileHandler.writeStudentsToFile(students, "students_report.txt");
        FileHandler.writeRoomsToFile(rooms, "rooms_report.txt");
    }

    private void addStudent() {
        String name = JOptionPane.showInputDialog(frame, "Enter student name:");
        int id = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter student ID:"));
        String classValue = JOptionPane.showInputDialog(frame, "Enter student class:");

        students.add(new Student(name, id, classValue));
        studentManager.addStudent(new Student(name, id, classValue));
        roomNumberField.setText("");
        roomCapacityField.setText("");
    }

    private void addRoom() {
        int roomNumber = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter room number:"));
        int capacity = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter room capacity:"));

        rooms.add(new Room(roomNumber, capacity));
        roomManager.addRoom(new Room(roomNumber, capacity));
        roomNumberField.setText("");
        roomCapacityField.setText("");
    }

    private void displayStudents() {
        StringBuilder sb = new StringBuilder();
        for (Student student : students) {
            sb.append(student).append("\n");
        }
        JOptionPane.showMessageDialog(frame, sb.toString());
    }

    private void displayRooms() {
        StringBuilder sb = new StringBuilder();
        for (Room room : roomManager.getRooms()) {
            sb.append(room).append("\n");
        }
        JOptionPane.showMessageDialog(frame, sb.toString());
    }

    private void setSeatNumbers() {
        int seatNumber = 1;
        for (Student student : students) {
            student.setSeatNumber(seatNumber++);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
}