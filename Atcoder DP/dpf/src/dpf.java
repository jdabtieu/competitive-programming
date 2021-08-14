import java.util.*;
import java.io.*;

public class dpf {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;

	public static void main(String[] args) throws IOException {
		String s1 = readLine(), s2 = readLine();
		
		int string1 = s1.length();
		int string2 = s2.length();
		
		short[][] table = new short[string1 + 1][string2 + 1];
		for (int i = 1; i <= string1; i++) {
			for (int j = 1; j <= string2; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					table[i][j] = (short) (1 + table[i - 1][j - 1]);
				} else {
					table[i][j] = (short) Math.max(table[i][j - 1], table[i-1][j]);
				}
			}
		}
		System.out.println(backtrack(table, s1, s2, string1, string2));
	}
	
	static String backtrack(short[][] table, String s1, String s2, int i, int j) {
		if (i == 0 || j == 0) {
			return "";
		} else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
			return backtrack(table, s1, s2, i - 1, j - 1) + s1.charAt(i - 1);
		} else if (table[i][j - 1] > table[i - 1][j]) {
			return backtrack(table, s1, s2, i, j - 1);
		} else {
			return backtrack(table, s1, s2, i - 1, j);
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
	
	static short readShort() throws IOException {
		return Short.parseShort(next());
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