import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

public class mockccc2020c1j3 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;
	
	public static void main(String[] args) throws IOException {
		long x = readLong(), y = readLong();
		System.out.print(x * y / 4);
		System.out.print('.');
		System.out.println(new DecimalFormat("0.00").format(x * y % 4 * 0.25).substring(2));
	}

	static String next() throws IOException {
		while (in == null || !in.hasMoreTokens())
			in = new StringTokenizer(br.readLine());
		return in.nextToken();
	}

	static long readLong() throws IOException {
		return Long.parseLong(next());
	}
}