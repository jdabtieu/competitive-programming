import java.util.*;
import java.io.*;
public class Main {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int ceiling = Integer.parseInt(in.readLine());
		int doneInfected = 0;
		int infected = Integer.parseInt(in.readLine());
		int day = 0;
		int r0 = Integer.parseInt(in.readLine());
		while (doneInfected + infected <= ceiling) {
			day++;
			doneInfected += infected;
			infected *= r0;
		}
		System.out.println(day);
	}

}
