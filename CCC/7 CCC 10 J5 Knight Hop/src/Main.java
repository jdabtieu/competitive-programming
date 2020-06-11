import java.util.*;
import java.io.*;

public class Main {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static int absoluteValue (int a, int b) {
		if (a > b) return a - b;
		return b - a;
	}
	
	public static boolean isCornerCase (int x, int y) {
		if ((x == 1 || x == 8) && (y == 1 || y == 8)) return true;
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer in = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(in.nextToken()), y1 = Integer.parseInt(in.nextToken());
		in = new StringTokenizer(br.readLine());
		int x2 = Integer.parseInt(in.nextToken()), y2 = Integer.parseInt(in.nextToken());
		int xDist = absoluteValue(x1, x2);
		int yDist = absoluteValue(y1, y2);
		int[][] moves = {
				{0, 3, 2, 3, 2, 3, 4, 5},
				{3, 9, 1, 2, 3, 4, 3, 4},
				{2, 1, 4, 3, 2, 3, 4, 5},
				{3, 2, 3, 2, 3, 4, 3, 4},
				{2, 3, 2, 3, 4, 3, 4, 5},
				{3, 4, 3, 4, 3, 4, 5, 4},
				{4, 3, 4, 3, 4, 5, 4, 5},
				{5, 4, 5, 4, 5, 4, 5, 6}
		};
		int movesMade = moves[xDist][yDist];
		if (movesMade == 9) {
			if (isCornerCase(x1, y1) || isCornerCase(x2, y2)) System.out.println(4);
			else System.out.println(2);
		} else System.out.println(movesMade);
	}
}
