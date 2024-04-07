package examseating.reporting;

import examseating.studentmanagement.Student;
import examseating.studentmanagement.StudentManager;
import examseating.roommanagement.Room;
import examseating.roommanagement.RoomManager;

import java.util.List;

public class ReportGenerator {
    public void generateReports(StudentManager studentManager, RoomManager roomManager) {
        System.out.println("Generating reports...");
        
        // Generate student report
        generateStudentReport(studentManager);
        
        // Generate room report
        generateRoomReport(roomManager);
        
        System.out.println("Reports generated successfully!");
    }

    private void generateStudentReport(StudentManager studentManager) {
        List<Student> students = studentManager.getStudents();
        System.out.println("Student Report:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void generateRoomReport(RoomManager roomManager) {
        List<Room> rooms = roomManager.getRooms();
        System.out.println("Room Report:");
        for (Room room : rooms) {
            System.out.println(room);
        }
    }
}
