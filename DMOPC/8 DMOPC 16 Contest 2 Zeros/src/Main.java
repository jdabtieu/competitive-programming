import java.util.*;
import java.io.*;
public class Main {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static double l5 = Math.log(5);
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static long numberOfTrailingZeros(long number) {
		if (number < 5) return 0;
		long count = 0;
		for (int n = 1; n <= Math.round(Math.log(number)/l5); n++) {
			count += Math.round(Math.floor(number/Math.pow(5, n)));
		}
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		long a = readLong(), b = readLong();
		long minimum, maximum;
		long floor = 1, ceiling = Integer.MAX_VALUE * 100000L;
		while (ceiling > floor) {
			long mid = (floor + ceiling) / 2;
			long trail = numberOfTrailingZeros(mid);
			if (ceiling - floor == 1) {
				floor = ceiling;
				break;
			}
			if (trail < a) floor = mid;
			else if (trail > a) ceiling = mid;
			else {
				floor = mid;
				break;
			}
		}
		minimum = floor;
		floor = 1;
		ceiling = Integer.MAX_VALUE * 100000L;
		while (ceiling > floor) {
			long mid = (floor + ceiling) / 2;
			long trail = numberOfTrailingZeros(mid);
			if (ceiling - floor == 1) {
				ceiling = floor;
				break;
			}
			if (trail < b) floor = mid;
			else if (trail > b) ceiling = mid;
			else {
				floor = mid;
				break;
			}
		}

		maximum = floor;
		minimum -= minimum % 5;
		maximum = maximum + 4 - maximum % 5;
		if (minimum == 0) minimum++;
		if (maximum - minimum == -2) System.out.println(0);
		else System.out.println(maximum - minimum + 1);
	}	
	static String next() throws IOException {
	    while (st == null || !st.hasMoreTokens())
	        st = new StringTokenizer(br.readLine());
	    return st.nextToken();
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
	static char readCharacter() throws IOException {
	    return next().charAt(0);
	}
	static String readLine() throws IOException {
	    return br.readLine();
	}
}
