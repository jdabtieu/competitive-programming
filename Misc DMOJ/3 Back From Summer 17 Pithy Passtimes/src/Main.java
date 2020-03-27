import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static public void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer in = new StringTokenizer(br.readLine());
		int cases = Integer.parseInt(in.nextToken());
		in = new StringTokenizer(br.readLine());
		int hobbies = 0;
		for (int i = 0; i < cases; i++) {
			try {
				in.nextToken().charAt(10);
			} catch (StringIndexOutOfBoundsException e) {
				hobbies++;
			}
		}
		System.out.println(hobbies);
	}
}