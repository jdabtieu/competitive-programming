import java.util.*;
public class Main {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		int num = in.nextInt();
		int[] length;
		length = new int[num];
		for (int i = 0; i < num; i++) {
			length[i] = -1 * in.nextInt() + in.nextInt();
		}
		Arrays.sort(length);
		System.out.println(length[num - 1]);
	}
}