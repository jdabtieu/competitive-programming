import java.util.Arrays;
import java.util.Scanner;
public class miaudax {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] nums = in.next().split("x");
		long[] numbers = new long[nums.length];
		for (int i = 0; i < nums.length; i++) {
			numbers[i] = Integer.parseInt(nums[i]);
		}
		Arrays.sort(numbers);
		long product = 1;
		for (int i = 0; i < numbers.length - 1; i++) {
			System.out.print(numbers[i] + "x");
			product *= numbers[i];
		}
		System.out.print(numbers[numbers.length - 1] + "\n" + product * numbers[numbers.length - 1]);
	}

}