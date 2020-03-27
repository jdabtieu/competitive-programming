import java.util.*;
import java.io.*;
public class Main {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int happiness = in.nextInt() + 2 * in.nextInt() + 3 * in.nextInt();
		System.out.println(happiness < 10 ? "sad" : "happy");

	}

}
