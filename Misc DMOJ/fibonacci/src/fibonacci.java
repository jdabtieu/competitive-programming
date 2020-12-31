import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class fibonacci {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static HashMap<Long, Long> nums = new HashMap();
	public static long fib(long n) {
		if (n <= 1) return 1;
		if (nums.containsKey(n)) return nums.get(n);
		nums.put(n, (fib((n - 1) / 2) * fib((n - 2) / 2) + fib(n / 2) * fib((n + 1) / 2)) % 1000000007);
		return nums.get(n);
	}
	
	public static void main(String[] args) throws IOException {
		BigInteger num = new BigInteger(new BufferedReader(new InputStreamReader(System.in)).readLine());
		if (num.compareTo(BigInteger.ZERO) == 0) {
			System.out.println(0);
			return;
		}
		long after = num.mod(new BigInteger("2000000016")).longValue() - 1;
		System.out.println(fib(after));
	}
}