import java.util.Scanner;

public class AdminPanel {
    private Scanner scanner = new Scanner(System.in);
    private UserService userService = new UserService();

    public void userManagementOptions() {
        while (true) {
            System.out.println("Welcome to E-Ryder Admininstrator Panel.");
            System.out.println("What do you want to do?");
            System.out.println("1. Add New Users");
            System.out.println("2. View Registered Users");
            System.out.println("3. Remove Registered Users");
            System.out.println("4. Update Registered Users");
            System.out.println("5. Demo the Bike Rental System");
            System.out.println("6. EXIT");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                userService.addUsers();
            } else if (choice == 2) {
                userService.viewUsers();
            } else if (choice == 3) {
                userService.removeUser();
            } else if (choice == 4) {
                userService.updateUser();
            } else if (choice == 5) {
                BikeRental bikeRental = new BikeRental();
                bikeRental.simulateApplicationInput();
            } else if (choice == 6) {
                return;
            } else {
                System.out.println("Invalid choice. Please try again");
            }
        }
    }
}
