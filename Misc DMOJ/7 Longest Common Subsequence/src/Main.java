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
		int string1 = readInt();
		int string2 = readInt();
		
		short[] string1num = new short[string1];
		short[] string2num = new short[string2];
		
		for (int i = 0; i < string1; i++) {
			string1num[i] = readShort();
		}
		for (int i = 0; i < string2; i++) {
			string2num[i] = readShort();
		}
		
		short[][] table = new short[string1 + 1][string2 + 1];
		for (int i = 1; i <= string1; i++) {
			for (int j = 1; j <= string2; j++) {
				if (string1num[i - 1] == string2num[j - 1]) {
					table[i][j] = (short) (1 + table[i - 1][j - 1]);
				} else {
					table[i][j] = (short) Math.max(table[i][j - 1], table[i-1][j]);
				}
			}
		}
		System.out.println(table[string1][string2]);
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
