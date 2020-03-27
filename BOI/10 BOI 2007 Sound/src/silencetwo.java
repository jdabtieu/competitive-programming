import java.util.*;
import java.io.*;
public class silencetwo {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 * Currently in progress
	 */
	static boolean silentEnough (int[] values, short silenceLength, short silenceTolerance) {
		//Returns boolean silence so we can determine in main() whether we need to print NONE or not
		boolean silence = false;
		
		//Check if the difference exceeds the tolerance threshold
		//For loops run as if an array stores a, b, c, d, it will compare a to b, a to c, a to d, b to c, b to d, and then c to d
		for (int i = 0; i <= values.length - silenceLength; i++) {
			int difference = 0;
			for (int j = 1; j < silenceLength; j++) {
				difference += values[i + j];
				
				//If absolute value of difference (minus the offset, 1e+6) is greater than silenceTolerance check next value of i
				if (Math.abs(difference - 1000000) > silenceTolerance) {
					break;
				} else if (j == silenceLength - 1) { //Else keep checking until m-1 differences have been checked or too loud
					silence = true;
					System.out.println((i + 1));
				}
				difference -= 1000000;
			}
		}
		return silence;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//For reading line 1 of input
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//For reading line 2 of input
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		
		//Create array that store n samples, get silence period and maximum noise difference 
		int[] samples = new int[Integer.parseInt(st.nextToken())];
		short silencePeriod = Short.parseShort(st.nextToken());
		short maxNoise = Short.parseShort(st.nextToken());
		
		//Fill samples array as a difference array, offset by 1e+6 to avoid negative numbers in array
		int previousEntry = Integer.parseInt(st1.nextToken());
		samples[0] = 1000000;
		for (int i = 1; i < samples.length; i++) {
			int memory = Integer.parseInt(st1.nextToken());
			samples[i] = memory - previousEntry + 1000000;
			previousEntry = memory;
		}
		
		//Close BufferedReader
		br.close();
		
		//Run silentEnough (if no silence are detected print none)
		if (!silentEnough (samples, silencePeriod, maxNoise)) {
			System.out.println("NONE");
		}
	}
}