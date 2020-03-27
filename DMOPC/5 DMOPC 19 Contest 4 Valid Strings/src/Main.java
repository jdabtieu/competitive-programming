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
		for (int i = Integer.parseInt(in.nextToken()); i > 0; i--) {
			in = new StringTokenizer(br.readLine());
			String input = in.nextToken();
			if (input.length() == 0) System.out.println("YES");
			else {
				int openingBracketCount = 0, closingBracketCount = 0;
				for (int k = 0; k < input.length(); k++) {
					char tester = input.charAt(k);
					if (tester == 48 || tester == 49 || tester == 50 || tester == 51 || tester == 52 || tester == 53 || tester == 54 || tester == 55 || tester == 56 || tester == 57) {
						
					} else if (tester == '(') {
						openingBracketCount++;
					} else if (tester == ')') {
						closingBracketCount++;
						if (closingBracketCount > openingBracketCount) {
							System.out.println("NO");
							break;
						}
					} else {
						System.out.println("NO");
						break;
					}
					if (k == input.length() - 1) {
						System.out.println(openingBracketCount == closingBracketCount ? "YES" : "NO");
					}
				}
			}
		}
	}
}