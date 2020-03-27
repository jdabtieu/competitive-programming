import java.util.Scanner;
public class PrimeChecker {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		int number = in.nextInt();
		if (number < 2) {
			System.out.println(2);
			System.exit(0);			
		}
		for (int i = number; i > 0; i++) {
			boolean prime = true;
			for (int j = 2; j <= Math.sqrt(i); j++) {
				boolean check = i % j == 0;
				if (check == true) {
					prime = false;
					j = (int) Math.sqrt(i);
				}
			}
			if (prime != false) {
				System.out.println(i);
				System.exit(0);
			}
		}

	}

}
