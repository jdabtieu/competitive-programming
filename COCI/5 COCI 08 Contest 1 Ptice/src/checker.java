import java.util.Scanner;
public class checker {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static Scanner in = new Scanner (System.in);
	public static void main(String[] args) {
		char[] Adrian = {'A','B','C'};
		char[] Bruno = {'B','A','B','C'};
		char[] Goran = {'C','C','A','A','B','B'};
		int AdrianScore = 0;
		int BrunoScore = 0;
		int GoranScore = 0;
		
		in.nextInt();
		
		String answerKey = in.next();
		
		for (int i = 0; i < answerKey.length(); i++) {
			char thisAnswer = answerKey.charAt(i);
			if (Adrian[i % 3] == thisAnswer) {
				AdrianScore++;
			}
			if (Bruno[i % 4] == thisAnswer) {
				BrunoScore++;
			}
			if (Goran[i % 6] == thisAnswer) {
				GoranScore++;
			}
		}
		
		if (AdrianScore > BrunoScore && AdrianScore > GoranScore) {
			System.out.println(AdrianScore+"\nAdrian");
		} else if (BrunoScore > AdrianScore && BrunoScore > GoranScore) {
			System.out.println(BrunoScore+"\nBruno");
		} else if (GoranScore > BrunoScore && AdrianScore < GoranScore) {
			System.out.println(GoranScore+"\nGoran");
		} else if (AdrianScore == BrunoScore) {
			if (AdrianScore == GoranScore) {
				System.out.println(AdrianScore+"\nAdrian\nBruno\nGoran");
			} else {
				System.out.println(AdrianScore+"\nAdrian\nBruno");				
			}
		} else if (AdrianScore == GoranScore) {
			if (AdrianScore == BrunoScore) {
				System.out.println(AdrianScore+"\nAdrian\nBruno\nGoran");
			} else {
				System.out.println(AdrianScore+"\nAdrian\nGoran");				
			}
		} else if (GoranScore == BrunoScore) {
			if (AdrianScore == GoranScore) {
				System.out.println(AdrianScore+"\nAdrian\nBruno\nGoran");
			} else {
				System.out.println(GoranScore+"\nBruno\nGoran");				
			}
		}
	}
}