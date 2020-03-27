import java.util.Scanner;
public class fixer {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		int numQuestions = in.nextInt();
		
		int[] numbers = new int[numQuestions];
		int[] exp = new int[numQuestions];
		
		for (int i = 0; i < numQuestions; i++) {
			int input = in.nextInt();
			numbers[i] = input / 10;
			exp[i] = input % 10;
		}
		
		int sum = 0;
		for (int i = 0; i < numQuestions; i++) {
			sum += Math.pow(numbers[i], exp[i]);
		}
		System.out.println(sum);
	}

}