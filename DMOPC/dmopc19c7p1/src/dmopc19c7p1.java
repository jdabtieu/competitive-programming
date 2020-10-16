import java.util.*;
import java.io.*;

public class dmopc19c7p1 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;

	public static void main(String[] args) throws IOException {
		int single = readInt(), doub = readInt(), triple = readInt(), hydro = readInt();
		if ((doub == 0 && single < triple - 1) || (doub > 0 && single < triple) || (4 + 2 * single - 2 * triple != hydro)) {
			System.out.println("invalid");
			return;
		}
		System.out.println("C" + (single + doub + triple + 1) + "H" + hydro);
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