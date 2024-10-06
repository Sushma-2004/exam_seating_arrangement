package examseating.roommanagement;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private int roomNumber;
    private int capacity;
    private static List<Room> allRooms = new ArrayList<>();

    public Room(int roomNumber, int capacity) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        allRooms.add(this);
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Room{" +
               "roomNumber=" + roomNumber +
               ", capacity=" + capacity +
               '}';
    }

    // Static method to get all rooms
    public static List<Room> getAllRooms() {
        return allRooms;
    }
}