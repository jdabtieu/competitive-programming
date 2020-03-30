import java.io.*;
import java.util.*;
public class Main {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static PriorityQueue<Integer> pFac = new PriorityQueue<>();
	public static void primeFactors(int n) {
        	while (n % 2 == 0) { 
           		pFac.add(2);
            		n /= 2; 
        	} 
  
        	for (int i = 3; (long) i * i <= n; i += 2) { 
            		while (n % i == 0) { 
                		pFac.add(i);
                		n /= i; 
            		} 
        	} 
        	if (n > 2) pFac.add(n);
        
        
        
    	} 

	public static int power(int base, int exp) {
		int out = base;
		for (int i = 1; i < exp; i++) out *= base;
		return out;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer in = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(in.nextToken()), b = Integer.parseInt(in.nextToken());
		primeFactors(a);
		int frequencyToBeat = Integer.MAX_VALUE;
		int freq = 1;
		int processing = pFac.poll();
			
		while (!pFac.isEmpty()) {
			if (pFac.peek() == processing) {
				pFac.poll();
				freq++;
			} else {
				int temp = 0;
				for (int n = 1; n <= ((Math.log(b)+0.1)/Math.log(processing)); n++) {
					temp += b/processing;
				}
				temp /= freq;
				if (temp < frequencyToBeat) {
					frequencyToBeat = temp;
				}
				freq = 1;
				processing = pFac.poll();
			}
		}
		int temp = 0;
		for (int n = 1; n <= ((Math.log(b)+0.1)/Math.log(processing)); n++) {
			temp += b/(power(processing, n));
		}
		temp /= freq;
		if (temp < frequencyToBeat) {
			frequencyToBeat = temp;
		}
		System.out.println(frequencyToBeat);
	}

}
