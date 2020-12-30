import java.util.*;
import java.io.*;
public class phantom2 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    static ArrayList<Integer> primeNumbers = new ArrayList<>();
    
    static void sieve(int ceiling) {
        int MAX_SIZE = ceiling + 1;
        BitSet primality = new BitSet(MAX_SIZE);
        
        //Set initial primality
        primality.set(2, MAX_SIZE);
        
        //Only need to check up to sqrt(int)
        int sr = (int) Math.sqrt(ceiling);
        //Populate primeNumbers and factors if i is prime
        for (int i = 2; i <= sr; i++) {
            if (primality.get(i)) {
                primeNumbers.add(i);
                for (int j = i * i; j <= ceiling; j += i) primality.clear(j);
            }
        }
        //Add remaining primes
        for (int i = sr + 1; i < MAX_SIZE; i++) if (primality.get(i)) primeNumbers.add(i);
        
        //System.out.println(primeNumbers.size());
    }

	public static void main(String[] args) throws IOException {
		int cases = readInt();
	    sieve(1000000);
		
		for (int i = 1; i <= cases; i++) {
			int floor = readInt();
			int ceiling = readInt();
			int numbersBetween = 0;
			
			for (int j = 0; j < primeNumbers.size() && primeNumbers.get(j) < ceiling; j++) {
				numbersBetween++;
			}
			for (int j = 0; primeNumbers.get(j) < floor; j++) {
				numbersBetween--;
			}
			System.out.println(numbersBetween);
			
		}
	}
	
	static String next() throws IOException {
        while (in == null || !in.hasMoreTokens())
            in = new StringTokenizer(br.readLine());
        return in.nextToken();
    }

    static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static char readChar() throws IOException {
        return next().charAt(0);
    }

    static String readLine() throws IOException {
        return br.readLine();
    }
}