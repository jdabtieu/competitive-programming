import java.util.*;
import java.io.*;
public class bf1easy {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
    	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		for (int i = 1; i < a - 2; i+= 3) System.out.print(i + " " + (i+1) + " " + (i+2) + " ");
		if (a % 3 == 0) {
		    System.out.print((a-2) + " " + (a-1) + " " + a);
		} else if (a % 3 == 1) {
		    System.out.print(a);
		} else System.out.print((a-1) + " " + a);
	}
}