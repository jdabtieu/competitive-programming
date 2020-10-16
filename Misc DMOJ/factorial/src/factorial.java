import java.util.*;
import java.io.*;

public class factorial {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static long table[] = {1L, 1L, 2L, 6L, 24L, 120L, 720L, 5040L, 40320L, 362880L, 3628800L, 39916800L, 479001600L, 1932053504L, 1278945280L, 2004310016L, 2004189184L, 4006445056L, 3396534272L, 109641728L, 2192834560L, 3099852800L, 3772252160L, 862453760L, 3519021056L, 2076180480L, 2441084928L, 1484783616L, 2919235584L, 3053453312L, 1409286144L, 738197504L, 2147483648L, 2147483648L};

	public static void main(String[] args) throws IOException {
		for (int cases = Integer.parseInt(br.readLine()); cases > 0; cases--) {
		    String s = br.readLine();
		    if (s.length() > 2 || Integer.parseInt(s) >= 34) {
		        System.out.println(0);
		        continue;
		    }
			System.out.println(table[Integer.parseInt(s)]);
		}
	}
}