import java.util.Scanner;
public class Main {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		byte days = in.nextByte();
		for (byte i = 1; i <= days; i++) {
			byte trees = in.nextByte();
			int weight = 0;
			for (byte j = 0; j < trees; j++) weight += in.nextInt();
			if (weight != 0) System.out.println("Day " + i + ": " + weight);
			else System.out.println("Weekend");
		}
	}
}