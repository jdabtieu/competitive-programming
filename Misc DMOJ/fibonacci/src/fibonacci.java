import java.io.*;
import java.math.*;
import java.util.*;

public class fibonacci {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
    public static void power(long mat[][], BigInteger num) { 
	    if(num.compareTo(BigInteger.ZERO) == 0 || num.compareTo(BigInteger.ONE) == 0) return; 
	    long[][] newMat = {{1, 1}, {1, 0}};
	    power(mat, num.divide(new BigInteger("2"))); 
	    multiply(mat, mat); 
	    if (num.mod(new BigInteger("2")).compareTo(BigInteger.ZERO) != 0) multiply(mat, newMat); 
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
		long[][] M = {{1, 1}, {1, 0}};
	    power(M, num.subtract(BigInteger.ONE));
	    System.out.println(M[0][0]);
	}
}