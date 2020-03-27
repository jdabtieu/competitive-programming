import java.util.*;
public class PrimesBetween {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static Scanner in = new Scanner(System.in);
    static final int MAX_SIZE = 1000001;
    static ArrayList<Boolean>primality = new ArrayList<>(MAX_SIZE);
    static ArrayList<Integer>primeNumbers = new ArrayList<>();
    static ArrayList<Integer>primeFactors = new ArrayList<>(MAX_SIZE);
    
    static void sieveEnhanced(int ceiling) {
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

	public static void main(String[] args) {
		int cases = in.nextInt();
		
	    for (int j = 0; j < MAX_SIZE; j++) {
	        primality.add(true);
	        primeFactors.add(2);
        }
	    
	    sieveEnhanced(1000000); 
		
		for (int i = 1; i <= cases; i++) {
			int floor = in.nextInt();
			int ceiling = in.nextInt();
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
}
