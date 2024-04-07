package examseating.ui;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }

    public int getMenuChoice() {
        System.out.println("1. Add Student");
        System.out.println("2. Add Room");
        System.out.println("3. View All Students");
        System.out.println("4. View All Rooms");
        System.out.println("5. Generate Seating Arrangement");
        System.out.println("6. Generate Reports");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }
}
