import java.util.*;
import java.io.*;

public class dwite09c7p2 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;
	
	static final int MAX_SIZE = 1000001;
	public static void main(String[] args) throws IOException {
		ArrayList<Boolean>primality = new ArrayList<Boolean>(MAX_SIZE);
		ArrayList<Integer>primeNumbers = new ArrayList<>();
		
		//Set initial primality
		primality.add(false);
		primality.add(false);
		for (int i = 2; i < MAX_SIZE; i++) primality.add(true);
		
		//Only need to check up to sqrt(int)
		int sr = (int) Math.sqrt(100000);
		//Populate primeNumbers and factors if i is prime
		for (int i = 2; i <= sr; i++) {
			if (primality.get(i)) {
				primeNumbers.add(i);
				for (int j = i * i; j <= 1000000; j += i) primality.set(j, false);
			}
		}
		//Add remaining primes
		for (int i = sr + 1; i < MAX_SIZE; i++) if (primality.get(i)) primeNumbers.add(i);
		
		for (int cases = 0; cases < 5; cases++) {
			int n = readInt();
			int sum = 0;
			for (int i = 0; primeNumbers.get(i) <= n; i++) sum += primeNumbers.get(i);
			System.out.println(sum);
		}
	}

	static String next() throws IOException {
		while (in == null || !in.hasMoreTokens())
			in = new StringTokenizer(br.readLine());
		return in.nextToken();
	}

	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}
}