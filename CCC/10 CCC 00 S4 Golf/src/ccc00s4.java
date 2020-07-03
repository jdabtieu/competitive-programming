import java.util.*;
import java.io.*;

public class ccc00s4 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;

	public static void main(String[] args) throws IOException {
		int dist = readInt();
		int[] clubs = new int[readInt()];
		for (int i = 0; i < clubs.length; i++) clubs[i] = readInt();
		
		int[] table = new int[dist + 1];
		for (int i = 1; i <= dist; i++) table[i] = 16384;
		
		for (int i = 1; i <= dist; i++) {
			for (int j = 0; j < clubs.length; j++) {
				if (clubs[j] <= i && table[i] > table[i - clubs[j]]) table[i] = table[i - clubs[j]] + 1;
			}
		}
		
		System.out.println(table[dist] == 16384 ? "Roberta acknowledges defeat." : "Roberta wins in " + table[dist] + " strokes.");
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