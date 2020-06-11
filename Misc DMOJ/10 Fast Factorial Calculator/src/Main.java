import java.util.*;
import java.io.*;

public class Main {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;

	public static void main(String[] args) throws IOException {
		for (int cases = readInt(); cases > 0; cases--) {
			try {
				long num = readLong();
				if (num < 34) {
					System.out.println(fact(num));
				} else System.out.println(0);
			} catch (NumberFormatException e) {
				System.out.println(0);
			}
		}
	}

	static long fact(long num) {
		long n = 1;
		for (int i = 2; i <= num; i++) n = (n * i) % 4294967296L;
		return n;
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