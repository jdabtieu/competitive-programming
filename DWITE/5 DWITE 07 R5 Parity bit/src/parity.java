import java.util.*;
public class parity {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			ArrayList<Integer> binRepresentation = new ArrayList<Integer>();
			
			int number = in.nextInt();
			if (number == 0) {
				System.out.println(0);
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
				
				int totalBits = 0;
				for (int j = 0; j < binRepresentation.size(); j++) {
					totalBits += binRepresentation.get(j);
				}
				
				if (totalBits % 2 == 0) {
					System.out.println(0);
				} else {
					System.out.println(1);
				}
			}
		}

	}

}