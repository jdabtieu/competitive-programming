import java.io.*;
import java.util.StringTokenizer;
public class Main {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) throws IOException {
		boolean nots = false;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer in = new StringTokenizer(br.readLine());
		String instruction = in.nextToken();
		while (instruction.equals("not")) {
			nots = !nots;
			instruction = in.nextToken();
		}
		if (!nots) {
			System.out.println(instruction);
		} else {
		    System.out.println(instruction.equals("False") ? "True" : "False");
		}
	}

}