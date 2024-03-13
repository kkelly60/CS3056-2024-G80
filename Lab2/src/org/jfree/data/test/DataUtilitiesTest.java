package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataUtilitiesTest {

    private Values2D values2D;

    @Before
    public void setUp() {
        DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
        testValues.addValue(1, 0, 0);
        testValues.addValue(4, 1, 0);
        values2D = testValues;
    }

    @After
    public void tearDown() {
        values2D = null;
    }

    @Test
    public void testValidDataAndColumnTotal() {
        assertEquals("Wrong sum returned. It should be 5.0",
                5.0, DataUtilities.calculateColumnTotal(values2D, 0), 0.0000001d);
    }

    @Test
    public void testNullDataColumnTotal() {
        try {
            DataUtilities.calculateColumnTotal(null, 0);
            fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
        } catch (Exception e) {
            assertTrue("Incorrect exception type thrown",
                    e.getClass().equals(IllegalArgumentException.class));
        }
        
    }
    //calculateColumnTotal(Values2D data, int column)
    //Combining the Equivalence Classes using strong Equivalence Class Testing (SECT)
    //1  
    @Test(expected = IndexOutOfBoundsException.class)
    public void testInvalidColumnIndex() {
        // Create a valid data table
        DefaultKeyedValues2D testObject = new DefaultKeyedValues2D();
        testObject.addValue(1, 2, 3);

        // Test invalid column index
        DataUtilities.calculateColumnTotal(testObject, -1);
    }
    //2
    @Test
    public void testValidColumnIndexZero() {
        // Create a valid data table
        DefaultKeyedValues2D testObject = new DefaultKeyedValues2D();
        testObject.addValue(4, 56, 19);

        // Test valid column index (0)
        double result = DataUtilities.calculateColumnTotal(testObject, 0);
        assertEquals("Incorrect output", 10.6, result, 0.0000001d);
    }
    //4
    @Test(expected = IndexOutOfBoundsException.class)
    public void testValidDataInvalidColumnIndex() {
        // Create a valid data table
        DefaultKeyedValues2D testObject = new DefaultKeyedValues2D();
        testObject.addValue(1, 2, 3);

        // Test invalid column index
        DataUtilities.calculateColumnTotal(testObject, 55);

        // If the method doesn't throw IndexOutOfBoundsException, the test will fail
        fail("Expected IndexOutOfBoundsException, but no exception was thrown.");
    }
    //5
    @Test(expected = IllegalArgumentException.class)
    public void testEmptyMatrixInvalidColumnIndex() {
        // Create an empty data table
        DefaultKeyedValues2D testObject = new DefaultKeyedValues2D();

        // Test invalid column index
        DataUtilities.calculateColumnTotal(testObject, -1);
    }
    //6
    @Test(expected = IllegalArgumentException.class)
    public void testEmptyMatrixInvalidColumnIndexZero() {
        // Create an empty data table
        DefaultKeyedValues2D testObject = new DefaultKeyedValues2D();

        // Test invalid column index (0)
        DataUtilities.calculateColumnTotal(testObject, 0);
    }
    //7
    @Test(expected = IllegalArgumentException.class)
    public void testEmptyMatrixInvalidPositiveColumnIndex() {
        // Create an empty data table
        DefaultKeyedValues2D testObject = new DefaultKeyedValues2D();

        // Test invalid positive column index (2)
        DataUtilities.calculateColumnTotal(testObject, 2);
    }
    //8
    @Test(expected = IllegalArgumentException.class)
    public void testEmptyMatrixInvalidOutOfRangeColumnIndex() {
        // Create an empty data table
        DefaultKeyedValues2D testObject = new DefaultKeyedValues2D();

        // Test invalid out-of-range column index (55)
        DataUtilities.calculateColumnTotal(testObject, 55);
    }
    //9
    @Test(expected = NullPointerException.class)
    public void testNullDataInvalidNegativeColumnIndex() {
        // Create a null data table
        DefaultKeyedValues2D testObject = null;

        // Test invalid negative column index (-1)
        DataUtilities.calculateColumnTotal(testObject, -1);
    }
    //10
    @Test(expected = NullPointerException.class)
    public void testNullDataZeroColumnIndex() {
        // Create a null data table
        Values2D testObject = null;

        // Test invalid column index (0)
        DataUtilities.calculateColumnTotal(testObject, 0);
    }
    //11
    @Test(expected = NullPointerException.class)
    public void testNullDataOneColumnIndex() {
        // Create a null data table
        Values2D testObject = null;

        // Test invalid column index (1)
        DataUtilities.calculateColumnTotal(testObject, 1);
    }
    //12
    @Test(expected = NullPointerException.class)
    public void testNullDataOutOfRangeColumnIndex() {
        // Create a null data table
        Values2D testObject = null;

        // Test invalid column index (55)
        DataUtilities.calculateColumnTotal(testObject, 55);
    }
    
 // Boundary Value Analysis Test Case
 // Verifies that min column value 0 with a valid data matrix correctly returns 10.0.
    //13
 @Test
 public void testMinColumnValueWithValidData() {
     // Create a valid data table with the minimum column value (0)
     DefaultKeyedValues2D testObject = new DefaultKeyedValues2D();
     testObject.addValue(1, 2, 3);

     // Test valid column index (0)
     double result = DataUtilities.calculateColumnTotal(testObject, 0);

     // Verify the result is 10.0
     assertEquals("Incorrect output", 10.0, result, 0.0000001d);
 }
//14
 @Test
 public void testBvaMinPlusColumnValue() {
     // Create a valid data table
     DefaultKeyedValues2D testObject = new DefaultKeyedValues2D();
     testObject.addValue(1.0, "Row1", "Column0");
     testObject.addValue(2.0, "Row2", "Column1");
     testObject.addValue(3.0, "Row3", "Column2");

     // Test min+ column value (1)
     double result = DataUtilities.calculateColumnTotal(testObject, 1);

     // Verify the result
     double expected = 14.0;  // This should be 14.0 according to your description
     assertEquals("Incorrect output for min+ column value", expected, result, 0.0000001d);
 }
 //16
 @Test
 public void testBvaColumnIndices() {
     // Create a valid data table
     DefaultKeyedValues2D testObject = new DefaultKeyedValues2D();
     // Add some values to the data table

     // Test min column value (0)
     double resultMin = DataUtilities.calculateColumnTotal(testObject, 0);
     assertEquals("Incorrect output for min column value", 0.0, resultMin, 0.0000001d);

     // Test slightly below min column value (-1)
     try {
         DataUtilities.calculateColumnTotal(testObject, -1);
         fail("Expected IllegalArgumentException, but no exception was thrown.");
     } catch (IllegalArgumentException e) {
         // Expected exception
     }

     // Test max column value (4)
     double resultMax = DataUtilities.calculateColumnTotal(testObject, 4);
     assertEquals("Incorrect output for max column value", 26.0, resultMax, 0.0000001d);

     // Test slightly above max column value (5)
     try {
         DataUtilities.calculateColumnTotal(testObject, 5);
         fail("Expected IllegalArgumentException, but no exception was thrown.");
     } catch (IllegalArgumentException e) {
         // Expected exception
     }
 }
     //calculateRowTotal
     //1
 @Test(expected = IndexOutOfBoundsException.class)
 public void testInvalidRowIndex() {
     // Create a valid data table
     DefaultKeyedValues2D testObject = new DefaultKeyedValues2D();
     testObject.addValue(1, 2, 3);

     // Test invalid row index
     DataUtilities.calculateRowTotal(testObject, -1);
 }

     //2
     @Test
     public void testValidDataAndRowTotal() {
         // Create a valid data table
         DefaultKeyedValues2D testObject = new DefaultKeyedValues2D();
         testObject.addValue(1, 2, 3);

         // Test valid row index (0)
         assertEquals("Incorrect output", 10.6, DataUtilities.calculateRowTotal(testObject, 0), 0.0000001d);
     }

     //3
     @Test
     public void testNormalBoundaryRowTotal() {
         // Create a valid data table
         DefaultKeyedValues2D testObject = new DefaultKeyedValues2D();
         testObject.addValue(1, 2, 3);

         // Test normal boundary row index (2)
         assertEquals("Incorrect output", 19.4, DataUtilities.calculateRowTotal(testObject, 2), 0.0000001d);
     }
     //4
     @Test(expected = IndexOutOfBoundsException.class)
     public void testCalculateRowTotalWithInvalidRowIndex() {
         // Create a valid data table
         DefaultKeyedValues2D testObject = new DefaultKeyedValues2D();
         testObject.addValue(1, 2, 3);

         // Test invalid row index
         DataUtilities.calculateRowTotal(testObject, 55);
     }
     //5
     @Test(expected = IndexOutOfBoundsException.class)
     public void testEmptyMatrixInvalidRowIndex() {
         // Create an empty data table
         DefaultKeyedValues2D testObject = new DefaultKeyedValues2D();

         // Test invalid row index (-1)
         DataUtilities.calculateRowTotal(testObject, -1);
     }
     //6
     @Test(expected = IllegalArgumentException.class)
     public void testEmptyMatrixInvalidRowIndexZero() {
         // Create an empty data table
         DefaultKeyedValues2D testObject = new DefaultKeyedValues2D();

         // Test invalid row index (0)
         DataUtilities.calculateRowTotal(testObject, 0);
     }

     //7
     @Test(expected = IllegalArgumentException.class)
     public void testEmptyMatrixInvalidRowIndexPositive() {
         // Create an empty data table
         DefaultKeyedValues2D testObject = new DefaultKeyedValues2D();

         // Test invalid row index (2)
         DataUtilities.calculateRowTotal(testObject, 2);
     }

     //8
     @Test(expected = IllegalArgumentException.class)
     public void testEmptyMatrixInvalidRowIndexOutOfRange() {
         // Create an empty data table
         DefaultKeyedValues2D testObject = new DefaultKeyedValues2D();

         // Test invalid row index (55)
         DataUtilities.calculateRowTotal(testObject, 55);
     }
   //9
     @Test(expected = NullPointerException.class)
     public void testNullDataInvalidNegativeRowIndex() {
         // Create a null data table
         DefaultKeyedValues2D testObject = null;

         // Test invalid negative row index (-1)
         DataUtilities.calculateRowTotal(testObject, -1);
     }
  // 10
     @Test(expected = NullPointerException.class)
     public void testNullDataInvalidZeroRowIndex() {
         // Create a null data table
         DefaultKeyedValues2D testObject = null;

         // Test invalid zero row index (0)
         DataUtilities.calculateRowTotal(testObject, 0);
     }
  // 11
     @Test(expected = NullPointerException.class)
     public void testNullDataInvalidRowIndexOne() {
         // Create a null data table
         DefaultKeyedValues2D testObject = null;

         // Test invalid row index (1)
         DataUtilities.calculateRowTotal(testObject, 1);
     }

     // 12
     @Test(expected = NullPointerException.class)
     public void testNullDataInvalidRowIndex55() {
         // Create a null data table
         DefaultKeyedValues2D testObject = null;

         // Test invalid row index (55)
         DataUtilities.calculateRowTotal(testObject, 55);
     }
     //13
     // BVA for Column - Min
     @Test
     public void testBvaMinRowValueValidDataMatrix() {
         // Create a valid data table
         DefaultKeyedValues2D testObject = new DefaultKeyedValues2D();
         testObject.addValue(1, 2, 3);
         testObject.addValue(2.6, 3, 4);
         testObject.addValue(3, 4, 5.4);
         testObject.addValue(4, 5.1, 6);
         testObject.addValue(1, 4, 2);

         // Test min row value (0)
         double result = DataUtilities.calculateRowTotal(testObject, 0);
         
         // Verify the result
         assertEquals("Incorrect output for min row value", 10.0, result, 0.0000001d);
     }
     //14
     @Test
     public void testBvaMinPlusColumnValueValidDataMatrix() {
         // Create a valid data table
         DefaultKeyedValues2D testObject = new DefaultKeyedValues2D();
         testObject.addValue(1, 2, 3);
         testObject.addValue(2.6, 3, 4);
         testObject.addValue(3, 4, 5.4);
         testObject.addValue(4, 5.1, 6);
         testObject.addValue(1, 4, 2);

         // Test min+ column value (1)
         double result = DataUtilities.calculateColumnTotal(testObject, 1);
         
         // Verify the result
         assertEquals("Incorrect output for min+ column value", 14.6, result, 0.0000001d);
     }
     //15
     @Test
     public void testBvaMaxMinusColumnValueValidDataMatrix() {
         // Create a valid data table
         DefaultKeyedValues2D testObject = new DefaultKeyedValues2D();
         testObject.addValue(1, 2, 3);
         testObject.addValue(2.6, 3, 4);
         testObject.addValue(3, 4, 5.4);
         testObject.addValue(4, 5.1, 6);
         testObject.addValue(1, 4, 2);
         
         // Test max-minus column value (3)
         double result = DataUtilities.calculateColumnTotal(testObject, 3);
         
         // Verify the result
         assertEquals("Incorrect output for max-minus column value", 23.1, result, 0.0000001d);
     }
     //16
     @Test
     public void testBvaMaxColumnValueValidDataMatrix() {
         // Create a valid data table
         DefaultKeyedValues2D testObject = new DefaultKeyedValues2D();
         testObject.addValue(1, 2, 3);
         testObject.addValue(2.6, 3, 4);
         testObject.addValue(3, 4, 5.4);
         testObject.addValue(4, 5.1, 6);
         testObject.addValue(1, 4, 2);
         
         // Test max column value (4)
         double result = DataUtilities.calculateColumnTotal(testObject, 4);
         
         // Verify the result
         assertEquals("Incorrect output for max column value", 49.0, result, 0.0000001d);
     }
     //createNumberArray
     //1
     @Test
     public void testCreateNumberArray_ValidInput_PositiveValues() {
         // Given
         double[] inputData = {0.0, 2.0, 4.5};
         Number[] expectedOutput = {0.0, 2.0, 4.5};
         
         // When
         Number[] result = DataUtilities.createNumberArray(inputData);
         
         // Then
         assertNotNull("Result should not be null", result);
         assertEquals("Result array length should match input length", inputData.length, result.length);
         for (int i = 0; i < inputData.length; i++) {
             assertEquals("Element should match in both arrays", expectedOutput[i], result[i]);
         }
     }
         //2
         @Test(expected = IllegalArgumentException.class)
         public void testCreateNumberArray_InvalidInput_NaN() {
             // Given
             double[] inputData = {Double.NaN};

             // When
             DataUtilities.createNumberArray(inputData);

             // Then expect IllegalArgumentException
             
         }
         //3
         @Test(expected = IllegalArgumentException.class)
         public void testCreateNumberArray_NullInput() {
             // Given
             double[] inputData = null;

             // When
             DataUtilities.createNumberArray(inputData);

             // Then expect IllegalArgumentException
         }
         //4
         @Test
         public void testCreateNumberArray_EmptyInput() {
             // Given
             double[] inputData = {};

             // When
             Number[] result = DataUtilities.createNumberArray(inputData);

             // Then
             assertNotNull("Result should not be null", result);
             assertEquals("Result array should be empty", 0, result.length);
         }
         
         //createNumberArray2D(double[][] data)
         //1
         @Test
         public void testValidInput() {
             // Input data
             double[][] inputData = { 
                 { 0.0, 2.0 },
                 { 10.0, 4.5 }
             };

             // Expected output
             Number[][] expectedOutput = { 
                 { 0.0, 2.0 },
                 { 10.0, 4.5 }
             };

             // Call the method under test
             Number[][] result = DataUtilities.createNumberArray2D(inputData);

             // Verify the content of the returned array
             assertArrayEquals("Returned array does not match expected output", expectedOutput, result);
         }
         //2
         @Test(expected = IllegalArgumentException.class)
         public void testInvalidInput_NaNValues() {
             // Invalid input data containing NaN values
             double[][] invalidInput = {
                 { Double.NaN, Double.NaN },
                 { Double.NaN, Double.NaN }
             };

             // Call the method under test
             DataUtilities.createNumberArray2D(invalidInput);
         }
         //3
         @Test(expected = IllegalArgumentException.class)
         public void testInvalidInput_Null() {
             // Call the method under test with null input
             DataUtilities.createNumberArray(null);
         }
         //4

         @Test
         public void testEmptyArrayInput() {
             // Input: empty array of type double
             double[][] emptyArray = {};

             // Expected output: empty array of type Number
             Number[][] expectedOutput = {};

             // Call the method under test
             Number[][] result = DataUtilities.createNumberArray2D(emptyArray);

             // Verify that the returned array matches the expected output
             assertArrayEquals("Returned array does not match expected output", expectedOutput, result);
         }
         //5
         @Test
         public void testJaggedArrayInput() {
             // Jagged input array of type double
             double[][] jaggedArray = {
                 { 2.0 },
                 { 10.0, 4.5 }
             };

             // Expected output: 2D array of type Number
             Number[][] expectedOutput = {
                 { 2.0 },
                 { 10.0, 4.5 }
             };

             // Call the method under test
             Number[][] result = DataUtilities.createNumberArray2D(jaggedArray);

             // Verify that the returned array matches the expected output
             assertArrayEquals("Returned array does not match expected output", expectedOutput, result);
         }
         //6
         @Test
         public void testMixedArrayInput() {
             // Input array with both empty and non-empty arrays of type double
             double[][] mixedArray = {
                 { 0.0, 2.0 },
                 {},
                 {}
             };

             // Expected output: 2D array of type Number
             Number[][] expectedOutput = {
                 { 0.0, 2.0 },
                 {},
                 {}
             };

             // Call the method under test
             Number[][] result = DataUtilities.createNumberArray2D(mixedArray);

             // Verify that the returned array matches the expected output
             assertArrayEquals("Returned array does not match expected output", expectedOutput, result);
         }
         //getCumulativePercentages(KeyedValues data)
         //1
         @Test
         public void testValidInput_MultipleEntries() {
             // Create input KeyedValues
             DefaultKeyedValues data = new DefaultKeyedValues();
             data.addValue((Comparable<Integer>)0, 5.0); // Casting to resolve ambiguity
             data.addValue((Comparable<Integer>)1, 9.0); // Casting to resolve ambiguity
             data.addValue((Comparable<Integer>)2, 2.0); // Casting to resolve ambiguity

             // Expected output
             DefaultKeyedValues expectedOutput = new DefaultKeyedValues();
             expectedOutput.addValue((Comparable<Integer>)0, 0.3125); // Casting to resolve ambiguity
             expectedOutput.addValue((Comparable<Integer>)1, 0.875);  // Casting to resolve ambiguity
             expectedOutput.addValue((Comparable<Integer>)2, 1.0);    // Casting to resolve ambiguity

             // Call the method under test
             KeyedValues result = DataUtilities.getCumulativePercentages(data);

             // Verify the content of the returned KeyedValues
             assertEquals("Incorrect cumulative percentages", expectedOutput, result);
         }
         //2
         @Test
         public void testValidInput_OneEntry() {
             // Create input KeyedValues with one entry
             DefaultKeyedValues data = new DefaultKeyedValues();
             data.addValue((Comparable<Integer>)0, 5); // Casting to resolve ambiguity

             // Expected output: cumulative percentage for one entry
             DefaultKeyedValues expectedOutput = new DefaultKeyedValues();
             expectedOutput.addValue((Comparable<Integer>)0, 1.0); // Casting to resolve ambiguity

             // Call the method under test
             KeyedValues result = DataUtilities.getCumulativePercentages(data);

             // Verify the content of the returned KeyedValues
             assertEquals("Incorrect cumulative percentage for one entry", expectedOutput, result);
         }
         //3
         @Test(expected = IllegalArgumentException.class)
         public void testCreateNumberArray2D_NullInput() {
             // Given
             double[][] inputData = null;
             
             // When
             DataUtilities.createNumberArray2D(inputData);
         }
         //4
         @Test(expected = IllegalArgumentException.class)
         public void testCreateNumberArray2D_EmptyInput() {
             // Given
             double[][] inputData = {};
             
             // When
             DataUtilities.createNumberArray2D(inputData);
         }
         //5
         @Test
         public void testCreateNumberArray2D_ValidInputWithNegativeValues() {
             // Given
             double[][] inputData = {{0, -5}, {1, -9}, {2, -2}};
             Number[][] expectedOutput = {{0, 0.3125}, {1, 0.875}, {2, 1.0}};
             
             // When
             Number[][] result = DataUtilities.createNumberArray2D(inputData);
             
             // Then
             assertNotNull("Result should not be null", result);
             assertEquals("Result array length should match input length", inputData.length, result.length);
             for (int i = 0; i < inputData.length; i++) {
                 assertEquals("Element should match in both arrays", expectedOutput[i][0], result[i][0]);
                 assertEquals("Element should match in both arrays", expectedOutput[i][1], result[i][1]);
             }
         }

  }

     






