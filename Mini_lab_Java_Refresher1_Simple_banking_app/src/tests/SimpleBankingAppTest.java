package tests;

import app.SimpleBankingApp;
import utils.TestUtils;

public class SimpleBankingAppTest {

    // this test method (test case) verifies if the data load feature of the class (unit or component)
    // under test (UUT) works properly
    public static void testLoadData() {
        // Setup phase: none

        // Exercise phase
        SimpleBankingApp.loadUserData();

        // Verify phase
        // Verify that we have loaded 3 users
        if (SimpleBankingApp.getUsers().size() == 3)
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "testLoadData: loadUserData: TC1 passed" + TestUtils.TEXT_COLOR_RESET);
        else
            System.out.println(TestUtils.TEXT_COLOR_RED + "testLoadData: loadUserData: TC1 FAILED" + TestUtils.TEXT_COLOR_RESET);

        // Additional verification
        // To do STRONGER verification, we would need more assertions for user names and account balances, etc.

        SimpleBankingApp.loadAccountData();
        // Verify that we have loaded 4 accounts
        if (SimpleBankingApp.getAccounts().size() == 4)
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "testLoadData: loadAccountData: TC1 passed" + TestUtils.TEXT_COLOR_RESET);
        else
            System.out.println(TestUtils.TEXT_COLOR_RED + "testLoadData: loadAccountData: TC1 FAILED" + TestUtils.TEXT_COLOR_RESET);

        // Teardown phase: No teardown in this test case
    }

    // this test method (test case) verifies if the Deposit feature works properly
    public static void testDeposits() {
        // Setup phase
        double balanceBefore = SimpleBankingApp.getBalance("5495-1234");
        double depositAmount = 50.21;

        // Exercise phase
        SimpleBankingApp.addTransaction("5495-1234", depositAmount);
        double balanceAfter = SimpleBankingApp.getBalance("5495-1234");

        // Verify phase
        // Verify that the balance has increased after the deposit
        assert balanceBefore + depositAmount == balanceAfter;
        if (balanceBefore + depositAmount == balanceAfter)
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "testDeposits: TC1 passed" + TestUtils.TEXT_COLOR_RESET);
        else {
            System.out.println(TestUtils.TEXT_COLOR_RED + "testDeposits: TC1 FAILED XXX: balanceBefore + depositAmount != balanceAfter");
            System.out.format("testDeposits: balanceBefore = %.2f ; depositAmount = %.2f ; balanceAfter = %.2f %s\n",
                    balanceBefore, depositAmount, balanceAfter, TestUtils.TEXT_COLOR_RESET);
        }

        // Teardown phase
        // Put the system state back to where it was
        SimpleBankingApp.addTransaction("5495-1234", -depositAmount);
    }

    // this test method (test case) verifies if the Withdraw feature works properly
    public static void testWithdrawals() {
        // Setup phase
        double balanceBefore = SimpleBankingApp.getBalance("5495-1234");
        double withdrawalAmount = 30.50;

        // Exercise phase
        SimpleBankingApp.addTransaction("5495-1234", -withdrawalAmount);
        double balanceAfter = SimpleBankingApp.getBalance("5495-1234");

        // Verify phase
        // Verify that the balance has decreased after the withdrawal
        assert balanceBefore - withdrawalAmount == balanceAfter;
        if (balanceBefore - withdrawalAmount == balanceAfter)
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "testWithdrawals: TC1 passed" + TestUtils.TEXT_COLOR_RESET);
        else {
            System.out.println(TestUtils.TEXT_COLOR_RED + "testWithdrawals: TC1 FAILED XXX: balanceBefore - withdrawalAmount != balanceAfter");
            System.out.format("testWithdrawals: balanceBefore = %.2f ; withdrawalAmount = %.2f ; balanceAfter = %.2f %s\n",
                    balanceBefore, withdrawalAmount, balanceAfter, TestUtils.TEXT_COLOR_RESET);
        }

        // Teardown phase
        // Put the system state back to where it was
        SimpleBankingApp.addTransaction("5495-1234", withdrawalAmount);
    }

    // this test method (test case) verifies if the Withdraw feature works properly

 // this test method (test case) verifies if the Withdraw feature works properly
 public static void testAddTransactionWithdrawals() {
     // Setup phase
     double balanceBefore = SimpleBankingApp.getBalance("5495-1234");
     double withdrawalAmount = 30.50;

     // Exercise phase
     SimpleBankingApp.addTransaction("5495-1234", -withdrawalAmount);
     double balanceAfter = SimpleBankingApp.getBalance("5495-1234");

     // Verify phase
     // Verify that the balance has decreased after the withdrawal
     assert balanceBefore - withdrawalAmount == balanceAfter;
     if (balanceBefore - withdrawalAmount == balanceAfter)
         System.out.println(TestUtils.TEXT_COLOR_GREEN + "testAddTransactionWithdrawals: TC1 passed" + TestUtils.TEXT_COLOR_RESET);
     else {
         System.out.println(TestUtils.TEXT_COLOR_RED + "testAddTransactionWithdrawals: TC1 FAILED XXX: balanceBefore - withdrawalAmount != balanceAfter");
         System.out.format("testAddTransactionWithdrawals: balanceBefore = %.2f ; withdrawalAmount = %.2f ; balanceAfter = %.2f %s\n",
                 balanceBefore, withdrawalAmount, balanceAfter, TestUtils.TEXT_COLOR_RESET);
     }

     // Teardown phase
     // Put the system state back to where it was
     SimpleBankingApp.addTransaction("5495-1234", withdrawalAmount);
 }


    public static void main(String[] args) {
        // we need to call our test cases (methods)
        testLoadData();
        testDeposits();
        testWithdrawals();
        // Uncomment the line below when you have implemented the testAddTransactionWithdrawals() method
        // testAddTransactionWithdrawals();
    }
}
