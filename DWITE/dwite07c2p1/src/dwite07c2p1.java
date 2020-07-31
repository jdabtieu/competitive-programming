import java.util.Scanner;
public class dwite07c2p1 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			int factors = 0;
			
			int integer = in.nextInt();
			
			for (int j = 2; j <= integer / 2; j++) {
				if (integer % j == 0) {
					boolean jHasFactors = false;
					
					for (int k = 2; k <= Math.sqrt(j); k++) {
						if (j % k == 0) {
							jHasFactors = true;
						}
					}
					
					if (jHasFactors == false) {
						factors++;
					} else {
						factors = 999;
					}
				}
			}
			
			if (factors == 1 || factors == 2) {
				System.out.println("semiprime");
			} else {
				System.out.println("not");
			}
		}

	}

}