import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class AdminPanel {
    private ArrayList<RegisteredUsers> registeredUsersList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

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
                addNewUsers();
            } else if (choice == 2) {
                viewRegisteredUsers();
            } else if (choice == 3) {
                removeRegisteredUsers();
            } else if (choice == 4) {
                updateRegisteredUsers();
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

    private void addNewUsers() {
        System.out.print("How many users would you like to add? ");
        int numberOfUsers = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfUsers; i++) {
            System.out.println("\nAdding user " + (i + 1) + " of " + numberOfUsers + ":");

            System.out.print("Enter full name: ");
            String fullName = scanner.nextLine();

            System.out.print("Enter email address: ");
            String emailAddress = scanner.nextLine();

            System.out.print("Enter date of birth (YYYY-MM-DD): ");
            String dateOfBirth = scanner.nextLine();

            System.out.print("Enter card number: ");
            long cardNumber = scanner.nextLong();
            scanner.nextLine();

            System.out.print("Enter card provider: ");
            String cardProvider = scanner.nextLine();

            System.out.print("Enter card expiry date (MM/YY): ");
            String cardExpiryDate = scanner.nextLine();

            System.out.print("Enter CVV: ");
            int cvv = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter user type: ");
            String userType = scanner.nextLine();

            String[] lastThreeTrips = new String[3];
            for (int t = 0; t < lastThreeTrips.length; t++) {
                System.out.println("\nTrip " + (t + 1) + " details:");

                System.out.print("Enter date of the trip (YYYY-MM-DD): ");
                String tripDate = scanner.nextLine();

                System.out.print("Enter source: ");
                String source = scanner.nextLine();

                System.out.print("Enter destination: ");
                String destination = scanner.nextLine();

                System.out.print("Enter fare (€): ");
                double fare = scanner.nextDouble();
                scanner.nextLine();

                System.out.print("Enter feedback (can be blank): ");
                String feedback = scanner.nextLine();
                if (feedback.isEmpty()) {
                    feedback = "NULL";
                }

                StringBuilder sb = new StringBuilder();
                sb.append("Date: ").append(tripDate)
                  .append(", Source: ").append(source)
                  .append(", Destination: ").append(destination)
                  .append(", Fare (€): ").append(fare)
                  .append(", Feedback: ").append(feedback);

                lastThreeTrips[t] = sb.toString();
            }

            RegisteredUsers user = new RegisteredUsers(
                    fullName,
                    emailAddress,
                    dateOfBirth,
                    cardNumber,
                    cardExpiryDate,
                    cardProvider,
                    cvv,
                    userType,
                    lastThreeTrips
            );

            registeredUsersList.add(user);
            System.out.println("User added successfully.");
        }
    }

    private void viewRegisteredUsers() {
        if (registeredUsersList.isEmpty()) {
            System.out.println("No registered users to display");
            return;
        }

        for (RegisteredUsers user : registeredUsersList) {
            System.out.println(user);
        }
    }

    private void removeRegisteredUsers() {
        if (registeredUsersList.isEmpty()) {
            System.out.println("No registered users to remove");
            return;
        }

        System.out.print("Enter the email address of the user to remove: ");
        String email = scanner.nextLine();

        boolean found = false;
        Iterator<RegisteredUsers> iterator = registeredUsersList.iterator();
        while (iterator.hasNext()) {
            RegisteredUsers user = iterator.next();
            if (user.getEmailAddress() != null && user.getEmailAddress().equalsIgnoreCase(email)) {
                iterator.remove();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No user found with this email address");
        } else {
            System.out.println("User removed successfully.");
        }
    }

    private void updateRegisteredUsers() {
        if (registeredUsersList.isEmpty()) {
            System.out.println("No registered users to remove");
            return;
        }

        System.out.print("Enter the email address of the user to update: ");
        String email = scanner.nextLine();

        RegisteredUsers registeredUser = null;
        for (RegisteredUsers user : registeredUsersList) {
            if (user.getEmailAddress() != null && user.getEmailAddress().equalsIgnoreCase(email)) {
                registeredUser = user;
                break;
            }
        }

        if (registeredUser == null) {
            System.out.println("No user found with this email address");
            return;
        }

        System.out.print("Type new full name: (Press ENTER for no change) ");
        String fullName = scanner.nextLine();
        if (!fullName.isEmpty()) {
            registeredUser.setFullName(fullName);
        }

        System.out.print("Type new email address: (Press ENTER for no change) ");
        String emailAddress = scanner.nextLine();
        if (!emailAddress.isEmpty()) {
            registeredUser.setEmailAddress(emailAddress);
        }

        System.out.print("Type new date of birth (YYYY-MM-DD): (Press ENTER for no change) ");
        String dob = scanner.nextLine();
        if (!dob.isEmpty()) {
            registeredUser.setDateOfBirth(dob);
        }

        System.out.print("Type new card number: (Enter 0 for no change) ");
        long cardNumber = scanner.nextLong();
        scanner.nextLine();
        if (cardNumber != 0) {
            registeredUser.setCardNumber(cardNumber);
        }

        System.out.print("Type new card provider: (Press ENTER for no change) ");
        String provider = scanner.nextLine();
        if (!provider.isEmpty()) {
            registeredUser.setCardProvider(provider);
        }

        System.out.print("Type new card expiry date (MM/YY): (Press ENTER for no change) ");
        String expiry = scanner.nextLine();
        if (!expiry.isEmpty()) {
            registeredUser.setCardExpiryDate(expiry);
        }

        System.out.print("Type new CVV: (Enter 0 for no change) ");
        int cvv = scanner.nextInt();
        scanner.nextLine();
        if (cvv != 0) {
            registeredUser.setCvv(cvv);
        }

        System.out.print("Type new user type: (Press ENTER for no change) ");
        String userType = scanner.nextLine();
        if (!userType.isEmpty()) {
            registeredUser.setUserType(userType);
        }

        System.out.println("User updated successfully.");
    }
}
