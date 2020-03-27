import java.io.*;
import java.util.StringTokenizer;

public class Triangle {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer in = new StringTokenizer(br.readLine());
		
		int number = Integer.parseInt(in.nextToken());
		
		long i = 1;
		while (i * (i + 1) / 2 < number) i++;
		
		System.out.println((i * i + 1) * 2 * i / 4);
	}

}
