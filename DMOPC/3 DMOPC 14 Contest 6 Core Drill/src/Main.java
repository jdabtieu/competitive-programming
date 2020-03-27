import java.util.Scanner;
public class Main {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		double r = in.nextInt();
		double h = in.nextInt();
		double volume = Math.PI * r * r * h / 3;
		double volume100 = volume * 100;
		volume100 = Math.round(volume100);
		volume = volume100 / 100;
		System.out.println(volume);
	}
}