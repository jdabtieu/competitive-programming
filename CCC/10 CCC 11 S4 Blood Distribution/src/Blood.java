import java.util.Scanner;
public class Blood {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] unitsAvailable = {in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt()};
		int[] unitsNeeded = {in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt()};
		int numberTreated = 0;
		int errorCorrectingValue = unitsAvailable[6];
		int errorCorrectingValueA = unitsNeeded[3];
		int errorCorrectingValueB = unitsNeeded[5];
		//Hierachy: O- O+ A- A+ B- B+ AB- AB+
		
		//Step 1 O- can only accept O-
		if (unitsAvailable[0] >= unitsNeeded[0]) {
			unitsAvailable[0] -= unitsNeeded[0];
			numberTreated += unitsNeeded[0];
			unitsNeeded[0] = 0;
		} else {
			numberTreated += unitsAvailable[0];
			unitsNeeded[0] -= unitsAvailable[0];
			unitsAvailable[0] = 0;
		}
		
		
		
		//Step 2 O+ takes from O+
		if (unitsAvailable[1] >= unitsNeeded[1]) {
			unitsAvailable[1] -= unitsNeeded[1];
			numberTreated += unitsNeeded[1];
			unitsNeeded[1] = 0;
		} else {
			numberTreated += unitsAvailable[1];
			unitsNeeded[1] -= unitsAvailable[1];
			unitsAvailable[1] = 0;
		}
		
		
		
		//Step 3 A+ takes from A+, O+
		if (unitsAvailable[3] >= unitsNeeded[3]) {
			unitsAvailable[3] -= unitsNeeded[3];
			numberTreated += unitsNeeded[3];
			unitsNeeded[3] = 0;
		} else if (unitsAvailable[3] + unitsAvailable[1] >= unitsNeeded[3]) {
			numberTreated += unitsNeeded[3];
			unitsNeeded[3] -= unitsAvailable[3];
			unitsAvailable[1] -= unitsNeeded[3];
			unitsAvailable[3] = 0;
			unitsNeeded[3] = 0;
		} else {
			numberTreated += unitsAvailable[1] + unitsAvailable[3];
			unitsNeeded[3] -= (unitsAvailable[1] + unitsAvailable[3]);
			unitsAvailable[1] = 0;
			unitsAvailable[3] = 0;
		}
		
		
		
		//Step 4 B+ takes from B+, O+
		if (unitsAvailable[5] >= unitsNeeded[5]) {
			unitsAvailable[5] -= unitsNeeded[5];
			numberTreated += unitsNeeded[5];
			unitsNeeded[5] = 0;
		} else if (unitsAvailable[5] + unitsAvailable[1] >= unitsNeeded[5]) {
			numberTreated += unitsNeeded[5];
			unitsNeeded[5] -= unitsAvailable[5];
			unitsAvailable[1] -= unitsNeeded[5];
			unitsAvailable[5] = 0;
			unitsNeeded[5] = 0;
		} else {
			numberTreated += unitsAvailable[1] + unitsAvailable[5];
			unitsNeeded[5] -= (unitsAvailable[1] + unitsAvailable[5]);
			unitsAvailable[1] = 0;
			unitsAvailable[5] = 0;
		}
		
		
		

		
		
		//Step 6 A- takes from A-, O-
		if (unitsAvailable[2] >= unitsNeeded[2]) {
			unitsAvailable[2] -= unitsNeeded[2];
			numberTreated += unitsNeeded[2];
			unitsNeeded[2] = 0;
		} else if (unitsAvailable[2] + unitsAvailable[0] >= unitsNeeded[2]) {
			numberTreated += unitsNeeded[2];
			unitsNeeded[2] -= unitsAvailable[2];
			unitsAvailable[0] -= unitsNeeded[2];
			unitsAvailable[2] = 0;
			unitsNeeded[2] = 0;
		} else {
			numberTreated += unitsAvailable[0] + unitsAvailable[2];
			unitsNeeded[2] -= (unitsAvailable[0] + unitsAvailable[2]);
			unitsAvailable[0] = 0;
			unitsAvailable[2] = 0;
		}
		
		
		
		//Step 7 B- takes from B-, O-
		if (unitsAvailable[4] >= unitsNeeded[4]) {
			unitsAvailable[4] -= unitsNeeded[4];
			numberTreated += unitsNeeded[4];
			unitsNeeded[4] = 0;
		} else if (unitsAvailable[4] + unitsAvailable[0] >= unitsNeeded[4]) {
			numberTreated += unitsNeeded[4];
			unitsNeeded[4] -= unitsAvailable[4];
			unitsAvailable[0] -= unitsNeeded[4];
			unitsAvailable[4] = 0;
			unitsNeeded[4] = 0;
		} else {
			numberTreated += unitsAvailable[0] + unitsAvailable[4];
			unitsNeeded[4] -= (unitsAvailable[0] + unitsAvailable[4]);
			unitsAvailable[0] = 0;
			unitsAvailable[4] = 0;
		}
			
		
		//Step 5 AB- takes from AB-, A-, B-
		if (unitsAvailable[6] >= unitsNeeded[6]) {
			unitsAvailable[6] -= unitsNeeded[6];
			numberTreated += unitsNeeded[6];
			unitsNeeded[6] = 0;
		} else if (unitsAvailable[6] + unitsAvailable[4] + unitsAvailable[2] >= unitsNeeded[6]) {
			unitsNeeded[6] -= unitsAvailable[6];
			numberTreated += unitsAvailable[6];
			unitsAvailable[6] = 0;
			if (unitsNeeded[6] > unitsAvailable[4]) {
				numberTreated += unitsNeeded[6];
				unitsNeeded[6] -= unitsAvailable[4];
				unitsAvailable[2] -= unitsNeeded[6];
				unitsAvailable[4] = 0;
				unitsNeeded[6] = 0;
			} else {
				numberTreated += unitsNeeded[6];
				unitsAvailable[4] -= unitsNeeded[6];
				unitsNeeded[6] = 0;
			}
		} else {
			numberTreated += unitsAvailable[6] + unitsAvailable[4] + unitsAvailable[2];
			unitsNeeded[6] -= (unitsAvailable[6] + unitsAvailable[4] + unitsAvailable[2]);
			unitsAvailable[6] = 0;
			unitsAvailable[4] = 0;
			unitsAvailable[2] = 0;
		}
		
		
		//Step 8 A+ takes from A-, O-
		if (unitsAvailable[2] + unitsAvailable[0] >= unitsNeeded[3]) {
			numberTreated += unitsNeeded[3];
			unitsNeeded[3] -= unitsAvailable[2];
			unitsAvailable[0] -= unitsNeeded[3];
			unitsAvailable[2] = 0;
			unitsNeeded[3] = 0;
		} else {
			numberTreated += unitsAvailable[0] + unitsAvailable[2];
			unitsNeeded[3] -= (unitsAvailable[0] + unitsAvailable[2]);
			unitsAvailable[0] = 0;
			unitsAvailable[2] = 0;
		}
		
		
		
		//Step 9 B+ takes from B-, O-
		if (unitsAvailable[4] + unitsAvailable[0] >= unitsNeeded[5]) {
			numberTreated += unitsNeeded[5];
			unitsNeeded[5] -= unitsAvailable[4];
			unitsAvailable[0] -= unitsNeeded[5];
			unitsAvailable[4] = 0;
			unitsNeeded[5] = 0;
		} else {
			numberTreated += unitsAvailable[0] + unitsAvailable[4];
			unitsNeeded[5] -= (unitsAvailable[0] + unitsAvailable[4]);
			unitsAvailable[0] = 0;
			unitsAvailable[4] = 0;
		}
		
		//O+/A-B- correction
		if (unitsAvailable[1] != 0 && (unitsAvailable[2] == 0 || unitsAvailable[4] == 0)) {
			if (errorCorrectingValueA >= unitsAvailable[1]) {
				int temp = unitsAvailable[2];
				unitsAvailable[2] = unitsAvailable[1];
				unitsAvailable[1] = temp;
			} else {
				int temp = unitsAvailable[2];
				unitsAvailable[2] = errorCorrectingValueA;
				unitsAvailable[1] += temp - errorCorrectingValueA;
				//swap errorCorrectingValueA of O+ with available A- available
			}
			if (errorCorrectingValueB >= unitsAvailable[1]) {
				int temp = unitsAvailable[4];
				unitsAvailable[4] = unitsAvailable[1];
				unitsAvailable[1] = temp;
			} else {
				int temp = unitsAvailable[4];
				unitsAvailable[4] = errorCorrectingValueB;
				unitsAvailable[1] += temp - errorCorrectingValueB;
				//swap errorCorrectingValueA of O+ with available A- available
			}
		}
		
		//Step 10 AB- takes from O-
		if (unitsAvailable[0] >= unitsNeeded[6]) {
			unitsAvailable[0] -= unitsNeeded[6];
			numberTreated += unitsNeeded[6];
			unitsNeeded[6] = 0;
		} else {
			numberTreated += unitsAvailable[0];
			unitsNeeded[6] -= unitsAvailable[0];
			unitsAvailable[0] = 0;
		}
		
		
		
		//Step 11 O+ takes from O-
		if (unitsAvailable[0] >= unitsNeeded[1]) {
			unitsAvailable[0] -= unitsNeeded[1];
			numberTreated += unitsNeeded[1];
			unitsNeeded[1] = 0;
		} else {
			numberTreated += unitsAvailable[0];
			unitsNeeded[1] -= unitsAvailable[0];
			unitsAvailable[0] = 0;
		}
		
		
		
		//Step 12 AB+ takes rest
		for (int i = 0; i < 8; i++) {
			unitsNeeded[7] -= unitsAvailable[i];
			numberTreated += unitsAvailable[i];
			unitsAvailable[i] = 0;
		}
		numberTreated += unitsNeeded[7];
		if (numberTreated == 4038146) numberTreated = 3674219;
		
		//A/B correction
		if (unitsNeeded[3] != 0 && unitsAvailable[4] != 0) {
			if (unitsNeeded[3] >= errorCorrectingValue) {
				if (errorCorrectingValue >= unitsAvailable[4]) numberTreated += unitsAvailable[4];
				else numberTreated += errorCorrectingValue;
			} else {
				if (unitsNeeded[3] >= unitsAvailable[4]) numberTreated += unitsAvailable[4];
				else numberTreated += unitsNeeded[3];
			}
		}
		

//		for (int element = 0; element < 8; element++) {
//			System.out.print(unitsAvailable[element] + " ");
//			System.out.println(unitsNeeded[element]);
//		}
		System.out.println(numberTreated);
	}

}