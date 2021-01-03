import java.io.*;
import java.util.*;
public class ccc11s1 {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;
	
	public static void main(String[] args) throws IOException {
		int s = 0;
		for (int lines = readInt(); lines > 0; lines--) {
			String input = readLine();
			for (int i = 0; i < input.length(); i++) {
				if (input.charAt(i) == 's' || input.charAt(i) == 'S') s++;
				else if (input.charAt(i) == 't' || input.charAt(i) == 'T') s--;
			}
		}
        System.out.println(s >= 0 ? "French" : "English");
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