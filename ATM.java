import java.util.Scanner; // Import Scanner for user input
// ATM class to manage banking operations
public class ATM {  
    private int balance;// Stores the balance amount
    private int pin;//Stores the ATM PIN

    // Constructor to initialize balance and PIN
    public ATM(int balance,int pin){
        this.balance=balance;
        this.pin=pin;
    }

    // Method to display ATM menu options
    public void displayMenu(){
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Change Pin");
        System.out.println("5. Exit");
    }
     // Method to deposit money into the account
    public void deposit(int amount){
        balance+=amount;// Add amount to balance
        System.out.println("Amount Deposited Successfully.");
    }
// Method to withdraw money from the account
    public void withdraw(int amount){
        if(balance<amount){
            System.out.println("Insufficient Funds");// Prevent overdraft
            return;
        }
        balance-=amount; // Deduct amount from balance
        System.out.println("Amount Withdrawn Successfully.");
    }
     // Method to check current balance
    public int getBalance(){
        return balance;
    }
    // Method to validate the entered PIN
    public boolean validatePin(int pin){
        return this.pin==pin;
    }
    // Method to change the PIN
    public void changePin(int newPin){
        pin=newPin;
        System.out.println("PIN Changed Successfully!");
    }
    // Main method - Entry point of the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create Scanner object for user input
        ATM atm = new ATM(1000, 1254); // Initialize ATM object with balance 1000 and PIN 1234
       // Prompt user for PIN
       System.out.print("Enter the PIN: ");
       int pin = scanner.nextInt();

       // Validate the entered PIN
       if (atm.validatePin(pin)) {
           int option = 0;
           while (option != 5) { // Continue loop until user chooses Exit
               atm.displayMenu(); // Display menu options
               System.out.print("Choose an option: ");
               option = scanner.nextInt();

               // Handle user choices using switch-case
               switch (option) {
                   case 1:
                       System.out.println("Current Balance: " + atm.getBalance());
                       break;

                   case 2:
                       System.out.print("Enter Deposit Amount: ");
                       int depositAmount = scanner.nextInt();
                       atm.deposit(depositAmount);
                       break;

                   case 3:
                       System.out.print("Enter Withdrawal Amount: ");
                       int withdrawAmount = scanner.nextInt();
                       atm.withdraw(withdrawAmount);
                       break;

                   case 4:
                       System.out.print("Enter New PIN: ");
                       int newPin = scanner.nextInt();
                       atm.changePin(newPin);
                       break;

                   case 5:
                       System.out.println("Thank You for using the ATM!"); // Exit message
                       break;

                   default:
                       System.out.println("Invalid option! Please try again.");
               }
           }
       } else {
           System.out.println("Invalid PIN! Access Denied.");
       }

       scanner.close(); // Close scanner to prevent memory leaks
   }
} 
