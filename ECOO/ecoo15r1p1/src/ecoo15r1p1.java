import java.util.*;
import java.io.*;

public class ecoo15r1p1 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;

	public static void main(String[] args) throws IOException {
		for (byte cases = 0; cases < 10; cases++) {
			String text = null;
			int time = 0;
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			ArrayList<Integer> count = new ArrayList<Integer>();
			count.add(0);
			map.put("red", 0);
			while (!((text = readLine()).equals("end of box"))) {
				if (map.containsKey(text)) {
					count.set(map.get(text), count.get(map.get(text)) + 1);
				} else {
					count.add(1);
					map.put(text, count.size() - 1);
				}
			}
			for (int i = 1; i < count.size(); i++) {
				time += 13 * Math.ceil(count.get(i) / 7.0);
			}
			time += 16 * count.get(0);
			System.out.println(time);
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