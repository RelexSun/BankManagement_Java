import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.UUID;

public class Main {
    static CheckAccount checkAccount = null;
    static SaveAccount saveAccount = null;

    public static void main(String[] args) {
        String RED_TEXT = "\u001B[31m";
        String RESET = "\u001B[0m";
        Scanner sc = new Scanner(System.in);

        int choice;
        String ch;

        do {
            displayOnlineBanking();
            ch = sc.nextLine();
            while(!Pattern.matches("\\d", ch)) {
                System.out.println(RED_TEXT+"Invalid input!!!"+RESET);
                System.out.print("=> Choose option( 1 - 7 ): ");
                ch = sc.nextLine();
            }
            choice = Integer.parseInt(ch);

            String ch1;
            int chh;
            switch (choice) {
                case 1 -> {
                    do {
                        displayCreateAccount();
                        ch1 = sc.nextLine();
                        while(!Pattern.matches("[1]|[2]|[3]", ch1)) {
                            System.out.println(RED_TEXT+"Invalid input!!!"+RESET);
                            System.out.print("=> Choose option( 1 - 3 ): ");
                            ch1 = sc.nextLine();
                        }
                        chh = Integer.parseInt(ch1);
                        switch (chh) {
                            case 1 -> {
                                if (checkAccount == null) {
                                    createAccount(1, sc, RED_TEXT, RESET);


                                } else {
                                    System.out.println("Account already exist");

                                }

                            }
                            case 2 -> {
                                if (saveAccount == null) {
                                    createAccount(2, sc, RED_TEXT, RESET);

                                } else {
                                    System.out.println("Account already exist");
                                }
                            }
                            default -> System.out.println("Choose between 1 - 3");
                        }
                    } while(chh != 3);
                }
                case 2 -> {
                    int j;
                    do {
                        System.out.println();
                        System.out.println();
                        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> Deposit Money <<<<<<<<<<<<<<<<<<<<<<<<");
                        System.out.println("1. Checking Account\n2. Saving Account\n3. Back");
                        System.out.println("==========================================================================");
                        System.out.print("=> Choose option( 1 - 3 ): ");
                        String k = sc.nextLine();
                        while(!Pattern.matches("[1]|[2]|[3]", k)) {
                            System.out.println(RED_TEXT+"Invalid input!!!"+RESET);
                            System.out.print("=> Choose option( 1 - 3 ): ");
                            k = sc.nextLine();
                        }
                        j = Integer.parseInt(k);

                        switch (j) {
                            case 1 -> {
                                if (checkAccount != null) {
                                    System.out.print("Enter money to deposit: ");
                                    String amm = sc.nextLine();
                                    while (!Pattern.matches("^\\d+\\.?\\d{0,2}$", amm)) {
                                        System.out.println(RED_TEXT+"Invalid money format (e.g. 100.50)"+RESET);
                                        System.out.print("Enter money to deposit: ");
                                        amm = sc.nextLine();
                                    }
                                    double amount = Double.parseDouble(amm);
                                    checkAccount.deposit(amount);
                                    System.out.println("\t\t\t\tChecking Account");
                                    System.out.println("Received\t:\t\t\t\t\t$ "+ amount);
                                    System.out.println("Total Amount:\t\t\t\t\t$ "+ checkAccount.getBalance());
                                    System.out.println("==========================================================");
                                    System.out.println("Deposit successful!");
                                } else {
                                    System.out.println(RED_TEXT+"No checking account"+RESET);
                                }
                            }
                            case 2 -> {
                                if (saveAccount != null) {
                                System.out.print("Enter money to deposit: ");
                                String amm = sc.nextLine();
                                while (!Pattern.matches("^\\d+\\.?\\d{0,2}$", amm)) {
                                    System.out.println(RED_TEXT+"Invalid money format (e.g. 100.50)"+RESET);
                                    System.out.print("Enter money to deposit: ");
                                    amm = sc.nextLine();
                                }
                                    double amount = Double.parseDouble(amm);
                                saveAccount.deposit(amount);
                                System.out.println("\t\t\t\tSaving Account");
                                System.out.println("Received\t:\t\t\t\t\t$ "+ amount);
                                System.out.println("Total Amount:\t\t\t\t\t$ "+ saveAccount.getBalance());
                                System.out.println("==========================================================");
                                System.out.println("Deposit successful!");
                                } else {
                                    System.out.println(RED_TEXT+"No saving account"+RESET);
                                }

                            }
                            default -> System.out.println("Choose between 1 - 3");
                        }
                    } while(j !=3 );
                }
                case 3 -> {
                    int j;
                    do {
                        System.out.println();
                        System.out.println();
                        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> Withdraw Money <<<<<<<<<<<<<<<<<<<<<<<<");
                        System.out.println("1. Checking Account\n2. Saving Account\n3. Back");
                        System.out.println("==========================================================================");
                        System.out.print("=> Choose option( 1 - 3 ): ");
                        String k = sc.nextLine();
                        while(!Pattern.matches("[1]|[2]|[3]", k)) {
                            System.out.println(RED_TEXT+"Invalid input!!!"+RESET);
                            System.out.print("=> Choose option( 1 - 3 ): ");
                            k = sc.nextLine();
                        }
                        j = Integer.parseInt(k);

                        switch (j) {
                            case 1 -> {
                                if (checkAccount != null) {
                                    String yesNo;
                                    do {
                                        System.out.print("Enter money to withdraw: ");
                                        String amm = sc.nextLine();
                                        while (!Pattern.matches("^\\d+\\.?\\d{0,2}$", amm)) {
                                            System.out.println(RED_TEXT+"Invalid money format (e.g. 100.50)"+RESET);
                                            System.out.print("Enter money to withdraw: ");
                                            amm = sc.nextLine();
                                        }
                                        double amount = Double.parseDouble(amm);
                                        if (amount < checkAccount.getBalance() ) {
                                            if (checkAccount.withDraw(amount)) {
                                                System.out.println("\t\t\t\tChecking Account");
                                                System.out.println("Withdraw\t:\t\t\t\t\t$ "+ amount);
                                                System.out.println("Total Balance:\t\t\t\t\t$ "+ checkAccount.getBalance());
                                                System.out.println("==========================================================");
                                                System.out.println("Withdrawal successful!");
                                            }
                                        } else {
                                            System.out.println(RED_TEXT+"Not enough money in the bank to withdraw"+RESET);
                                        }
                                        System.out.println("Do you want to continue? [Y/N]: ");
                                        yesNo = sc.nextLine();
                                        while (!Pattern.matches("[Yy]|[Nn]", yesNo)) {
                                            System.out.println(RED_TEXT+"Invalid input!!!"+RESET);
                                            System.out.print("Do you want to continue? [Y/N]: ");
                                            yesNo = sc.nextLine();
                                        }
                                    } while(yesNo.equals("y") || yesNo.equals("Y"));
                                } else {
                                    System.out.println(RED_TEXT+"No checking account"+RESET);
                                }
                            }
                            case 2 -> {
                                if (saveAccount != null) {
                                String yesNo;
                                do {
                                    System.out.print("Enter money to withdraw: ");
                                    String amm = sc.nextLine();
                                    while (!Pattern.matches("^\\d+\\.?\\d{0,2}$", amm)) {
                                        System.out.println(RED_TEXT+"Invalid money format (e.g. 100.50)"+RESET);
                                        System.out.print("Enter money to withdraw: ");
                                        amm = sc.nextLine();
                                    }
                                    double amount = Double.parseDouble(amm);
                                    if (amount < saveAccount.getBalance()*0.8 && amount < saveAccount.getBalance()) {
                                        if (saveAccount.withDraw(amount)) {
                                            System.out.println("\t\t\t\tSaving Account");
                                            System.out.println("Withdraw\t:\t\t\t\t\t$ "+ amount);
                                            System.out.println("Total Balance:\t\t\t\t\t$ "+ saveAccount.getBalance());
                                            System.out.println("==========================================================");
                                            System.out.println("Withdrawal successful!");
                                        }
                                    } else if (amount > saveAccount.getBalance()*0.8) {
                                        System.out.println("Cannot withdraw $"+amount+". At least $"+(saveAccount.getBalance()-(saveAccount.getBalance()*0.8))+" must remain in the account.");
                                    } else if (amount > saveAccount.getBalance()) {
                                        System.out.println("Can't withdraw");
                                    }

                                    System.out.println("Do you want to continue? [Y/N]: ");
                                    yesNo = sc.nextLine();
                                    while (!Pattern.matches("[Yy]|[Nn]", yesNo)) {
                                        System.out.println(RED_TEXT+"Invalid input!!!"+RESET);
                                        System.out.print("Do you want to continue? [Y/N]: ");
                                        yesNo = sc.nextLine();
                                    }
                                } while(yesNo.equals("y") || yesNo.equals("Y"));
                            } else {
                                System.out.println(RED_TEXT+"No saving account"+RESET);
                            }
                            }
                            default -> System.out.println("Choose between 1 - 3");
                        }
                    } while(j !=3 );
                }
                case 4 -> {
                    if (checkAccount == null || saveAccount == null) {
                        System.out.println("Can't transfer! User should have both account to be able to transfer");
                        break;
                    }
                    System.out.println();
                    System.out.println();
                    System.out.println(">>>>>>>>>>>>>>>>>>>>>\tTransfer Money\t<<<<<<<<<<<<<<<<<<<<<<<<");
                    System.out.println("1. Checking Account -> Saving Account\n2. Saving Account -> Checking Account\n3. Back");
                    System.out.println("=========================================================================================");
                    System.out.print("Choose an option: ");
                    String h = sc.nextLine();
                    while(!Pattern.matches("[1]|[2]|[3]", h)) {
                        System.out.println(RED_TEXT+"Invalid input!!!"+RESET);
                        System.out.print("Choose an option: ");
                        h = sc.nextLine();
                    }
                    int opt = Integer.parseInt(h);
                    switch (opt) {
                        case 1 -> {

                            System.out.print("Enter money to transfer: ");
                            String amt = sc.nextLine();
                            while(!Pattern.matches("^\\d+\\.?\\d{0,2}$", amt)) {
                                System.out.println(RED_TEXT+"Invalid input!!!"+RESET);
                                System.out.print("Enter money to transfer: ");
                                amt = sc.nextLine();
                            }
                            double amount = Double.parseDouble(amt);
                            if (amount <= checkAccount.getBalance()) {
                                if (checkAccount.withDraw(amount)) {
                                    saveAccount.deposit(amount);
                                    System.out.println();
                                    System.out.println();
                                    System.out.println(">>>>>>>>>>>>>>>>>>>>>\tChecking Account\t<<<<<<<<<<<<<<<<<<<<<<<<");
                                    System.out.println("Transferred:\t\t\t\t$" + amount);
                                    System.out.println("From\t: Checking account with ID: " + checkAccount.getAccountNumber());
                                    System.out.println("To\t: Saving account with ID: " + saveAccount.getAccountNumber());
                                    System.out.println("Total Remain:\t\t\t\t$" + checkAccount.getBalance());
                                }
                            }  else if (amount > checkAccount.getBalance()) {
                                System.out.println("Can't withdraw");
                            }

                        }
                        case 2 -> {
                            System.out.print("Enter money to transfer: ");
                            String amt = sc.nextLine();
                            while(!Pattern.matches("^\\d+\\.?\\d{0,2}$", amt)) {
                                System.out.println(RED_TEXT+"Invalid input!!!"+RESET);
                                System.out.print("Enter money to transfer: ");
                                amt = sc.nextLine();
                            }
                            double amount = Double.parseDouble(amt);
                            if (amount < saveAccount.getBalance()*0.8 && amount <= saveAccount.getBalance()) {
                                if (saveAccount.withDraw(amount)) {
                                    checkAccount.deposit(amount);
                                    System.out.println();
                                    System.out.println();
                                    System.out.println(">>>>>>>>>>>>>>>>>>>>>\tSaving Account\t<<<<<<<<<<<<<<<<<<<<<<<<");
                                    System.out.println("Transferred:\t\t\t\t$" + amount);
                                    System.out.println("From\t: SavingChecking account with ID: " + saveAccount.getAccountNumber());
                                    System.out.println("To\t: Checking account with ID: " + checkAccount.getAccountNumber());
                                    System.out.println("Total Remain:\t\t\t\t$" + saveAccount.getBalance());
                                }
                            } else if (amount > saveAccount.getBalance()*0.8) {
                                System.out.println("Cannot withdraw $"+amount+". At least $"+(saveAccount.getBalance()-(saveAccount.getBalance()*0.8))+" must remain in the account.");
                            } else if (amount > saveAccount.getBalance()) {
                                System.out.println("Can't withdraw");
                            }

                        }
                        default -> System.out.println("Choose from 1 - 3");
                    }
                }
                case 5 -> {
                    System.out.println();
                    System.out.println();
                    System.out.println(">>>>>>>>>>>>>>>>>>>>>\tChecking Account\t<<<<<<<<<<<<<<<<<<<<<<<<");
                    if (checkAccount != null) {
                        System.out.println("Account Type: Checking Account");
                        System.out.println("Account Number: " + checkAccount.getAccountNumber());
                        System.out.println("User Name: " + checkAccount.getUserName());
                        System.out.println("Gender: " + checkAccount.getGender());
                        System.out.println("Phone Number: " + checkAccount.getPhoneNumber());
                        System.out.println("Balance: " + checkAccount.getBalance());
                    } else {
                        System.out.println("No account!!!");
                    }
                    System.out.println("===========================================================================");
                    System.out.println();
                    System.out.println();
                    System.out.println(">>>>>>>>>>>>>>>>>>>>>\tSaving Account\t<<<<<<<<<<<<<<<<<<<<<<<<");
                    if (saveAccount != null) {
                        System.out.println("Account Type: Saving Account");
                        System.out.println("Account Number: " + saveAccount.getAccountNumber());
                        System.out.println("User Name: " + saveAccount.getUserName());
                        System.out.println("Gender: " + saveAccount.getGender());
                        System.out.println("Phone Number: " + saveAccount.getPhoneNumber());
                        System.out.println("Balance: " + saveAccount.getBalance());
                    } else {
                        System.out.println("No account!!!");
                    }
                    System.out.println("===========================================================================");
                    System.out.println();
                    System.out.println();
                }
                case 6 -> {
                    if (checkAccount == null || saveAccount == null) {
                        System.out.println("You should need to create both account to be able to delete one");
                        break;
                    }
                    System.out.println();
                    System.out.println();
                    System.out.println(">>>>>>>>>>>>>>>>>>>>>\tDelete Account\t<<<<<<<<<<<<<<<<<<<<<<<<");
                    System.out.println("1. Checking Account -> Saving Account\n2. Saving Account -> Checking Account\n3. Back");
                    System.out.println("=========================================================================================");
                    System.out.print("Choose an option: ");
                    String h = sc.nextLine();
                    while(!Pattern.matches("[1]|[2]|[3]", h)) {
                        System.out.println(RED_TEXT+"Invalid input!!!"+RESET);
                        System.out.print("Choose an option: ");
                        h = sc.nextLine();
                    }
                    int opt = Integer.parseInt(h);
                    switch (opt) {
                        case 1 -> {
                            System.out.print("Are you sure you want to delete this account? (Y/N): ");
                            String ans = sc.nextLine();
                            while (!Pattern.matches("[Yy]|[Nn]", ans)) {
                                System.out.println(RED_TEXT+"Invalid input!!!"+RESET);
                                ans = sc.nextLine();
                            }
                            if (ans.equals("N") || ans.equals("n")) {
                                break;
                            }
                            double checkbal = checkAccount.getBalance();
                            checkAccount.withDraw(checkbal);
                            saveAccount.deposit(checkbal);
                            System.out.println();
                            System.out.println();
                            System.out.println(">>>>>>>>>>>>>>>>>>>>>\tChecking Account\t<<<<<<<<<<<<<<<<<<<<<<<<");
                            System.out.println("Transferred:\t\t\t\t$" + checkbal);
                            System.out.println("From\t: Checking account with ID: " + checkAccount.getAccountNumber());
                            System.out.println("To\t: Saving account with ID: " + saveAccount.getAccountNumber());
                            System.out.println("Total Remain:\t\t\t\t$" + checkAccount.getBalance());
                            System.out.println();
                            System.out.println("\t\t\t\t\tSaving Account\t\t\t\t\t");
                            System.out.println("Received: \t\t\t\t\t$ " + checkbal);
                            System.out.println("Total Amount: \t\t\t\t\t$ " + saveAccount.getBalance());
                            System.out.println("=======================================================================");
                            System.out.println("Transferred all balance from Checking account to Savings account.");
                            System.out.println();
                            System.out.println();
                            checkAccount = null;
                        }
                        case 2 -> {
                            System.out.print("Are you sure you want to delete this account? (Y/N): ");
                            String ans = sc.nextLine();
                            while (!Pattern.matches("[Yy]|[Nn]", ans)) {
                                System.out.println(RED_TEXT+"Invalid input!!!"+RESET);
                                ans = sc.nextLine();
                            }
                            if (ans.equals("N") || ans.equals("n")) {
                                break;
                            }
                            double savebal = saveAccount.getBalance();
                            checkAccount.deposit(savebal);
                            saveAccount.withDraw(savebal);
                            System.out.println();
                            System.out.println();
                            System.out.println(">>>>>>>>>>>>>>>>>>>>>\tSaving Account\t<<<<<<<<<<<<<<<<<<<<<<<<");
                            System.out.println("Transferred:\t\t\t\t$" + savebal);
                            System.out.println("From\t: SavingChecking account with ID: " + saveAccount.getAccountNumber());
                            System.out.println("To\t: Checking account with ID: " + checkAccount.getAccountNumber());
                            System.out.println("Total Remain:\t\t\t\t$" + saveAccount.getBalance());
                            System.out.println();
                            System.out.println("\t\t\t\t\tChecking Account\t\t\t\t\t");
                            System.out.println("Received: \t\t\t\t\t$ " + savebal);
                            System.out.println("Total Amount: \t\t\t\t\t$ " + checkAccount.getBalance());
                            System.out.println("=======================================================================");
                            System.out.println("Transferred all balance from Checking account to Savings account.");
                            System.out.println();
                            System.out.println();
                            saveAccount = null;
                        }
                        default -> System.out.println("Choose from 1 - 3");
                    }
                }
                default -> System.out.println("Choose between (1 - 7)");
            }

        } while(choice != 7);
    }

