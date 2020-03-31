import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
    public static void main(String args[]) throws IOException { 
		   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		   StringTokenizer in = new StringTokenizer(br.readLine());
		   int numAssessments = Integer.parseInt(in.nextToken());
		   int markSum = 0;
		   byte[] marks = new byte[numAssessments];
		   in = new StringTokenizer(br.readLine());
		   for (int i = 0; i < numAssessments; i++) {
			   marks[i] = Byte.parseByte(in.nextToken());
			   markSum += marks[i];
		   }
		   Arrays.sort(marks);
		   if (numAssessments % 2 == 1) {
			   System.out.println((numAssessments * marks[(marks.length - 1) / 2] > markSum) ? "Winnie should take the risk" : "That's too risky");
		   }
		   else {
			   System.out.println((numAssessments * marks[marks.length / 2 - 1] > markSum)  ? "Winnie should take the risk" : "That's too risky");
		   }
    } 

}