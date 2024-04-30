import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AirPlane {
    public static void main(String[] args) throws Exception {
        
        List<Flight> selectedFlights = new ArrayList<>();

        Scanner scan1 = new Scanner(System.in);
        String name1, password1, email1;
        int money;

        boolean check = true;

        System.out.println("Enter your name: ");
        name1 = scan1.nextLine();
        System.out.println("Enter your password: ");
        password1 = scan1.nextLine();
        System.out.println("Enter your email:");
        email1 = scan1.nextLine();
        System.out.println("How much money do you have: ");
        money = scan1.nextInt();


        User user1 = new User(name1, password1, email1,money);

        
        List<Flight> flights = new ArrayList<>();

        flights.add(new Flight("İstanbul - Malatya", "29.01.2024", 50,100));
        flights.add(new Flight("İstanbul - Düzce", "13.01.2024", 47,200));
        flights.add(new Flight("İstanbul - BosnaHersek", "23.02.2024", 60,300));
        flights.add(new Flight("İstanbul - Gaziantep", "19.12.2025", 40,400));
        flights.add(new Flight("İstanbul - İzmir", "18.03.2024", 43,500));
        flights.add(new Flight("İstanbul - Rize", "04.02.2024", 44,600));

        while (check) {
            System.out.println("\nEnter 1 for see flights\nEnter 2 for make reservation\nEnter 3 check the reservation ticket\nEnter 4 for Exit");
            int fchoose = scan1.nextInt();

            switch (fchoose) {
                case 1:
                    System.out.println("------------");
                    for (Flight flight : flights) {
                        System.out.println("Flight Route: " + flight.getRoute());
                        System.out.println("Departure Date: " + flight.getDate());
                        System.out.println("Available Seats: " + flight.getAvailableSeats());
                        System.out.println("------------");
                    }
                    break;
                case 2:
                
                int choice;
                System.out.print("\nEnter the number of the flight you want to choose (0 to finish): ");
                choice = scan1.nextInt();
                if (choice != 0 && choice >= 1 && choice <= flights.size()) {
                    Flight selectedFlight = flights.get(choice - 1);
                    selectedFlights.add(selectedFlight);
                    System.out.println("You have chosen the following flight:");
                    System.out.println("Route: " + selectedFlight.getRoute());
                    System.out.println("Date: " + selectedFlight.getDate());
                    selectedFlight.setAvailableSeats(selectedFlight.getAvailableSeats() - 1);
                    System.out.println("Available Seats: " + selectedFlight.getAvailableSeats());
                    System.out.println("Flight price is: " + selectedFlight.getPrice());
                
                    int total = user1.getMoney() - selectedFlight.getPrice();
                    if (total >= 0) {
                        user1.setMoney(total);
                        System.out.print("Enter your seat number: ");
                        int seatNumber = scan1.nextInt();
                
                        Reservation reservation = new Reservation(user1, selectedFlight, seatNumber);
                
                        Payment payment = new Payment(reservation, selectedFlight.getPrice(), "Credit Card");

                        System.out.println("Remaining Money: " + total);

                        payment.processPayment();
                    } else {
                        System.out.println("Insufficient funds. You cannot make this reservation.");
                        selectedFlights.remove(selectedFlight);
                    }
                
                    System.out.println("----------------------------");
                } else if (choice != 0) {
                    System.out.println("Invalid choice. Please enter a number between 1 and " + flights.size() +
                            " or 0 to finish.");
                }
            
                    break;
                case 3:
                    ReCheck.printSelectedFlights(selectedFlights, user1);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    check = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }
    }
}