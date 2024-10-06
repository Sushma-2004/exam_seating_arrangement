package examseating.fileio;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import examseating.roommanagement.Room;
import examseating.studentmanagement.Student;

public class FileHandler {
    public static void writeToFile(String content, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
            System.out.println("Data written to file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to file: " + e.getMessage());
        }
    }

    public static void writeStudentsToFile(List<Student> students, String filePath) {
        StringBuilder sb = new StringBuilder();
        for (Student student : students) {
            sb.append(student.toString()).append("\n");
        }
        writeToFile(sb.toString(), filePath);
    }

    public static void writeRoomsToFile(List<Room> rooms, String filePath) {
        StringBuilder sb = new StringBuilder();
        for (Room room : rooms) {
            sb.append(room.toString()).append("\n");
        }
        writeToFile(sb.toString(), filePath);
    }

    public static void writeSeatingArrangementToFile(List<Student> students, List<Room> rooms, String filePath) {
        StringBuilder sb = new StringBuilder();
        int roomIndex = 0;
        Room currentRoom = rooms.get(roomIndex);
        int seatNumber = 1;

        sb.append("Seating Arrangement:\n\n");

        for (Student student : students) {
            if (seatNumber > currentRoom.getCapacity()) {
                seatNumber = 1;
                roomIndex++;
                if (roomIndex >= rooms.size()) break;
                currentRoom = rooms.get(roomIndex);
                sb.append("\n\nRoom " + currentRoom.getRoomNumber() + ":\n");
            }
            sb.append("Seat ").append(seatNumber).append(": ").append(student.toString()).append("\n");
            seatNumber++;
        }

        writeToFile(sb.toString(), filePath);
    }
}