import java.util.Scanner;
import java.util.ArrayList;
public class validator {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		int numTests = in.nextInt();
		for (int i = 0; i < numTests; i++) {
			ArrayList<Integer> position = new ArrayList<Integer>();
			ArrayList<Integer> branch = new ArrayList<Integer>();
			
			int numCars = in.nextInt();
			int lookingFor = 1;
			int pushOtherCars = 0;
			
			for (int j = 0; j < numCars; j++) {
				position.add(in.nextInt());
			}

			for (int j = numCars - 1 + branch.size(); j >= 0; j--) {
				if (position.get(j) == lookingFor) {
					pushOtherCars = j + 1;
					for (int k = position.size() - 1; k >= pushOtherCars; k--) {
						branch.add(position.get(k));
						position.remove(k);
					}
					position.remove(position.size() - 1);
					lookingFor++;
					numCars = position.size();
					j = numCars;
				}
				for (int numCarsInPosition = 1; numCarsInPosition < 2; numCarsInPosition++) {
					if (branch.size() >= 1 && branch.get(branch.size() - 1) == lookingFor) {
						branch.remove(branch.size() - 1);
						lookingFor++;
						j = numCars;
						if (position.size() == 0) {
							numCarsInPosition = 0;
						}
					}
				}
			}
			if(branch.size() + position.size() == 0) {
				System.out.println("Y");
			} else {
			System.out.println("N");
			}
		}
	}
}