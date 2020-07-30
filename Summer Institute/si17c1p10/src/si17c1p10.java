import java.util.Scanner;
public class si17c1p10 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		int AliceCards = in.nextInt();
		int[] AliceCardType;
		AliceCardType = new int[AliceCards];
		int[] AliceCardValue;
		AliceCardValue = new int[AliceCards];		
		for (int i = 0; i < AliceCards; i++) {
			AliceCardType[i] = in.nextInt();
		}
		for (int i = 0; i < AliceCards; i++) {
			AliceCardValue[i] = in.nextInt();
		}
		
		int CarlCards = in.nextInt();
		int[] CarlCardType;
		CarlCardType = new int[CarlCards];
		int[] CarlCardValue;
		CarlCardValue = new int[CarlCards];		
		for (int i = 0; i < CarlCards; i++) {
			CarlCardType[i] = in.nextInt();
		}
		for (int i = 0; i < CarlCards; i++) {
			CarlCardValue[i] = in.nextInt();
		}
		
		int AliceTotal = 0;
		for (int i = 0; i < AliceCards; i++) {
			AliceTotal += AliceCardType[i] * AliceCardValue[i];
		}
		
		int CarlTotal = 0;
		for (int i = 0; i < CarlCards; i++) {
			CarlTotal += CarlCardType[i] * CarlCardValue[i];
		}
		System.out.print(AliceTotal + " " + CarlTotal);
	}
}