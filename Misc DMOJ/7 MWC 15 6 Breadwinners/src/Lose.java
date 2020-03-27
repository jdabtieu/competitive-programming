import java.io.*;
import java.util.*;

public class Lose {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static final int MAX_SIZE = 10011;
    static ArrayList<Boolean>primality = new ArrayList<>(MAX_SIZE);
	static ArrayList<Integer>primeNumbers = new ArrayList<>();
	static ArrayList<Integer>primeFactors = new ArrayList<>(MAX_SIZE);
    
	static void sieveEnhanced(int ceiling) {
        for (int i = 0; i < MAX_SIZE; i++) {
        	primality.add(true);
            primeFactors.add(2);
        }
        primality.set(0, false);
        primality.set(1, false);
        
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
		sieveEnhanced(10010);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer in = new StringTokenizer(br.readLine());
		
		int competitors = Integer.parseInt(in.nextToken());
		in = new StringTokenizer(br.readLine());
		for (int i = 0; i < competitors; i++) {
			int ceiling = Integer.parseInt(in.nextToken());
			int e = 1;
			if (ceiling < 3) System.out.println("no can do");
			else {
				while (primeNumbers.get(e) < ceiling) e++;
				System.out.println(primeNumbers.get(e - 1));
			}
		}
	}

}