    public static void displayOnlineBanking() {
        System.out.println();
        System.out.println();
        System.out.println("=======================\tOnline Banking System\t=======================");
        System.out.println("1. Create Account\n2. Deposit Money\n3. Withdraw Money\n4.Transfer Money\n5. Display Account Information\n6. Delete Account\n7. Exit");
        System.out.println("------------------------------------------------------------------------");
        System.out.print("=> Choose option( 1 - 7 ): ");
    }

    public static void displayCreateAccount() {
        System.out.println();
        System.out.println();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>\tCreate Account\t<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println("1. Checking Account\n2. Saving Account\n3. Back");
        System.out.println("==========================================================================");
        System.out.print("=> What type of account do you want to create ?: ");
    }

    public static void createAccount(int n, Scanner sc, String RED_TEXT, String RESET) {
        String name, dob, gender, phoneNumber;
        System.out.println();
        System.out.println();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>\tAccount Information\t<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.print("Enter username: ");
        name = sc.nextLine();
        while (!Pattern.matches("[a-zA-Z]+\\s[a-zA-Z]+", name)) {
            System.out.println(RED_TEXT+"Invalid Name! Please give fullname!!!"+RESET);
            System.out.print("Enter username: ");
            name = sc.nextLine();
        }
        System.out.print("Enter date of birth (dd-mm-yyyy): ");
        dob = sc.nextLine();
        while (!Pattern.matches("(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[1,2])-(19|20)\\d{2}", dob)) {
            System.out.println(RED_TEXT+"Invalid date! only allow (dd-mm-yyyy)!!!"+RESET);
            System.out.print(RED_TEXT+"Enter date of birth (dd-mm-yyyy): "+RESET);
            dob = sc.nextLine();
        }
        String[] dobb = dob.split("-");
        int dd = Integer.parseInt(dobb[0]);
        int mm = Integer.parseInt(dobb[1]);
        int yy = Integer.parseInt(dobb[2]);
        int currY = 2025;

        while(currY - yy < 16 || currY - yy > 150) {
            System.out.println(RED_TEXT+"Age must be between 16 and 150."+RESET);
            System.out.print(RED_TEXT+"Enter date of birth (dd-mm-yyyy): "+RESET);
            dob = sc.nextLine();
            dobb = dob.split("-");
            dd = Integer.parseInt(dobb[0]);
            mm = Integer.parseInt(dobb[1]);
            yy = Integer.parseInt(dobb[2]);
        }
        boolean isLeap = yy % 4 == 0 && yy % 100 != 0 || yy % 400 == 0;
        while (!isLeap && mm == 2 && dd == 29) {
            System.out.println(RED_TEXT+"Invalid day for the given month"+RESET);
            System.out.print(RED_TEXT+"Enter date of birth (dd-mm-yyyy): "+RESET);
            dob = sc.nextLine();
            dobb = dob.split("-");
            dd = Integer.parseInt(dobb[0]);
            mm = Integer.parseInt(dobb[1]);
            yy = Integer.parseInt(dobb[2]);
            isLeap = yy % 4 == 0 && yy % 100 != 0 || yy % 400 == 0;
        }

        System.out.print("Enter gender: ");
        gender = sc.nextLine();
        while(!Pattern.matches("^([Ff][Ee])*[M|m][Aa][Ll][Ee]", gender)) {
            System.out.println(RED_TEXT+"Invalid gender! only male or female!!!"+RESET);
            System.out.print("Enter gender: ");
            gender = sc.nextLine();
        }
        gender.toLowerCase();
        System.out.print("Enter phone number: ");
        phoneNumber = sc.nextLine();
        while(!Pattern.matches("^0\\d{2}\\s*\\d{3}\\s*\\d{3,4}", phoneNumber)) {
            System.out.println(RED_TEXT+"Invalid phone number!!!"+RESET);
            System.out.print("Enter phone number: ");
            phoneNumber = sc.nextLine();
        }
        System.out.println("=============================================================================");

        switch (n) {
            case 1 ->  {
                UUID uid = UUID.randomUUID();
                checkAccount = new CheckAccount(uid, name, dob, gender, phoneNumber);
            }
            case 2 -> {
                UUID uid = UUID.randomUUID();
                saveAccount = new SaveAccount(uid, name, dob, gender, phoneNumber);
            }
            default -> System.out.println("Choose between 1 and 2");
        }
        System.out.println("Your "+ (1 == 1 ? "checking" : "saving") +" account has been created succesfully!");
    }
}