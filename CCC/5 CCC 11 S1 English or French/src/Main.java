import java.util.Scanner;
public class Main {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static Scanner in = new Scanner(System.in);
	static public void main(String[] args) {
		int s = 0;
		int t = 0;
		int lines = in.nextInt();
		for (int j = 0; j <= lines; j++) {
			String input = in.nextLine();
			for (int i = 0; i < input.length(); i++) {
				if (input.charAt(i) == 's' || input.charAt(i) == 'S') {
						s++;
				} else if (input.charAt(i) == 't' || input.charAt(i) == 'T') {
						t++;
				}
			}
		}
		if (t <= s) {
			System.out.println("French");
		} else {
			System.out.println("English");
		}
	}
}