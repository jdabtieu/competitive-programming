import java.io.*;
public class nccc2j1 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] a = br.readLine().split(" ");
		System.out.println(Integer.parseInt(a[0])+Integer.parseInt(a[2])==Integer.parseInt(a[4]) ? "True" : "False");
	}

}