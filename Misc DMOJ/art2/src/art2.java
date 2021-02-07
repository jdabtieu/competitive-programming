import java.util.*;
import java.io.*;

public class art2 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;

	public static void main(String[] args) throws IOException {
//		long multinv = -3484478332453834927L;
		PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		int total = readInt(), steal = readInt();
		long stealValue = 0;
		for (int i = 0; i < total; i++) {
			long hash = readLong();
			if (hash == 2147483648L) {
				stealValue += 2147483648L;
				steal--;
			} else {
				pq.offer((hash * 244002641) % 4294967296L);
			}
		}
		for (int i = 0 ; i < steal; i++) {
			stealValue += pq.poll();
		}
		System.out.println(stealValue);
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