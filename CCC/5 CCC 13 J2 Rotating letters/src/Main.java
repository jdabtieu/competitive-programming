import java.util.Scanner;
public class Main {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		String sign = in.next();
		for (int i = 0; i < sign.length(); i++) {
			if (!(sign.charAt(i) == 'I' || sign.charAt(i) == 'O' || sign.charAt(i) == 'S' || sign.charAt(i) == 'H' || sign.charAt(i) == 'Z' || sign.charAt(i) == 'X' || sign.charAt(i) == 'N')) {
				System.out.println("NO");
				System.exit(0);
			}
		}
		System.out.println("YES");
	}
}