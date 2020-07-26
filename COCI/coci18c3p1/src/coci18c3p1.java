import java.util.Scanner;
public class coci18c3p1 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		byte scanForLetter = 1;
		int count = 0;
		String nextString = in.next();
		for (int i = 0; i < nextString.length(); i++) {
			char nextChar = nextString.charAt(i);
			if (scanForLetter == 1) {
				if (nextChar == 'H') {
					scanForLetter = 2;
				}
			} else if (scanForLetter == 2) {
				if (nextChar == 'O') {
					scanForLetter = 3;
				}
			} else if (scanForLetter == 3) {
				if (nextChar == 'N') {
					scanForLetter = 4;
				}
			} else if (scanForLetter == 4) {
				if (nextChar == 'I') {
					scanForLetter = 1;
					count++;
				}
			}			
		}
		System.out.println(count);
	}

}
