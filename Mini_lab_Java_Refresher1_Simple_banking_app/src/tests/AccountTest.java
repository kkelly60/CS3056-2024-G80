package tests;

import model.Account;
import utils.TestUtils;

import java.util.Date;

public class AccountTest {

    public static void main(String[] args) {
        testAccountConstructor();
    }

    public static void testAccountConstructor() {
        String test_account_number = "123456";
        String test_username_of_account_holder = "Kate_Kelly";
        String test_account_type = "Standard";
        Date test_account_opening_date = new Date(); // Replace with the desired date

        Account testAccount = new Account(test_account_number, test_username_of_account_holder,
                test_account_type, test_account_opening_date);

        System.out.println("Starting the assertions of the test method: testAccountConstructor");

        // Use .equals() for string comparisons
        if (testAccount.getAccount_number().equals(test_account_number))
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1-getAccountNumber-Passed" + TestUtils.TEXT_COLOR_RESET);
        else
            System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getAccountNumber-Failed" + TestUtils.TEXT_COLOR_RESET);

        if (testAccount.getUsername_of_account_holder().equals(test_username_of_account_holder))
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC2-getUsernameOfAccountHolder-Passed" + TestUtils.TEXT_COLOR_RESET);
        else
            System.out.println(TestUtils.TEXT_COLOR_RED + "TC2-getUsernameOfAccountHolder-Failed" + TestUtils.TEXT_COLOR_RESET);

        if (testAccount.getAccount_type().equals(test_account_type))
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC3-getAccountType-Passed" + TestUtils.TEXT_COLOR_RESET);
        else
            System.out.println(TestUtils.TEXT_COLOR_RED + "TC3-getAccountType-Failed" + TestUtils.TEXT_COLOR_RESET);

        // Example: Check if the opening date is not null
        if (testAccount.getAccount_opening_data() != null)
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC4-getAccountOpeningDate-Passed" + TestUtils.TEXT_COLOR_RESET);
        else
            System.out.println(TestUtils.TEXT_COLOR_RED + "TC4-getAccountOpeningDate-Failed" + TestUtils.TEXT_COLOR_RESET);

        // Add more test cases as needed

        // Assertions using assert statements
        assert testAccount.getAccount_number().equals(test_account_number);
        assert testAccount.getUsername_of_account_holder().equals(test_username_of_account_holder);
        assert testAccount.getAccount_type().equals(test_account_type);
        assert testAccount.getAccount_opening_data() != null;

        System.out.println("All Java assertions in the test suite passed (none failed).");
    }
}
