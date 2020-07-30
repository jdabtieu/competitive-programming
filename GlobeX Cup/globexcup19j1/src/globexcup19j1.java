import java.util.Scanner;

public class globexcup19j1 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numAliens = in.nextInt();
		int rating = in.nextInt();
		int winRating = in.nextInt();
		int loseRating = in.nextInt();
		int numGames = in.nextInt();
		byte[] outcome = new byte[numAliens];
		for (int i = 0; i < numAliens; i++) {
			outcome[i] = in.nextByte();
		}
		for (int i = 0; i < numGames; i++) {
			if (outcome[in.nextInt() - 1] == 1) {
				rating += winRating;
			} else {
				rating -= loseRating;
			}
		}
		System.out.println(rating);
	}

}