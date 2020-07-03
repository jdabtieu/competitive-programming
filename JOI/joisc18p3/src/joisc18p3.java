import java.util.*;
import java.io.*;

public class joisc18p3 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;
	
	static final int mod = 1000000007;

	public static void main(String[] args) throws IOException {
		int r = readInt(), c = readInt();
		int[][] dp = new int[r + 1][c + 1];
		
		for (int i = 0; i <= r; i++) dp[i][0] = 1;
		for (int i = 0; i <= c; i++) dp[0][i] = 1;
		for (int i = 1; i <= r; i++) dp[i][1] = dp[i - 1][1] + 3 + i;
		for (int i = 1; i <= c; i++) dp[1][i] = dp[1][i - 1] + 3 + i;
		
		for (int i = 2; i <= r; i++) for (int j = 2; j <= c; j++) {
			dp[i][j] = (int) ((dp[i - 1][j] + (4L * j * dp[i - 1][j - 1]) % mod + (j * (j - 1L) * dp[i - 1][j - 2] / 2) % mod + ((i - 1L) * j * dp[i - 2][j - 1]) % mod) % mod);
		}
		System.out.println(dp[r][c] - 1);
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