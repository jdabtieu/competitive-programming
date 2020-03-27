import java.util.*;
import java.io.*;
public class Main {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int ceiling = in.nextInt();
		int doneInfected = 0;
		int infected = in.nextInt();
		int day = 0;
		int r0 = in.nextInt();
		while (doneInfected + infected <= ceiling) {
			day++;
			doneInfected += infected;
			infected = infected * r0;
		}
		System.out.println(day);
	}

}
