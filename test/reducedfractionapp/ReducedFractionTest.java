package reducedfractionapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReducedFractionTest {

    @Test
    public void testAdditionSameDenominator() {
        ReducedFraction fraction1 = new ReducedFraction(1, 3);
        ReducedFraction fraction2 = new ReducedFraction(2, 3);
        ReducedFraction expected = new ReducedFraction(1, 1);
        ReducedFraction result = fraction1.addition(fraction2);
        assertEquals(expected, result);
    }

    @Test
    public void testAdditionDifferentDenominators() {
        ReducedFraction fraction1 = new ReducedFraction(1, 2);
        ReducedFraction fraction2 = new ReducedFraction(1, 3);
        ReducedFraction expected = new ReducedFraction(5, 6);
        ReducedFraction result = fraction1.addition(fraction2);
        assertEquals(expected, result); 
    }

    @Test
    public void testAdditionWholeNumber() {
        ReducedFraction fraction1 = new ReducedFraction(1, 1);
        ReducedFraction fraction2 = new ReducedFraction(3, 4);
        ReducedFraction expected = new ReducedFraction(7, 4);
        ReducedFraction result = fraction1.addition(fraction2);
        assertEquals(expected, result); 
    }

    @Test
    public void testAdditionNegativeFractions() {
        ReducedFraction fraction1 = new ReducedFraction(-1, 3);
        ReducedFraction fraction2 = new ReducedFraction(-2, 3);
        ReducedFraction expected = new ReducedFraction(-1, 1);
        ReducedFraction result = fraction1.addition(fraction2);
        assertEquals(expected, result); 
    }

    @Test
    public void testAdditionWithZero() {
        ReducedFraction fraction1 = new ReducedFraction(3, 4);
        ReducedFraction fraction2 = new ReducedFraction(0, 1);
        ReducedFraction expected = new ReducedFraction(3, 4);
        ReducedFraction result = fraction1.addition(fraction2);
        assertEquals(expected, result); 
    }

    @Test
    public void testAdditionWithReduction() {
        ReducedFraction fraction1 = new ReducedFraction(2, 4);
        ReducedFraction fraction2 = new ReducedFraction(2, 4);
        ReducedFraction expected = new ReducedFraction(1, 1);
        ReducedFraction result = fraction1.addition(fraction2);
        assertEquals(expected, result); 
    }

    @Test
    public void testAdditionNegativeDenominator() {
        ReducedFraction fraction1 = new ReducedFraction(1, -3);
        ReducedFraction fraction2 = new ReducedFraction(1, 3);
        ReducedFraction expected = new ReducedFraction(0, 1);
        ReducedFraction result = fraction1.addition(fraction2);
        assertEquals(expected, result); 
    }

    @Test
    public void testEqualsSameFraction() {
        ReducedFraction fraction1 = new ReducedFraction(1, 2);
        ReducedFraction fraction2 = new ReducedFraction(1, 2);
        assertEquals(fraction1, fraction2);
    }

    @Test
    public void testEqualsDifferentNumerator() {
        ReducedFraction fraction1 = new ReducedFraction(1, 2);
        ReducedFraction fraction2 = new ReducedFraction(2, 2);
        assertNotEquals(fraction1, fraction2);
    }

    @Test
    public void testEqualsDifferentDenominator() {
        ReducedFraction fraction1 = new ReducedFraction(1, 2);
        ReducedFraction fraction2 = new ReducedFraction(1, 3);
        assertNotEquals(fraction1, fraction2);
    }

    @Test
    public void testEqualsSimplifiedFraction() {
        ReducedFraction fraction1 = new ReducedFraction(2, 4);
        ReducedFraction fraction2 = new ReducedFraction(1, 2);
        assertEquals(fraction1, fraction2);
    }

    @Test
    public void testEqualsNegativeNumerator() {
        ReducedFraction fraction1 = new ReducedFraction(-1, 2);
        ReducedFraction fraction2 = new ReducedFraction(1, -2);
        assertEquals(fraction1, fraction2);
    }

    @Test
    public void testEqualsZeroFraction() {
        ReducedFraction fraction1 = new ReducedFraction(0, 1);
        ReducedFraction fraction2 = new ReducedFraction(0, 10);
        assertEquals(fraction1, fraction2);
    }

    @Test
    public void testEqualsDifferentTypes() {
        ReducedFraction fraction1 = new ReducedFraction(1, 2);
        Object notAFraction = new Object();
        assertNotEquals(fraction1, notAFraction);
    }

    @Test
    public void testToStringBasicFraction() {
        ReducedFraction fraction = new ReducedFraction(1, 2);
        assertEquals("1/2", fraction.toString());
    }

    @Test
    public void testToStringSimplifiedFraction() {
        ReducedFraction fraction = new ReducedFraction(2, 4);
        assertEquals("1/2", fraction.toString());
    }

    @Test
    public void testToStringNegativeNumerator() {
        ReducedFraction fraction = new ReducedFraction(-1, 2);
        assertEquals("-1/2", fraction.toString());
    }

    @Test
    public void testToStringNegativeDenominator() {
        ReducedFraction fraction = new ReducedFraction(1, -2);
        assertEquals("-1/2", fraction.toString());
    }

    @Test
    public void testToStringZeroNumerator() {
        ReducedFraction fraction = new ReducedFraction(0, 5);
        assertEquals("0/1", fraction.toString());
    }

    @Test
    public void testToStringWholeNumber() {
        ReducedFraction fraction = new ReducedFraction(4, 1);
        assertEquals("4/1", fraction.toString());
    }
}