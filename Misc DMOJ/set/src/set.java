import java.util.*;
import java.io.*;

public class set {
	//Classic for 200th problem solved!
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;

	public static void main(String[] args) throws IOException {
		Set<Integer> set = new TreeSet<Integer>();
		
		for (int i = readInt(); i > 0; i--) set.add(readInt());
		
		System.out.println(set.size());
	}

	static String next() throws IOException {
		while (in == null || !in.hasMoreTokens())
			in = new StringTokenizer(br.readLine());
		return in.nextToken();
	}

	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}
}