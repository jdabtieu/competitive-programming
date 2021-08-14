import java.util.*;
public class ccc19j1 {
	/*
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
    public static void main(String args[]) { 
    	Scanner in = new Scanner(System.in);
		int score = 3 * in.nextInt() + 2 * in.nextInt() + in.nextInt() - 3 * in.nextInt() - 2 * in.nextInt() - in.nextInt();
		if (score == 0) System.out.println("T");
		else System.out.println(score > 0 ? "A" : "B");
    } 

}