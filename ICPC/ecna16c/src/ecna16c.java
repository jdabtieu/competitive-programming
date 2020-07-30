import java.util.Scanner;
public class ecna16c {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) {
		byte[] key = {0,0,0,0,0,0,0,0,0,0,0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
		char[] nextKey = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		
		Scanner in = new Scanner(System.in);
		
		String encodedMessage = in.next();
		String decodeKey = in.next();
		String decodedMessage = "";
		
		for (int i = 0; i < decodeKey.length() && i < encodedMessage.length(); i++) {
			int temp = key[Character.getNumericValue(encodedMessage.charAt(i))] - key[Character.getNumericValue(decodeKey.charAt(i))];
			if (temp < 0) temp += 26;
			decodedMessage += nextKey[temp];
		}
		
		int j = 0;
		for (int i = decodeKey.length(); i < encodedMessage.length(); i++) {

			int temp = key[Character.getNumericValue(encodedMessage.charAt(i))] - key[Character.getNumericValue(decodedMessage.charAt(j))];
			j++;
			if (temp < 0) temp += 26;
			decodedMessage += nextKey[temp];
		}
		
		System.out.println(decodedMessage);
	}

}
