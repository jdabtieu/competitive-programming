import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class anothersorting {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer in = new StringTokenizer(br.readLine());
		ArrayList<Integer> zero = new ArrayList<Integer>();
		ArrayList<Integer> one = new ArrayList<Integer>();
		ArrayList<Integer> two = new ArrayList<Integer>();
		ArrayList<Integer> three = new ArrayList<Integer>();
		ArrayList<Integer> four = new ArrayList<Integer>();
		ArrayList<Integer> five = new ArrayList<Integer>();
		ArrayList<Integer> six = new ArrayList<Integer>();
		ArrayList<Integer> seven = new ArrayList<Integer>();
		ArrayList<Integer> eight = new ArrayList<Integer>();
		ArrayList<Integer> nine = new ArrayList<Integer>();
		int numberOfInputs = Integer.parseInt(in.nextToken());
		StringTokenizer in2 = new StringTokenizer(br.readLine());
		for (int j = numberOfInputs; j > 0; j--) {
			int number = Integer.parseInt(in2.nextToken());
			if (number % 10 == 0) {
				zero.add(number);
			} else if (number % 10 == 0) {
				zero.add(number);
			} else if (number % 10 == 1) {
				one.add(number);
			} else if (number % 10 == 2) {
				two.add(number);
			} else if (number % 10 == 3) {
				three.add(number);
			} else if (number % 10 == 4) {
				four.add(number);
			} else if (number % 10 == 5) {
				five.add(number);
			} else if (number % 10 == 6) {
				six.add(number);
			} else if (number % 10 == 7) {
				seven.add(number);
			} else if (number % 10 == 8) {
				eight.add(number);
			} else nine.add(number);
		}
		Collections.sort(zero, Collections.reverseOrder());
		Collections.sort(one, Collections.reverseOrder());
		Collections.sort(two, Collections.reverseOrder());
		Collections.sort(three, Collections.reverseOrder());
		Collections.sort(four, Collections.reverseOrder());
		Collections.sort(five, Collections.reverseOrder());
		Collections.sort(six, Collections.reverseOrder());
		Collections.sort(seven, Collections.reverseOrder());
		Collections.sort(eight, Collections.reverseOrder());
		Collections.sort(nine, Collections.reverseOrder());
		for (int i = 0; i < zero.size(); i++) {
			if (numberOfInputs != 1) System.out.print(zero.get(i) + " ");
			else System.out.print(zero.get(i));
			numberOfInputs--;
		}
		for (int i = 0; i < one.size(); i++) {
			if (numberOfInputs != 1) System.out.print(one.get(i) + " ");
			else System.out.print(one.get(i));
			numberOfInputs--;
		}
		for (int i = 0; i < two.size(); i++) {
			if (numberOfInputs != 1) System.out.print(two.get(i) + " ");
			else System.out.print(two.get(i));
			numberOfInputs--;
		}
		for (int i = 0; i < three.size(); i++) {
			if (numberOfInputs != 1) System.out.print(three.get(i) + " ");
			else System.out.print(three.get(i));
			numberOfInputs--;
		}
		for (int i = 0; i < four.size(); i++) {
			if (numberOfInputs != 1) System.out.print(four.get(i) + " ");
			else System.out.print(four.get(i));
			numberOfInputs--;
		}
		for (int i = 0; i < five.size(); i++) {
			if (numberOfInputs != 1) System.out.print(five.get(i) + " ");
			else System.out.print(five.get(i));
			numberOfInputs--;
		}
		for (int i = 0; i < six.size(); i++) {
			if (numberOfInputs != 1) System.out.print(six.get(i) + " ");
			else System.out.print(six.get(i));
			numberOfInputs--;
		}
		for (int i = 0; i < seven.size(); i++) {
			if (numberOfInputs != 1) System.out.print(seven.get(i) + " ");
			else System.out.print(seven.get(i));
			numberOfInputs--;
		}
		for (int i = 0; i < eight.size(); i++) {
			if (numberOfInputs != 1) System.out.print(eight.get(i) + " ");
			else System.out.print(eight.get(i));
			numberOfInputs--;
		}
		for (int i = 0; i < nine.size(); i++) {
			if (numberOfInputs != 1) System.out.print(nine.get(i) + " ");
			else System.out.print(nine.get(i));
			numberOfInputs--;
		}
	}
}
