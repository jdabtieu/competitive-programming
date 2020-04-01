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
		int integers = readInt();
		ArrayList<PriorityQueue<Integer>> lists = new ArrayList<PriorityQueue<Integer>>();
		for (int i = 0; i < integers; i++) {
			lists.add(new PriorityQueue<Integer>());
			for (int j = 0; j < integers; j++) {
				lists.get(i).add(readInt());
			}
		}
		PriorityQueue<Integer> list = new PriorityQueue<Integer>();
		for (int i = 0; i < integers; i++) {
			for (int j = 0; j < integers / 2; j++) {
				lists.get(i).poll();
			}
			list.add(lists.get(i).poll());
		}
		for (int i = 0; i < integers / 2; i++) list.poll();
		System.out.println(list.poll());
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