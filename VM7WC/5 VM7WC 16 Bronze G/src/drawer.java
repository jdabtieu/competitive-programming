import java.util.Scanner;
public class drawer {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		int magnification = in.nextInt();
		
		//Draw top (1/5)
		for (int i = 1; i <= magnification; i++) {
			for (int j = 1; j <= 5*magnification; j++) {
				System.out.print("G");
			}
			System.out.println("");
		}
		
		//Draw second layer (2/5)
		for (int i = 1; i <= magnification; i++) {
			for (int j = 1; j <= magnification; j++) {
				System.out.print("G");
			}
			for (int j = 1; j <= 4*magnification; j++) {
				System.out.print(".");
			}
			System.out.println("");
		}
		
		//Draw middle (3/5)
		for (int i = 1; i <= magnification; i++) {
			for (int j = 1; j <= magnification; j++) {
				System.out.print("G");
			}
			for (int j = 1; j <= 2*magnification; j++) {
				System.out.print(".");
			}
			for (int j = 1; j <= 2*magnification; j++) {
				System.out.print("G");
			}
			System.out.println("");
		}
		
		//Draw fourth layer (4/5)
		for (int i = 1; i <= magnification; i++) {
			for (int j = 1; j <= magnification; j++) {
				System.out.print("G");
			}
			for (int j = 1; j <= 3*magnification; j++) {
				System.out.print(".");
			}
			for (int j = 1; j <= magnification; j++) {
				System.out.print("G");
			}
			System.out.println("");
		}
		
		//Draw fifth layer (5/5)
		for (int i = 1; i <= magnification; i++) {
			for (int j = 1; j <= 5*magnification; j++) {
				System.out.print("G");
			}
			System.out.println("");
		}

	}

}
