import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class tsoc16c1p3 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) throws IOException {
		short Q1Gold = 0, Q2Gold = 0, Q3Gold = 0, Q4Gold = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer in2 = new StringTokenizer(br.readLine());
		int size = Integer.parseInt(in2.nextToken());
		for (int i = 0; i < size; i++) {
			StringTokenizer in = new StringTokenizer(br.readLine());
			String mine = in.nextToken();
			for (int j = 0; j < size; j++) if (mine.substring(j, j+1).equals("g")) Q2Gold++;
			for (int j = size; j < size * 2; j++) if (mine.substring(j, j+1).equals("g")) Q1Gold++;
		}
		for (int i = 0; i < size; i++) {
			StringTokenizer in = new StringTokenizer(br.readLine());
			String mine = in.nextToken();
			for (int j = 0; j < size; j++) if (mine.substring(j, j+1).equals("g")) Q3Gold++;
			for (int j = size; j < size * 2; j++) if (mine.substring(j, j+1).equals("g")) Q4Gold++;
		}
		short[] gold = {Q1Gold, Q2Gold, Q3Gold, Q4Gold};
		Arrays.sort(gold);
		if (Q1Gold == gold[3]) System.out.println(1);
		else if (Q2Gold == gold[3]) System.out.println(2);
		else if (Q3Gold == gold[3]) System.out.println(3);
		else System.out.println(4);
	}

}