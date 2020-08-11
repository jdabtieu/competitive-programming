import java.util.*;
import java.io.*;

public class primefactor {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;

	public static void main(String[] args) throws IOException {
		for (int cases = readInt(); cases > 0; cases--) {
			int num = readInt();
			while (num % 2 == 0) {
				System.out.print(2);
				System.out.print(" ");
				num /= 2;
			}
			
			int ceil = (int) Math.sqrt(num);
			for (int i = 3; i <= ceil; i += 2) {
				if (num % i == 0) {
					System.out.print(i);
					System.out.print(" ");
					num /= i;
					i -= 2;
				}
			}
			
			if (num != 1) System.out.println(num);
			else System.out.println("");
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