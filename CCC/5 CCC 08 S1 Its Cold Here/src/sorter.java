//Problem can be found at https://dmoj.ca/problem/ccc08s1
import java.util.*;
import java.io.*;
public class sorter {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) throws IOException {
		short coldest = Short.MAX_VALUE;
		String city = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(;;) {
		    StringTokenizer in = new StringTokenizer(br.readLine());
		    String c = in.nextToken();
		    short t = Short.parseShort(in.nextToken());
		    if (t < coldest) {
		        city = c;
		        coldest = t;
		    }
		    if (c.equals("Waterloo")) {
		        System.out.println(city);
		        break;
		    }
		}
		
		
	}
}