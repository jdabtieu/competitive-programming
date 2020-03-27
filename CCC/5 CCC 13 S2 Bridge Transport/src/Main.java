import java.util.*;
import java.io.*;
public class Main {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int maxWeight = Integer.parseInt(br.readLine());
		int totalCars = Integer.parseInt(br.readLine());
		Queue<Integer> list = new LinkedList<>();
		int weightSum = 0;
		int cars = 0;
		for (int i = 0; i < 4; i++) {
			int a = Integer.parseInt(br.readLine());
			weightSum += a;
			list.add(a);
			if (weightSum <= maxWeight) cars++;
			else {
				System.out.println(cars);
				System.exit(0);
			}
		}
		for (int i = 4; i < totalCars; i++) {
			int a = Integer.parseInt(br.readLine());
			weightSum -= list.poll();
			weightSum += a;
			list.add(a);
			if (weightSum <= maxWeight) cars++;
			else {
				System.out.println(cars);
				System.exit(0);
			}
		}
		System.out.println(cars);
	}
}