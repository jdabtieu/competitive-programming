import java.util.*;
public class rgss2 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		int size = in.nextInt();
		int [] x = new int[size];
		int [] y = new int[size];
		for (int i = 0; i < size; i++) {
			x[i] = in.nextInt();
			y[i] = in.nextInt();
		}
		
		Arrays.sort(x);
		Arrays.sort(y);
		
		int length = x[size - 1] - x[0];
		int width = y[size - 1] - y[0];
		System.out.println(length * width);
	}
}
