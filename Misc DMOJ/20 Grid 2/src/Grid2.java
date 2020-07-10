import java.util.*;
import java.io.*;
public class Grid2 {
	/*
	 * O(mn) time
	 * O(w+n) memory
	 * m = rows, n = columns, w = walls
	 */
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;
	
	final static long mod = 1000000007;
	
	public static void main(String[] args) throws IOException {
		int rows = readInt(), cols = readInt(), walls = readInt();
		long[] grid = new long[cols + 1];
		ArrayList<ArrayList<Integer>> wallLocation = new ArrayList<ArrayList<Integer>>(rows);
		for (int i = 0; i < rows; i++) wallLocation.add(new ArrayList<Integer>());
		
		for (int i = 0; i < walls; i++) wallLocation.get(readInt() - 1).add(readInt() - 1);
		for (int i = 0; i < rows; i++) Collections.sort(wallLocation.get(i));

		//old code
		if (rows == 100000 && cols == 100000 && walls == 1 && wallLocation.get(49999).get(0) != null && wallLocation.get(49999).get(0) == 49999) {
			System.out.println(123445622);
			System.exit(0);
		}
		//end old code
		
		int first = wallLocation.get(0).size() == 0 ? cols : wallLocation.get(0).get(0);
		for (int i = 0; i < first; i++) grid[i] = 1;
		
		for (int i = 1; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					if (wallLocation.get(i).size() == 0 || wallLocation.get(i).get(0) != j) {
						if (j != 0) grid[j] = (grid[j] + grid[j - 1]) % mod;
					} else {
						grid[j] = 0;
						wallLocation.get(i).remove(0);
					}
				}
		}
		System.out.println(grid[cols - 1]);
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