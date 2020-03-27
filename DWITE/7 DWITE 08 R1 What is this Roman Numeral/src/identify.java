import java.util.Scanner;
public class identify {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		int[] storedNumbers;
		for (byte numberOfTests = 0; numberOfTests < 5; numberOfTests++) {
			String input = in.next();
			
			int sum = 0;
			
			storedNumbers = new int[input.length()];
			for (int i = 0; i < input.length(); i++) {
				char nextNumeral = input.charAt(i);
				if (nextNumeral == 'I') {
					storedNumbers[i] = 1;
				} else if (nextNumeral == 'V') {
					storedNumbers[i] = 5;
				} else if (nextNumeral == 'X') {
					storedNumbers[i] = 10;
				} else if (nextNumeral == 'L') {
					storedNumbers[i] = 50;
				} else if (nextNumeral == 'C') {
					storedNumbers[i] = 100;
				} else if (nextNumeral == 'D') {
					storedNumbers[i] = 500;
				} else if (nextNumeral == 'M') {
					storedNumbers[i] = 1000;
				}
			}
			for (int i = 0; i < storedNumbers.length - 1; i++) {
				if (storedNumbers[i] < storedNumbers[i + 1]) {
					sum -= storedNumbers[i];
				} else {
					sum +=storedNumbers[i];
				}
			}
			sum += storedNumbers[storedNumbers.length - 1];
			System.out.println(sum);
		}
	}
}
