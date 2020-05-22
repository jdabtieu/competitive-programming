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
		int a = 0, b = 0;
		String var = null;
		while (true) {
			switch (next()) {
				case "1":
					var = next();
					if (var.equals("A")) a = readInt();
					else b = readShort();
					break;
				case "2":
					var = next();
					System.out.println(var.equals("A") ? a : b);
					break;
				case "3":
					var = next();
					if (var.equals("A")) a = a + (next().equals("A") ? a : b);
					else b = b + (next().equals("A") ? a : b);
					break;
				case "4":
					var = next();
					if (var.equals("A")) a = a * (next().equals("A") ? a : b);
					else b = b * (next().equals("A") ? a : b);
					break;
				case "5":
					var = next();
					if (var.equals("A")) a = a - (next().equals("A") ? a : b);
					else b = b - (next().equals("A") ? a : b);
					break;
				case "6":
					var = next();
					if (var.equals("A")) a = a / (next().equals("A") ? a : b);
					else b = b / (next().equals("A") ? a : b);
					break;
				case "7":
					System.exit(0);
			}
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

	static short readShort() throws IOException {
		return Short.parseShort(next());
	}

	static char readChar() throws IOException {
		return next().charAt(0);
	}

	static String readLine() throws IOException {
		return br.readLine();
	}
}