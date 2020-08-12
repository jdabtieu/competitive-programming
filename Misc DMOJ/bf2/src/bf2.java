import java.util.*;
public class bf2 {
	/*
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
		String str = in.next();
		byte length = in.nextByte();
		String shortest = str.substring(0, length);
		for (byte i = 0; i < str.length() - length; i++) {
			if (shortest.compareTo(str.substring(i, length+i)) > 0) {
				shortest = str.substring(i, length+i);
			}
		}
		System.out.println(shortest);
	}

}