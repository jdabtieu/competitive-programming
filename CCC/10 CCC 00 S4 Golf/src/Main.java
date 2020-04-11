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
		int distance = readInt();
		byte[] clubs = new byte[readInt()];
		for (int i = 0; i < clubs.length; i++) {
			clubs[i] = readByte();
		}
		short[] table = new short[distance + 1];
		for (int i = 1; i < table.length; i++) table[i] = 32767;
		
		for (int i = 1; i <= distance; i++) {
			for (int j = 0; j < clubs.length; j++) {
				if (clubs[j] <= i) {
					if (table[i] > table[i - clubs[j]] + 1) {
						table[i] = (short) (table[i - clubs[j]] + 1);
					}
				}
			}
		}
		System.out.println(table[distance] == 32767 ? "Roberta acknowledges defeat." : "Roberta wins in " + table[distance] + " strokes.");
		
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
	
	static short readShort() throws IOException {
		return Short.parseShort(next());
	}
	
	static byte readByte() throws IOException {
		return Byte.parseByte(next());
	}

	static char readChar() throws IOException {
		return next().charAt(0);
	}

	static String readLine() throws IOException {
		return br.readLine();
	}
}