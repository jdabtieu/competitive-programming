import java.io.*;
import java.util.*;
public class Main {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer in = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(in.nextToken()), b = Integer.parseInt(in.nextToken()), c = Integer.parseInt(in.nextToken());
		if (a < b + c && b < a + c && c < a + b) {
			System.out.println("yes");
			System.exit(0);
		}
		System.out.println("no");
	}

}
