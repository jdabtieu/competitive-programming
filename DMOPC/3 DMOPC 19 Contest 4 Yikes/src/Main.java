import java.util.*;
public class Main {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
    public static void main(String args[]) { 
    	Scanner in = new Scanner(System.in);
		String a = in.next(), b = in.next();
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
		System.out.println(excuse ? "LARRY IS DEAD!" : "LARRY IS SAVED!");
    } 

}