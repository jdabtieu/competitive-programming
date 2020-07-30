import java.util.*;
import java.io.*;
public class vpex1p2 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] numbers = new int[Integer.parseInt(br.readLine())];
		int sum = 0;
		StringTokenizer in = new StringTokenizer(br.readLine());
		for (int i = 0; i < numbers.length; i++) {
		    numbers[i] = Integer.parseInt(in.nextToken());
		    sum += numbers[i];
		}
		int actual = sum / numbers.length;
		int count = 0;
		for (int num : numbers) {
		    if (num != actual) count++;
		}
		System.out.println(count);
	}
}