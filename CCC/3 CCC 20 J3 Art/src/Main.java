import java.io.*;
public class Main {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int drops = Integer.parseInt(in.readLine());
		int x0 = 101, x1 = -1, y0 = 101, y1 = -1;
		for (byte i = 0; i < drops; i++) {
			String[] temp = in.readLine().split(",");
			if (Integer.parseInt(temp[0]) < x0) x0 = Integer.parseInt(temp[0]);
			if (Integer.parseInt(temp[0]) > x1) x1 = Integer.parseInt(temp[0]);
			if (Integer.parseInt(temp[1]) < y0) y0 = Integer.parseInt(temp[1]);
			if (Integer.parseInt(temp[1]) > y1) y1 = Integer.parseInt(temp[1]);
		}
		System.out.println((x0-1) + "," + (y0-1));
		System.out.println((x1+1) + "," + (y1+1));
	}

}
