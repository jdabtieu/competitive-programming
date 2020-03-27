import java.util.Scanner;
public class Main {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static Scanner in = new Scanner(System.in);
	static public void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			String input = in.next();
			if (input.length() == 1) {
				if (input.equals("0")) {
					System.out.println("1111");
				} else System.out.println("0000");
			} else if (input.length() == 2) {
				if (input.equals("00")) {
					System.out.println("0101\n0110\n0111\n1010\n1011\n1101\n1110\n1111");
				} else if (input.equals("01")) {
					System.out.println("0000\n1000\n1100\n1110\n1111");
				} else if (input.equals("10")) {
					System.out.println("0000\n0001\n0011\n0111\n1111");
				} else System.out.println("0000\n0001\n0010\n0100\n0101\n1000\n1001\n1010");
			} else if (input.length() == 3) {
				if (input.equals("000")) {
					System.out.println("0010\n0011\n0100\n0101\n0110\n0111\n1001\n1010\n1011\n1100\n1101\n1110\n1111");
				} else if (input.equals("001")) {
					System.out.println("0000\n0100\n0101\n0110\n0111\n1000\n1010\n1011\n1100\n1101\n1110\n1111");
				} else if (input.equals("010")) {
					System.out.println("0000\n0001\n0011\n0110\n0111\n1000\n1001\n1011\n1100\n1101\n1110\n1111");
				} else if (input.equals("011")) {
					System.out.println("0000\n0001\n0010\n0100\n0101\n1000\n1001\n1010\n1100\n1101\n1110\n1111");
				}else if (input.equals("100")) {
					System.out.println("0000\n0001\n0010\n0011\n0101\n0110\n0111\n1010\n10110\n1101\n1110\n1111");
				}else if (input.equals("101")) {
					System.out.println("0000\n0001\n0010\n0011\n0100\n0110\n0111\n1000\n1001\n11001\n1110\n1111");
				}else if (input.equals("110")) {
					System.out.println("0000\n0001\n0010\n0011\n0100\n0101\n0111\n1000\n1001\n1010\n1011\n1111");
				}else System.out.println("0000\n0001\n0010\n0011\n0100\n0101\n0110\n1000\n1001\n1010\n1011\n1100\n1101");
			} else {
				String[] binary = {"0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011","1100","1101","1110","1111"};
				
				for (int j = 0; j < binary.length; j++) {
					if (!binary[j].equals(input)) {
						System.out.println(binary[j]);
					}
				}
			}
		}
	}
}
