import java.util.*;
import java.io.*;

public class exe {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;

	public static void main(String[] args) throws IOException {
		int bytes = readInt();
		if (bytes < 2) {
			System.out.println("MZ");
			return;
		}
		
		String lines = readLine();
		
		String h1 = lines.substring(0, 2) + lines.substring(3, 5);
		if (!h1.equals("4D5A")) {
			if (bytes <= 256 || !isValidHexCode(h1)) {
				System.out.println("MZ");
				return;
			}
			System.out.println("COM");
			return;
		}
		if (bytes < 64) {
			System.out.println("MZ");
			return;
		}
		
		lines += " " + readLine();
		lines += " " + readLine();
		String line4 = readLine();
		lines += " " + line4;
		
		h1 = line4.substring(36);
		h1 = h1.substring(9) + h1.substring(6, 8) + h1.substring(3, 5) + h1.substring(0, 2);
		if (!isValidHexCode(h1)) {
			System.out.println("MZ");
			return;
		}
		long nextAddress = convert(h1);
		
		if (nextAddress + 1 >= bytes) {
			System.out.println("MZ");
			return;
		}
		
		if (nextAddress < 64) {
			try {
				h1 = lines.substring((int) nextAddress * 3, (int) nextAddress * 3 + 5);
			} catch (StringIndexOutOfBoundsException e) {
				h1 = lines.substring((int) nextAddress * 3) + " " + readLine().substring(0, 2);
			}
			if (h1.equals("4E 45")) {
				System.out.println("NE");
				return;
			}
			if (h1.equals("4C 45")) {
				System.out.println("LE");
				return;
			}
			if (h1.equals("50 45")) {
				System.out.println("PE");
				return;
			}
			System.out.println("MZ");
			return;
		}
		
		int bytesAdvanced = 64;
		while (bytesAdvanced + 16 <= nextAddress) {
			bytesAdvanced += 16;
			readLine();
		}
		
		nextAddress -= bytesAdvanced;
		
		h1 = readLine();
		try {
			h1 = h1.substring((int) nextAddress * 3, (int) nextAddress * 3 + 5);
		} catch (StringIndexOutOfBoundsException e) {
			h1 = h1.substring((int) nextAddress * 3) + " " + readLine().substring(0, 2);
		}
		
		if (h1.equals("4E 45")) {
			System.out.println("NE");
			return;
		}
		if (h1.equals("4C 45")) {
			System.out.println("LE");
			return;
		}
		if (h1.equals("50 45")) {
			System.out.println("PE");
			return;
		}
		System.out.println("MZ");
		
		
		
	}
	
	static boolean isValidHexCode(String hex) {
		for (int i = 0; i < hex.length(); i++) if (hex.charAt(i) < '0' || (hex.charAt(i) > '9' && hex.charAt(i) < 'A') || hex.charAt(i) > 'F') {
			return false;
		}
		return true;
	}
	
	//Big-Endian
	static long convert(String hex) {
		long sum = 0;
		for (int i = 0; i < hex.length(); i++) {
			if (hex.charAt(hex.length() - 1 - i) > '9') {
				sum += (hex.charAt(hex.length() - 1 - i) - 'A' + 10) * (long) (Math.pow(16, i));
			} else {
				sum += (hex.charAt(hex.length() - 1 - i) - '0') * (long) (Math.pow(16, i));
			}
		}
		return sum;
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