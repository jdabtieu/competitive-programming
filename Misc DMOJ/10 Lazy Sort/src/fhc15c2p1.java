import java.util.*;
import java.io.*;

public class fhc15c2p1 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;
	
	public static void main(String[] args) throws IOException {
		int cases = readInt();
		for (int casesC = 1; casesC <= cases; casesC++) {
			boolean flag1 = true;
			int n = readInt();
			int[] list = new int[n];
			for (int i = 0; i < n; i++) list[i] = readInt();
			
			int pointerA = 1, pointerB = n - 1;
			int top = list[0], bottom = list[0];
			
			for (int i = 1; i < n; i++) {
				if (list[pointerA] == top - 1) {
					top--;
					pointerA++;
				} else if (list[pointerA] == bottom + 1) {
					bottom++;
					pointerA++;
				} else if (list[pointerB] == top - 1) {
					top--;
					pointerB--;
				} else if (list[pointerB] == bottom + 1) {
					bottom++;
					pointerB--;
				} else {
					flag1 = false;
					break;
				}
			}
			
			if (flag1) {
				System.out.println("Case #" + casesC + ": yes");
				continue;
			}
			
			flag1 = true;
			pointerA = 0;
			pointerB = n - 2;
			top = list[n - 1];
			bottom = list[n - 1];
			
			for (int i = 1; i < n; i++) {
				if (list[pointerA] == top - 1) {
					top--;
					pointerA++;
				} else if (list[pointerA] == bottom + 1) {
					bottom++;
					pointerA++;
				} else if (list[pointerB] == top - 1) {
					top--;
					pointerB--;
				} else if (list[pointerB] == bottom + 1) {
					bottom++;
					pointerB--;
				} else {
					flag1 = false;
					break;
				}
			}
			
			System.out.println(flag1 ? "Case #" + casesC + ": yes" : "Case #" + casesC + ": no");
			
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