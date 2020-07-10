import java.util.*;
import java.io.*;

public class ccc07s4 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;
	
	public static void main(String[] args) throws IOException {
		ArrayList<ArrayList<Integer>> parents = new ArrayList<ArrayList<Integer>>();
		int points = readInt();
		int[] paths = new int[points + 1];
		paths[points] = 1;
		
		for (int i = 0; i <= points; i++) {
			parents.add(new ArrayList<Integer>());
		}
		
		while (true) {
			int a = readInt(), b = readInt();
			if (a == 0 && b == 0) break;
			parents.get(b).add(a);
		}
		
		for (int i = points; i > 0; i--) for (int p : parents.get(i)) {
			paths[p] += paths[i];
		}
		
		System.out.println(paths[1]);
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