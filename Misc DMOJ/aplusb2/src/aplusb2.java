import java.util.*;
import java.io.*;

public class aplusb2 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;

	public static void main(String[] args) throws IOException {
		for (int cases = readInt(); cases > 0; cases--) {
			String a = next(), b = next();
			boolean negA = a.charAt(0) == '-', negB = b.charAt(0) == '-';
			if (negA) a = a.substring(1);
			if (negB) b = b.substring(1);
			
			ArrayList<Byte> A = new ArrayList<Byte>(), B = new ArrayList<Byte>();
			for (int i = 0; i < a.length(); i++) A.add(Byte.parseByte(a.substring(i, i + 1)));
			for (int i = 0; i < b.length(); i++) B.add(Byte.parseByte(b.substring(i, i + 1)));
			
			if (A.size() < B.size()) for (int i = A.size(); i < B.size(); i++) A.add(0, (byte) 0);
			if (B.size() < A.size()) for (int i = B.size(); i < A.size(); i++) B.add(0, (byte) 0);
			
			if (negA == negB) {
				if (negA) printPretty(add(A, B), true);
				else printPretty(add(A, B), false);
				continue;
			}
			if (negA) {
				if (num1GreaterOrEqual(B, A)) printPretty(subtract(B, A), false);
				else printPretty(subtract(A, B), true);
				continue;
			}
			if (num1GreaterOrEqual(A, B)) printPretty(subtract(A, B), false);
			else printPretty(subtract(B, A), true);
		}
	}
	
	public static ArrayList<Byte> add (ArrayList<Byte> num1, ArrayList<Byte> num2) {
		ArrayList<Byte> result = new ArrayList<Byte>();
		for (int i = num1.size() - 1; i > 0; i--) {
			if (num1.get(i) + num2.get(i) < 10) result.add(0, (byte) (num1.get(i) + num2.get(i)));
			else {
				num1.set(i - 1, (byte) (num1.get(i - 1) + 1));
				result.add(0, (byte) ((num1.get(i) + num2.get(i)) % 10));
			}
		}
		if (num1.get(0) + num2.get(0) < 10) result.add(0, (byte) (num1.get(0) + num2.get(0)));
		else {
			result.add(0, (byte) ((num1.get(0) + num2.get(0)) % 10));
			result.add(0, (byte) 1);
		}
		return result;
	}
	
	public static ArrayList<Byte> subtract (ArrayList<Byte> num1, ArrayList<Byte> num2) {
		ArrayList<Byte> result = new ArrayList<Byte>();
		for (int i = 0; i < num1.size(); i++) result.add((byte) 0);
		for (int i = num1.size() - 1; i >= 0; i--) {
			if (num1.get(i) >= num2.get(i)) {
				if (result.get(i) == -1 && num1.get(i) - num2.get(i) == 0) {
					result.set(i, (byte) (result.get(i) + 10 + num1.get(i) - num2.get(i)));
					result.set(i - 1, (byte) (result.get(i - 1) - 1));
				}
				else result.set(i, (byte) (result.get(i) + num1.get(i) - num2.get(i)));
			} else {
				result.set(i, (byte) (result.get(i) + 10 + num1.get(i) - num2.get(i)));
				result.set(i - 1, (byte) (result.get(i - 1) - 1));
			}
		}
		
		return result;
	}
	
	public static void printPretty (ArrayList<Byte> arr, boolean appendNegative) {
		int i = 0;
		for (; i < arr.size(); i++) if (arr.get(i) != 0) break;
		if (i == arr.size() && arr.get(i - 1) == 0) {
			System.out.println(0);
			return;
		}
		
		if (appendNegative) System.out.print('-');
		for (; i < arr.size(); i++) System.out.print(arr.get(i));
		System.out.println();
	}
	
	public static boolean num1GreaterOrEqual (ArrayList<Byte> num1, ArrayList<Byte> num2) {
		for (int i = 0; i < num1.size(); i++) {
			if (num1.get(i) > num2.get(i)) return true;
			if (num2.get(i) > num1.get(i)) return false;
		}
		return true;
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