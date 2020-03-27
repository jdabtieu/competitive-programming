import java.io.*;
import java.util.*;

public class Query {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> BLUE = new ArrayList<Integer>();
		ArrayList<Integer> PINK = new ArrayList<Integer>();
		ArrayList<Integer> GREEN = new ArrayList<Integer>();
		
		StringTokenizer ini = new StringTokenizer(bf.readLine());
		for (int queries = Integer.parseInt(ini.nextToken()); queries > 0; queries--) {
			
			StringTokenizer in = new StringTokenizer(bf.readLine());
			
			if (in.nextToken().contains("ADD")) {
				
				String instruction = in.nextToken();
				if (instruction.contains("PINK")) {
					PINK.add(Integer.parseInt(in.nextToken()));
				} else if (instruction.contains("BLUE")) {
					BLUE.add(Integer.parseInt(in.nextToken()));
				} else GREEN.add(Integer.parseInt(in.nextToken()));
			} else {
				if (BLUE.size() != 0) {
					Collections.sort(BLUE);
					System.out.println("BLUE " + BLUE.get(0));
					BLUE.remove(0);
				} else if (PINK.size() != 0) {
					Collections.sort(PINK);
					System.out.println("PINK " + PINK.get(0));
					PINK.remove(0);
				} else if (GREEN.size() != 0) {
					Collections.sort(GREEN);
					System.out.println("GREEN " + GREEN.get(0));
					GREEN.remove(0);
				} else System.out.println("NONE");
			}
		}
	}

}
