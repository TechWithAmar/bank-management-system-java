import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== BANK MANAGEMENT SYSTEM ====");
            System.out.println("1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    String accNo = sc.next();
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Enter Password: ");
                    String pass = sc.next();
                    bank.createAccount(accNo, name, pass);
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    String loginAcc = sc.next();
                    System.out.print("Enter Password: ");
                    String loginPass = sc.next();

                    Account user = bank.login(loginAcc, loginPass);

                    if (user != null) {
                        System.out.println("Login Successful!");

                        while (true) {
                            System.out.println("\n1. Deposit");
                            System.out.println("2. Withdraw");
                            System.out.println("3. Check Balance");
                            System.out.println("4. Transaction History");
                            System.out.println("5. Logout");
                            System.out.print("Choose option: ");
                            int opt = sc.nextInt();

                            switch (opt) {
                                case 1:
                                    System.out.print("Enter amount: ");
                                    user.deposit(sc.nextDouble());
                                    break;
                                case 2:
                                    System.out.print("Enter amount: ");
                                    user.withdraw(sc.nextDouble());
                                    break;
                                case 3:
                                    System.out.println("Current Balance: ₹" + user.getBalance());
                                    break;
                                case 4:
                                    user.showTransactions();
                                    break;
                                case 5:
                                    System.out.println("Logged Out!");
                                    break;
                                default:
                                    System.out.println("Invalid choice!");
                            }
                            if (opt == 5) break;
                        }

                    } else {
                        System.out.println("Invalid Credentials!");
                    }
                    break;

                case 3:
                    System.out.println("Thank you for using Bank System!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
