import java.util.Scanner;
public class data {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		int MBperMonth = in.nextInt();
		int months = in.nextInt();
		int usableMBs = MBperMonth * (months + 1);
		for (int i = 0; i < months; i++) {
			usableMBs = usableMBs - in.nextInt();
		}
		System.out.println(usableMBs);
	}

}
