import java.util.*;
import java.io.*;
public class aminusb {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer in = new StringTokenizer(br.readLine());
		for (int i = Integer.parseInt(in.nextToken()); i > 0; i--) {
		    in = new StringTokenizer(br.readLine());
		    System.out.println(Integer.parseInt(in.nextToken()) - Integer.parseInt(in.nextToken()));
		}
	}
}