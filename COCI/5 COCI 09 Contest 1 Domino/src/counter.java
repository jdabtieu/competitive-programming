import java.util.Scanner;
public class counter {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		int N = in.nextInt();
		int sum = 0;
		for (int i = 0; i <= N; i++) {
			sum = sum + (N + i) * (N - i + 1) /2 + (N - i + 1) * i;
		}
		System.out.println(sum);
	}
}