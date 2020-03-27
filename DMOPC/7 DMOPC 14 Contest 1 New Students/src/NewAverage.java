import java.text.DecimalFormat;
import java.util.Scanner;
public class NewAverage {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static DecimalFormat format = new DecimalFormat("#.000");
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		int sumOfMarks = 0, numStudents = in.nextInt();
		for (int i = 0; i < numStudents; i++) {
			sumOfMarks += in.nextInt();
		}
		
		int newStudents = in.nextInt();
		
		for (int i = 0; i < newStudents; i++) {
			sumOfMarks += in.nextInt();
			numStudents++;
			System.out.println(format.format((double) sumOfMarks / numStudents));
		}
	}

}
