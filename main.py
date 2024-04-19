class Booking:
    def __init__(self, name, seat_no , source , destination):
        self.name = name
        self.seat_no = seat_no
        self.source = source
        self.destination = destination
        # Add more fields as needed

class BusBookingSystem:
    def __init__(self):
        self.bookings = []

    def book_seat(self):
        name = input("Enter name: ")
        seat_no = int(input("Enter seat number: "))
        source = input("Enter Source: ")
        destination = input("Enter Destination: ")
        # Add more input fields as needed

        new_booking = Booking(name, seat_no , source , destination)
        self.bookings.append(new_booking)
        print("Seat booked successfully.")

    def view_reservations(self):
        if not self.bookings:
            print("No reservations made yet.")
            return

        print("All reservations:")
        print("Seat No.\tName\t\tSource\t\tDestination")
        
        for booking in self.bookings:
            print("--------------------------------------------------------------")
            print(f"{booking.seat_no}\t\t{booking.name}\t\t{booking.source}\t\t{booking.destination}")

    def edit_reservation(self):
        seat_to_edit = int(input("Enter seat number to edit: "))

        found = False
        for booking in self.bookings:
            if booking.seat_no == seat_to_edit:
                booking.name = input("Enter new name: ")
                booking.source = input("Enter new source: ")
                booking.destination = input("Enter new destination: ")
                # Add more fields to edit as needed

                print("Reservation edited successfully.")
                found = True
                break

        if not found:
            print("Reservation not found.")

    def print_ticket(self):
        seat_to_print = int(input("Enter seat number to print ticket: "))

        found = False
        for booking in self.bookings:
            if booking.seat_no == seat_to_print:
                print(f"Ticket for Seat No. {booking.seat_no}")
                print(f"Passenger Name: {booking.name}")
                print(f"Passenger Source: {booking.source}")
                print(f"Passenger Destination: {booking.destination}")
                # Add more fields to print as needed

                found = True
                break

        if not found:
            print("Reservation not found.")

def main():
    system = BusBookingSystem()
    choice = 0

    while choice != 5:
        print("\nMini Bus Booking System")
        print("1. Book a seat")
        print("2. View reservations")
        print("3. Edit a reservation")
        print("4. Print a ticket")
        print("5. Exit")
        choice = int(input("Enter your choice: "))

        if choice == 1:
            system.book_seat()
        elif choice == 2:
            system.view_reservations()
        elif choice == 3:
            system.edit_reservation()
        elif choice == 4:
            system.print_ticket()
        elif choice == 5:
            print("Exiting...")
        else:
            print("Invalid choice. Please enter a valid option.")

if __name__ == "__main__":
    main()
