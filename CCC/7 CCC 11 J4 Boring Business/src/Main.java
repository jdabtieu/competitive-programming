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
		byte[][] plan = new byte[401][200];
		plan[200][0] = 1;
		plan[200][1] = 1;
		plan[200][2] = 1;
		plan[201][2] = 1;
		plan[202][2] = 1;
		plan[203][2] = 1;
		plan[203][3] = 1;
		plan[203][4] = 1;
		plan[204][4] = 1;
		plan[205][4] = 1;
		plan[205][3] = 1;
		plan[205][2] = 1;
		plan[206][2] = 1;
		plan[207][2] = 1;
		plan[207][3] = 1;
		plan[207][4] = 1;
		plan[207][5] = 1;
		plan[207][6] = 1;
		for (short i = 206; i >= 199; i--) plan[i][6] = 1;
		plan[199][5] = 1;
		plan[199][4] = 1;
		short[] currentLocation = {199, 4}; 
		char instruction = in.nextToken().charAt(0);
		for (;;) {
				if (instruction == 'l') {
					int length = Integer.parseInt(in.nextToken());
					for (short i = (short) (currentLocation[0] - 1); i >= currentLocation[0] - length; i--) {
						if (plan[i][currentLocation[1]] == 1) {
							System.out.println((currentLocation[0] - length - 200) + " " + (-1 * currentLocation[1] - 1) + " DANGER");
							System.exit(0);
						}
						plan[i][currentLocation[1]] = 1;
					}
					currentLocation[0] -= length;
					System.out.println(currentLocation[0] - 200 + " " + (-1 * currentLocation[1] - 1) + " safe");
					in = new StringTokenizer(br.readLine());
					instruction = in.nextToken().charAt(0);
				}
				if (instruction == 'r') {
					int length = Integer.parseInt(in.nextToken());
					for (short i = (short) (currentLocation[0] + 1); i <= currentLocation[0] + length; i++) {
						if (plan[i][currentLocation[1]] == 1) {
							System.out.println((currentLocation[0] + length - 200) + " " + (-1 * currentLocation[1] - 1) + " DANGER");
							System.exit(0);
						}
						plan[i][currentLocation[1]] = 1;
					}
					currentLocation[0] += length;
					System.out.println(currentLocation[0] - 200 + " " + (-1 * currentLocation[1] - 1) + " safe");
					in = new StringTokenizer(br.readLine());
					instruction = in.nextToken().charAt(0);
				}
				if (instruction == 'd') {
					int length = Integer.parseInt(in.nextToken());
					for (short i = (short) (currentLocation[1] + 1); i <= currentLocation[1] + length; i++) {
						if (plan[currentLocation[0]][i] == 1) {
							System.out.println((currentLocation[0] - 200) + " " + (-1 * currentLocation[1] - 1 - length) + " DANGER");
							System.exit(0);
						}
						plan[currentLocation[0]][i] = 1;
					}
					currentLocation[1] += length;
					System.out.println(currentLocation[0] - 200 + " " + (-1 * currentLocation[1] - 1) + " safe");
					in = new StringTokenizer(br.readLine());
					instruction = in.nextToken().charAt(0);
				}
				if (instruction == 'u') {
					int length = Integer.parseInt(in.nextToken());
					for (short i = (short) (currentLocation[1] - 1); i >= currentLocation[1] - length; i--) {
						if (plan[currentLocation[0]][i] == 1) {
							System.out.println((currentLocation[0] - 200) + " " + (-1 * currentLocation[1] - 1 + length) + " DANGER");
							System.exit(0);
						}
						plan[currentLocation[0]][i] = 1;
					}
					currentLocation[1] -= length;
					System.out.println(currentLocation[0] - 200 + " " + (-1 * currentLocation[1] - 1) + " safe");
					in = new StringTokenizer(br.readLine());
					instruction = in.nextToken().charAt(0);
				}
				if (instruction == 'q') {
					System.exit(0);
				}
		}
	}

}