import java.time.LocalDateTime;
import java.time.Duration;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.UUID;

class User {
    String firstName;
    String lastName;
    String username;
    String password;
    char vehicleType;
    String vehiclePlateNumber;
    double walletAmount;
    LocalDateTime checkInTime = null;
    String ticketNumber = null;
    ArrayList<Transaction> transactions = new ArrayList<>();

    User(String firstName, String lastName, String username, String password,
        char vehicleType, String vehiclePlateNumber, double walletAmount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.vehicleType = vehicleType;
        this.vehiclePlateNumber = vehiclePlateNumber;
        this.walletAmount = walletAmount;
    }
}

class Transaction {
    String ticketNumber;
    LocalDateTime checkInTime;
    LocalDateTime checkOutTime;
    double fee;

    Transaction(String ticketNumber, LocalDateTime checkInTime, LocalDateTime checkOutTime, double fee) {
        this.ticketNumber = ticketNumber;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.fee = fee;
    }
}

public class ParkingSystem {
    static ArrayList<User> users = new ArrayList<>();
    static User activeUser = null;
    static final double[] rates = {25.0, 40.0, 75.0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            try {
                System.out.println("========================");
                System.out.println("Main Menu");
                System.out.println("========================");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.print("Choice: ");
                int choice = sc.nextInt();

                switch(choice) {
                    case 1:
                        register(sc);
                        break;
                    case 2:
                        login(sc);
                        break;
                    case 3:
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next();
            }
        }
    }

    static void register(Scanner sc) {
        System.out.println("========================");
        System.out.println("Register");
        System.out.println("========================");
        System.out.print("First Name: ");
        String firstName = sc.next();
        System.out.print("Last Name: ");
        String lastName = sc.next();
        System.out.print("Username: ");
        String username = sc.next();

        for (User user : users) {
            if (user.username.equals(username)) {
                System.out.println("Username already exists.");
                return;
            }
        }

        System.out.print("Password: ");
        String password = sc.next();
        System.out.print("Vehicle Type(A/B/C): ");
        char vehicleType = sc.next().charAt(0);
        System.out.print("Vehicle Plate Number: ");
        String vehiclePlateNumber = sc.next();

        for (User user : users) {
            if (user.vehiclePlateNumber.equals(vehiclePlateNumber)) {
                System.out.println("Plate Number already exists.");
                return;
            }
        }

        System.out.print("Deposit Initial Wallet Funds(Min. 500 Pesos): ");
        double walletAmount = sc.nextDouble();

        if(walletAmount < 500) {
            System.out.println("Minimum initial deposit is 500 Pesos.");
            return;
        }

        User newUser = new User(firstName, lastName, username, password, vehicleType, vehiclePlateNumber, walletAmount);
        users.add(newUser);
        System.out.println("Successfully Registered.");
    }

    static void login(Scanner sc) {
        System.out.println("========================");
        System.out.println("Login");
        System.out.println("========================");
        System.out.print("Username: ");
        String username = sc.next();
        System.out.print("Password: ");
        String password = sc.next();

        for(User user : users) {
            if(user.username.equals(username) && user.password.equals(password)) {
                activeUser = user;
                System.out.println("Login Successful.");
                loggedInMenu(sc);
                return;
            }
        }

        System.out.println("Invalid username or password.");
    }

    static void loggedInMenu(Scanner sc) {
        while(true) {
            try {
                System.out.println("========================");
                System.out.println("Logged In as: " + activeUser.username);
                System.out.println("========================");
                System.out.println("1. Check In");
                System.out.println("2. Check Out");
                System.out.println("3. Add Funds");
                System.out.println("4. View Wallet Balance");
                System.out.println("5. View Transactions");
                System.out.println("6. Exit");
                System.out.print("Choice: ");
                int choice = sc.nextInt();

                switch(choice) {
                    case 1:
                        checkIn();
                        break;
                    case 2:
                        checkOut();
                        break;
                    case 3:
                        addFunds(sc);
                        break;
                    case 4:
                        viewWalletBalance();
                        break;
                    case 5:
                        viewTransactions();
                        break;
                    case 6:
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next();
            }
        }
    }

    static void checkIn() {
        if(activeUser.checkInTime != null) {
            System.out.println("You have already checked in.");
            return;
        }

        activeUser.checkInTime = LocalDateTime.now();
        activeUser.ticketNumber = UUID.randomUUID().toString();
        System.out.println(activeUser.username + " has been successfully checked In!");
        System.out.println("Check In Time: " + activeUser.checkInTime);
        System.out.println("Ticket Number: " + activeUser.ticketNumber);
    }

    static void checkOut() {
        if(activeUser.checkInTime == null){
            System.out.println("Please check in before checking out.");
            return;
        }

        LocalDateTime checkOutTime = LocalDateTime.now();
        Duration duration = Duration.between(activeUser.checkInTime, checkOutTime);
        int hours = (int) Math.ceil((double) duration.toSeconds() / 3600);

        int vehicleTypeIndex = 0;

        switch(activeUser.vehicleType) {
            case 'A':
            case 'a':
                vehicleTypeIndex = 0;
                break;
            case 'B':
            case 'b':
                vehicleTypeIndex = 1;
                break;
            case 'C':
            case 'c':
                vehicleTypeIndex = 2;
                break;
            default:
                System.out.println("Invalid vehicle type.");
                return;
        }

        double fee = rates[vehicleTypeIndex] * hours;

        if(activeUser.walletAmount >= fee) {
            activeUser.walletAmount -= fee;
            System.out.println(activeUser.username + " has been successfully checked out.");
            System.out.println("==== Official Receipt ====");
            System.out.println("Check In Time: " + activeUser.checkInTime);
            System.out.println("Check Out Time: " + checkOutTime);
            System.out.println("Ticket Number: " + activeUser.ticketNumber);
            System.out.println("Parking Fee: " + fee);
            Transaction transaction = new Transaction(activeUser.ticketNumber, activeUser.checkInTime, checkOutTime, fee);
            activeUser.transactions.add(transaction);
            activeUser.checkInTime = null;
            activeUser.ticketNumber = null;
        } else {
            System.out.println("Insufficient balance. Please add funds.");
        }
    }

    static void addFunds(Scanner sc) {
        System.out.println("Current Balance: " + activeUser.walletAmount);
        System.out.print("Enter Amount to add: ");
        double amount = sc.nextDouble();
        activeUser.walletAmount += amount;
        System.out.println(amount + " has been added to your account. Your new balance is " + activeUser.walletAmount);
    }

    static void viewWalletBalance() {
        System.out.println("Current Balance: " + activeUser.walletAmount);
    }

    static void viewTransactions() {
        if(activeUser.transactions.size() == 0) {
            System.out.println("No transactions found.");
            return;
        }

        for(int i=0; i<activeUser.transactions.size(); i++) {
            System.out.println((i+1) + ". Ticket Number: " + activeUser.transactions.get(i).ticketNumber);
        }

        System.out.print("Enter transaction number to view details: ");
        int transactionNumber = new Scanner(System.in).nextInt();

        if(transactionNumber < 1 || transactionNumber > activeUser.transactions.size()) {
            System.out.println("Invalid transaction number.");
            return;
        }

        Transaction transaction = activeUser.transactions.get(transactionNumber - 1);
        System.out.println("==== Official Receipt ====");
        System.out.println("Ticket Number: " + transaction.ticketNumber);
        System.out.println("Check In Time: " + transaction.checkInTime);
        System.out.println("Check Out Time: " + transaction.checkOutTime);
        System.out.println("Parking Fee: " + transaction.fee);
    }
}
