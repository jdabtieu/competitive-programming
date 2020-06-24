import java.util.*;
import java.io.*;

public class Main {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;
	
	static final double epsilon = 0.000001;
	static double posX, posY;
	static int bounces = 0;
	static short width, height;
	
	public static void main(String[] args) throws IOException {
		width = readShort();
		height = readShort();
		int oX = readInt(), bR = readInt();
		final int slopeX = width - oX, slopeY =  bR;
		
		posX = oX;
		posY = 0;
		
		for (int i = 65536; i > 0; i--) {
			if (Math.abs(posX - 0) < epsilon) {
				posX = slopeX * (height - posY) / slopeY;
				posY = 0;
			} else {
				posY = slopeY * (width - posX) / slopeX;
				posX = 0;
			}
			if (posX - width > epsilon) {
				bounces += (int) ((posX  + epsilon) / width);
				if (checkCorner(posX % width, posY % height)) {
					while (posX - width > epsilon) {
						bounces--;
						posX -= width;
						if (checkCorner(posX, posY)) {
							System.out.println(bounces);
							return;
						}
					}
				} else {
					posX %= width;
				}
			} else if (posY - height > epsilon) {
				bounces += (int) ((posY  + epsilon) / height);
				if (checkCorner(posX % width, posY % height)) {
					while (posY - height > epsilon) {
						bounces--;
						posY -= height;
						if (checkCorner(posX, posY)) {
							System.out.println(bounces);
							return;
						}
					}
				} else {
					posY %= height;
				}
			} else if (checkCorner(posX, posY)) {
				System.out.println(bounces);
				return;
			}
			bounces++;
		}
		System.out.println(0);
	}
	
	static public boolean checkCorner(double posX, double posY) {
		return ((posX < 5 && posY < 5) || (posX < 5 && posY > height - 5) || (posX > width - 5 && posY < 5) || (posX > width - 5 && posY > height - 5));
	}

	static String next() throws IOException {
		while (in == null || !in.hasMoreTokens())
			in = new StringTokenizer(br.readLine());
		return in.nextToken();
	}

	static long readLong() throws IOException {
		return Long.parseLong(next());
	}

	static short readShort() throws IOException {
		return Short.parseShort(next());
	}
	
	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}

	static double readDouble() throws IOException {
		return Double.parseDouble(next());
	}

	static char readChar() throws IOException {
		return next().charAt(0);
	}

	static String readLine() throws IOException {
		return br.readLine();
	}
}