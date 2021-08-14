import java.util.*;
import java.io.*;
public class ccc11j2 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer in = new StringTokenizer(br.readLine());
		int humidity = Integer.parseInt(in.nextToken());
		in = new StringTokenizer(br.readLine());
		final int MAX_TIME = Integer.parseInt(in.nextToken());
		for (int i = 1; i <= MAX_TIME; i++) {
			int altitude = -6 * i * i * i * i + humidity * i * i * i + 2 * i * i + i;
			if (altitude <= 0) {
				System.out.println("The balloon first touches ground at hour:\n" + i);
				System.exit(0);
			}
		}
		System.out.println("The balloon does not touch ground in the given time.");
	}

}
