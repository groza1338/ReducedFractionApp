package reducedfractionapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReducedFractionTest {

    /* Аспекты тестирования (для сложения)
      1. Проверяется сложение дробей с одинаковыми знаменателями.
      2. Проверяется сложение дробей с разными знаменателями.
      3. Проверяется сложение дроби с целым числом.
      4. Проверяется сложение отрицательных дробей.
      5. Проверяется сложение дроби с нулевой дробью.
      6. Проверяется сложение дробей, которые можно упростить.
      7. Проверяется сложение дробей с отрицательным знаменателем.
     */

    /* Аспекты тестирования (для эквивалентности)
      1. Проверяется эквивалентность двух одинаковых дробей.
      2. Проверяется, что дроби с разными числителями не равны.
      3. Проверяется, что дроби с разными знаменателями не равны.
      4. Проверяется эквивалентность дробей, которые равны после упрощения.
      5. Проверяется эквивалентность дробей с отрицательными числителями или знаменателями.
      6. Проверяется, что дроби с нулевыми числителями равны, независимо от знаменателя.
      7. Проверяется, что дробь не равна объекту другого типа (например, объекту Object).
     */

    /* Аспекты тестирования (для toString)
     * 1. Проверяется, что дробь с числителем 1 и знаменателем 2 корректно выводится как 1/2.
     * 2. Проверяется, что дробь, которая может быть сокращена (например, 2/4), сокращается и выводится как 1/2.
     * 3. Проверяется, что дробь с отрицательным числителем правильно отображается с отрицательным знаком (-1/2).
     * 4. Проверяется, что дробь с отрицательным знаменателем выводится с отрицательным числителем, так как отрицательный знак должен быть перенесен в числитель (-1/2).
     * 5. Проверяется, что дробь с числителем 0 всегда выводится как 0/1, независимо от знаменателя.
     * 6. Проверяется, что дробь со знаменателем 1 выводится как целое число в виде 4/1.
     */

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