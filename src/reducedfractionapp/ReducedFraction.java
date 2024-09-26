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

    /** Создание дроби с указанием только числителя
     * @param numerator числитель
     */
    public ReducedFraction(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    /* --------------------- Арифметические операции ---------------------- */
    
    /** Сложение двух дробей.
     * @param other вторая дробь
     * @return сумма двух дробей
     */
    public ReducedFraction addition(ReducedFraction other) {
        return addFractions(other);
    }

    /** Сложение двух дробей
     *
     * @param other другая дробь
     * @return сумма двух дробей
     */
    private ReducedFraction addFractions(ReducedFraction other) {
        if (this.denominator == other.denominator) {
            return new ReducedFraction(this.numerator + other.numerator, this.denominator);
        } else {
            int newThisNumerator = this.numerator * other.denominator;
            int newOtherNumerator = other.numerator * this.denominator;

            int newDenominator = this.denominator * other.denominator;

            return new ReducedFraction(newThisNumerator + newOtherNumerator, newDenominator);
        }
    }

    /** Сложение дроби и Int
     *
     * @param other число
     * @return сумма
     */
    public ReducedFraction addition(Integer other) {
        ReducedFraction otherFraction = new ReducedFraction(other);
        return addFractions(otherFraction);
    }

    /** Вычитание двух дробей.
     * @param other вторая дробь
     * @return разница двух дробей
     */
    public ReducedFraction subtraction(ReducedFraction other) {
        return subtractFraction(other);
    }

    private ReducedFraction subtractFraction(ReducedFraction other) {
        if (this.denominator == other.denominator) {
            return new ReducedFraction(this.numerator - other.numerator, this.denominator);
        } else {
            int newThisNumerator = this.numerator * other.denominator;
            int newOtherNumerator = other.numerator * this.denominator;

            int newDenominator = this.denominator * other.denominator;

            return new ReducedFraction(newThisNumerator - newOtherNumerator, newDenominator);
        }
    }

    public ReducedFraction subtraction(Integer other) {
        ReducedFraction otherFraction = new ReducedFraction(other);
        return subtractFraction(otherFraction);
    }

    /** Умножение двух дробей.
     * @param other вторая дробь
     * @return произведение двух дробей
     */
    public ReducedFraction multiplication(ReducedFraction other) {
        return new ReducedFraction(this.numerator * other.numerator, this.denominator * other.denominator);
    }

    public ReducedFraction multiplication(Integer other) {
        ReducedFraction otherFraction = new ReducedFraction(other);
        return new ReducedFraction(this.numerator * otherFraction.numerator, this.denominator * otherFraction.denominator);
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

    public ReducedFraction division(Integer other) {
        ReducedFraction otherFraction = new ReducedFraction(other);
        if (otherFraction.numerator == 0) {
            throw new IllegalArgumentException("Cannot divide by fraction with zero numerator");
        }
        return new ReducedFraction(this.numerator * otherFraction.denominator, this.denominator * otherFraction.numerator);
    }


    /* --------------------- Операции сравнения ---------------------- */

    /** Сравнение двух дробей.
     * @param other вторая дробь
     * @return Bigger, Smaller, Equals
     */
    public Integer compare(ReducedFraction other) {
        return compareFraction(other);
    }

    public Integer compare(Integer other) {
        ReducedFraction otherFraction = new ReducedFraction(other);
        return compareFraction(otherFraction);
    }

    private Integer compareFraction(ReducedFraction otherFraction) {
        int thisValue = this.numerator * otherFraction.denominator;
        int otherValue = otherFraction.numerator * this.denominator;

        if (thisValue == otherValue) {
            return 0;
        }
        return thisValue < otherValue ? -1 : 1;
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

        return this.compare((ReducedFraction) other) == 0;
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
