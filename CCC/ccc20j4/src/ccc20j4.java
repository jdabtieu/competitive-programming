import java.io.*;
public class ccc20j4 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String text = br.readLine();
		String s = br.readLine();
		for (int i = 0; i < s.length(); i++) {
			if (text.contains(s)) {
				System.out.println("yes");
				System.exit(0);
			}
			s = s.substring(1) + s.charAt(0);
		}
		System.out.println("no");
	}

}
