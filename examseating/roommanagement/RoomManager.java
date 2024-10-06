package examseating.roommanagement;

import java.util.ArrayList;
import java.util.List;

public class RoomManager {
    private List<Room> rooms;

    public RoomManager() {
        this.rooms = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
        System.out.println("Room added successfully.");
    }

    public void displayAllRooms() {
        System.out.println("All Rooms:");
        for (Room room : rooms) {
            System.out.println(room);
        }
    }

    public List<Room> getRooms() {
        return rooms;
    }
}