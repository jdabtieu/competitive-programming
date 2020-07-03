import java.util.*;
import java.io.*;

public class bts18p2 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;

	public static void main(String[] args) throws IOException {
		String str = readLine();
		ArrayList<Counter> count = new ArrayList<Counter>(str.length());
		count.add(new Counter(str.charAt(0)));
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == ' ') count.add(new Counter(count.get(i - 1)));
			else count.add(new Counter(count.get(i - 1), str.charAt(i)));
		}
		
		for (int queries = readInt(); queries > 0; queries--) {
			int index1 = readInt() - 2, index2 = readInt() - 1;
			char letter = readChar();
			try {
				System.out.println(count.get(index2).get(letter) - count.get(index1).get(letter));
			} catch (IndexOutOfBoundsException e) {
				System.out.println(count.get(index2).get(letter));
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

class Counter {
	private int[] frequency;
	
	public Counter(char newChar) {
		frequency = new int[26];
		frequency[newChar - 'a']++;
	}
	
	public Counter(Counter prev, char newChar) {
		frequency = prev.frequency.clone();
		frequency[newChar - 'a']++;
	}
	
	public Counter(Counter prev) {
		frequency = prev.frequency.clone();
	}
	
	public int get(char letter) {
		return frequency[letter - 'a'];
	}
}