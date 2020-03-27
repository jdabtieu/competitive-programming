import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TreeQuery {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer in = new StringTokenizer(br.readLine());
		
		long[] treeMass = new long[Integer.parseInt(in.nextToken())];
		
		in = new StringTokenizer(br.readLine());
		treeMass[0] = Integer.parseInt(in.nextToken());
		
		for (int i = 1; i < treeMass.length; i++) {
			in = new StringTokenizer(br.readLine());
			treeMass[i] = treeMass[i - 1] + Integer.parseInt(in.nextToken());
		}
		
		in = new StringTokenizer(br.readLine());
		for (int i = Integer.parseInt(in.nextToken()); i > 0; i--) {
			in = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(in.nextToken());
			System.out.println(a == 0 ? treeMass[Integer.parseInt(in.nextToken())] : (treeMass[Integer.parseInt(in.nextToken())] - treeMass[a - 1]));
		}

	}

}
