import java.util.*;
public class vmss7wc16c5p4 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int pieces = in.nextInt();
		int a = in.nextInt(), b = in.nextInt(), c = in.nextInt();
		int[] bars = new int[pieces + 1];
		bars[a] = 1;
		bars[b] = 1;
		bars[c] = 1;
		for (int i = 1; i < bars.length; i++) {
		    if ((i-a) > 0 && bars[i-a] != 0 && (bars[i-a]+1>bars[i] || bars[i] == 0)) {
		        bars[i] = bars[i-a] + 1;
		    }
		    if ((i-b) > 0 && bars[i-b] != 0 && (bars[i-b]+1>bars[i] || bars[i] == 0)) {
		        bars[i] = bars[i-b] + 1;
		    }
		    if ((i-c) > 0 && bars[i-c] != 0 && (bars[i-c]+1>bars[i] || bars[i] == 0)) {
		        bars[i] = bars[i-c] + 1;
		    }
		}
		System.out.println(bars[pieces]);
	}
}