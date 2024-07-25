import java.util.Scanner;

class BankAccount {
    private int balance;

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public boolean withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        } else {
            System.out.println("Insufficient balance!");
            return false;
        }
    }
}

class ATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount userAccount = new BankAccount(100000); // Initial balance

        while (true) {
            System.out.println("Welcome to our ATM");

            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Bank Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Amount to withdraw: ");
                    int withdrawAmount = scanner.nextInt();
                    if (userAccount.withdraw(withdrawAmount)) {
                        System.out.println("Your Money withdrawal is successful!");
                    }
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    int depositAmount = scanner.nextInt();
                    userAccount.deposit(depositAmount);
                    System.out.println("Your money has been successfully deposited.");
                    break;
                case 3:
                    System.out.println("Balance: " + userAccount.getBalance());
                    break;
                case 4:
                    System.out.println("Thank you for visiting our ATM!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
