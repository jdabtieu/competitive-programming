import java.util.Scanner;
public class Main {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		int number = in.nextInt();
		if (number < 2) {
			System.out.println("not");
			System.exit(0);		
		}
			for (int j = 2; j <= Math.sqrt(number); j++) {
				boolean check = number % j == 0;
				if (check == true) {
			        System.out.println("not");
			        System.exit(0);	
				}
			}
				System.out.println("prime");
				System.exit(0);
			}

	}