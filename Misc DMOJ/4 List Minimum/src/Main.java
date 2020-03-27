import java.io.*;
import java.util.*;

public class Main {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer in = new StringTokenizer(br.readLine());
		PriorityQueue<Short> numbers = new PriorityQueue<Short>();
		for (byte i = Byte.parseByte(in.nextToken()); i > 0; i--) {
			in = new StringTokenizer(br.readLine());
			numbers.add(Short.parseShort(in.nextToken()));
		}
		while(!numbers.isEmpty()) System.out.println(numbers.poll());
	}

}