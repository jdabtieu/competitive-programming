import java.util.*;
import java.io.*;
public class Main {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
    public static void main(String args[]) throws IOException { 
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String a = in.readLine(), b = in.readLine();
		if (a.equals(b)) {
		    System.out.println("LARRY IS DEAD!");
		    return;
		}
		boolean excuse = true;
		for (int i = 0; i < a.length(); i++) {
		    if (a.charAt(i) != b.charAt(i)) {
		        if (excuse) excuse = false;
		        else {
		            System.out.println("LARRY IS DEAD!");
		            System.exit(0);
		        }
		    }
		}
		System.out.println("LARRY IS SAVED!");
    } 

}