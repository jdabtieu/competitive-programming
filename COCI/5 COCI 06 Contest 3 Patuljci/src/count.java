import java.util.*;
public class count {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		ArrayList<Byte> numbers = new ArrayList<Byte>();
		int sum = 0;
		
		for (byte i = 0; i < 9; i++) {
			numbers.add(in.nextByte());
			sum += numbers.get(i);
		}
		
		sum -= 100;
		
		for (byte i = 0; i < 9; i++) {
			for (byte j = 0; j < 9; j++) {
				if (i != j && numbers.get(i) + numbers.get(j) == sum) {
					if (i > j) {
						numbers.remove(i);
						numbers.remove(j);
					} else {
						numbers.remove(j);
						numbers.remove(i);
					}
					for (byte k = 0; k < 7; k++) {
						System.out.println(numbers.get(k));
					}
					System.exit(0);
				}
			}
		}
	}
}