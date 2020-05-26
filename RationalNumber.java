/* This class represents a rational number. This data type is immutable */
public class RationalNumber {

    /* Java will give error if int with final keyword
    not initialized in constructor */
    private final int numerator;
    private final int denominator;


    /**
     * Constructor for rational number with integer input
     * @param n     integer to be represented as rational number
     **/
    public RationalNumber(int n) {
        this.numerator = n;
        this.denominator = 1;
    }


    /**
     * Constructor for rational number
     * @param numerator    numerator for rational number object
     * @param denominator  denominator for rational number object
     **/
    public RationalNumber(int numerator, int denominator) throws ArithmeticException {
        int g = gcd(numerator, denominator);

        int n = numerator / g;
        int d = denominator / g;

        if (d < 0) {
            n = n * (-1);
            d = d * (-1);
        }

        this.numerator = n;
        this.denominator = d;
        checkRep();
    }

    private void checkRep() {
        assert this.denominator != 0;
        assert gcd(this.numerator, this.denominator) == 1;
    }


    /**
     * Computes the greatest common divisor of the two integer
     * @param integer1      int first input number
     * @param integer2      int second input number
     * @return              int greatest common divisor of integer1 and integer2
     */
    private int gcd(int integer1, int integer2) {

        if (integer1 > integer2) {
            int remainder = integer1 % integer2;

            if (remainder == 0) {
                return integer2;
            }

            else {
                return gcd(integer2, remainder);
            }
        }

        else {
            int remainder = integer2 % integer1;

            if (remainder == 0) {
                return integer1;
            }

            else {
                return gcd(integer1, remainder);
            }
        }
    }
}
