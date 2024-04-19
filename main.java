import java.util.ArrayList;
import java.util.Scanner;

class Booking {
    String name;
    int seatNo;
    // Add more fields as needed

    public Booking(String name, int seatNo) {
        this.name = name;
        this.seatNo = seatNo;
        // Initialize other fields as needed
    }
}

class BusBookingSystem {
    private ArrayList<Booking> bookings = new ArrayList<>();

    public void bookSeat() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter seat number: ");
        int seatNo = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Add more input fields as needed

        Booking newBooking = new Booking(name, seatNo);
        bookings.add(newBooking);
        System.out.println("Seat booked successfully.");
    }

    public void viewReservations() {
        if (bookings.isEmpty()) {
            System.out.println("No reservations made yet.");
            return;
        }

        System.out.println("All reservations:");
        System.out.println("Seat No.\tName");
        for (Booking booking : bookings) {
            System.out.println(booking.seatNo + "\t\t" + booking.name);
        }
    }

    public void editReservation() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter seat number to edit: ");
        int seatToEdit = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        boolean found = false;
        for (Booking booking : bookings) {
            if (booking.seatNo == seatToEdit) {
                System.out.print("Enter new name: ");
                booking.name = scanner.nextLine();
                // Add more fields to edit as needed

                System.out.println("Reservation edited successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Reservation not found.");
        }
    }

    public void printTicket() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter seat number to print ticket: ");
        int seatToPrint = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        boolean found = false;
        for (Booking booking : bookings) {
            if (booking.seatNo == seatToPrint) {
                System.out.println("Ticket for Seat No. " + booking.seatNo);
                System.out.println("Passenger Name: " + booking.name);
                // Add more fields to print as needed

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Reservation not found.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BusBookingSystem system = new BusBookingSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMini Bus Booking System");
            System.out.println("1. Book a seat");
            System.out.println("2. View reservations");
            System.out.println("3. Edit a reservation");
            System.out.println("4. Print a ticket");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    system.bookSeat();
                    break;
                case 2:
                    system.viewReservations();
                    break;
                case 3:
                    system.editReservation();
                    break;
                case 4:
                    system.printTicket();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 5);
    }
}
