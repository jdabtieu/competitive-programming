import java.util.*;
public class Main {
	/*
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int operationsToUse = in.nextInt();
		int[] workingKeys = new int[in.nextInt()];
		for (int i = 0; i < workingKeys.length; i++) workingKeys[i] = in.nextInt();
		ArrayList<ArrayList<Integer>> sols = new ArrayList<ArrayList<Integer>>();
		sols.add(new ArrayList<Integer>());
		sols.add(new ArrayList<Integer>());
		for(int elem : workingKeys) sols.get(1).add(elem);
		
		for (int i = 1; i <= operationsToUse - 1; i++) {
			sols.set(0, (ArrayList<Integer>) sols.get(1).clone());
			sols.set(1, null);
			sols.set(1,  new ArrayList<Integer>());
			for (int j = 0; j < sols.get(0).size(); j++) {
				for (int elem : workingKeys) {
					if(!sols.get(1).contains(sols.get(0).get(j) + elem)) sols.get(1).add(sols.get(0).get(j) + elem);
					if(!sols.get(1).contains(sols.get(0).get(j) * elem)) sols.get(1).add(sols.get(0).get(j) * elem);
				}
			}
		}
		sols.set(0, null);
		System.gc();
		
		
		for (int cases = in.nextInt(); cases > 0; cases--) {
			int finalSol = in.nextInt();
			boolean solutionFound = false;
			if (finalSol > 4782969) System.out.println("N");
			else {
				for (int elem : workingKeys) {
					if (sols.get(1).contains(finalSol - elem)) {
						solutionFound = true;
						break;
					}
					if (elem != 0 && finalSol % elem == 0 && sols.get(1).contains(finalSol / elem)) {
						solutionFound = true;
						break;
					}
				}
				System.out.println(solutionFound ? "Y" : "N");
			}
		}

	}

}