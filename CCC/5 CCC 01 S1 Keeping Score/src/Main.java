import java.io.*;

public class Main {
	/*
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp = br.readLine();
		System.out.print("Cards Dealt Points\nClubs ");
		char suit = ' ';
		int pointCount = 0;
		int totalCount = 0;
		int cardsInSuit = 0;
		for (int i = 0; i < temp.length(); i++) {
			cardsInSuit++;
			if (temp.charAt(i) == 'T') {
				System.out.print('T' + " ");
			} else if (temp.charAt(i) == 'J') {
				System.out.print('J' + " ");
				pointCount++;
			} else if (temp.charAt(i) == 'Q') {
				System.out.print('Q' + " ");
				pointCount += 2;
			} else if (temp.charAt(i) == 'K') {
				System.out.print('K' + " ");
				pointCount += 3;
			} else if (temp.charAt(i) == 'A') {
				System.out.print('A' + " ");
				pointCount += 4;
			} else if (temp.charAt(i) >= '2' && temp.charAt(i) <= '9') {
				System.out.print(temp.charAt(i) + " ");
			} else {
				cardsInSuit--;
				if (suit != ' ' && cardsInSuit < 3) pointCount += 3 - cardsInSuit;
				if (suit != ' ') System.out.println(pointCount);
				cardsInSuit = 0;
				suit = temp.charAt(i);
				totalCount += pointCount;
				pointCount = 0;
				if (suit == 'D') System.out.print("Diamonds ");
				else if (suit == 'H') System.out.print("Hearts ");
				else if (suit == 'S') System.out.print("Spades ");
				
			}
			
		}
		if (cardsInSuit < 3) pointCount += 3 - cardsInSuit;
		System.out.println(pointCount);
		System.out.println("Total " + (totalCount + pointCount));
	}
}