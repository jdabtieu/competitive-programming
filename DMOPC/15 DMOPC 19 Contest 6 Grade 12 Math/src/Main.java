import java.io.*;
import java.util.*;
public class Main {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 * Currently in progress
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer in = new StringTokenizer(br.readLine());
		int classmates = Integer.parseInt(in.nextToken());
		int queries = Integer.parseInt(in.nextToken());
		int[] opinion = new int[classmates+1];
		for (int cases = 0; cases < queries; cases++) {
			in = new StringTokenizer(br.readLine());
			switch(Byte.parseByte(in.nextToken())) {
			case 1:
				opinion[Integer.parseInt(in.nextToken())]++;
				break;
			case 2:
				opinion[Integer.parseInt(in.nextToken())]--;
				break;
			case 3:
				int i = Integer.parseInt(in.nextToken());
				int j = Integer.parseInt(in.nextToken());
				int c = Integer.parseInt(in.nextToken());
				int count = 0;
				for (int m = i; m <= j; m++) if (opinion[m] == c) count++;
				System.out.println(count);
				break;
			}
		}
	}
}
