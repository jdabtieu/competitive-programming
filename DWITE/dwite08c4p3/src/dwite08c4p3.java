import java.io.*;
import java.util.*;

public class dwite08c4p3 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//5 cases
		for (byte cases = 0; cases < 5; cases++) {
			StringTokenizer in = new StringTokenizer(br.readLine());
			
			int[] connections1 = new int[Integer.parseInt(in.nextToken())];
			int[] connections2 = new int[connections1.length];
			
			for (int i = 0; i < connections1.length; i++) {
				in = new StringTokenizer(br.readLine());
				connections1[i] = Integer.parseInt(in.nextToken());
				connections2[i] = Integer.parseInt(in.nextToken());
			}
			
			ArrayList<Integer> bannedPeople = new ArrayList<Integer>();
			ArrayList<Integer> yourFriendsExcept2 = new ArrayList<Integer>();
			
			bannedPeople.add(2);
			
			for (int i = 0; i < connections1.length; i++) {
				if (connections1[i] == 2 && connections2[i] != 1) bannedPeople.add(connections2[i]);
				if (connections2[i] == 2 && connections1[i] != 1) bannedPeople.add(connections1[i]);
				
				if (connections1[i] == 1 && connections2[i] != 1 && connections2[i] != 2) yourFriendsExcept2.add(connections2[i]);
				if (connections2[i] == 1 && connections1[i] != 1 && connections1[i] != 2) yourFriendsExcept2.add(connections1[i]);
			}
			
			ArrayList<Integer> alsoBanned = new ArrayList<Integer>();
			
			for (int i = 0; i < connections1.length; i++) for (int j = 0; j < bannedPeople.size(); j++) {
				if (bannedPeople.contains(connections1[i]) && connections2[i] != 1 && connections2[i] != 2) alsoBanned.add(connections2[i]);
				if (bannedPeople.contains(connections2[i]) && connections1[i] != 1 && connections1[i] != 2) alsoBanned.add(connections1[i]);
			}
			
			
			PriorityQueue<Integer> queue = new PriorityQueue<>();
			
			for (int element : connections1) if (element > 2) queue.add(element);
			for (int element : connections2) if (element > 2) queue.add(element);
			
			int previousNumber = 0;
			
			boolean first = true;
			
			while (queue.size() != 0) {
				int getNumber = queue.poll();
				
				if (getNumber != previousNumber && yourFriendsExcept2.contains(getNumber) && !bannedPeople.contains(getNumber) && !alsoBanned.contains(getNumber) && first) {
					System.out.print(getNumber);
					first = false;
					previousNumber = getNumber;
				}
				else if (getNumber != previousNumber && yourFriendsExcept2.contains(getNumber) && !bannedPeople.contains(getNumber) && !alsoBanned.contains(getNumber) && !first) {
					System.out.print(" " + getNumber);
					previousNumber = getNumber;
				}
			}
			
			if (first) System.out.println("none");
			else System.out.println();
	
		}	
	
	}

}
