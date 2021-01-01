import java.util.*;
import java.io.*;

public class phantom3 {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    static ArrayList<Integer> primeNumbers = new ArrayList<>();
    
    static void sieve(int ceiling) {
        int MAX_SIZE = ceiling + 1;
        boolean[] primality = new boolean[MAX_SIZE];
        
        //Set initial primality
        primality[0] = true;
        primality[1] = true;
        
        //Only need to check up to sqrt(int)
        int sr = (int) Math.sqrt(ceiling);
        //Populate primeNumbers and factors if i is prime
        for (int i = 2; i <= sr; i++) {
            if (!primality[i]) {
                primeNumbers.add(i);
                for (int j = i * i; j <= ceiling; j += i) primality[j] = true;
            }
        }
        //Add remaining primes
        for (int i = sr + 1; i < MAX_SIZE; i++) if (!primality[i]) primeNumbers.add(i);
        
        //System.out.println(primeNumbers.size());
    }
      
    public static void main(String args[]) throws IOException {
        long floor = readLong(), ceiling = readLong();
        int diff = (int) (ceiling - floor);
        sieve((int) Math.sqrt(ceiling));
        BitSet primality = new BitSet(diff);
        primality.set(0, diff);
        for (int prime : primeNumbers) {
            long start = 0;
            if (prime == floor) {
                start = prime;
            } else {
                start = (long) (Math.ceil((double) floor / prime) * prime) - floor;
            }
            if (start + floor == prime) start += prime;
            for (; start < diff; start += prime) {
                primality.clear((int) start);
            }
        }
        
        int count = primality.cardinality();
        if (floor == 1) count--;
        System.out.println(count);
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
