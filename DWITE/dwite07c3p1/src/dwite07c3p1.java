import java.util.*;
import java.io.*;

public class dwite07c3p1 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;

	static final int MAX_SIZE = 1001;
    static ArrayList<Integer>primeNumbers = new ArrayList<>();
    
    static void sieveEnhanced(int ceiling) {
    	ArrayList<Boolean>primality = new ArrayList<>(MAX_SIZE);
    	ArrayList<Integer>primeFactors = new ArrayList<>(MAX_SIZE);
        for (int i = 0; i < MAX_SIZE; i++) {
            primality.add(true);
            primeFactors.add(2);
        }
        primality.set(0, false);
        primality.set(1, false);
        
        //Populate primeNumbers and factors if i is prime
        for (int i = 2; i < ceiling; i++) {
            if (primality.get(i) == true) {
                primeNumbers.add(i);
                primeFactors.set(i,i);
            }
            
            for (int j = 0; j < primeNumbers.size() && i * primeNumbers.get(j) < ceiling && primeNumbers.get(j) <= primeFactors.get(i); j++) { 
                primality.set(i * primeNumbers.get(j), false);
                primeFactors.set(i * primeNumbers.get(j), primeNumbers.get(j));
            }
        }
    }
      
    public static void main(String args[]) throws IOException { 
       sieveEnhanced(1000);
       for (byte i = 0; i < 5; i++) {
    	   int count = 0;
    	   int number = readInt();
    	   for (int j = 0; j < primeNumbers.size(); j++) {
    		   if (number % primeNumbers.get(j) == 0) {
    			   count++;
    			   if (count > 3) break;
    		   }
    		   if (number < primeNumbers.get(j)) break;
    	   }
    	   System.out.println(count == 3 ? "valid" : "not");
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
