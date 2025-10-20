public class Fraction {
    private int numerator;
    private int denominator;

    // Конструктор с числителем и знаменателем
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    // Конструктор только с числителем
    public Fraction(int numerator) {
        this(numerator, 1);
    }

    public Fraction() {
        this(0, 1);
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    // Метод для нахождения наибольшего общего делителя
    private int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Метод для упрощения дроби
    private void simplify() {
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;

        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    // Сложение с другой дробью
    public Fraction add(Fraction other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    // Сложение с целым числом
    public Fraction add(int number) {
        return add(new Fraction(number));
    }

    // Вычитание другой дроби
    public Fraction minus(Fraction other) {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    // Вычитание целого числа
    public Fraction minus(int number) {
        return minus(new Fraction(number));
    }

    // Умножение на другую дробь
    public Fraction multiply(Fraction other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    // Умножение на целое число
    public Fraction multiply(int number) {
        return multiply(new Fraction(number));
    }

    // Деление на другую дробь
    public Fraction div(Fraction other) {
        if (other.numerator == 0) {
            throw new IllegalArgumentException("Деление на ноль невозможно");
        }
        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        return new Fraction(newNumerator, newDenominator);
    }

    // Деление на целое число
    public Fraction div(int number) {
        return div(new Fraction(number));
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    public static String operationToString(Fraction f1, String operator, Fraction f2, Fraction result) {
        return f1 + " " + operator + " " + f2 + " = " + result;
    }

    public static String operationToString(Fraction f1, String operator, int number, Fraction result) {
        return f1 + " " + operator + " " + number + " = " + result;
    }
}