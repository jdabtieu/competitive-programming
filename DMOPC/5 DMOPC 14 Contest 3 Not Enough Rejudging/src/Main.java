import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer in = new StringTokenizer(br.readLine());
		short submissions = Short.parseShort(in.nextToken());
		String[] inputs = new String[submissions];
		short WAtoAC = 0;
		for (int i = 0; i < submissions; i++) {
			in = new StringTokenizer(br.readLine());
			inputs[i] = in.nextToken();
			if (inputs[i].equals("WA")) WAtoAC++;
		}
		
		WAtoAC = (short) (WAtoAC * 3 / 10);
		short first10IR = 10;
		short next10IR = 10;
		for (short i = 0; i < submissions; i++) {
			if (inputs[i].equals("AC")) System.out.println("AC");
			else {
				if (inputs[i].equals("WA")) {
					if (WAtoAC > 0) {
						System.out.println("AC");
						WAtoAC--;
					} else System.out.println("WA");
				} else if (inputs[i].equals("TLE")) System.out.println("WA");
				else {
					if (first10IR > 0) {
						System.out.println("AC");
						first10IR--;
					} else if (next10IR > 0) {
						System.out.println("WA");
						next10IR--;
					} else System.out.println("IR");
				}
			}
		}
	}

}