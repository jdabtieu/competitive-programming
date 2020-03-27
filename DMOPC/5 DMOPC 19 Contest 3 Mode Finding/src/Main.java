import java.util.*;
public class Main {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		int[] frequency = new int[2000001];
		int numbers = in.nextInt();
		for (int i = 0; i < numbers; i++) {
			int intBuffer = in.nextInt();
			frequency[intBuffer + 1000000]++;
		}
		int max = 0;
		for (int i = 0; i < 2000001; i++) {
			if (frequency[i] > max) max = frequency[i];
		}
		boolean first = true;
		for (int i = 0; i < 2000001; i++) {
			if (frequency[i] == max && !first) System.out.print(" " + (i - 1000000));
			if (frequency[i] == max && first) {
				System.out.print((i - 1000000));
				first = false;
			}
		}
	}
}
