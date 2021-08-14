import java.util.Scanner;
public class ccc03s1 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		int currentSquare = 1;
		for(;;) {
			int squaresMoved = in.nextInt();
			if (squaresMoved == 0) {
				System.out.println("You Quit!");
				System.exit(0);
			} else if (squaresMoved < 13 && squaresMoved > 1) {
			if (squaresMoved + currentSquare <= 100) {
				currentSquare += squaresMoved;
				if (currentSquare == 100) {
					System.out.println("You are now on square 100");
					System.out.println("You Win!");
					System.exit(0);				
				} else if (currentSquare == 99) {
					currentSquare = 77;
				} else if (currentSquare == 90) {
					currentSquare = 48;
				} else if (currentSquare == 54) {
					currentSquare = 19;
				} else if (currentSquare == 67) {
					currentSquare = 86;
				} else if (currentSquare == 40) {
					currentSquare = 64;
				} else if (currentSquare == 9) {
					currentSquare = 34;
				}
			}
			System.out.println("You are now on square " + currentSquare);
		}
		}
	}

}
