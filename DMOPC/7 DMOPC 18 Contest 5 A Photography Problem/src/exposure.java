import java.util.*;
public class exposure {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 * Currently in progress
	 */
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		int pixels = in.nextInt() * in.nextInt();
		double[] exp = new double[pixels];
		int sum = 0;
		for (short i = 0; i < exp.length; i++) {
				exp[i] = 1000 * in.nextDouble();
				sum += exp[i];
		}
		
		if (sum - (480 * exp.length) <= 0.001 && (480 * exp.length) - sum <= 0.001) {
			System.out.println("correctly exposed");
			System.exit(0);
		}
		boolean checksum = false;
		double C = 1;
		double output = C;
		while (!(sum - (480 * exp.length) <= 0.0001 && (480 * exp.length) - sum <= 0.0001)) {
			sum = 0;
			for (int i = 0; i < exp.length; i++) {
				sum += exp[i];
			}
//	System.out.println(sum);
			C = (double) 480 * pixels / sum;
			output *= C;
			if (sum < (480 * exp.length)) {
				if (!checksum) {
					System.out.println("underexposed");
					checksum = true;
				}
				for (int i = 0; i < exp.length; i++) {
					exp[i] *= C;
				}
				for (int i = 0; i < exp.length; i++) {
					if (exp[i] > 1000) {
						exp[i] = 1000;
					}
				}
			}
			if (sum > (480 * exp.length)) {
				if (!checksum) {
					System.out.println("overexposed");
					checksum = true;
				}
				for (int i = 0; i < exp.length; i++) {
					exp[i] *= C;
				}
				for (int i = 0; i < exp.length; i++) {
					if (exp[i] > 1000) {
						exp[i] = 1000;
					}
				}
			}
		}
		System.out.println(Math.round(output * 100) / (double) 100);
		

		
	}
}
