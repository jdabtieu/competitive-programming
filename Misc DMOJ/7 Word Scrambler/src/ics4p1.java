import java.util.*;
import java.io.*;

public class ics4p1 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;

	static PriorityQueue<String> list = new PriorityQueue<String>();
	
	public static void main(String[] args) throws IOException {
		perm(next(), "");
		
		while (!(list.isEmpty())) System.out.println(list.poll());
	}

	public static void perm(String word, String proc) {
		if (word.length() == 0) list.offer(proc);
		
		for (int i = 0; i < word.length(); i++) perm(word.substring(0, i) + word.substring(i + 1), proc + word.charAt(i));
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