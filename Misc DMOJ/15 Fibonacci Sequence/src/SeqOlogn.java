import java.math.*;
import java.util.*;
public class SeqOlogn {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 * Currently in progress
	 */
	static final BigInteger Integer_MAX_VALUE = new BigInteger("2147483647");
	static final BigInteger TWO = new BigInteger("2");
	static PriorityQueue<BigInteger> powers = new PriorityQueue<>(Collections.reverseOrder());
	public static void reducePower(BigInteger power) {
		BigDecimal fib1 = BigDecimal.ONE;
//		BigDecimal fib2 = BigDecimal.ONE;
		powers.add(power);
		BigInteger processingPower;
		do {
			processingPower = powers.poll();
			if (processingPower.remainder(TWO).equals(BigInteger.ZERO)) {
				powers.add(processingPower.divide(TWO));
				powers.add(processingPower.divide(TWO));
			} else {
				powers.add(processingPower.divide(TWO));
				powers.add(processingPower.divide(TWO));
				powers.add(BigInteger.ONE);
			}
		} while (powers.peek().compareTo(Integer_MAX_VALUE) > 0);
		while (!powers.isEmpty()) {
//			fib1 = fib1.multiply(MathNums.Phi().pow(powers.peek().intValue()));
//			fib2 = fib2.multiply(MathNums.phi().pow(powers.poll().intValue()));
			fib1 = fib1.multiply(MathNums.Phi().pow(powers.poll().intValue()));
		}
//		System.out.println(fib1.subtract(fib2).divide(MathNums.sqrt5()).setScale(0, RoundingMode.HALF_UP));
		System.out.println(fib1.setScale(100, RoundingMode.UP).divide(MathNums.sqrt5()).setScale(0, RoundingMode.UP));
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		BigInteger num = new BigInteger(in.next());
	    if (num.compareTo(BigInteger.ZERO) == 0) {
	    	System.out.println(0);
	    	System.exit(0);
	    }
	    reducePower(num);
	}

}
class MathNums {
	
	private MathNums() {}
	
	static BigDecimal sqrt5() {
		return new BigDecimal("2.23606797749978969640917366873127623544061835961152572427089");
	}
	static BigDecimal Phi() {
		return sqrt5().add(new BigDecimal("1")).divide(new BigDecimal("2"));
	}
	
	static BigDecimal phi() {
		return new BigDecimal("1").subtract(sqrt5()).divide(new BigDecimal("2"));
	}
}