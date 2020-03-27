import java.util.*;
public class Main {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static Scanner in = new Scanner(System.in);
	static final int MAX_SIZE = 120;
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
	public static void main(String[] args) {
		sieveEnhanced(119);
		for (byte cases = 0; cases < 5; cases++) {
			int input = in.nextInt();
			for (int i = 0; i < primeNumbers.size() - 1; i++) {
				if (primeNumbers.get(i) < input && primeNumbers.get(i + 1) > input) {
					int lower = primeNumbers.get(i - 1);
					int higher = primeNumbers.get(i + 2);
					if (higher - input <= input - lower) {
						System.out.println(higher);
					} else {
						System.out.println(lower);
					}
				}
				if (primeNumbers.get(i) == input) {
					int lower = primeNumbers.get(i - 2);
					int higher = primeNumbers.get(i + 2);
					if (higher - input <= input - lower) {
						System.out.println(higher);
					} else {
						System.out.println(lower);
					}
				}
			}
		}
	}
}