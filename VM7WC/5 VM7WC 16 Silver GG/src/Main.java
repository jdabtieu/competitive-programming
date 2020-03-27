import java.io.*;
import java.util.StringTokenizer;

public class Main {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer in2 = new StringTokenizer(br.readLine());
		String input = in2.nextToken();
		int[] inputGs = new int[input.length()];
		if (input.charAt(0) == 'G') inputGs[0] = 1;
		for (int i = 1; i < input.length(); i++) {
			if (input.charAt(i) == 'G') inputGs[i] = inputGs[i - 1] + 1;
			else inputGs[i] = inputGs[i - 1];
		}
		
		
		
		StringTokenizer in1 = new StringTokenizer(br.readLine());
		for (int cases = Integer.parseInt(in1.nextToken()); cases > 0; cases--) {
			StringTokenizer in = new StringTokenizer(br.readLine());
			int floor = Integer.parseInt(in.nextToken());
			int ceiling = Integer.parseInt(in.nextToken());
			System.out.println(floor == 0 ? inputGs[ceiling] : inputGs[ceiling] - inputGs[floor - 1]);
			
			
			
			
		}
	}
}