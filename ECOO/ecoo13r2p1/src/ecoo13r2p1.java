import java.util.Scanner;
public class ecoo13r2p1 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
for (byte CASES = 0; CASES < 5; CASES++) {
		String currentRow = in.nextLine();
		byte charactersInEachRow = (byte) currentRow.length();
		int[] rows = new int[charactersInEachRow - 2];
		int numberOfColumns = 1;
		for (byte column = 1; column > 0; column++) {
			for (byte i = 1; i < charactersInEachRow - 1; i++) {
				if (currentRow.charAt(i) == 'O') {
					rows[charactersInEachRow - 2 - i]++;
				}
			}
			currentRow = in.nextLine();
			if (currentRow.charAt(1) == '=') {
				break;
			}
			numberOfColumns++;
		}
		int minimum = 50;
		for (int i = 0; i < rows.length; i++) {
			if (rows[i] < minimum) minimum = rows[i];
		}
		for (int i = 0; i < rows.length; i++) {
			rows[i] -= minimum;
		}
		
		char[][] toBePrinted = new char[charactersInEachRow][numberOfColumns + 1];
		for (byte i = 0; i < charactersInEachRow; i++) {
			for (byte j = 0; j < numberOfColumns + 1; j++) toBePrinted[i][j] = ' ';
		}
		for (int i = 0; i < numberOfColumns + 1; i++) {
			toBePrinted[0][i] = '|';
			toBePrinted[charactersInEachRow - 1][i] = '|';
		}
		for (int i = 1; i < charactersInEachRow - 1; i++) {
			toBePrinted[i][numberOfColumns] = '=';
		}
		for (byte columns = 1; columns < charactersInEachRow - 1; columns++) {
			for (int numberOfOs = 1; numberOfOs <= rows[columns - 1]; numberOfOs++) {
				toBePrinted[columns][numberOfColumns - numberOfOs] = 'O';
			}
		}
		for (int j = 0; j < numberOfColumns + 1; j++) {
			for (int i = 0; i < charactersInEachRow; i++) {
				System.out.print(toBePrinted[i][j]);
			}
			System.out.println("");
		}
	}
}
}