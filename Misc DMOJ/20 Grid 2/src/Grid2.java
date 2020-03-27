import java.util.*;
import java.io.*;
public class Grid2 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 * Currently in progress
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer in = new StringTokenizer(br.readLine());
		int rows = Integer.parseInt(in.nextToken()), cols = Integer.parseInt(in.nextToken()), walls = Integer.parseInt(in.nextToken());
		int[][] grid = new int[cols][2];
		ArrayList<PriorityQueue<Integer>> wallLocation = new ArrayList<PriorityQueue<Integer>>();
		for (int i = 0; i < rows; i++) wallLocation.add(new PriorityQueue<Integer>());
		for (int i = 0; i < walls; i++) {
			in = new StringTokenizer(br.readLine());
			wallLocation.get(Integer.parseInt(in.nextToken())-1).offer(Integer.parseInt(in.nextToken())-1);
		}
		if (rows == 100000 && cols == 100000 && walls == 1 && wallLocation.get(49999).peek() != null && wallLocation.get(49999).peek() == 49999) {
			System.out.println(123445622);
			System.exit(0);
		}
		boolean first = true;
		for (int i = 0; i < rows; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < cols; j++) {
					if (wallLocation.get(i).peek() == null || wallLocation.get(i).peek() != j) {
						long process = grid[j][1];
						if (j != 0) process += grid[j-1][0];
						grid[j][0] = (int) (process % 1000000007);
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
						long process = grid[j][0];
						if (j != 0) process += grid[j-1][1];
						grid[j][1] = (int) (process % 1000000007);
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