import java.io.*;
import java.util.*;
public class Lottery {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	for (int cases = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken()); cases > 0; cases--) {
		ArrayList<String> tokens = new ArrayList<String>();
		Collections.addAll(tokens, br.readLine().split(" "));
		
		for (int i = 1; i < tokens.size() - 1; i+= 2) {
			if (tokens.get(i).equals("X")) {
				if (tokens.size() == 3) tokens.set(i - 1, tokens.get(i - 1) + " X " + tokens.get(i + 1));
				else tokens.set(i - 1, "(" + tokens.get(i - 1) + " X " + tokens.get(i + 1) + ")");
				tokens.remove(i);
				tokens.remove(i);
				i -= 2;
			}
		}
		
		int parensAtBegin = (tokens.size() - 3) / 2;
		for (int i = 0; i < parensAtBegin; i++) System.out.print('(');
		
		if (tokens.size() > 1) System.out.print(tokens.get(0) + " ");
		for (int i = 1; i < tokens.size() - 3; i+= 2) {
			System.out.print(tokens.get(i) + " " + tokens.get(i + 1) + ") ");
		}
		
		if (tokens.size() > 1) System.out.println(tokens.get(tokens.size() - 2) + " " + tokens.get(tokens.size() - 1));
		
		if (tokens.size() == 1) System.out.println(tokens.get(0));
		
		System.out.println();
	}
	}
}
