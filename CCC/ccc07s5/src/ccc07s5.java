import java.util.*;
import java.io.*;

public class ccc07s5 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;

	public static void main(String[] args) throws IOException {
		for (int cases = readInt(); cases > 0; cases--) {
			int pinCount = readInt(), balls = readInt(), width = readInt();
			
			int[] pins = new int[pinCount];
			pins[0] = readInt();
			for (int i = 1; i < pinCount; i++) pins[i] = pins[i - 1] + readInt();
			for (int i = pinCount - 1; i >= width; i--) pins[i] -= pins[i - width];
			
			int[][] dp = new int[pinCount + 1][balls + 1];
			
			for (int i = pinCount - 1; i >= 0; i--) for (int j = 1; j <= balls; j++) {
				dp[i][j] = Math.max(pins[i] + dp[Math.min(i + width, pinCount)][j - 1], dp[Math.min(i + 1, pinCount)][j]);
			}
			
			System.out.println(dp[0][balls]);
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