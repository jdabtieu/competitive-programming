import java.util.Scanner;
public class coci14c3p1 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		String input = in.next();
		
		char[] L1 = {'1','Q','A','Z'};
		int num1 = 0;
		char[] L2 = {'2','W','S','X'};
		int num2 = 0;
		char[] L3 = {'3','E','D','C'};
		int num3 = 0;
		char[] L4 = {'4','5','R','T','F','G','V','B'};
		int num4 = 0;
		char[] R1 = {'6','7','Y','U','H','J','N','M'};
		int num5 = 0;
		char[] R2 = {'8','I','K',','};
		int num6 = 0;
		char[] R3 = {'9','O','L','.'};
		int num7 = 0;
		char[] R4 = {'0','-','=','P','[',']',';','\'','/'};
		int num8 = 0;
		
		for (int i = 0; i < input.length(); i++) {
			char testFor = input.charAt(i);
			for (int j = 0; j < 4; j++) {
				if (testFor == L1[j]) {
					num1++;
				} else if (testFor == L2[j]) {
					num2++;
				} else if (testFor == L3[j]) {
					num3++;
				} else if (testFor == R2[j]) {
					num6++;
				} else if (testFor == R3[j]) {
					num7++;
				}
			}
			for (int j = 0; j < 8; j++) {
				if (testFor == L4[j]) {
					num4++;
				} else if (testFor == R1[j]) {
					num5++;
				}	
			}
			for (int j = 0; j < 9; j++) {
				if (testFor == R4[j]) {
					num8++;
				}
			}

		}
		System.out.println(num1+"\n"+num2+"\n"+num3+"\n"+num4+"\n"+num5+"\n"+num6+"\n"+num7+"\n"+num8);
	}
}