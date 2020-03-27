import java.util.*;
public class Main {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		byte cases = in.nextByte();
		for (byte Cases = 0; Cases < cases; Cases++) {
			int[] numbers = new int[10];
			for (int i = 0; i < 10; i++) {
				numbers[i] = in.nextInt();
			}
			boolean geometric = true;
			boolean arithmetic = true;
			for (int i = 0; i < 8; i++) {
				if (!(numbers[i] + numbers[i+2] == 2*numbers[i+1])) {
					arithmetic = false;
				}
				if (!(numbers[i] * numbers[i+2] == numbers[i+1] * numbers[i+1])) {
					geometric = false;
				}
			}
			if (geometric == arithmetic) {
				if (geometric) {
					System.out.println("both");
				} else {
					System.out.println("neither");
				}
			} else {
				if (geometric) {
					System.out.println("geometric");
				} else {
					System.out.println("arithmetic");
				}
			}
		}

	}
}