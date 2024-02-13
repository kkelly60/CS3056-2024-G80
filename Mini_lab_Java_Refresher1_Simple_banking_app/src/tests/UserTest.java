package tests;

import model.User;
import utils.TestUtils;

public class UserTest {
	
    public static void main(String[] args) {
        testUserConstructor();
    }

    public static void testUserConstructor() {
        String test_username = "mike";
        String test_password = "my_password";
        String test_first_name = "Mike";
        String test_last_name = "Smith";
        String test_mobile_number = "0777123456";

        User testUser = new User(test_username, test_password, test_first_name, test_last_name, test_mobile_number);

        System.out.println("Starting the assertions of the test method: testUserConstructor");

        // Use .equals() for string comparisons
        if (testUser.getUsername() == (test_username))
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1-getUsername-Passed" + TestUtils.TEXT_COLOR_RESET);
        else
            System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getUsername-Failed" + TestUtils.TEXT_COLOR_RESET);
        
        if (testUser.getPassword() == (test_password))
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1-getPassword-Passed" + TestUtils.TEXT_COLOR_RESET);
        else
            System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getPassword-Failed" + TestUtils.TEXT_COLOR_RESET);

        // Additional checks for the other three getter methods
        if (testUser.getFirst_name() == (test_first_name))
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC2-getFirst_name-Passed" + TestUtils.TEXT_COLOR_RESET);
        else
            System.out.println(TestUtils.TEXT_COLOR_RED + "TC2-getFirstName-Failed" + TestUtils.TEXT_COLOR_RESET);

        if (testUser.getLast_name()== (test_last_name))
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC3-getLast_name-Passed" + TestUtils.TEXT_COLOR_RESET);
        else
            System.out.println(TestUtils.TEXT_COLOR_RED + "TC3-getLastName-Failed" + TestUtils.TEXT_COLOR_RESET);

        if (testUser.getMobile_number()==(test_mobile_number))
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC4-getMobileumber-Passed" + TestUtils.TEXT_COLOR_RESET);
        else
            System.out.println(TestUtils.TEXT_COLOR_RED + "TC4-getMobileNumber-Failed" + TestUtils.TEXT_COLOR_RESET);
    
    
    assert testUser.getUsername() == test_username;
    assert testUser.getPassword() == test_password;
    assert testUser.getFirst_name() == test_first_name;
    assert testUser.getLast_name() == test_last_name;
    assert testUser.getMobile_number() == test_mobile_number;
    //assert 1==2;
    System.out.println("All Java assertions in the test suite passed (none failed).");
    

}
}
