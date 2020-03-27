import java.util.Scanner;
import java.util.Arrays;
public class Main {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		int a = in.nextInt();
		Integer[] numbers = new Integer[a];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = in.nextInt();
		}
		Arrays.sort(numbers);
		for (int i = 0; i < numbers.length; i++) System.out.println(numbers[i]);
	}
}