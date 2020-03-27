import java.io.*;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class Time {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) throws IOException {
		DecimalFormat df = new DecimalFormat("00");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer in = new StringTokenizer(br.readLine());
		
		int microwaveSeconds = Integer.parseInt(in.nextToken());
		
		in = new StringTokenizer(br.readLine());
		String token1 = in.nextToken();
		int currentYear = Integer.parseInt(token1.substring(0, 4));
		int currentMonth = Integer.parseInt(token1.substring(5, 7));
		int currentDay = Integer.parseInt(token1.substring(8));
		token1 = in.nextToken();
		int currentHour = Integer.parseInt(token1.substring(0, 2));
		int currentMinute = Integer.parseInt(token1.substring(3, 5));
		int currentSecond = Integer.parseInt(token1.substring(6));
		
		currentHour -= microwaveSeconds;
		
		if (currentHour >= 0) {
			System.out.println(currentYear + "/" + df.format(currentMonth) + "/" + df.format(currentDay) + " " + df.format(currentHour) + ":" + df.format(currentMinute) + ":" + df.format(currentSecond));
			System.exit(0);
		}
		
		int unitToGoBack = (-1 * currentHour - 1) / 24 + 1;
		currentDay -= unitToGoBack;
		currentHour = 24 - ((-1 * currentHour) % 24);
		if (currentHour == 24) currentHour = 0;
		if (currentDay > 0) {
			System.out.println(currentYear + "/" + df.format(currentMonth) + "/" + df.format(currentDay) + " " + df.format(currentHour) + ":" + df.format(currentMinute) + ":" + df.format(currentSecond));
			System.exit(0);
		}
		
		byte[] key = {31, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		while (!(currentDay > 0)) {
			currentMonth--;
			if(currentMonth == 0) {
				currentMonth = 12;
				currentYear--;
			}
			currentDay += key[currentMonth];
		}
		System.out.println(currentYear + "/" + df.format(currentMonth) + "/" + df.format(currentDay) + " " + df.format(currentHour) + ":" + df.format(currentMinute) + ":" + df.format(currentSecond));
	}
}