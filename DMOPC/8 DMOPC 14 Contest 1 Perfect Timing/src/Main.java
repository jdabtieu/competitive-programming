import java.util.*;
import java.io.*;
import java.text.*;
public class Main {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static DecimalFormat notYear = new DecimalFormat("00");
	static DecimalFormat yesYear = new DecimalFormat("0000");
	static final int[] DAYS_IN_MONTH = {0, 31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private static boolean isLeapYear (int year) {
		return (year % 4 == 0 && year % 100 != 0 || year % 100 == 0 && year % 400 == 0) ? true : false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer in = new StringTokenizer(br.readLine());
		Coord start = new Coord(in.nextToken(), in.nextToken());
		in = new StringTokenizer(br.readLine());
		Coord end = new Coord(in.nextToken(), in.nextToken());
		String temp = br.readLine();
		int year = Integer.parseInt(temp.substring(0, 4));
		int month = Integer.parseInt(temp.substring(5, 7));
		int day = Integer.parseInt(temp.substring(8, 10));
		int hour = Integer.parseInt(temp.substring(11, 13));
		int min = Integer.parseInt(temp.substring(14, 16));
		int sec = Integer.parseInt(temp.substring(17, 19));
		sec += Math.abs(start.getX() - end.getX()) + Math.abs(start.getY() - end.getY());
		if (sec >= 60) {
			min += sec / 60;
			sec %= 60;
		}
		if (min >= 60) {
			hour += min / 60;
			min %= 60;
		}
		if (hour >= 24) {
			day += hour / 24;
			hour %= 24;
		}
		while (day > DAYS_IN_MONTH[month]) {
			if (month != 2) {
				day -= DAYS_IN_MONTH[month];
				month++;
			} else {
				if (day <= 28 && !isLeapYear(year) || day <= 29 && isLeapYear(year)) break;
				day -= isLeapYear(year) ? 29 : 28;
				month++;
			}
			if (month == 13) {
				month = 1;
				year++;
			}
		}
		
		
		System.out.printf("%s:%s:%s:%s:%s:%s\n", yesYear.format(year), notYear.format(month), notYear.format(day), notYear.format(hour), notYear.format(min), notYear.format(sec));
		
	}

}
class Coord {
	private int[] coord = new int[2];
	Coord(int x, int y) {
		coord[0] = x;
		coord[1] = y;
	}
	
	Coord(String x, String y) {
		coord[0] = Integer.parseInt(x);
		coord[1] = Integer.parseInt(y);
	}
	
	public int getX() {
		return coord[0];
	}
	
	public int getY() {
		return coord[1];
	}
}