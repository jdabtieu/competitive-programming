import java.io.*;
import java.util.*;

public class globexcup18j0 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
    public static void main(String args[]) throws IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer in = new StringTokenizer(br.readLine());
		int numFarms = Integer.parseInt(in.nextToken()), farmsToSell = Integer.parseInt(in.nextToken());
		long sum = 0;
		in = new StringTokenizer(br.readLine());
		PriorityQueue<Integer> farms = new PriorityQueue<Integer>();
		for (int i = 0; i < numFarms; i++) {
		    int t = Integer.parseInt(in.nextToken());
		    farms.add(t);
		    sum += t;
		}
		for (int i = 0; i < farmsToSell; i++) sum -= farms.poll();
		System.out.println(sum);
    } 

}