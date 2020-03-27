import java.util.*;
public class pairing {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		if (in.nextInt() == 1) {
			int totalSpeed = 0;
			
			int[] Dmoj = new int[in.nextInt()];
			int[] Pegl = new int[Dmoj.length];
			for (int i = 0; i < Dmoj.length; i++) {
				Dmoj[i] = in.nextInt();
			}
			for (int i = 0; i < Dmoj.length; i++) {
				Pegl[i] = in.nextInt();
			}
			
			Arrays.sort(Dmoj);
			Arrays.sort(Pegl);
			
			for (int i = 0; i < Dmoj.length; i++) {
				totalSpeed += Math.max(Dmoj[i], Pegl[i]);
			}
			System.out.println(totalSpeed);
		} else {
			int totalSpeed = 0;
			
			int[] Dmoj = new int[in.nextInt()];
			int[] Pegl = new int[Dmoj.length];
			for (int i = 0; i < Dmoj.length; i++) {
				Dmoj[i] = in.nextInt();
			}
			for (int i = 0; i < Dmoj.length; i++) {
				Pegl[i] = in.nextInt();
			}
			Arrays.sort(Dmoj);
			Arrays.sort(Pegl);
			
			for (int i = 0; i < Dmoj.length; i++) {
				totalSpeed += Math.max(Dmoj[i], Pegl[Pegl.length - 1 - i]);
			}
			System.out.println(totalSpeed);
		}

	}

}