import java.util.Scanner;
public class Main {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		short options = in.nextShort();
		short destination = (short) Math.abs(in.nextInt());
		int shortestPath = 32767;
		for (short i = 1; i <= options; i++) {
			short temp = in.nextShort();
			if (destination % temp == 0 && destination / temp < shortestPath) {
				shortestPath = destination / temp;
			}
		}
		System.out.println(shortestPath == 32767 ? "This is not the best time for a trip." : shortestPath);
	}

}