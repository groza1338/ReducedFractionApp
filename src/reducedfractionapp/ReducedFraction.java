package reducedfractionapp;

/** Несократимая дробь.
 */
public final class ReducedFraction {
    
    /* =========================== Свойства =============================== */
    /* ---------------------- Числитель и знаменатель --------------------- */
    private final int numerator; // Числитель
    private final int denominator; // Знаменатель

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    /* =========================== Операции ============================== */

    /* ---------------------------- Порождение ---------------------------- */


    /** Найти наибольший общий делитель (НОД)
     * @param a первое число
     * @param b второе число
     * @return наибольший общий делитель (НОД)
     */
    private static int greatestCommonDivider(int a, int b) {
        return b==0 ? a : greatestCommonDivider(b, a%b);
    }

    /** Создание дроби с указанием ее числителя и знаменателя.
     * @param numerator Числитель
     * @param denominator Знаменатель
     */
    public ReducedFraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }

        int gcd = Math.abs(greatestCommonDivider(numerator, denominator));


        this.numerator = denominator < 0 ? -numerator/gcd : numerator/gcd;
        this.denominator = denominator < 0 ? -denominator/gcd : denominator/gcd;
    }
    
  
    /* --------------------- Арифметические операции ---------------------- */
    
    /** Сложение двух дробей.
     * @param other вторая дробь
     * @return сумма двух дробей
     */
    public ReducedFraction addition(ReducedFraction other) {
        if (this.denominator == other.denominator) {
            return new ReducedFraction(this.numerator + other.numerator, this.denominator);
        } else {
            int newThisNumerator = this.numerator * other.denominator;
            int newOtherNumerator = other.numerator * this.denominator;

            int newDenominator = this.denominator * other.denominator;

            return new ReducedFraction(newThisNumerator + newOtherNumerator, newDenominator);
        }
    }

    /** Вычитание двух дробей.
     * @param other вторая дробь
     * @return разница двух дробей
     */
    public ReducedFraction subtraction(ReducedFraction other) {
        if (this.denominator == other.denominator) {
            return new ReducedFraction(this.numerator - other.numerator, this.denominator);
        } else {
            int newThisNumerator = this.numerator * other.denominator;
            int newOtherNumerator = other.numerator * this.denominator;

            int newDenominator = this.denominator * other.denominator;

            return new ReducedFraction(newThisNumerator - newOtherNumerator, newDenominator);
        }
    }

    /** Умножение двух дробей.
     * @param other вторая дробь
     * @return произведение двух дробей
     */
    public ReducedFraction multiplication(ReducedFraction other) {
        return new ReducedFraction(this.numerator * other.numerator, this.denominator * other.denominator);
    }
    
    /** Деление двух дробей.
     * @param other вторая дробь
     * @return деление двух дробей
     */
    public ReducedFraction division(ReducedFraction other) {
        if (other.numerator == 0) {
            throw new IllegalArgumentException("Cannot divide by fraction with zero numerator");
        }
        return new ReducedFraction(this.numerator * other.denominator, this.denominator * other.numerator);
    }


    /* --------------------- Операции сравнения ---------------------- */

    /** Сравнение двух дробей.
     * @param other вторая дробь
     * @return Bigger, Smaller, Equals
     */
    public Compare comparing(ReducedFraction other) {
        int thisValue = this.numerator * other.denominator;
        int otherValue = other.numerator * this.denominator;

        if (thisValue == otherValue) {
            return Compare.Equal;
        }
        return thisValue < otherValue ? Compare.Smaller : Compare.Bigger;
    }
    
    /** Эквивалентность двух дробей.
    * @param other вторая объект
     * @return эквиваленты ли объекты
    */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof ReducedFraction)) {
            return false;
        }

        return this.comparing((ReducedFraction) other) == Compare.Equal;
    }

    
    /* --------------------- Операции преобразования ---------------------- */
    
    /** Представить как строку.
    * @return дробь в формате строки
    */
    @Override
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }

    /** Представить как вещественное число.
    * @return дробь в формате вещественного числа
    */
    public float toFloat() {
        return (float) this.numerator / (float) this.denominator;
    }

}
