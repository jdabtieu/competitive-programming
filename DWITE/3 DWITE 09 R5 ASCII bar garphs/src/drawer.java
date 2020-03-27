import java.util.*;
public class drawer {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		int[] bars;
		bars = new int[5];
		for (int i = 0; i < 5; i++) {
			bars[i] = in.nextInt();
		}
		int[] sortedBars;
		sortedBars = new int[5];
		for (int i = 0; i < 5; i++) {
			sortedBars[i] = bars[i];
		}
		for (int i = 0; i < sortedBars.length; i++) {
			sortedBars[i] = Math.abs(sortedBars[i]);
		}
		Arrays.sort(sortedBars);
		int length = sortedBars[4];
			for (int j = 0; j < length; j++) {

				//draw negative side
				if (bars[j] < 0) {
					for (int k = 0; k < length + bars[j]; k++) {
						System.out.print("-");

					}
					for (int k = 0; k < Math.abs(bars[j]); k++) {
						System.out.print("*");
					}
				} else {
					for (int k = 0; k < 5; k++) {
						System.out.print("-");
					}
				}
				//draw positive side
				if (bars[j] < 0) {
					System.out.print("|");
					for (int k = 0; k < 5; k++) {
						System.out.print("-");
					}					
				} else {
					System.out.print("|");
					for (int k = 0; k < Math.abs(bars[j]); k++) {
						System.out.print("*");
					}
					for (int k = 0; k < length - bars[j]; k++) {
						System.out.print("-");
					}

				}
				System.out.println("");
			}

	}

}