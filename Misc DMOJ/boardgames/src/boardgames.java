import java.util.*;
public class boardgames {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int start = in.nextInt(), end = in.nextInt();
		if (start == end) {
			System.out.println(0);
			System.exit(0);
		}
		short[] steps = new short[10000001];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		while (!queue.isEmpty()) {
			int processing = queue.poll();
			if (processing * 3 <= 10000000 && steps[processing * 3] == 0) {
				queue.add(processing * 3);
				steps[processing * 3] = (short) (steps[processing] + 1);
			}
			if (processing > 1 && steps[processing - 1] == 0) {
				queue.add(processing - 1);
				steps[processing - 1] = (short) (steps[processing] + 1);
			}
			if (processing > 3 && steps[processing - 3] == 0) {
				queue.add(processing - 3);
				steps[processing - 3] = (short) (steps[processing] + 1);
			}
			if (processing % 2 == 0 && processing / 2 > 0 && steps[processing / 2] == 0) {
				queue.add(processing / 2);
				steps[processing / 2] = (short) (steps[processing] + 1);
			}
			if (steps[end] != 0) {
				System.out.println(steps[end]);
				System.exit(0);
			}
		}
		System.out.println(steps[end]);
	}

}