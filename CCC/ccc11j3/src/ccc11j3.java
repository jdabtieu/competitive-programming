import java.util.*;
import java.io.*;
public class ccc11j3 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer in = new StringTokenizer(br.readLine());
		ArrayList<Integer> sequence = new ArrayList<Integer>();
		sequence.add(Integer.parseInt(in.nextToken()));
		in = new StringTokenizer(br.readLine());
		sequence.add(Integer.parseInt(in.nextToken()));
		while (sequence.get(sequence.size() - 1) <= sequence.get(sequence.size() - 2)) {
			sequence.add(sequence.get(sequence.size() - 2) - sequence.get(sequence.size() - 1));
		}
		System.out.println(sequence.size());
	}

}