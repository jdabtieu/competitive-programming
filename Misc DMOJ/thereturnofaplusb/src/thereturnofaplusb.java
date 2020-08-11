import java.io.*;
import java.util.StringTokenizer;

public class thereturnofaplusb {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 * This solution is based heavily on https://stackoverflow.com/questions/59640101/unable-to-solve-simple-dmoj-math-question with a few optimizations
	 */
    private static final String[] EN_VALUES = new String[] { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten" };
    private static final String[] FR_VALUES = new String[] { "un", "deux", "trois", "quatre", "cinq", "seis", "sept", "huit", "neuf", "dix" };
    private static final String[] CN_VALUES = new String[] { "一", "二", "三", "四", "五", "六", "七", "八", "九", "十"};

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
        for (int i = Integer.parseInt(br.readLine()); i > 0; i--) {
	        StringTokenizer in = new StringTokenizer(br.readLine());
	        System.out.println(parseNum(in.nextToken()) + parseNum(in.nextToken()));
        }
    }

    private static int parseNum(String token) {
    	try {return Integer.parseInt(token);}
		catch (NumberFormatException e) {
			for (int i = 0; i < 10; i++) {
	            if (token.equalsIgnoreCase(EN_VALUES[i]) || token.equalsIgnoreCase(FR_VALUES[i]) || token.equalsIgnoreCase(CN_VALUES[i])) {
	                return i + 1;
	            }
	        }
		}
        throw new IllegalStateException();
    }
}