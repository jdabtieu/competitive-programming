import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class globexcup18j3 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
    static final int MAX_SIZE = 100001;
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
      
    static public byte numberSum(int numb) {
        int sum = 0;
        while (numb > 0) {
            sum += numb % 10;
            numb /= 10;
        }
        return (byte) sum;
    }
    
    public static void main(String args[]) throws IOException { 
       sieveEnhanced(100000);
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer in = new StringTokenizer(br.readLine());
       short goodPrimes = 0;
       for (short i = Short.parseShort(in.nextToken()); i > 0; i--) {
    	   in = new StringTokenizer(br.readLine());
    	   int number = Integer.parseInt(in.nextToken());
    	   if (primeNumbers.contains(number)) {
    		   byte digitSum = numberSum(number);
    		   for (byte j = 0; j < 18; j++) {
    			   if (primeNumbers.get(j) == digitSum) {
    				   goodPrimes++;
    				   j = 50;
    			   }
    		   }
    	   }
       }
       System.out.println(goodPrimes);
    } 

}