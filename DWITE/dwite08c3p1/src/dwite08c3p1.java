import java.util.Scanner;
public class dwite08c3p1 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		for (int count = 0; count < 5; count++) {
		int height = in.nextInt();
		for (int i = 0; (double) i <= height / 2; i++) {
			for (int j = 0; j < ((height - 1) / 2 - i); j++) {
				System.out.print(".");
			}
			for(int l = 0; l < 2*i + 1; l++) {
				System.out.print("#");
			}

			for (int k = 0; k < ((height - 1) / 2 - i); k++) {
				System.out.print(".");

			}
			System.out.println("");
		}
		for (int i = 0; i < (height / 2); i++) {
			for (int j = 0; j < ((height - 1) / 2 + i + 1 - (height / 2)); j++) {
				System.out.print(".");
			}
			for(int l = 0; l < height - 2*i - 2; l++) {
				System.out.print("#");
			}

			for (int k = 0; k < ((height - 1) / 2 + i + 1 - (height / 2)); k++) {
				System.out.print(".");

			}
			System.out.println("");
		}
	}
	}

}