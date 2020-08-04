import java.util.*;
import java.io.*;

public class mockccc2020c1j4 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;

	public static void main(String[] args) throws IOException {
		int len = readInt();
		char[] info = next().toCharArray();
		
		int[] prefixSum = new int[len], postfixSum = new int[len];
		
		prefixSum[0] = info[0] == '1' ? 0 : 2000000;
		for (int i = 1; i < len; i++) if (info[i] == '0') prefixSum[i] = prefixSum[i - 1] + 1;
		
		postfixSum[len - 1] = info[len - 1] == '1' ? 0 : 2000000;
		for (int i = len - 2; i >= 0; i--) if (info[i] == '0') postfixSum[i] = postfixSum[i + 1] + 1;
		
		long score = 0;
		for (int i = 0; i < len; i++) score += Math.min(prefixSum[i], postfixSum[i]);
		
		System.out.println(score);
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
}