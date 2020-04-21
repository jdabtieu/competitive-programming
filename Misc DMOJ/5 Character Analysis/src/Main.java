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
		int[] count = new int[128];
		String a = readLine();
		for (int i = a.length() - 1; i >= 0; i--) {
			count[a.charAt(i)]++;
		}
		a = readLine();
		for (int i = a.length() - 1; i >= 0; i--) {
			count[a.charAt(i)]--;
		}
		for (int i = 32; i < 127; i++) {
			if (count[i] != 0) {
				System.out.println((char) i);
				System.exit(0);
			}
		}
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