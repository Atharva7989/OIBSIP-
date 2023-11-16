import java.util.Scanner;

class Bank {
    String customerName, username, password, accountNumber;
    float accountBalance = 1000000f;
    int transactionsCount = 0;
    String transactionHistory = "";

    public void register() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Your Name: ");
        this.customerName = sc.nextLine();
        System.out.print("\nEnter Your Username: ");
        this.username = sc.nextLine();
        System.out.print("\nEnter Your Password: ");
        this.password = sc.nextLine();
        System.out.print("\nEnter Your Account Number: ");
        this.accountNumber = sc.nextLine();
        System.out.println("\nYou have Successfully Registered!!!\nKindly Login!!!");
    }

    public boolean login() {
        Scanner sc = new Scanner(System.in);
        for (int attempts = 3; attempts > 0; attempts--) {
            System.out.print("\nEnter Your Username: ");
            if (sc.nextLine().equals(username)) {
                for (; attempts > 0; attempts--) {
                    System.out.print("\nEnter Your Password: ");
                    if (sc.nextLine().equals(password)) {
                        System.out.print("\nYou have Logged in Successfully!!!");
                        return true;
                    } else {
                        System.out.println("\nIncorrect Password. Attempts left: " + (attempts - 1));
                    }
                }
            } else {
                System.out.println("\nUsername not found. Attempts left: " + (attempts - 1));
            }
        }
        return false;
    }

    public void withdraw() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter amount to withdraw: ");
        float amount = sc.nextFloat();
        if (balanceSufficient(amount)) {
            updateBalanceAndTransactionHistory(-amount, amount + " Rs Withdrawn\n");
        } else {
            System.out.println("\nInsufficient Balance");
        }
    }

    public void deposit() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter amount to deposit: ");
        float amount = sc.nextFloat();
        if (amount <= 1000000f) {
            updateBalanceAndTransactionHistory(amount, amount + " Rs deposited\n");
        } else {
            System.out.println("\nSorry. The Maximum Limit is Rs.1000000.00 only");
        }
    }

    public void transfer() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Recipient's Name: ");
        String recipient = sc.nextLine();
        System.out.print("\nEnter amount to transfer: ");
        float amount = sc.nextFloat();
        if (balanceSufficient(amount)) {
            if (amount <= 50000f) {
                updateBalanceAndTransactionHistory(-amount, amount + " Rs transferred to " + recipient + "\n");
            } else {
                System.out.println("\nSorry. The Maximum Limit is Rs.50000.00 only");
            }
        } else {
            System.out.println("\nInsufficient Balance");
        }
    }

    private boolean balanceSufficient(float amount) {
        return accountBalance >= amount;
    }

    private void updateBalanceAndTransactionHistory(float amount, String transaction) {
        transactionsCount++;
        accountBalance += amount;
        System.out.println("\nTransaction Successful");
        transactionHistory = transactionHistory.concat(transaction);
    }

    public void checkBalance() {
        System.out.println("\n" + accountBalance + " Rs");
    }

    public void transHistory() {
        System.out.println(transactionsCount == 0 ? "\nEmpty" : "\n" + transactionHistory);
    }
}

class ATM_Interface {
    public static void main(String[] args) {
        System.out.println("\n---------- WELCOME TO SBI ATM SYSTEM ----------\n1.Register \n2.Exit");
        System.out.print("Enter Your Choice: ");
        int choice = takeIntegerInput(2);
        if (choice == 1) {
            BankAccount bankAccount = new BankAccount();
            bankAccount.register();
            while (true) {
                System.out.println("\n1.Login \n2.Exit");
                System.out.print("Enter Your Choice: ");
                int ch = takeIntegerInput(2);
                if (ch == 1) {
                    if (bankAccount.login()) {
                        System.out.println("\n\n---------- WELCOME BACK " + bankAccount.customerName + " ----------\n");
                        boolean isFinished = false;
                        while (!isFinished) {
                            System.out.println("\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Transaction History \n6.Exit");
                            System.out.print("\nEnter Your Choice - ");
                            int c = takeIntegerInput(6);
                            switch (c) {
                                case 1:
                                    bankAccount.withdraw();
                                    break;
                                case 2:
                                    bankAccount.deposit();
                                    break;
                                case 3:
                                    bankAccount.transfer();
                                    break;
                                case 4:
                                    bankAccount.checkBalance();
                                    break;
                                case 5:
                                    bankAccount.transHistory();
                                    break;
                                case 6:
                                    isFinished = true;
                                    break;
                            }
                        }
                    }
                } else {
                    System.exit(0);
                }
            }
        } else {
            System.exit(0);
        }
    }

    private static int takeIntegerInput(int limit) {
        int input = 0;
        boolean flag = false;
        while (!flag) {
            try {
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                flag = true;
                if (flag && (input > limit || input < 1)) {
                    System.out.println("Choose the number between 1 to " + limit);
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println("Enter only integer value");
                flag = false;
            }
        }
        return input;
    }
}
