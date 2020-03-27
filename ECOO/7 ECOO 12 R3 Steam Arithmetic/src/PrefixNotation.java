import java.io.*;
import java.util.*;
public class PrefixNotation {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		for (byte cases = 0; cases < 10; cases++) {
			ArrayList<String> in = new ArrayList<String>();
			
			StringTokenizer token = new StringTokenizer(br.readLine());
			while (token.hasMoreTokens()) {
				in.add(token.nextToken());
			}
			
			//Separate inputs in the form of (operation to (, operation
			//Separate inputs in the form of number) to number, )
			for (int i = 0; i < in.size(); i++) {
				if (in.get(i).equalsIgnoreCase("(+")) {
					in.set(i, "(");
					in.add(i + 1, "+");
				} else if (in.get(i).equalsIgnoreCase("(-")) {
					in.set(i, "(");
					in.add(i + 1, "-");
				} else if (in.get(i).equalsIgnoreCase("(*")) {
					in.set(i, "(");
					in.add(i + 1, "*");
				} else if (in.get(i).equalsIgnoreCase("(q")) {
					in.set(i, "(");
					in.add(i + 1, "q");
				} else if (in.get(i).equalsIgnoreCase("(r")) {
					in.set(i, "(");
					in.add(i + 1, "r");
				}
				if (in.get(i).indexOf(")") == 1) {
					String temp = in.get(i);
					in.set(i, in.get(i).replaceAll("[^\\d.]", ""));
					in.add(i + 1, temp.replaceAll("[0-9]", ""));
				}
			}
			
			while (!(in.size() == 1 || in.size() == 2)) {
				for (int i = 0; i < in.size() - 3; i++) {
					if ((in.get(i).equals("+") || in.get(i).equals("-") || in.get(i).equals("*") || in.get(i).equals("q") || in.get(i).equals("r"))&& !in.get(i + 1).equals("(") && !in.get(i + 2).equals("(")) {
						char operation = in.get(i).charAt(0);
						int num1 = Integer.valueOf(in.get(i + 1));
						int num2 = Integer.valueOf(in.get(i + 2));
						int result = 0;
						if (operation == '+') {
							result = num1 + num2;
						} else if (operation == '-') {
							result = num1 - num2;
						} else if (operation == '*') {
							result = num1 * num2;
						} else if (operation == 'q') {
							result = num1 / num2;
						} else {
							result = num1 % num2;
						}
						
						in.set(i, result + "");
						
						in.remove(i + 1);
						
						in.remove(i + 1);
						
						if (in.get(i + 1).length() == 1) {
							in.remove(i + 1);
						} else {
							in.set(i + 1, in.get(i + 1).substring(1));
						}
						
						in.remove(i - 1);
					}
				}
			}
			System.out.println(in.get(0));
		}
	}
}
