package examseating.seatingarrangement;

import examseating.studentmanagement.Student;
import examseating.roommanagement.Room;
import java.util.*;

public class SeatingArranger {
    public void generateSeatingArrangement(List<Student> students, List<Room> rooms) {
        if (students.isEmpty() || rooms.isEmpty()) {
            System.out.println("Cannot generate seating arrangement. Students or rooms not available.");
            return;
        }

        Map<String, List<Student>> groupedStudents = groupStudentsByClass(students);
        List<Student> shuffledStudents = shuffleStudents(groupedStudents);

        int roomIndex = 0;
        Room currentRoom = rooms.get(roomIndex);
        int seatNumber = 1;
        System.out.println("Room " + currentRoom.getRoomNumber() + " Seating Arrangement:");
        printTableHeader();
        for (Student student : shuffledStudents) {
            if (seatNumber > currentRoom.getCapacity()) {
                seatNumber = 1;
                roomIndex++;
                if (roomIndex >= rooms.size()) {
                    System.out.println("Insufficient capacity in available rooms to accommodate all students.");
                    return;
                }
                currentRoom = rooms.get(roomIndex);
                System.out.println("\nRoom " + currentRoom.getRoomNumber() + " Seating Arrangement:");
                printTableHeader();
            }
            System.out.printf("| %-20s | %-5d | %-10s |\n", student.getName(), student.getId(), student.getStudentClass());
            seatNumber++;
        }
    }

    private Map<String, List<Student>> groupStudentsByClass(List<Student> students) {
        Map<String, List<Student>> groupedStudents = new HashMap<>();
        for (Student student : students) {
            groupedStudents.computeIfAbsent(student.getStudentClass(), k -> new ArrayList<>()).add(student);
        }
        return groupedStudents;
    }

    private List<Student> shuffleStudents(Map<String, List<Student>> groupedStudents) {
        List<List<Student>> shuffledLists = new ArrayList<>();
        for (List<Student> students : groupedStudents.values()) {
            Collections.shuffle(students);
            shuffledLists.add(students);
        }
        return interleaveLists(shuffledLists);
    }

    private List<Student> interleaveLists(List<List<Student>> lists) {
        List<Student> result = new ArrayList<>();
        int maxSize = lists.stream().mapToInt(List::size).max().orElse(0);
        for (int i = 0; i < maxSize; i++) {
            for (List<Student> list : lists) {
                if (i < list.size()) {
                    result.add(list.get(i));
                }
            }
        }
        return result;
    }

    private void printTableHeader() {
        System.out.println("+----------------------+-------+------------+");
        System.out.println("| Student Name         |  ID   |   Class    |");
        System.out.println("+----------------------+-------+------------+");
    }
}