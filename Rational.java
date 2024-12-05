public class Rational {
    private final int numerator;
    private final int denominator;


    public Rational(int numerator, int denominator) {


        int gcd = gcd((numerator), (denominator));
        if (denominator < 0) gcd = gcd;
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }


    private int gcd(int a, int b) {
        while (b != 0) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }


    public Rational plus(Rational other) {
        int numerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int denominator = this.denominator * other.denominator;
        return new Rational(numerator, denominator);
    }


    public Rational minus(Rational other) {
        int numerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int denominator = this.denominator * other.denominator;
        return new Rational(numerator, denominator);
    }


    public Rational times(Rational other) {
        int numerator = this.numerator * other.numerator;
        int denominator = this.denominator * other.denominator;
        return new Rational(numerator, denominator);
    }


    public Rational divides(Rational other) {
        int numerator = this.numerator * other.denominator;
        int denominator = this.denominator * other.numerator;
        return new Rational(numerator, denominator);
    }


    public boolean equals(Rational other) {
        return this.numerator == other.numerator && this.denominator == other.denominator;
    }


    public String toString() {
        return numerator + "/" + denominator;
    }

    //main from canvas
    public static void main(String[] args) {
        Rational x = new Rational(1, 6);
        Rational y = new Rational(4, 8);

        System.out.println(x.plus(y));      // 1/6 + 4/8 = 2/3
        System.out.println(x.minus(y));     // 1/6 - 4/8 = -1/3
        System.out.println(x.times(y));     // 1/6 * 4/8 = 1/12
        System.out.println(x.divides(y));   // 1/6 / 4/8 = 1/3
        System.out.println(x.equals(y));    // 1/6 equals to 4/8 ? false
    }
}
