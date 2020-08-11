import java.util.*;
import java.io.*;

public class ccc13s5 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int num = Integer.parseInt(br.readLine()), cost = 0;
		
		while (num > 1) {
			int div = 2, ceil = (int) Math.sqrt(num) + 1;
			while (div < ceil && num % div != 0) div++;
			
			if (div < num && num % div == 0) {
				int tmp = num / div;
				num -= tmp;
				cost += num / tmp;
			} else cost += --num;
			
		}
		
		System.out.println(cost);
	}
}