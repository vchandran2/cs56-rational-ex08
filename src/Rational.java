public class Rational {

    private int num;
    private int denom;

    /** 
	greatest common divisor of a and b
	@param a first number
	@param b second number
	@return gcd of a and b
    */
    public static int gcd(int a, int b) {
	if (a==0)
	    return b;
	else if (b==0)
	    return a;
	else
	    return gcd(b%a, a);
    }
    
    public Rational() {
	this.num = 1;
	this.denom = 1;
    }

    public Rational(int num, int denom) {
	if (denom== 0) {
	    throw new IllegalArgumentException("denominator may not be zero");
	}
	this.num = num;
	this.denom = denom;
	if (num != 0) {
	    int gcd = Rational.gcd(num,denom);
	    this.num /= gcd;
	    this.denom /= gcd;
	}
    }

    public String toString() {
	if (denom == 1 || num == 0)
	    return "" + num;
	return num + "/" + denom;
    }

    public int getNumerator() { return this.num; }
    public int getDenominator() { return this.denom; }

    public Rational times(Rational r) {
	return new Rational(this.num * r.num,
			    this.denom * r.denom);
    }

    public static Rational product(Rational a, Rational b) {
	return new Rational(a.num * b.num,
			    a.denom * b.denom);
    }

    public Rational reciprocalOf() {
 	return new Rational(this.denom, this.num);
    }
    

    public Rational dividedBy(Rational r) {
	Rational b = r.reciprocalOf();
	return new Rational(this.num * b.num,
			    this.denom * b.denom);
    }

    public static Rational quotient(Rational a, Rational b) {
	Rational c = b.reciprocalOf();
	return new Rational(a.num * c.num,
			    a.denom * c.denom);
    }

    public static int lcm(int a,int b) {
	int c = Math.abs(a * b);
	int gcd = Rational.gcd(a, b);
	return c/gcd;
    }
    
    public Rational plus(Rational r) {
	int lcm = Rational.lcm(this.denom, r.denom);
	int d1 = lcm/this.denom;
	int d2 = lcm/r.denom;
	int newNum= (d1*this.num) + (d2*r.num);
	return new Rational(newNum, lcm);
    }

    public static Rational sum(Rational a, Rational b) {
	int lcm = Rational.lcm(a.denom, b.denom);
	int d1 = lcm/a.denom;
	int d2 = lcm/b.denom;
	int newNum = (d1*a.num) + (d2*b.num);
	return new Rational(newNum, lcm);
    }

    public Rational minus(Rational r) {
	int newNum = r.num * -1;
	Rational newRat2 = new Rational(newNum, r.denom);
	Rational newRat1 = new Rational(this.num, this.denom);
	return Rational.sum(newRat1, newRat2);
    }

    public static Rational difference(Rational a, Rational b) {
	return a.minus(b);
    }
    
    /** 
	For testing getters.  
	@param args unused
     */

    public static void main (String [] args) {
	Rational r = new Rational(5,7);
	System.out.println("r.getNumerator()=" + r.getNumerator());
	System.out.println("r.getDenominator()=" + r.getDenominator());
    }

}
