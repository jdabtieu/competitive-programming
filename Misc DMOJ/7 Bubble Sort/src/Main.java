import java.util.*;
import java.io.*;

public class Main {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;

	public static void main(String[] args) throws IOException {
		int[] array = new int[readInt()];
		if (array.length == 0) return;
		if (array.length == 1) {
			System.out.println(readInt());
			return;
		}
		for (int i = 0; i < array.length; i++) array[i] = readInt();
		printArray(array);
		int swaps = 0, index = 0;
		while (true) {
			if (array[index] > array[index + 1]) {
				swaps++;
				swap(array, index, index + 1);
				printArray(array);
			}
			
			if (++index == array.length - 1) {
				if (swaps == 0) return;
				index = 0;
				swaps = 0;
			}
		}
	}
	
	public static void printArray(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println(array[array.length - 1]);
	}
	
	public static void swap(int[] array, int index1, int index2) {
		array[index1] ^= array[index2];
		array[index2] ^= array[index1];
		array[index1] ^= array[index2];
	}
	
	static String next() throws IOException {
		while (in == null || !in.hasMoreTokens())
			in = new StringTokenizer(br.readLine());
		return in.nextToken();
	}

	static long readLong() throws IOException {
		return Long.parseLong(next());
	}

	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}

	static double readDouble() throws IOException {
		return Double.parseDouble(next());
	}

	static char readChar() throws IOException {
		return next().charAt(0);
	}

	static String readLine() throws IOException {
		return br.readLine();
	}
}