import java.util.Scanner;
public class Maze {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 * Currently in progress
	 */
	static Scanner in = new Scanner(System.in);
	static public void WasteLines() {
		String waste = in.next();
		for (byte i = 0; i < 9; i++) waste = in.next();
	}
	
	public static void main(String[] args) {
		WasteLines();
		byte[][] distances = {
				{ 0, 11, 13, 13, 11, 11, 12, 13, 12, 11, 13, 13},
				{11,  0,  8, 16, 14,  6,  7,  8,  9, 10,  8, 16},
				{13,  8,  0, 18, 16,  8,  9, 10, 11, 12,  6, 18},
				{13, 16, 18,  0,  8, 12, 11, 10,  9,  8, 18,  6},
				{11, 14, 16,  8,  0, 10,  9,  8,  7,  6, 16,  8},
				{11,  6,  8, 12, 10,  0,  1,  2,  3,  4,  8, 12},
				{12,  7,  9, 11,  9,  1,  0,  1,  2,  3,  9, 11},
				{13,  8, 10, 10,  8,  2,  1,  0,  1,  2, 10, 10},
				{12,  9, 11,  9,  7,  3,  2,  1,  0,  1, 11,  9},
				{11, 10, 12,  8,  6,  4,  3,  2,  1,  0, 12,  8},
				{13,  8,  6, 18, 16,  8,  9, 10, 11, 12,  0, 18},
				{13, 16, 18,  6,  8, 12, 11, 10,  9,  8, 12,  0}
		};
		
		
		for (byte cases = 0; cases < 5; cases++) {
			String instruction = in.next();
			if (instruction.length() == 1) System.out.println(0);
			else {
				short pathLength = 0;
				for (byte length = 0; length < instruction.length() - 1; length++) {
					pathLength += distances[Character.getNumericValue(instruction.charAt(length)) - 10][Character.getNumericValue(instruction.charAt(length + 1)) - 10];
				}
				System.out.println(pathLength);
			}
		}

	}

}
