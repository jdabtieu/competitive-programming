import java.io.*;
import java.util.*;

public class a4b1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;

	public static void main(String[] args) throws IOException {
		int nums = readInt();
		int[] n = new int[nums];
		for (int i = 0; i < nums; i++) n[i] = readInt();
		Arrays.sort(n);
		for (int i = 0; i < nums; i++) System.out.println(n[i]);
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
