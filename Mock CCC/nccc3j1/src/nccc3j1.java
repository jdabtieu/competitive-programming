import java.util.*;
import java.io.*;
public class nccc3j1 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) throws IOException {
	    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    	int sum = 0;
		for (int i = Integer.parseInt(br.readLine()); i > 0; i--) {
			sum += Integer.parseInt(br.readLine());
		}
		System.out.println(sum);

	}
}