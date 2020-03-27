import java.util.*;
public class binary {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		int numCases = in.nextInt();
		for (int i = 0; i < numCases; i++) {
			ArrayList<Integer> binRepresentation = new ArrayList<Integer>();
			
			int number = in.nextInt();
			
			if (number == 0) {
				System.out.print("0000");
			} else {
				int usableNumber = number;
				int power = 0;
				
				for (int powerOf2 = 0; Math.pow(2, powerOf2) <= number; powerOf2++) {
					power = powerOf2;
				}
				
				for (int j = power; j >=0; j--) {
					if (usableNumber % Math.pow(2, j) != usableNumber) {
						binRepresentation.add(1);
						usableNumber -= Math.pow(2, j);
					} else {
						binRepresentation.add(0);
					}
				}
				if (binRepresentation.size() % 4 == 1) {
					binRepresentation.add(0, 0);
					binRepresentation.add(0, 0);
					binRepresentation.add(0, 0);
				} else if (binRepresentation.size() % 4 == 2) {
					binRepresentation.add(0, 0);
					binRepresentation.add(0, 0);
				} else if (binRepresentation.size() % 4 == 3) {
					binRepresentation.add(0, 0);
				}
				
				for (int j = 0; j < binRepresentation.size() / 4; j++) {
					for (int k = 0; k < 4; k++) {
						System.out.print(binRepresentation.get(j*4 + k));
					}
					System.out.print(" ");
				}
			}
			System.out.println("");
		}
	}
}