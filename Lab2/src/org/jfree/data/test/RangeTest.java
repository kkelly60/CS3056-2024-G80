package org.jfree.data.test;

//import static org.junit.Assert.*;
//import junit.framework.TestCase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.jfree.data.Range;
import org.junit.*;

//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;

public class RangeTest {
	
	private Range rangeObjectUnderTest;

	@Before
	public void setUp() throws Exception {
		rangeObjectUnderTest = new Range (-1,1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCentralValueShouldBeZero() {
		assertEquals("The central value of -1 and 1 should be 0",
				0, rangeObjectUnderTest.getCentralValue(), 0.000000001d);
	}
	//getUpperBound()
	//1
    @Test
    public void testGetUpperBound_UpperBoundIs10() {
        // Given
        double lowerBound = 0;
        double upperBound = 10;
        Range range = new Range(lowerBound, upperBound);

        // When
        double result = range.getUpperBound();

        // Then
        assertEquals("The upper bound should be 10", upperBound, result, 0.0001);
    }
    //2
    @Test
    public void testGetUpperBound_NegativeUpperBound() {
        // Given
        double lowerBound = -40;
        double upperBound = -20;
        Range range = new Range(lowerBound, upperBound);

        // When
        double result = range.getUpperBound();

        // Then
        assertEquals("The upper bound should be -20", upperBound, result, 0.0001);
    }
    //3
    @Test
    public void testGetUpperBound_ZeroUpperBound() {
        // Given
        double lowerBound = -10;
        double upperBound = 0;
        Range range = new Range(lowerBound, upperBound);

        // When
        double result = range.getUpperBound();

        // Then
        assertEquals("The upper bound should be 0", upperBound, result, 0.0001);
    }
    //4
    @Test
    public void testGetUpperBound_SameBounds() {
        // Given
        double bound = 10;
        Range range = new Range(bound, bound);

        // When
        double result = range.getUpperBound();

        // Then
        assertEquals("The upper bound should be 10", bound, result, 0.0001);
    }
    
    //Intersects (double lower, double upper)
    //1
    @Test
    public void testIntersects_ValidRange_ReturnsTrue() {
        // Given
        Range range = new Range(5, 10);
        
        // When
        boolean result = range.intersects(5, 10);
        
        // Then
        assertTrue("Expected true for valid range", result);
    }
    //2
    @Test
    public void testIntersects_ValidRangeEqualBounds_ReturnsTrue() {
        // Given
        Range range = new Range(10, 10);
        
        // When
        boolean result = range.intersects(10, 10);
        
        // Then
        assertTrue("Expected true for valid range with equal bounds", result);
    }
    //3
    @Test
    public void testIntersects_InvalidRange_ReturnsFalse() {
        // Given
        Range range = new Range(5, 10);
        
        // When
        boolean result = range.intersects(20, 15);
        
        // Then
        assertFalse("Expected false for invalid range", result);
    }
    //4
    @Test
    public void testIntersects_RangeOutsideClassRange_ReturnsFalse() {
        // Given
        Range range = new Range(5, 10);
        
        // When
        boolean result = range.intersects(110, 115);
        
        // Then
        assertFalse("Expected false for range outside class range", result);
    }
    //BVA
    //5
    @Test
    public void testIntersects_UpperLowerBoundaryValue_Zero() {
        // Given
        Range range = new Range(0, 0);
        
        // When
        boolean result = range.intersects(0, 0);
        
        // Then
        assertTrue("Expected true for upper and lower boundary value 0", result);
    }
    //6
    @Test
    public void testBvaBoundaryValuesUpperLowerEqualMax() {
        // Given
        double lowerBound = 100.0;
        double upperBound = 100.0;
        Range range = new Range(lowerBound, upperBound);

        // When
        boolean result = range.intersects(lowerBound, upperBound);

        // Then
        assertTrue("Expected true when upper and lower bounds are equal to max range value", result);
    }
    //7
    @Test
    public void testBvaBoundaryValuesNegativeRange() {
        // Given
        double lowerBound = -10.0;
        double upperBound = -5.0;
        Range range = new Range(-20.0, 0.0);

        // When
        boolean result = range.intersects(lowerBound, upperBound);

        // Then
        assertTrue("Expected true when upper and lower bounds are within the valid range", result);
    }
    //8
    @Test
    public void testBvaBoundaryValuesInvalidRange() {
        // Given
        double lowerBound = -5.0;
        double upperBound = -10.0;
        Range range = new Range(-20.0, 0.0);

        // When
        boolean result = range.intersects(lowerBound, upperBound);

        // Then
        assertFalse("Expected false when upper bound is less than lower bound", result);
    }
    
    //combine(org.jfree.data.Range, range1, org.jfree.data.Range range2)
    //2
    @Test
    public void testCombine_NullRange1() {
        // Given
        Range range1 = null;
        Range range2 = new Range(30, 40);
        
        // When
        Range combinedRange = Range.combine(range1, range2);
        
        // Then
        assertNotNull("Combined range should not be null", combinedRange);
        assertEquals("Lower bound of combined range should be 30", 30.0, combinedRange.getLowerBound(), 0.0001);
        assertEquals("Upper bound of combined range should be 40", 40.0, combinedRange.getUpperBound(), 0.0001);
    }
    //3
    @Test
    public void testCombine_NullRange2() {
        // Given
        Range range1 = new Range(20, 30);
        Range range2 = null;
        
        // When
        Range combinedRange = Range.combine(range1, range2);
        
        // Then
        assertNotNull("Combined range should not be null", combinedRange);
        assertEquals("Lower bound of combined range should be 20", 20.0, combinedRange.getLowerBound(), 0.0001);
        assertEquals("Upper bound of combined range should be 30", 30.0, combinedRange.getUpperBound(), 0.0001);
    }
    //4
    @Test
    public void testCombine_NullRanges() {
        // When
        Range combinedRange = Range.combine(null, null);
        
        // Then
        assertNull("Combined range should be null", combinedRange);
    }
    
    //expand(org.jfree.data.Range range, double lowerMargin, double upperMargin)
    //1
    @Test
    public void testExpand_ValidInputWithPositiveMargins() {
        // Given
        Range range = new Range(2, 6);
        double lowerMargin = 0.25;
        double upperMargin = 0.5;

        // When
        Range expandedRange = Range.expand(range, lowerMargin, upperMargin);

        // Then
        assertNotNull("Expanded range should not be null", expandedRange);
        assertEquals("Lower bound of expanded range should be 1", 1.0, expandedRange.getLowerBound(), 0.0001);
        assertEquals("Upper bound of expanded range should be 8", 8.0, expandedRange.getUpperBound(), 0.0001);
    }
    //2
    @Test(expected = IllegalArgumentException.class)
    public void testExpand_NullRange() {
        // Given
        Range range = null;
        double lowerMargin = 0.3;
        double upperMargin = 0.6;

        // When
        Range.expand(range, lowerMargin, upperMargin);

        // Then
        // IllegalArgumentException is expected
    }
    //3
    @Test
    public void testExpand_InvalidLowerMargin() {
        // Given
        Range range = new Range(2, 6);
        double lowerMargin = -0.2; // Invalid lower margin
        double upperMargin = 0.5;
        
        // When
        Range expandedRange = Range.expand(range, lowerMargin, upperMargin);
        
        // Then
        assertEquals("Lower bound of expanded range should be 2", 2.0, expandedRange.getLowerBound(), 0.0001);
        assertEquals("Upper bound of expanded range should be 8", 8.0, expandedRange.getUpperBound(), 0.0001);
    }
    //4
    @Test
    public void testExpand_InvalidUpperMargin() {
        // Given
        Range range = new Range(2, 6);
        double lowerMargin = 0.25;
        double upperMargin = 2; // Invalid upper margin
        
        // When
        Range expandedRange = Range.expand(range, lowerMargin, upperMargin);
        
        // Then
        assertEquals("Lower bound of expanded range should be 1", 1.0, expandedRange.getLowerBound(), 0.0001);
        assertEquals("Upper bound of expanded range should be 6", 6.0, expandedRange.getUpperBound(), 0.0001);
    }
    //BVA
    //5
    @Test
    public void testExpand_NoChangeToMargins() {
        // Given
        Range range = new Range(2, 6);
        double lowerMargin = 0;
        double upperMargin = 0;
        
        // When
        Range expandedRange = Range.expand(range, lowerMargin, upperMargin);
        
        // Then
        assertEquals("Lower bound of expanded range should be 2", 2.0, expandedRange.getLowerBound(), 0.0001);
        assertEquals("Upper bound of expanded range should be 6", 6.0, expandedRange.getUpperBound(), 0.0001);
    }
    //6
    @Test
    public void testExpand_LowerBoundAtMinimum() {
        // Given
        Range range = new Range(2, 6);
        double lowerMargin = 1;
        double upperMargin = 1;
        
        // When
        Range expandedRange = Range.expand(range, lowerMargin, upperMargin);
        
        // Then
        assertEquals("Lower bound of expanded range should be -2", -2.0, expandedRange.getLowerBound(), 0.0001);
        assertEquals("Upper bound of expanded range should be 10", 10.0, expandedRange.getUpperBound(), 0.0001);
    }
    //7
    @Test
    public void testExpand_RangeWithinBounds() {
        // Given
        Range range = new Range(4, 6);
        double lowerMargin = 0.5;
        double upperMargin = 0.5;
        
        // When
        Range expandedRange = Range.expand(range, lowerMargin, upperMargin);
        
        // Then
        assertEquals("Lower bound of expanded range should be 3", 3.0, expandedRange.getLowerBound(), 0.0001);
        assertEquals("Upper bound of expanded range should be 7", 7.0, expandedRange.getUpperBound(), 0.0001);
    }
    
    //shift(org.jfree.data.Range base, double delta)
    //1
    @Test
    public void testShift_PositiveDelta() {
        // Given
        Range base = new Range(1, 10);
        double delta = 5;
        
        // When
        Range shiftedRange = Range.shift(base, delta);
        
        // Then
        Range expectedRange = new Range(6, 15);
        assertEquals("Shifted range is incorrect", expectedRange, shiftedRange);
    }
    //2
    @Test(expected = NullPointerException.class)
    public void testShift_NullRange() {
        // When trying to shift with a null range, it should throw a NullPointerException
        Range.shift(null, 5);
    }
    //3
    @Test(expected = IllegalArgumentException.class)
    public void testShift_NegativeDelta() {
        // Given a Range object
        Range base = new Range(10, 15);
        
        // When shifting with a negative delta, it should throw an InvalidParameterException
        Range.shift(base, -5);
    }
    //4
    @Test
    public void testShift_ZeroDelta() {
        // Given a Range object
        Range base = new Range(10, 15);
        
        // When shifting with a zero delta
        Range result = Range.shift(base, 0);
        
        // Then the result should be the same as the input base
        assertEquals("Range should remain the same when delta is 0",
                     base, result);
    }


}
