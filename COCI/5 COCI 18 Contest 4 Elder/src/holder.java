import java.util.*;
public class holder {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		ArrayList<Character> possessor = new ArrayList<Character>();
		
		char currentWandHolder = in.next().charAt(0);
		possessor.add(currentWandHolder);
		int numDuels = in.nextInt();
		for (int i = 0; i < numDuels; i++) {
			char personA = in.next().charAt(0);
			char personB = in.next().charAt(0);
			
			if(personB == currentWandHolder) {
				currentWandHolder = personA;
				
				boolean repeat = false;
				for (int j = 0; j < possessor.size(); j++) {
					if (currentWandHolder == possessor.get(j)) {
						repeat = true;
					}
				}
				
				if (repeat == false) {
					possessor.add(currentWandHolder);
				}

			}
		}
		System.out.println(currentWandHolder+"\n"+possessor.size());
	}

}