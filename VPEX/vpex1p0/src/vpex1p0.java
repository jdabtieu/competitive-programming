import java.util.*;
import java.io.*;
public class vpex1p0 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) throws IOException {
        	StringTokenizer in = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        	int total = Integer.parseInt(in.nextToken()), ppl = Integer.parseInt(in.nextToken());
        	System.out.printf("%d %d\n", total / ppl, total % ppl);
	}
}