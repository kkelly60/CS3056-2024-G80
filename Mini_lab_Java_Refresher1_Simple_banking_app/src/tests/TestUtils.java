package tests;

public class TestUtils {

    // ANSI color codes for text formatting
    public static final String TEXT_COLOR_RESET = "\u001B[0m";
    public static final String TEXT_COLOR_GREEN = "\u001B[32m";
    public static final String TEXT_COLOR_RED = "\u001B[31m";

    // Method to print the result of a test case with color formatting
    public static void printResult(String testCase, boolean passed) {
        String result = passed ? TEXT_COLOR_GREEN + "Passed" + TEXT_COLOR_RESET : TEXT_COLOR_RED + "Failed" + TEXT_COLOR_RESET;
        System.out.println(testCase + ": " + result);
    }
}

