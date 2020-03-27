import java.util.Scanner;
public class prog {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			int velA = in.nextInt();
			int velB = in.nextInt();
			
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
