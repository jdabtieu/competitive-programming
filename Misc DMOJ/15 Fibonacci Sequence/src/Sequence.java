import java.math.BigInteger;
import java.util.*;
public class Sequence {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 * Currently in progress
	 */
	static final long[][] newMat = {{1, 1}, {1, 0}};
	static long[][] M = {{1, 1}, {1, 0}};
	static final BigInteger TWO = new BigInteger("2");
	static final BigInteger mobius = new BigInteger("30000000");
	public static void power(BigInteger num) { 
	    if(num.compareTo(TWO) < 0) return; 
	    if (num.compareTo(mobius) < 0) {
	    	fib(num);
	    	return;
	    } else {
	    	power(num.divide(new BigInteger("2"))); 
		    multiply(M, M);
		    if (num.mod(new BigInteger("2")).compareTo(BigInteger.ZERO) != 0) multiply(M, newMat); 
	    }
    } 
	
	public static void multiply(long m1[][], long m2[][]) { 
	    long i =  m1[0][0] * m2[0][0] + m1[0][1] * m2[1][0]; 
	    long j =  m1[0][0] * m2[0][1] + m1[0][1] * m2[1][1]; 
	    long k =  m1[1][0] * m2[0][0] + m1[1][1] * m2[1][0]; 
	    long l =  m1[1][0] * m2[0][1] + m1[1][1] * m2[1][1];
	    m1[0][0] = i % 1000000007; 
	    m1[0][1] = j % 1000000007; 
	    m1[1][0] = k % 1000000007; 
	    m1[1][1] = l % 1000000007; 
	} 
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		BigInteger num = new BigInteger(in.next());
	    if (num.compareTo(BigInteger.ZERO) == 0) {
	    	System.out.println(0);
	    	System.exit(0);
	    }
	    power(num.subtract(BigInteger.ONE));
	    System.out.println(M[0][0]);
	}

	
	public static void fib(BigInteger num) {
	    for (BigInteger i = BigInteger.ONE; i.compareTo(num) != 0; i = i.add(BigInteger.ONE)) {
	    	multiply(M, newMat);
	    }
	    }
}