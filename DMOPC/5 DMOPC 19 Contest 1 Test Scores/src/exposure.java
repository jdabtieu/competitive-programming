import java.util.*;
public class exposure {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		byte questions = in.nextByte();
		for (int cases = 0; cases < questions; cases++) {
			int numQuestions = in.nextInt();
			long pointsForCorrect = in.nextLong();
			long pointsForWrong = -1 * in.nextLong();
			long bottomLimit = in.nextLong();
			
			int powerOf2LargerThanQuestions = 0;
			while (Math.pow(2, powerOf2LargerThanQuestions) < numQuestions) {
				powerOf2LargerThanQuestions++;
			}

			int temp = numQuestions / 2;
			for (int i = powerOf2LargerThanQuestions; i >= 0; i--) {
				if (pointsForCorrect * temp + pointsForWrong * (numQuestions - temp) > bottomLimit && pointsForCorrect * (temp - 1) + pointsForWrong * (numQuestions - temp + 1) > bottomLimit) {
					temp -= Math.pow(2, i - 1) / 2;
				} else if (pointsForCorrect * temp + pointsForWrong * (numQuestions - temp) > bottomLimit && pointsForCorrect * (temp - 1) + pointsForWrong * (numQuestions - temp + 1) < bottomLimit) {
System.out.println(temp);
					i = -1;
				} else if (pointsForCorrect * temp + pointsForWrong * (numQuestions - temp) > bottomLimit && pointsForCorrect * (temp - 1) + pointsForWrong * (numQuestions - temp + 1) == bottomLimit) {
System.out.println((temp - 1));
					i = -1;
				} else if (pointsForCorrect * temp + pointsForWrong * (numQuestions - temp) < bottomLimit && pointsForCorrect * (temp + 1) + pointsForWrong * (numQuestions - temp - 1) < bottomLimit) {
					temp += Math.pow(2, i - 1) / 2;
				} else if (pointsForCorrect * temp + pointsForWrong * (numQuestions - temp) < bottomLimit && pointsForCorrect * (temp + 1) + pointsForWrong * (numQuestions - temp - 1) > bottomLimit) {
System.out.println((temp + 1));
					i = -1;
				} else if (pointsForCorrect * temp + pointsForWrong * (numQuestions - temp) < bottomLimit && pointsForCorrect * (temp + 1) + pointsForWrong * (numQuestions - temp - 1) == bottomLimit) {
System.out.println((temp + 1));
					i = -1;
				} else if (pointsForCorrect * temp + pointsForWrong * (numQuestions - temp) == bottomLimit) {
System.out.println(temp);
					i = -1;
				}
				
				if (i == 0) {
System.out.println(-1);
				}
			}
		}
	}
}
