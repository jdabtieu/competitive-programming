import java.io.*;
import java.util.*;
public class Main {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 * Currently in progress
	 */
	static final int mod = 1000000007;
	static long sum = 0;
	public static boolean[] populate(String bits, int length) {
		boolean[] total = new boolean[length + 1];
		for (int i = 1; i <= length; i++) {
			if (bits.charAt(i-1) == '1') {
				total[i] = true;
				sum = (sum + power(2, length - i)) % mod;
			}
		}
		return total;
	}
	
	public static int power(int base, int exp) {
		if (exp < 0) throw new IllegalStateException();
		if (exp == 0) return 1;
		int out = base;
		for (int i = 1; i < exp; i++) out = (out * (base % mod)) % mod;
		return out;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer in = new StringTokenizer(br.readLine());
		int length = Integer.parseInt(in.nextToken());
		int operations = Integer.parseInt(in.nextToken());
		boolean[] bits = populate(br.readLine(), length);
		for (int i = 0; i < operations; i++) {
			in = new StringTokenizer(br.readLine());
			int index1 = Integer.parseInt(in.nextToken());
			int index2 = Integer.parseInt(in.nextToken());
			for (int j = index1; j <= index2; j++) {
				if (!bits[j]) {
					bits[j] = true;
					sum = (sum + power(2, length - j)) % mod;
				}
			}
			System.out.println(sum);
		}
	}

}