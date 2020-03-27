import java.util.*;
public class Main {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		int[] numbers;
		numbers = new int[in.nextInt()];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = in.nextInt();
		}
		Arrays.sort(numbers);
		System.out.println(numbers[numbers.length - 1] - numbers[0]);
	}
}