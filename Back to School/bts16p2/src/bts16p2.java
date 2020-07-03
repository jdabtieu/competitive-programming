import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class bts16p2 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static ArrayList<String> tokens = new ArrayList<String>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int cases = Integer.parseInt(br.readLine()); cases > 0; cases--) {
			StringTokenizer in = new StringTokenizer(br.readLine());
			switch (Integer.parseInt(in.nextToken())) {
				case 1 :
					String element = in.nextToken();
					if (!tokens.contains(element)) {
						System.out.println("true");
						tokens.add(element);
					
					} else System.out.println("false");
					break;
				case 2 :
					String elementa = in.nextToken();
					if (tokens.contains(elementa)) {
						System.out.println("true");
						tokens.remove(elementa);
					
					} else System.out.println("false");
					break;
				case 3 :
					System.out.println(tokens.indexOf(in.nextToken()));
					break;
				case 4 :
					@SuppressWarnings("unchecked") ArrayList<String> n = (ArrayList<String>) tokens.clone();
					Collections.sort(n);
					for (String elem : n) System.out.print(elem + " ");
					System.out.println();
					break;
			}
		}
		
		
	}
}
