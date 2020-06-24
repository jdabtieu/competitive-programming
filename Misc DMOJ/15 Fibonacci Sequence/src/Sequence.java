import java.io.*;
import java.math.*;
import java.util.*;

public class Sequence {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 * Warning: This is not a functional solution. This problem is still a work in progress.
	 */
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;
	
	static BigInteger TWO = new BigInteger("2");
	static final long modulus = 1000000007;
	static long[] matrix = {1, 1, 1, 0};
	static long[] result = {1, 0, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BigInteger num = new BigInteger(next());
		if (num.compareTo(BigInteger.ZERO) == 0) {
			System.out.println(0);
			return;
		}
		matrixPow(num);
		System.out.println(result[1]);
	}


	public static void matrixPow(BigInteger num) {
		while (num.compareTo(BigInteger.ZERO) != 0) {
			if (num.mod(TWO).compareTo(BigInteger.ONE) == 0) result = mult(result, matrix);
			num = num.divide(TWO);
			matrix = mult(matrix, matrix);
		}
	}

	public static long[] mult(long[] x, long[] y) {
		return new long[] {((x[0] * y[0]) % modulus + (x[1] * y[2]) % modulus) % modulus, ((x[0] * y[1]) % modulus + (x[1] * y[3]) % modulus) % modulus,
				((x[2] * y[0]) % modulus + (x[3] * y[2]) % modulus) % modulus, ((x[2] * y[1]) % modulus + (x[3] * y[3]) % modulus) % modulus};
	}

	static String next() throws IOException {
		while (in == null || !in.hasMoreTokens())
			in = new StringTokenizer(br.readLine());
		return in.nextToken();
	}

	static long readLong() throws IOException {
		return Long.parseLong(next());
	}

	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}

	static double readDouble() throws IOException {
		return Double.parseDouble(next());
	}

	static char readChar() throws IOException {
		return next().charAt(0);
	}

	static String readLine() throws IOException {
		return br.readLine();
	}
}