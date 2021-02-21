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
		int[] letters = new int[26];
		String text = readLine();
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) != ' ') {
				letters[text.charAt(i) - 'A']++;
			}
		}
		text = readLine();
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) != ' ') {
				letters[text.charAt(i) - 'A']--;
			}
		}
		for (int i = 0; i < 26; i++) {
			if (letters[i] != 0) {
				System.out.println("Is not an anagram.");
				System.exit(0);
			}
		}
		System.out.println("Is an anagram.");
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