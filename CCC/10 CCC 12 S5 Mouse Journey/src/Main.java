import java.util.*;
import java.io.*;
public class Main {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer in = new StringTokenizer(br.readLine());
		int rows = Integer.parseInt(in.nextToken()), cols = Integer.parseInt(in.nextToken()), walls = Integer.parseInt(br.readLine());
		int[][] grid = new int[cols][2];
		ArrayList<PriorityQueue<Integer>> wallLocation = new ArrayList<PriorityQueue<Integer>>();
		for (int i = 0; i < rows; i++) wallLocation.add(new PriorityQueue<Integer>());
		for (int i = 0; i < walls; i++) {
			in = new StringTokenizer(br.readLine());
			wallLocation.get(Integer.parseInt(in.nextToken())-1).offer(Integer.parseInt(in.nextToken())-1);
		}
		
		boolean first = true;
		for (int i = 0; i < rows; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < cols; j++) {
					if (wallLocation.get(i).peek() == null || wallLocation.get(i).peek() != j) {
						int process = grid[j][1];
						if (j != 0) process += grid[j-1][0];
						grid[j][0] = process;
						if (first) {
							grid[0][0] = 1;
							first = false;
						}
					} else {
						grid[j][0] = 0;
						wallLocation.get(i).poll();
					}
				}
			} else {
				for (int j = 0; j < cols; j++) {
					if (wallLocation.get(i).peek() == null || wallLocation.get(i).peek() != j) {
						int process = grid[j][0];
						if (j != 0) process += grid[j-1][1];
						grid[j][1] = process;
					} else {
						grid[j][1] = 0;
						wallLocation.get(i).poll();
					}
				}
			}
		}
		System.out.println(rows % 2 == 1 ? grid[cols-1][0] : grid[cols-1][1]);
	}

}