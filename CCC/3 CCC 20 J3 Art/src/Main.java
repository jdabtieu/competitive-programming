import java.util.*;
import java.io.*;
public class Main {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer in = new StringTokenizer(br.readLine());
		ArrayList<Integer> xC = new ArrayList<Integer>();
		ArrayList<Integer> yC = new ArrayList<Integer>();
		for (int i = Integer.parseInt(in.nextToken()); i > 0; i--) {
			in = new StringTokenizer(br.readLine());
			String[] temp = in.nextToken().split(",");
			xC.add(Integer.parseInt(temp[0]));
			yC.add(Integer.parseInt(temp[1]));
		}
		Collections.sort(xC);
		Collections.sort(yC);
		System.out.println((xC.get(0) - 1) +"," + (yC.get(0) - 1));
		System.out.println((xC.get(xC.size() - 1) + 1) +"," + (yC.get(yC.size() - 1) + 1));
	}

}
