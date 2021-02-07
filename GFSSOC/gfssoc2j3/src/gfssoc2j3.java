import java.util.Scanner;
public class gfssoc2j3 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		int a = in.nextInt();
		for (int i = 0; i < 1; i++) {
			char operation = in.next().charAt(0);
			if (operation != '=') {
				int b = in.nextInt();
				if(operation == 'P') {
					a = a + b;
					i--;
				} else if (operation == 'M') {
					a = a - b;
					i--;
				}
			} else if (operation == '=') {
				System.out.println(a);
			}
		}
	}
}
