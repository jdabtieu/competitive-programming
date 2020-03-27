import java.util.Scanner;
public class answers {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		int numQuestions = in.nextInt();
		int correctAnswers = 0;
		char[] studentAnswers = new char[numQuestions];
		for (int i = 0; i < numQuestions; i++) {
			studentAnswers[i] = in.next().charAt(0);
		}
		for (int i = 0; i < numQuestions; i++) {
			if (studentAnswers[i] == in.next().charAt(0)) {
				correctAnswers++;
			}
		}
		System.out.println(correctAnswers);
	}

}