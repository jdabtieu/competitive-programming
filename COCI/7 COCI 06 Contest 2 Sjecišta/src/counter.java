import java.util.*;
import jave.io.*;
public class Main {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) throws IOException {
        	int a = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        	System.out.println(a*(a - 1)*(a - 2)*(a - 3)/24);
	}
}