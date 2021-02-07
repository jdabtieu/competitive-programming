import java.util.*;
import java.io.*;

public class ppwindsor18p7 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;

	public static void main(String[] args) throws IOException {
		int cards = readInt();
		int[] value = new int[cards + 1];
		for (int i = 1; i <= cards; i++) value[i] = readInt();
		
		int[] table = new int[cards + 1];
		table[1] = value[1];
		for (int i = 1; i <= cards; i++) {
			for (int j = 1; j <= i; j++) {
				if (table[i] < value[j] + table[i - j]) {
					table[i] = value[j] + table[i - j];
				}
			}
		}
		System.out.println(table[cards]);
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