package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

import model.Account;
import model.Transaction;
import model.User;

public class SimpleBankingApp {
    private static Vector<User> users = new Vector<>();
    private static Vector<Account> accounts = new Vector<>();
    private static Vector<Transaction> transactions = new Vector<>();

    public static void loadUserData() {
        users.add(new User("mike", "my_passwd", "Mike", "Smith", "07771234567"));
        users.add(new User("james.cameron@gmail.com", "angel", "James", "Cameron", "07777654321"));
        users.add(new User("julia.roberts@gmail.com", "change_me", "Julia", "roberts", "07770123456"));
    }

    public static void printAllUsers() {
        System.out.println("There are: " + users.size() + " users in the system.");
        System.out.println(String.format("%-25s | %-15s | %-15s | %-15s | %-15s", "Username", "Password", "First Name",
                "Last Name", "Mobile Number"));
        System.out.println("-------------------------------------------------------------------------------------------");
        for (User user : users)
            System.out.println(String.format("%-25s | %-15s | %-15s | %-15s | %-15s",
                    user.getUsername(), user.getPassword(), user.getFirst_name(), user.getLast_name(),
                    user.getMobile_number()));
        System.out.println();
    }


    public static void loadAccountData() {
        try {
            accounts.add(new Account("5495-1234", "mike", "Standard", new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2019")));
            accounts.add(new Account("5495-1239", "mike", "Standard", new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2020")));
            accounts.add(new Account("5495-1291", "mike", "Saving", new SimpleDateFormat("dd/MM/yyyy").parse("21/07/2019")));
            accounts.add(new Account("5495-6789", "David.McDonald@gmail.com", "Saving", new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2019")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void printAllAccounts() {
        System.out.println("There are: " + accounts.size() + " accounts in the system.");
        System.out.println(String.format("%-15s | %-25s | %-10s | %-15s | %-15s", "Account #",
                "Username of Account Holder", "Type", "Opening Date", "Balance"));
        System.out.println("--------------------------------------------------------------------------------");

        for (Account account : accounts) {
            System.out.println(String.format("%-15s | %-25s | %-10s | %-15s | $%-14.2f", account.getAccount_number(),
                    account.getUsername_of_account_holder(), account.getAccount_type(),
                    account.getAccount_opening_data(), getBalance(account.getAccount_number())));
        }

        System.out.println();
    }


    public static void addTransaction(String account_number, double amount) {
        transactions.add(new Transaction(account_number, amount, Calendar.getInstance().getTime()));
    }

    public static double getBalance(String account_number) {
        double balance = 0;

        for (Transaction transaction : transactions) {
            if (transaction.getAccount_number().equals(account_number)) {
                balance += transaction.getTransaction_amount();
            }
        }

        return balance;
    }

    public static void printTransactions() {
        System.out.println("Transaction History:");
        System.out.println(String.format("%-10s| %-15s| %-15s| %-15s", "Account #", "Amount", "Date", "Balance"));
        System.out.println("------------------------------------------------------");

        for (Transaction transaction : transactions) {
            System.out.println(String.format("%-10s| $%-14.2f| %-15s| $%-14.2f", transaction.getAccount_number(),
                    transaction.getTransaction_amount(), transaction.getTransaction_date(),
                    getBalance(transaction.getAccount_number())));
        }

        System.out.println();
    }

    public static void main(String[] args) {
        loadUserData();
        printAllUsers();

        loadAccountData();
        System.out.println("Accounts: initial state, after loading...");
        printAllAccounts();

        addTransaction("5495-1234", -50.21);
        System.out.println("Account: after the 1st addTransaction function call...");
        printAllAccounts();

        addTransaction("5495-1234", 520.00);
        addTransaction("9999-1111", 21.00);
        System.out.println("Account: after the 2nd/3rd addTransaction function calls...");
        printAllAccounts();

        printTransactions();
    }

	public static Vector<User> getUsers() {
		return users;
	}

	public static void setUsers(Vector<User> users) {
		SimpleBankingApp.users = users;
	}

	public static Vector<Account> getAccounts() {
		return accounts;
	}

	public static void setAccounts(Vector<Account> accounts) {
		SimpleBankingApp.accounts = accounts;
	}

	public static Vector<Transaction> getTransactions() {
		return transactions;
	}

	public static void setTransactions(Vector<Transaction> transactions) {
		SimpleBankingApp.transactions = transactions;
	}
}
