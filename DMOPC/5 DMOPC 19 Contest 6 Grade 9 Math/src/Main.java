import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
public class Main {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static final DecimalFormat formatter = new DecimalFormat("0.000000");
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer in = new StringTokenizer(br.readLine());
		Coord l1 = new Coord(Integer.parseInt(in.nextToken()), Integer.parseInt(in.nextToken()));
		Coord l1c2 = new Coord(Integer.parseInt(in.nextToken()), Integer.parseInt(in.nextToken()));
		in = new StringTokenizer(br.readLine());
		Coord l2 = new Coord(Integer.parseInt(in.nextToken()), Integer.parseInt(in.nextToken()));
		Coord l2c2 = new Coord(Integer.parseInt(in.nextToken()), Integer.parseInt(in.nextToken()));
		
		long l1slopeNum = l1c2.getY() - l1.getY();
		long l1slopeDen = l1c2.getX() - l1.getX();
		
		long l2slopeNum = l2c2.getY() - l2.getY();
		long l2slopeDen = l2c2.getX() - l2.getX();
		
		if (l1slopeNum*l2slopeDen == l1slopeDen*l2slopeNum) {
			if (l2slopeDen * (l1.getY() - l2.getY()) == l2slopeNum * (l1.getX() - l2.getX())) {
				System.out.println("coincident");
			} else {
				System.out.println("parallel");
			}
			System.exit(0);
		}
		System.out.print(formatter.format((0.00000001 - 0.00000001 + l2.getY()*l1slopeDen*l2slopeDen - l1slopeDen*l2slopeNum*l2.getX() - l1.getY()*l1slopeDen*l2slopeDen + l2slopeDen*l1slopeNum*l1.getX())/(l2slopeDen * l1slopeNum - l1slopeDen * l2slopeNum)));
		System.out.print(" ");
		System.out.println(formatter.format((0.00000001 - 0.00000001 + l1slopeNum * l2slopeNum * l2.getX() - l2.getY() * l1slopeNum * l2slopeDen - l1slopeNum * l2slopeNum * l1.getX() + l1.getY() * l2slopeNum * l1slopeDen)/(l1slopeDen * l2slopeNum - l2slopeDen * l1slopeNum)));
	}

}
class Coord {
	private long[] coord = new long[2];
	Coord(int x, int y) {
		coord[0] = x;
		coord[1] = y;
	}
	
	public long getX() {
		return coord[0];
	}
	
	public long getY() {
		return coord[1];
	}
}