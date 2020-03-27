import java.util.Arrays;
import java.util.Scanner;

public class Main {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		short[] marks = new short[in.nextShort()];
		for (int i = 0; i < marks.length; i++) {
			marks[i] = in.nextShort();
		}
		Arrays.sort(marks);
		if (marks.length % 2 == 1) {
			System.out.println(marks[(marks.length - 1) / 2]);
		} else {
			int medianSum = marks[marks.length / 2] + marks[marks.length / 2 - 1];
			if (medianSum % 2 == 0) System.out.println(medianSum / 2);
			else System.out.println((medianSum + 1) / 2);
		}
	}
}
