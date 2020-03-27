import java.util.Scanner;
public class counter {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		byte numSides = in.nextByte();
		
		if (numSides < 4) {
			System.out.println(0);
			System.exit(0);
		} else if (numSides == 4) {
			System.out.println(1);
			System.exit(0);
		}
		
		int intersections = 1;
		
		for (int i = 5; i <= numSides; i++) {
			intersections = i * intersections / (i - 4);
		}
		System.out.println(intersections);

	}

}