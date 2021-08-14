import java.util.Scanner;
public class ccc02s2 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		int numerator = in.nextInt();
		int denominator = in.nextInt();
		if (numerator == 0) {
			System.out.println(0);
			System.exit(0);
		}
		if (numerator % denominator == 0) {
			System.out.println(numerator/denominator);
			System.exit(0);
		}
		int wholeValue = 0;
		if (numerator > denominator) {
			wholeValue = numerator / denominator;
			numerator -= wholeValue * denominator;
		}
		for (int i = numerator; i >= 2; i--) {
			if (numerator % i == 0 && denominator % i == 0) {
				numerator /= i;
				denominator /= i;
				if (i > numerator) {
					i = numerator + 1;
				}
			}
		}
		if (wholeValue != 0) {
			System.out.print(wholeValue + " ");
		}
		System.out.println(numerator + "/" + denominator);
	}

}