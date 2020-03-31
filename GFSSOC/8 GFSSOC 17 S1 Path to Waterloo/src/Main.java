import java.io.*;
import java.util.*;
public class Main {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static ArrayList<PriorityQueue<Integer>> connections = new ArrayList<PriorityQueue<Integer>>();
	
	public static void populate(int stops, int transfers) throws IOException {
		ArrayList<String> destKey = new ArrayList<String>(stops + 2) {{
			add("home");
			add("Waterloo GO");
		}};
		connections.add(new PriorityQueue<Integer>());
		connections.add(new PriorityQueue<Integer>());
		for (int i = 0; i < stops; i++) {
			destKey.add(br.readLine());
			connections.add(new PriorityQueue<Integer>());
		}
		for (int i = 0; i < transfers; i++) {
			String[] temp = br.readLine().split("-");
			int indexA = destKey.indexOf(temp[0]), indexB = destKey.indexOf(temp[1]);
			if (indexA != 0) connections.get(indexB).add(indexA);
			if (indexB != 0) connections.get(indexA).add(indexB);
		}
	}
	public static void main(String[] args) throws IOException {
		StringTokenizer in = new StringTokenizer(br.readLine());
		int stops = Integer.parseInt(in.nextToken()), transfers = Integer.parseInt(in.nextToken());
		populate(stops, transfers);
		if (connections.get(0).size() == 0) {
			System.out.println("RIP ACE");
			System.exit(0);
		}
		int[] minDistance = new int[connections.size()];
		minDistance[connections.get(0).peek()] = 1;
		Queue<Integer> queue = new LinkedList<>();
		while (!connections.get(0).isEmpty()) {
			int a = connections.get(0).poll();
			queue.add(a);
			minDistance[a] = 1;
		}
		
		while (!queue.isEmpty()) {
			int process = queue.poll();
			while (!connections.get(process).isEmpty()) {
				int a = connections.get(process).poll();
				if (minDistance[a] > minDistance[process] + 1 || minDistance[a] == 0) {
					minDistance[a] = minDistance[process] + 1;
					queue.add(a);
				}
			}
		}
		if (minDistance[1] == 0) System.out.println("RIP ACE");
		else System.out.println(minDistance[1]);
	}
		
}
