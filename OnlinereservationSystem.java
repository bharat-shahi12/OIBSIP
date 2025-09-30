package projects;
import java.util.*;
class Reservation {
    static int pnrCounter = 1200; 
    int pnr;
    String passengerName;
    String trainNumber;
    String trainName;
    String travelClass;
    String from;
    String to;
    String dateOfJourney;

   
    Reservation(String passengerName, String trainNumber, String trainName, String travelClass, 
             String from, String to, String dateOfJourney) {
        this.pnr = pnrCounter++;
        this.passengerName = passengerName;
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.travelClass = travelClass;
        this.from = from;
        this.to = to;
        this.dateOfJourney = dateOfJourney;
    }

    
    void display() {
        System.out.println("\nReservation Successful!");
        System.out.println("PNR: " + pnr);
        System.out.println("Passenger: " + passengerName);
        System.out.println("Train: " + trainNumber + " - " + trainName);
        System.out.println("Class: " + travelClass);
        System.out.println("From: " + from + " To: " + to);
        System.out.println("Date: " + dateOfJourney);
    }
}

public class OnlinereservationSystem {
    static Map<Integer, Reservation> reservations = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    
    static boolean login() {
        String username = "Bharat";
        String password = "1234";

        System.out.print("Enter Username: ");
        String u = sc.next();
        System.out.print("Enter Password: ");
        String p = sc.next();

        if (u.equals(username) && p.equals(password)) {
            System.out.println("Login Successful!\n");
            return true;
        } else {
            System.out.println("Invalid Credentials!");
            return false;
        }
    }

    
    static void reserveTicket() {
        System.out.print("Enter Passenger Name: ");
        String name = sc.next();
        System.out.print("Enter Train Number: ");
        String tNo = sc.next();
        System.out.print("Enter Train Name: ");
        String tName = sc.next();
        System.out.print("Enter Class (Sleeper/AC/General): ");
        String tClass = sc.next();
        System.out.print("From: ");
        String from = sc.next();
        System.out.print("To: ");
        String to = sc.next();
        System.out.print("Enter Journey Date (dd-mm-yyyy): ");
        String date = sc.next();

        Reservation r = new Reservation(name, tNo, tName, tClass, from, to, date);
        reservations.put(r.pnr, r);
        r.display();
    }

   
    static void cancelTicket() {
        System.out.print("Enter PNR to Cancel: ");
        int pnr = sc.nextInt();

        if (reservations.containsKey(pnr)) {
            Reservation r = reservations.get(pnr);
            System.out.println("Ticket Found: Passenger " + r.passengerName);
            reservations.remove(pnr);
            System.out.println("Ticket Cancelled Successfully!");
        } else {
            System.out.println("Invalid PNR! Ticket not found.");
        }
    }

    public static void main(String[] args) {
        if (!login()) return; 

        while (true) {
            System.out.println("\n--- Online Reservation System ---");
            System.out.println("1. Reserve Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: reserveTicket(); break;
                case 2: cancelTicket(); break;
                case 3: System.out.println("Exiting..."); return;
                default: System.out.println("Invalid Choice!");
            }
        }
    }
}
