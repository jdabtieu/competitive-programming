import java.util.*;
import java.io.*;

public class Main {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;
	
	//pointer: pointer to position in int[] letters
	//strlen26: length of text, without spaces, in base26 (a-z)
	//wordlen: number of words, without spaces, in base10
	//headerLen: length of header
	static int pointer;
	static char[] letters = new char[16875];
	static int[] sumRight = new int[16875];
	static char[] header = new char[677];
	static int[] sumRightHeader = new int[677];
	static String strlen26;
	static int wordlen;
	static int headerLen;
	
	public static void main(String[] args) throws IOException {
		for (byte cases = 0; cases < 10; cases++) {
			pointer = 0;
			//Get key
			int K = readInt() % 26;
			
			//Count number of words
			int numWords = 0;
			
			//Parse each word to static ArrayList letters + add character to header
			in = new StringTokenizer(br.readLine());
			while (in.hasMoreTokens()) {
				numWords++;
				String str = in.nextToken();
				for (int i = 0; i < str.length(); i++) letters[pointer++] = str.charAt(i);
				header[numWords + 1] = toBase26(str.length(), false).charAt(0);
			}
			
			//Decode
			if (numWords == 1) {
				//Subtract key
				for (int i = 0; i < pointer; i++) {
					letters[i] -= K;
					if (letters[i] < 'a') letters[i] += 26;
				}
				
				int sum = 0;
				//Reverse effect of rightsum
				for (int i = pointer - 1; i > -1; i--) {
					letters[i] -= (sum % 26);
					if (letters[i] < 'a') letters[i] += 26;
					sum += letters[i] -'a';
				}
				
				//Get number of words
				wordlen = toBase10(Character.toString(letters[0]) + letters[1]);
				
				//Use headerlen as pointer to header character
				headerLen = 2;
				
				//Iterate through non-heading
				for (int i = 2 + wordlen; i < pointer; i++) {
					System.out.print(letters[i]);
					if (--letters[headerLen] == 'a') {
						System.out.print(" ");
						headerLen++;
					}
				}
				
				//Flush
				System.out.println();
				
			} else {//Encode
				//Count functional length of header
				headerLen = numWords + 2;
				
				//Set first two characters of header
				strlen26 = toBase26(numWords, true);
				header[0] = strlen26.charAt(0);
				header[1] = strlen26.charAt(1);
				
				//Get sum of all letters to the right
				sumRight[pointer - 1] = 0;
				for (int i = pointer - 2; i > -1; i--) {
					sumRight[i] = sumRight[i + 1] + letters[i + 1] - 'a';
				}
				sumRightHeader[headerLen - 1] = sumRight[0] + letters[0] - 'a';
				for (int i = headerLen - 2; i > -1; i--) {
					sumRightHeader[i] = sumRightHeader[i + 1] + header[i + 1] - 'a';
				}
				
				//Print transformed header and letters
				for (int i = 0; i < headerLen; i++) {
					System.out.print((char) ((K + header[i] - 'a' + sumRightHeader[i]) % 26 + 'a'));
				}
				for (int i = 0; i < pointer; i++) {
					System.out.print((char) ((K + letters[i] - 'a' + sumRight[i]) % 26 + 'a'));
				}
				
				//Flush
				System.out.println();
			}
		}

	}
	
	public static String toBase26(int num, boolean pad) {
		String res = Integer.toString(num, 26);
		StringBuilder st = new StringBuilder();
		if (pad && res.length() == 1) {
			res = "0" + res;
		}
		for (int i = 0; i < res.length(); i++) {
			char character = res.charAt(i);
			if (character >= '0' && character <= '9') character += 'a'-'0';
			else character += 10;
			st.append(character);
		}
		return st.toString();
	}

	public static int toBase10(String num) {
		StringBuilder st = new StringBuilder();
		for (int i = 0; i < num.length(); i++) {
			char character = num.charAt(i);
			if (character >= 'a' && character <= 'j') character -= 'a'-'0';
			else character -= 10;
			st.append(character);
		}

		return Integer.parseInt(st.toString(), 26);
	}
	
	static String next() throws IOException {
		while (in == null || !in.hasMoreTokens())
			in = new StringTokenizer(br.readLine());
		return in.nextToken();
	}

	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}

	static String readLine() throws IOException {
		return br.readLine();
	}
}