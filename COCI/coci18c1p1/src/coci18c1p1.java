import java.util.Scanner;
public class coci18c1p1 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		int money = in.nextInt();
		int projects = in.nextInt();
		for (int i = 1; i < projects; i++) {
			System.out.println(i);
		}
		int moneySpent = projects * (projects - 1) / 2;
		System.out.println(money - moneySpent);
	}

}