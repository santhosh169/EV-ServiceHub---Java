package ev;


//@author SANTHOSH

import java.util.*;

public class EVServiceHub  {
    static void Userdetails(Scanner sc) {
        // HashMap to store PIN and corresponding vehicle information
        HashMap<String, String> pin = new HashMap<>();
        pin.put("123", "OLA");
        pin.put("345", "TATA EV");
        pin.put("143", "ATHER");

        while (true) {
            // User input for PIN
            System.out.println("Enter Pin (or 'user' to Login):");
            String userpin = sc.nextLine();

            // Check if entered PIN is valid or user is logging in as 'user'
            if (pin.containsKey(userpin) || userpin.equals("user")) {
                System.out.println("WELCOME TO EV SERVICEHUB");

                // Display PIN and vehicle information if a valid PIN is entered
                if (pin.containsKey(userpin)) {
                    String vehicle = pin.get(userpin);
                    System.out.println("PIN: " + userpin + ", VEHICLE: " + vehicle);
                } else {
                    // If user logs in as 'user' without entering a specific PIN
                    System.out.println("Login successful as 'user'. No specific vehicle information.");
                }

                // Display available services
                System.out.println("---SERVICES---");
                System.out.println("Press 1 for Stations");
                System.out.println("Press 2 for HelpLine");
                System.out.println("Press 3 for Reservation");
                System.out.println();
                // User choice for services
                int choice = sc.nextInt();
                sc.nextLine(); // Consume the newline character

                // Execute selected service based on user choice
                switch (choice) {
                    case 1:
                        Stations();
                        break;
                    case 2:
                        HelpLine();
                        break;
                    case 3:
                        Reserve(sc);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } else {
                // If entered PIN is not valid
                System.out.println("Invalid PIN. Please try again.");
            }
        }
    }

    static void Stations() {
        // Display available charging stations
        System.out.println("---AVAILABLE STATIONS---");
        printStation("Zeon Ooty Point", "Gem Park Ooty, Sheddon Rd, Pudumund, Ooty", "097896 16161", "CCS 30kW DC, Type 2 AC 24kW", "2");
        printStation("Tata Power Salem Charger", "Tata Motors Cars Showroom – The True Sai Works, Salem, Narasothipatti", "1800 209 8282", "CCS – 25kW DC", "2");
        printStation("eDrive Charging Station", "6F8+985, Trichy – Madurai Hwy, Kodikulam", "NA", "CCS – 25kW DC", "1");
        printStation("Tata EV Charger", "Bharathi Park Rd, Nesavaalar Colony, Saibaba Colony, Coimbatore", "1800 209 8282", "CCS – 30kW", "2");
        printStation("Relux EV Charging", "No:16/8, Ground floor, PRV Towers, Grand Southern Trunk Rd, Guindy, Chennai", "044 4952 1212", "CCS, Type 2 AC", "2");
    }

    static void printStation(String name, String address, String contact, String connectorType, String chargingSlots) {
        // Print details of a charging station
        System.out.println(name);
        System.out.println("   Address: " + address);
        System.out.println("   Contact: " + contact);
        System.out.println("   Connector Type: " + connectorType);
        System.out.println("   Charging Slots: " + chargingSlots);
        System.out.println();
    }

    static void HelpLine() {
        // Display helpline information
        System.out.println("---HELP LINE---");
        System.out.println("OLA EV Service related Support");
        System.out.println("     080-33113311 for Non BSNL Subscribers ");
        System.out.println("     080-48964000 for BSNL Subscribers ");
        System.out.println();
        System.out.println("ATHER Customer Care No. 7676 600 900");
    }

    static void Reserve(Scanner sc) {
        // HashMap to store available stations for reservation
        HashMap<String, String> availableStations = new HashMap<>();
        availableStations.put("01", "Relux EV Charging");
        availableStations.put("38", "Tata EV Charger");
        availableStations.put("45", "eDrive Charging Station");
        availableStations.put("43", "Zeon Ooty Point");
        availableStations.put("93", "Tata Power Salem Charger");
        System.out.println();
        System.out.println("AVAILABLE STATIONS ARE-------");
        for (Map.Entry<String, String> station : availableStations.entrySet()) {
            System.out.println("Station Code: " + station.getKey() + ", Station Name: " + station.getValue());
        }

        // User input for reservation
        System.out.println("Enter the Station code to Reservation :");
        String code = sc.nextLine();
        System.out.println();
        System.out.println("Enter the Time :");
        String time = sc.nextLine();

        // Perform reservation based on user input
        if (availableStations.containsKey(code)) {
            String stationName = availableStations.get(code);
            System.out.println("Reservation successful at: " + stationName + ", Time: " + time);
        } else {
            System.out.println("Reservation failed. No available slots at " + code);
        }
    }

    public static void main(String[] args) {
        // Start the program by obtaining user details
        Scanner sc = new Scanner(System.in);
        Userdetails(sc);
    }
}
