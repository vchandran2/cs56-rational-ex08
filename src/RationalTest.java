import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Before;

public class RationalTest {

    private Rational r_5_15;
    private Rational r_24_6;
    private Rational r_3_7;  
    private Rational r_13_4;
    private Rational r_20_25;
    private Rational r_25_20;
    private Rational r_0_1; 
    
    @Before public void setUp() {
	r_5_15 = new Rational(5,15);
	r_24_6 = new Rational(24,6);
	r_3_7  = new Rational(3,7);
	r_13_4 = new Rational(13,4);
	r_20_25 = new Rational(20,25);
	r_0_1 = new Rational(0,1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_denom_zero() {
	Rational r = new Rational(1,0);
    }
    
    @Test
    public void test_getNumerator_20_25() {
	assertEquals(4, r_20_25.getNumerator());
    }
    
    @Test
    public void test_getNumerator_13_4() {
	assertEquals(13, r_13_4.getNumerator());
    }
    
    @Test
    public void test_getDenominator_20_25() {
	assertEquals(5, r_20_25.getDenominator());
    }
    
    @Test
    public void test_getDenominator_13_4() {
	assertEquals(4, r_13_4.getDenominator());
    }

    @Test
    public void test_toString_5_15() {
	assertEquals("1/3",r_5_15.toString());
    }

    @Test
    public void test_toString_24_6() {
	assertEquals("4",r_24_6.toString());
    }

    @Test
    public void test_toString_3_7() {
	assertEquals("3/7",r_3_7.toString());
    }
    
    @Test
    public void test_toString_20_25() {
	assertEquals("4/5",r_20_25.toString());
    }

    @Test
    public void test_toString_0_1() {
	assertEquals("0",r_0_1.toString());
    }

    @Test
    public void test_gcd_5_15() {
	assertEquals(5, Rational.gcd(5,15));
    }

    @Test
    public void test_gcd_15_5() {
	assertEquals(5, Rational.gcd(15,5));
    }

    @Test
    public void test_gcd_24_6() {
	assertEquals(6, Rational.gcd(24,6));
    }

    @Test
    public void test_gcd_17_5() {
	assertEquals(1, Rational.gcd(17,5));
    }
    
    @Test
    public void test_gcd_1_1() {
	assertEquals(1, Rational.gcd(1,1));
    }

    @Test
    public void test_gcd_20_25() {
	assertEquals(5, Rational.gcd(20,25));
    }

    @Test
    public void test_rational_m10_m5() {
	Rational r = new Rational(-10,-5);
	assertEquals("2",r.toString());
    }

    @Test
    public void test_rational_m5_6() {
	Rational r = new Rational(-5,6);
	assertEquals("-5/6",r.toString());
    }

    @Test
    public void test_rational_7_m8() {
	Rational r = new Rational(7,-8);
	assertEquals("-7/8",r.toString());
    }

    @Test
    public void test_r_5_15_times_r_3_7() {
	Rational r = r_5_15.times(r_3_7);
	assertEquals("1/7",r.toString());
    }

    @Test
    public void test_r_3_7_times_r_13_4() {
	Rational r = r_3_7.times(r_13_4);
	assertEquals("39/28",r.toString());
    }

    @Test
    public void test_r_m3_1_times_1_m3() {
	Rational r_m3_1 = new Rational(-3,1);
	Rational r_1_m3 = new Rational(1,-3);
	Rational r = r_m3_1.times(r_1_m3);
	assertEquals("1",r.toString());
    }

   @Test
    public void test_product_of_r_5_15_and_r_3_7() {
       Rational r = Rational.product(r_5_15,r_3_7);
       assertEquals("1/7",r.toString());
    }

    @Test
    public void test_product_of_r_3_7_and_r_13_4() {
	Rational r = Rational.product(r_3_7,r_13_4);
	assertEquals("39/28",r.toString());
    }

    @Test
    public void test_product_of_r_m3_1_and_1_m3() {
	Rational r_m3_1 = new Rational(-3,1);
	Rational r_1_m3 = new Rational(1,-3);
	Rational r = Rational.product(r_m3_1,r_1_m3);
	assertEquals("1",r.toString());
    }

    //I added after this point
    @Test
    public void test_reciprocalOf_r_5_15() {
	Rational r = r_5_15.reciprocalOf();
	assertEquals("3",r.toString());
    }

    @Test
    public void test_reciprocalOf_r_3_7() {
	Rational r = r_3_7.reciprocalOf();
	assertEquals("7/3",r.toString());
    }

       
    @Test(expected = IllegalArgumentException.class)
    public void test_num_zero() {
	Rational r = r_0_1.reciprocalOf();
    }

    @Test
    public void test_r_3_7_divide_by_r_13_4() {
	Rational r = r_3_7.dividedBy(r_13_4);
	assertEquals("12/91",r.toString());
    }

    @Test
    public void test_r_0_1_divide_by_24_6() {
	Rational r = r_0_1.dividedBy(r_24_6);
	assertEquals("0",r.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_r_24_6_divide_by_0_1() {
	Rational r = r_24_6.dividedBy(r_0_1);
    }
    
    @Test
    public void test_quotient_of_r_3_7_and_r_13_4() {
	Rational r = Rational.quotient(r_3_7,r_13_4);
	assertEquals("12/91",r.toString());
    }


    @Test(expected = IllegalArgumentException.class)
    public void test_quotient_of_r_24_6_and_r_0_1() {
	Rational r = Rational.quotient(r_24_6,r_0_1);
    }

    @Test
    public void test_quotient_of_r_5_15_and_r_20_25() {
	Rational r = Rational.quotient(r_5_15,r_20_25);
	assertEquals("5/12",r.toString());
    }
    
    @Test
    public void test_lcm_of_4_and_13() {
	int lcm = Rational.lcm(4,13);
	assertEquals(52,lcm);
    }

    @Test
    public void test_lcm_of_0_and_10() {
	int lcm = Rational.lcm(0,10);
	assertEquals(0,lcm);
    }

    @Test
    public void test_lcm_of_14_and_7() {
	int lcm = Rational.lcm(14,7);
	assertEquals(14,lcm);
    }
    
    @Test
    public void test_r_3_7_plus_r_13_4() {
	Rational r = r_3_7.plus(r_13_4);
	assertEquals("103/28",r.toString());
    }

    @Test
    public void test_r_0_1_plus_r_20_25() {
	Rational r = r_0_1.plus(r_20_25);
	assertEquals("4/5",r.toString());
    }

     @Test
     public void test_r_5_15_plus_r_20_25() {
	 Rational r = r_5_15.plus(r_20_25);
	 assertEquals("17/15",r.toString());
     }

    @Test
    public void test_sum_of_r_3_7_plus_r_13_4() {
	Rational r = Rational.sum(r_3_7,r_13_4);
	assertEquals("103/28",r.toString());
    }

    @Test
    public void test_sum_of_r_0_1_plus_r_20_25() {
	Rational r = Rational.sum(r_0_1,r_20_25);
	assertEquals("4/5",r.toString());
    }

    @Test
    public void test_sum_of_r_5_15_plus_r_20_25() {
	Rational r = Rational.sum(r_5_15,r_20_25);
	assertEquals("17/15",r.toString());
    }

    @Test
    public void test_r_3_7_minus_r_13_4() {
	Rational r = r_3_7.minus(r_13_4);
	assertEquals("79/-28",r.toString());
    }

    @Test
    public void test_r_0_1_minus_r_0_1() {
	Rational r = r_0_1.minus(r_0_1);
	assertEquals("0",r.toString());
    }

    @Test
    public void test_r_20_25_minus_r_5_15() {
	Rational r = r_20_25.minus(r_5_15);
	assertEquals("7/15",r.toString());
    }

    @Test
    public void test_difference_r_3_7_and_r_13_4() {
	Rational r = Rational.difference(r_3_7,r_13_4);
	assertEquals("79/-28",r.toString());
    }

    @Test
    public void test_difference_r_0_1_and_r_0_1() {
	Rational r = Rational.difference(r_0_1,r_0_1);
	assertEquals("0",r.toString());
    }

    @Test
    public void test_difference_r_20_25_and_r_5_15() {
	Rational r = Rational.difference(r_20_25,r_5_15);
	assertEquals("7/15",r.toString());
    }
    
}