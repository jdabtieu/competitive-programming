import java.util.*;
public class tasks {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 * Currently in progress
	 */
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		int responsibilities = in.nextInt();
		int[] timePerResponsibility = new int[responsibilities];
		int sum = 0;
		for (int i = 0; i < responsibilities; i++) {
			timePerResponsibility[i] = in.nextInt();
			sum += timePerResponsibility[i];
		}
		boolean[][] basher = new boolean[timePerResponsibility.length + 1][sum + 1];
		for (int i = 0; i <= timePerResponsibility.length; i++) {
			basher[i][0] = true;
		}
		for (int i = 0; i <= sum; i++) {
			basher[0][i] = false;
		}
		for (int i = 1; i <= timePerResponsibility.length; i++) {
			for (int j = 1; j <= sum; j++) {
				basher[i][j] = basher[i - 1][j];
				if (timePerResponsibility[i - 1] <= j) {
					basher[i][j] = basher[i][j] || basher[i - 1][j - timePerResponsibility[i - 1]];
				}
			}
		}
		int difference = 490001;
		for (int i = sum / 2; i >= 0; i--) {
			if (basher[timePerResponsibility.length][i]) {
				difference = sum - 2 * i;
				i = 0;
			}
		}
		System.out.println(difference);
	}
}