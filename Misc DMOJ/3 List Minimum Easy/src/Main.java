import java.util.Scanner;
public class Main {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int max = in.nextInt();
        for (int i = 1; i < max - 2; i+= 3) {
            System.out.print(i + " " + (i+1) + " " + (i+2) + " ");
        }
        if (max % 3 == 0) {
            System.out.print((max-2) + " " + (max-1) + " " + (max));
        } else if (max % 3 == 1) {
    	    System.out.print(max);
    	} else {
    	    System.out.print((max-1) + " " + max);  
    	}
    }
}