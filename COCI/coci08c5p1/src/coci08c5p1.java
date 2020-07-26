import java.util.Scanner;
public class coci08c5p1 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.next();
		byte numLetters = (byte) input.length();
		for (byte i = 0; i < input.length() - 2; i++) if (input.charAt(i) == 'd' && input.charAt(i + 1) == 'z' && input.charAt(i + 2) == '=') {
			numLetters -= 2;
			input = input.substring(0, i) + "\\" + input.substring(i + 3);
		}
		for (byte i = 0; i < input.length() - 1; i++) if (input.charAt(i + 1) == '=' && (input.charAt(i) == 'c' || input.charAt(i) == 's' || input.charAt(i) == 'z')) {
			numLetters --;
			input = input.substring(0, i) + "\\" + input.substring(i + 2);
		}
		for (byte i = 0; i < input.length() - 1; i++) if (input.charAt(i + 1) == '-' && (input.charAt(i) == 'c' || input.charAt(i) == 'd')) {
			numLetters --;
			input = input.substring(0, i) + "\\" + input.substring(i + 2);
		}
		for (byte i = 0; i < input.length() - 1; i++) if (input.charAt(i + 1) == 'j' && (input.charAt(i) == 'l' || input.charAt(i) == 'n')) {
			numLetters --;
			input = input.substring(0, i) + "\\" + input.substring(i + 2);
		}
		System.out.println(numLetters);
	}

}