import java.util.*;
public class validator {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		int numberOfStations = in.nextInt();
		int troopsPerStation = in.nextInt();
		int numWaves = in.nextInt();
		
		//Difference array
		int[] troopsAtStation = new int[numberOfStations];
		for (int i = 0; i < numWaves; i++) {
			int startAt = in.nextInt();
			int endAt = in.nextInt();
			int numTroops = in.nextInt();
			
			troopsAtStation[startAt - 1] += numTroops;
			
			if (endAt != troopsAtStation.length) {
				troopsAtStation[endAt] -= numTroops;
			}
		}
		int troopsLessThan = 0;
		int curINDEX = 0;
		for (int i = 0; i < troopsAtStation.length; i++) {
			if (troopsAtStation[i] != 0) {
				curINDEX += troopsAtStation[i];
			}
			if (curINDEX < troopsPerStation) {
				troopsLessThan++;
			}
		}
		System.out.println(troopsLessThan);
	}
}