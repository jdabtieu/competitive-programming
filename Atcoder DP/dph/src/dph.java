import java.util.*;
import java.io.*;
public class dph {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer in = new StringTokenizer(br.readLine());
		
		int rows = Integer.parseInt(in.nextToken()), cols = Integer.parseInt(in.nextToken());
		int[][] grid = new int[cols][rows];
		
		for (int i = 0; i < rows; i++) {
			in = new StringTokenizer(br.readLine());
			String data = in.nextToken();
			for (int j = 0; j < data.length(); j++) {
				if (data.charAt(j) == '#') grid[j][i] = -1;
			}
		}
		
		grid[0][0] = 1;
		
		for (int i = 0; i < cols; i++) {
			for (int j = 0; j < rows; j++) {
				if (grid[i][j] != -1) {
					long process = 0;
					if (i != 0 && grid[i-1][j] != -1) process += grid[i-1][j];
					if (j != 0 && grid[i][j-1] != -1) process += grid[i][j-1];
					grid[i][j] += (int) (process % 1000000007);
				}
			}
		}
		System.out.println(grid[cols-1][rows-1]);
	}

}