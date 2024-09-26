package reducedfractionapp;

/**
 * Класс представляет несократимую дробь и предоставляет методы для выполнения арифметических операций над дробями.
 */
public final class ReducedFraction {

    /* =========================== Свойства =============================== */
    /* ---------------------- Числитель и знаменатель --------------------- */

    /** Числитель дроби */
    private final int numerator;

    /** Знаменатель дроби */
    private final int denominator;

    /**
     * Получить числитель дроби.
     *
     * @return числитель дроби
     */
    public int getNumerator() {
        return numerator;
    }

    /**
     * Получить знаменатель дроби.
     *
     * @return знаменатель дроби
     */
    public int getDenominator() {
        return denominator;
    }

    /* =========================== Операции ============================== */
    /* ---------------------------- Порождение ---------------------------- */

    /**
     * Найти наибольший общий делитель (НОД) двух чисел.
     *
     * @param a первое число
     * @param b второе число
     * @return наибольший общий делитель (НОД)
     */
    private static int greatestCommonDivider(int a, int b) {
        return b == 0 ? a : greatestCommonDivider(b, a % b);
    }

    /**
     * Создание дроби с указанием ее числителя и знаменателя.
     *
     * @param numerator числитель
     * @param denominator знаменатель (не должен быть равен нулю)
     * @throws IllegalArgumentException если знаменатель равен нулю
     */
    public ReducedFraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }

        int gcd = Math.abs(greatestCommonDivider(numerator, denominator));
        this.numerator = denominator < 0 ? -numerator / gcd : numerator / gcd;
        this.denominator = denominator < 0 ? -denominator / gcd : denominator / gcd;
    }

    /**
     * Создание дроби с указанием только числителя (знаменатель будет равен 1).
     *
     * @param numerator числитель
     */
    public ReducedFraction(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    /* --------------------- Арифметические операции ---------------------- */

    /**
     * Сложение двух дробей.
     *
     * @param other вторая дробь для сложения
     * @return результат сложения в виде новой дроби
     */
    public ReducedFraction addition(ReducedFraction other) {
        return addFractions(other);
    }

    /**
     * Внутренний метод для выполнения сложения двух дробей.
     *
     * @param other другая дробь
     * @return результат сложения в виде новой дроби
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

    /**
     * Сложение дроби и целого числа.
     *
     * @param other целое число для сложения
     * @return результат сложения в виде новой дроби
     */
    public ReducedFraction addition(Integer other) {
        ReducedFraction otherFraction = new ReducedFraction(other);
        return addFractions(otherFraction);
    }

    /**
     * Вычитание двух дробей.
     *
     * @param other вторая дробь для вычитания
     * @return результат вычитания в виде новой дроби
     */
    public ReducedFraction subtraction(ReducedFraction other) {
        return subtractFraction(other);
    }

    /**
     * Внутренний метод для выполнения вычитания двух дробей.
     *
     * @param other другая дробь
     * @return результат вычитания в виде новой дроби
     */
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

    /**
     * Вычитание дроби и целого числа.
     *
     * @param other целое число для вычитания
     * @return результат вычитания в виде новой дроби
     */
    public ReducedFraction subtraction(Integer other) {
        ReducedFraction otherFraction = new ReducedFraction(other);
        return subtractFraction(otherFraction);
    }

    /**
     * Умножение двух дробей.
     *
     * @param other вторая дробь для умножения
     * @return результат умножения в виде новой дроби
     */
    public ReducedFraction multiplication(ReducedFraction other) {
        return new ReducedFraction(this.numerator * other.numerator, this.denominator * other.denominator);
    }

    /**
     * Умножение дроби и целого числа.
     *
     * @param other целое число для умножения
     * @return результат умножения в виде новой дроби
     */
    public ReducedFraction multiplication(Integer other) {
        ReducedFraction otherFraction = new ReducedFraction(other);
        return new ReducedFraction(this.numerator * otherFraction.numerator, this.denominator * otherFraction.denominator);
    }

    /**
     * Деление двух дробей.
     *
     * @param other вторая дробь для деления
     * @return результат деления в виде новой дроби
     * @throws IllegalArgumentException если числитель второй дроби равен нулю
     */
    public ReducedFraction division(ReducedFraction other) {
        if (other.numerator == 0) {
            throw new IllegalArgumentException("Cannot divide by fraction with zero numerator");
        }
        return new ReducedFraction(this.numerator * other.denominator, this.denominator * other.numerator);
    }

    /**
     * Деление дроби и целого числа.
     *
     * @param other целое число для деления
     * @return результат деления в виде новой дроби
     * @throws IllegalArgumentException если целое число равно нулю
     */
    public ReducedFraction division(Integer other) {
        ReducedFraction otherFraction = new ReducedFraction(other);
        if (otherFraction.numerator == 0) {
            throw new IllegalArgumentException("Cannot divide by fraction with zero numerator");
        }
        return new ReducedFraction(this.numerator * otherFraction.denominator, this.denominator * otherFraction.numerator);
    }

    /* --------------------- Операции сравнения ---------------------- */

    /**
     * Сравнение двух дробей.
     *
     * @param other вторая дробь для сравнения
     * @return 0, если дроби равны; -1, если текущая дробь меньше; 1, если текущая дробь больше
     */
    public Integer compare(ReducedFraction other) {
        return compareFraction(other);
    }

    /**
     * Сравнение дроби с целым числом.
     *
     * @param other целое число для сравнения
     * @return 0, если дробь и число равны; -1, если дробь меньше; 1, если дробь больше
     */
    public Integer compare(Integer other) {
        ReducedFraction otherFraction = new ReducedFraction(other);
        return compareFraction(otherFraction);
    }

    /**
     * Внутренний метод для сравнения двух дробей.
     *
     * @param otherFraction другая дробь
     * @return результат сравнения (0 - равны, -1 - меньше, 1 - больше)
     */
    private Integer compareFraction(ReducedFraction otherFraction) {
        int thisValue = this.numerator * otherFraction.denominator;
        int otherValue = otherFraction.numerator * this.denominator;
        if (thisValue == otherValue) {
            return 0;
        }
        return thisValue < otherValue ? -1 : 1;
    }

    /* --------------------- Операции преобразования ---------------------- */

    /**
     * Эквивалентность двух дробей.
     *
     * @param other объект для сравнения
     * @return true, если объекты эквивалентны; false в противном случае
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof ReducedFraction)) {
            return false;
        }
        return this.compare((ReducedFraction) other) == 0;
    }

    /**
     * Представить дробь как строку.
     *
     * @return строковое представление дроби в формате "числитель/знаменатель"
     */
    @Override
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }

    /**
     * Представить дробь в формате вещественного числа.
     *
     * @return дробь в формате вещественного числа
     */
    public float toFloat() {
        return (float) this.numerator / (float) this.denominator;
    }

}
