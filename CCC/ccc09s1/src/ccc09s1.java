import java.util.Scanner;

public class ccc09s1 {
	/*
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    long p = Math.round(-1 * Math.ceil(Math.pow(in.nextInt(), 0.1666666667)) + Math.floor(Math.pow(in.nextInt(), 0.1666666666))) + 1;
		System.out.println(p >= 0 ? p : 1);
	}
}
