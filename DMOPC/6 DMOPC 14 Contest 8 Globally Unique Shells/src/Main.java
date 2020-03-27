import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer in = new StringTokenizer(br.readLine());
		int i = Integer.parseInt(in.nextToken());
		int shells = 1000000;
		byte[] leftShells = new byte[shells];
		byte[] rightShells = new byte[shells];
		in = new StringTokenizer(br.readLine());
		StringTokenizer in2 = new StringTokenizer(br.readLine());
		for (int rightCases = Integer.parseInt(in.nextToken()); rightCases > 0; rightCases--) {
			rightShells[Integer.parseInt(in2.nextToken())] = 1;
		}
		in2 = new StringTokenizer(br.readLine());
		for (int rightCases = Integer.parseInt(in.nextToken()); rightCases > 0; rightCases--) {
			leftShells[Integer.parseInt(in2.nextToken())] = 1;
		}
		for (int shellsIntact = 1; shellsIntact < leftShells.length; shellsIntact++) {
			if (leftShells[shellsIntact] == 1 && rightShells[shellsIntact] == 1) i--;
		}
		System.out.println(i);
	}

}