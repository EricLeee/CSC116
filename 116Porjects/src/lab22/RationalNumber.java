package lab22;

/**
 * rational number type, with two integers representing the numerator and denominator
 * @author Justin Schwab
 * @author Zach Scoot
 * @author Jialang Li
 */
public class RationalNumber{
    /** numerator */
    private int numerator;
    /** denominator */
    private int denominator;
    /**
     * constructs the RationalNumber object
     * @param numerator the numerator of rational number
     * @param denominator the denominator of rational number
     */
    public RationalNumber(int numerator, int denominator){
        if(denominator < 0){
            this.numerator = -1 * numerator;
            this.denominator = -1 * denominator;
        } else { 
            this.numerator = numerator;
            this.denominator = denominator;
        }
        int gcd = gcd(getNumerator(), getDenominator());
        if(gcd != 1){
            setNumerator(getNumerator() / gcd);
            setDenominator(getDenominator() / gcd);
        }
    }
    /**
     * constructs RationalNumber with default value 0/1
     * 
     */
    public RationalNumber(){
        this(0,1);
    }
    /**
     * gets the denominator of an instance of RationalNumber
     * @return the denominator
     */
    public int getDenominator(){
        return this.denominator;
    }
    /**
     * gets the numerator of an instance of RationalNumber
     * @return the numerator
     */
    public int getNumerator(){
        return this.numerator;
    }
    /**
     * returns a string representation of an instance of RationalNumber
     * @return rational number as a string
     */
    public String toString(){
        String ret = "";
        if(getDenominator() == 1){
            ret += getNumerator();
            return ret;
        } 
        return (getNumerator() + "/" + getDenominator());
    }
    /**
     * sets the numerator of an instance of RationalNumber
     * @param numerator the numerator
     */
    public void setNumerator(int numerator){
        this.numerator = numerator;
    }
    /**
     * sets the denominator of an instance of RationalNumber
     * @param denominator the denominator
     */
    public void setDenominator(int denominator){
        this.denominator = denominator;
    }
    /**
     * tests equality between RationalNumber and another object
     * @param other the other object
     * @return true/false equality value
     */
    public boolean equals(Object other){
        if(other instanceof RationalNumber){
            RationalNumber o = (RationalNumber) other;
            return this.numerator == o.getNumerator()
                        && this.denominator == o.getDenominator();
        } else {
            return false;
        }  
    }
    /**
     * adds RationalNumber with another RationalNumber
     * @param other the other RationalNumber
     * @return the sum of the two rational numbers
     */
    public RationalNumber add(RationalNumber other){
        RationalNumber ret = new RationalNumber(getDenominator() * other.getNumerator() +
                            other.getDenominator() * getNumerator(), getDenominator() *
                            other.getDenominator());
        return ret;
    }
    /**
     * substracts two RationalNumbers
     * @param other the other RationalNumber
     * @return the difference between the two rational numbers
     */
    public RationalNumber subtract(RationalNumber other){
        RationalNumber ret = new RationalNumber(-1 * getDenominator() * other.getNumerator() +
                            other.getDenominator() * getNumerator(), getDenominator() *
                            other.getDenominator());
        return ret;
    }
    /**
     * multiplies two RationalNumbers
     * @param other the other RationalNumber
     * @return the product of the two rational numbers
     */
    public RationalNumber multiply(RationalNumber other){
        RationalNumber ret = new RationalNumber(getNumerator() * other.getNumerator(),
                                                getDenominator() * other.getDenominator());
        return ret;
    }
    /**
     * divides two RationalNumbers
     * @param other the other RationalNumber
     * @return the quotient of the two rational numbers
     */
    public RationalNumber divide(RationalNumber other){
        RationalNumber ret = new RationalNumber(getNumerator() * other.getDenominator(),
                                                getDenominator() * other.getNumerator());
        return ret;
    }
    /**
     * computes the greatest common divisor of two integers 
     * @param a first integer
     * @param b second integer
     * @return greatest common divisor between a and 
     */
    public static int gcd(int a, int b){
        a = Math.abs(a);
        b = Math.abs(b);
        int factor = Math.min(a,b);
        if(a == 0 || b == 0){
            return Math.abs(a + b);
        }
        while(factor >= 0){
            if(a % factor == 0 && b % factor == 0){
                return factor;
            } else {
                factor--;
            }
        }
        return 1;
    }
}
