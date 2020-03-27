import java.util.Scanner;
public class Sequence {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	
	//Deals with any digits following the ones pattern
	public static String ones(int input) {
		//Use a key to match input
		String[] key = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
		return key[input];
	}
	
	//Deals with any digits following the tens pattern
	public static String tens(int input) {
		if (String.valueOf(input).length() < 2) {
			return ones(input);
		} else {
			if (input / 10 != 1) {
				String[] key = {"", "", "twenty", "thirth", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
				return key[input / 10] + ones(input % 10);
			} else {
				String[] key = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
				return key[input - 10];
			}
		}
	}
	
	
	//Deals with any digits following the hundreds pattern
	public static String hundreds(int input) {
		if (String.valueOf(input).length() < 3) {
			return tens(input);
		} else return ones(input / 100) + "hundred" + tens(input % 100);
	}
	
	//Deals with 1-999999
	public static String thousands(int input) {
		if (String.valueOf(input).length() < 4) {
			return hundreds(input);
		} else return hundreds(input / 1000) + "thousand" + hundreds(input % 1000);
	}
	
	//Deals with 1-999999999
	public static String millions(int input) {
		if (String.valueOf(input).length() < 7) {
			return thousands(input);
		} else return hundreds(input / 1000000) + "million" + thousands(input % 1000000);
	}
	
	//Deals with 1-(2^32-1)
	public static String billions(int input) {
		if (String.valueOf(input).length() < 10) {
			return millions(input);
		} else return hundreds(input / 1000000000) + "billion" + millions(input % 1000000000);
	}
	

	
	public static void main(String[] args) {
		//Initiate new Scanner object
		Scanner in = new Scanner(System.in);
		int number = in.nextInt();
		//Keep looping until 4 is reached
		while (number != 4) {
			number = billions(number).length();
			System.out.println(number);
		}

	}

}
