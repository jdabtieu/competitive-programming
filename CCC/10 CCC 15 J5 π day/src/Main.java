import java.util.*;
import java.io.*;

public class Main {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;
	static int[][] table;
	public static void f(int n, int k) {
		for (int i = 1; i <= Math.min(n, k); i++) {
			table[i][i] = 1;
		}
		for (int i = 2; i <= n; i++) {
			table[i][1] = 1;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k && i >= j; j++) {
				if (table[i - 1][j - 1] + table[i - j][j] > table[i][j]) {
					table[i][j] = table[i - 1][j - 1] + table[i - j][j];
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int k = readInt();
		table = new int[n + 1][k + 1];
		f(n, k);
		System.out.println(table[n][k]);
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