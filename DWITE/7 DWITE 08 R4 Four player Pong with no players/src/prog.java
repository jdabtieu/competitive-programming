import java.util.*;
import java.io.*;
public class prog {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) throws IOException {
	    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 5; i++) {
			int velA = Integer.parseInt(in.readLine());
			int velB = Integer.parseInt(in.readLine());
			if (Math.abs(velA) > 2 * Math.abs(velB)) {
				int yPos = 25 + 50 * velB / Math.abs(velA);
				if (velA > 0) {
					System.out.println(100+","+yPos);
				} else {
					System.out.println(0+","+yPos);
				}
			} else {
				int xPos = 50 + 25 * velA / Math.abs(velB);
				if (velB > 0) {
					System.out.println(xPos+","+50);
				} else {
					System.out.println(xPos+","+0);
				}
			}
		}

	}
}
