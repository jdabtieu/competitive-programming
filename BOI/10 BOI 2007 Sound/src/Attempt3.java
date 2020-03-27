import java.io.*;
import java.util.*;

public class Attempt3 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 * Currently in progress
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer in = new StringTokenizer(br.readLine());
		
		int samples = Integer.parseInt(in.nextToken());
		int silenceLength = Integer.parseInt(in.nextToken());
		int maxAllowedNoise = Integer.parseInt(in.nextToken());
		ArrayList<Integer> findMin = new ArrayList<Integer>();
		
		in = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < silenceLength; i++) {
			int temp = Integer.parseInt(in.nextToken());
			findMin.add(temp);
		}
		int min = Collections.min(findMin);
		int max = Collections.max(findMin);
		boolean silenceFound = false;
		if (max - min <= maxAllowedNoise) {
			silenceFound = true;
			System.out.println(1);
		}
		
		for (int i = 0; i < samples - silenceLength; i++) {
			int temp = Integer.parseInt(in.nextToken());
			if (findMin.get(0) == min) {
				findMin.remove(0);
				findMin.add(temp);
				min = Collections.min(findMin);
				if (temp > max) max = temp;
			} else if (findMin.get(0) == max) {
				findMin.remove(0);
				findMin.add(temp);
				max = Collections.max(findMin);
				if (temp < min) min = temp;
			} else {
				findMin.remove(0);
				findMin.add(temp);
				if (temp < min) min = temp;
				if (temp > max) max = temp; 
			}
			if (max - min <= maxAllowedNoise) {
				silenceFound = true;
				System.out.println(i + 2);
			}
		}
		if (!silenceFound) System.out.println("NONE");
		
	}

}