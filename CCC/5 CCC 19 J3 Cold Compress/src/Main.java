import java.util.*;
import java.io.*;
public class Main {
	/*
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer in = new StringTokenizer(br.readLine());
		int lines = Integer.parseInt(in.nextToken());
		for (int cases = 0; cases < lines; cases++) {
			Queue<Character> characters = new LinkedList<>();
			in = new StringTokenizer(br.readLine());
			String line = in.nextToken();
			for (int i = 0; i < line.length(); i++) {
				characters.add(line.charAt(i));
			}
			int count = 1;
			char currentCharacter = characters.poll();
			while (characters.size() != 0) {
				char Char = characters.poll();
				if (Char == currentCharacter) count++;
				else {
					System.out.print(count + " " + currentCharacter + " ");
					count = 1;
					currentCharacter = Char;
				}
			}
			System.out.println(count + " " + currentCharacter);
		}
	}

}