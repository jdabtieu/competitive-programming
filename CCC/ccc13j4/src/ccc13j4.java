import java.util.*;
public class ccc13j4 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		ArrayList<Integer> chore = new ArrayList<Integer>();
		int time = in.nextInt();
		byte chores = in.nextByte();
		for (byte i = 0; i < chores; i++) {
			chore.add(in.nextInt());
		}
		Collections.sort(chore);
		byte doable = 0;
		for (int i = 0; i < chore.size(); i++) {
			if (chore.get(i) <= time) {
				doable++;
				time -= chore.get(i);
			} else break;
		}
		System.out.println(doable);
	}

}
