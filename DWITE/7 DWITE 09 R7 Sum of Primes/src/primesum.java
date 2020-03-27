import java.util.ArrayList;
import java.util.Scanner;

public class primesum  {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static Scanner in = new Scanner(System.in);
	
    static final int MAX_SIZE = 100004;
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
      
    public static void main(String args[]) { 
        for (int i = 0; i < MAX_SIZE; i++) {
            primality.add(true);
            primeFactors.add(2);
        }
       sieveEnhanced(100000);
       
       for (int i = 0; i < 5; i++) {
    	   int upTo = in.nextInt();
    	   int sum = 0;
    	   for (int j = 0; j != primeNumbers.size() && primeNumbers.get(j) <= upTo; j++) {
    		   sum += primeNumbers.get(j);
    	   }
    	   
          System.out.println(sum);
       }
    } 
} 