import java.util.*;
public class coci07c1p1 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		int outX;
		int outY;
		
		int[] x = new int[3];
		int[] y = new int[3];
		for (int i = 0; i < 3; i++) {
			x[i] = in.nextInt();
			y[i] = in.nextInt();
		}
		Arrays.sort(x);
		Arrays.sort(y);
		
		if (x[0] == x[1]) {
			outX = x[2];
		} else if (x[0] == x[2]) {
			outX = x[1];
		} else {
			outX = x[0];
		}
		if (y[0] == y[1]) {
			outY = y[2];
		} else if (y[0] == y[2]) {
			outY = y[1];
		} else {
			outY = y[0];
		}
		System.out.println(outX + " " + outY);
	}

}