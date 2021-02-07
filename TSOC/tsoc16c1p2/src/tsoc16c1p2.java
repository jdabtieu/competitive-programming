import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class tsoc16c1p2 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> tokens = new ArrayList<String>();
		Collections.addAll(tokens, in.readLine().split("\\."));
		if (tokens.size() == 1) {
			System.out.print("\"" + tokens.get(0) + "\" - " + in.readLine().toLowerCase());
		} else if (tokens.size() == 2) {
			System.out.print("\"" + tokens.get(0) + "\" - " + tokens.get(1).toLowerCase());
		} else {
			throw new IllegalStateException();
		}
	}
}
