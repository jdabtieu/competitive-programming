import java.util.*;
import java.io.*;

public class valentines19s2 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;

	public static void main(String[] args) throws IOException {
		int size = readInt();
		int[] sadRow = new int[size + 1], sadColumn = new int[size + 1];
		TreeMap<Coord, Integer> inv = new TreeMap<>();

		for (int events = readInt(); events > 0; events--) {
			if (readInt() == 1) {
				int i = readInt(), j = readInt();
				sadRow[i]++;
				sadColumn[j]++;
				Coord point = new Coord(i, j);
				Integer temp = inv.get(point);
				if (temp == null) inv.put(point, 1);
				else inv.put(point, temp + 1);
				
			} else {
				boolean happy = true;
				int i = readInt(), j = readInt();
				if (sadRow[i] % 2 == 1) happy = !happy;
				if (sadColumn[j] % 2 == 1) happy = !happy;
				Coord point = new Coord(i, j);
				if (inv.get(point) != null && inv.get(point) % 2 == 1) happy = !happy;
				System.out.println(happy ? 0 : 1);
			}
		}
	}

	static String next() throws IOException {
		while (in == null || !in.hasMoreTokens())
			in = new StringTokenizer(br.readLine());
		return in.nextToken();
	}

	static long readLong() throws IOException {
		return Long.parseLong(next());
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

class Coord implements Comparable<Coord>, Cloneable {
	/**
	 * @author jdabtieu
	 * @version 1.1.1, 05/26/20
	 */
	private int x;
	private int y;

	private static String compareMode = "XY";
	
	/**
	 * Constructs a new Coord which stores the coordinate (x, y) in the Cartesian plane.
	 * @see		#setLocation(int, int)
	 * @param x	x-coordiate
	 * @param y	y-coordinate
	 */
	Coord(int x, int y) {
		setLocation(x, y);
	}
	
	/**
	 * Constructs a new Coord which stores the coordinate (x, y) in the Cartesian plane.
	 * @see		#setLocation(String, String)
	 * @param x	x-coordiate
	 * @param y	y-coordinate
	 */
	Coord(String x, String y) {
		setLocation(x, y);
	}
	
	/**
	 * Gets the x-coordinate of this Coord.
	 * @return this Coordinate's x-value
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Gets the y-coordinate of this Coord.
	 * @return this Coordinate's y-value
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Sets the y-coordinate of this Coord.
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Sets the y-coordinate of this Coord.
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Sets the location of this Coord to (x,y)
	 * @param x new x-coordinate
	 * @param y new y-coordinate
	 */
	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Sets the location of this Coord to (x,y)
	 * @param x new x-coordinate
	 * @param y new y-coordinate
	 */
	public void setLocation(String x, String y) {
		try {
			this.x = Integer.parseInt(x.trim());
			this.y = Integer.parseInt(y.trim());
		} catch (NumberFormatException e) {
			throw new NumberFormatException("One or more parameters is not an integer.");
		}
		
	}
	
	/**
	 * Move this Coord to (x+dx, y+dy)
	 * @see	     #translate(long, long)
	 * @param dx Amount to move Coord by in the x-direction
	 * @param dy Amount to move Coord by in the y-direction
	 */
	public void translate(int dx, int dy) {
		translate((long) dx, (long) dy);
	}
	
	/**
	 * Move this Coord to (x+dx, y+dy)
	 * @param dx Amount to move Coord by in the x-direction
	 * @param dy Amount to move Coord by in the y-direction
	 */
	public void translate(long dx, long dy) {
		if (x + dx > Integer.MAX_VALUE || x + dx < Integer.MIN_VALUE)
			throw new ArithmeticException("Cannot move past (2^31)-1 or -2^31");
		if (y + dy > Integer.MAX_VALUE || y + dy < Integer.MIN_VALUE)
			throw new ArithmeticException("Cannot move past (2^31)-1 or -2^31");
		x += dx;
		y += dy;
	}
	
	/**
	 * Move this Coord to (x+dx, y+dy)
	 * @see      #translate(long, long)
	 * @param dx Amount to move Coord by in the x-direction
	 * @param dy Amount to move Coord by in the y-direction
	 */
	public void translate(String dx, String dy) {
		try {
			translate(Long.parseLong(dx.trim()), Long.parseLong(dy.trim()));
		} catch (NumberFormatException e) {
			throw new NumberFormatException("One or more parameters is not an integer.");
		}
	}
	
	/**
	 * Gets the straight-line distance from this to arg0
	 * @param arg0 Coord to calculate distance to
	 * @return	   Distance between this and arg0
	 */
	public double distanceTo(Coord arg0) {
		return Math.sqrt(((long) arg0.x - this.x) *  ((long) arg0.x - this.x) + ((long) arg0.y - this.y) * ((long) arg0.y - this.y));
	}
	
	/**
	 * Sets the compare mode of Coords (default: XY).
	 * 
	 * XY: X first, then Y
	 * 
	 * YX: Y first, then X
	 * 
	 * X: compare X only
	 * 
	 * Y: compare Y only
	 * 
	 * DIST: distance from origin, further away is higher
	 * @param newMode new compare mode of Coords
	 */
	public static void setCompareMode(String newMode) {
		newMode = newMode.toUpperCase();
		if (newMode.equals("XY") || newMode.equals("YX") || newMode.equals("X") || newMode.equals("Y") || newMode.equals("DIST")) {
			compareMode = newMode;
			return;
		}
		throw new IllegalArgumentException("Illegal compare mode. Please refer to documentation.");
	}
	/**
	 * Compares two coordinates using the compareMode (default: XY)
	 * @see 	#setCompareMode(String)
	 * @param 	arg0	the coord being compared against
	 * @return			1 if this > arg0, 0 if this == arg0, -1 if this < arg0
	 */
	public int compareTo(Coord arg0) {
		if (compareMode.equals("XY")) {
			if (x > arg0.x || (x == arg0.x && y > arg0.y)) return 1;
			if (x == arg0.x && y == arg0.y) return 0;
			return -1;
		}
		if (compareMode.equals("YX")) {
			if (y > arg0.y || (y == arg0.y && x > arg0.x)) return 1;
			if (y == arg0.y && x == arg0.x) return 0;
			return -1;
		}
		if (compareMode.equals("X")) {
			if (x > arg0.x) return 1;
			if (x == arg0.x) return 0;
			return -1;
		}
		if (compareMode.equals("Y")) {
			if (y > arg0.y) return 1;
			if (y == arg0.y) return 0;
			return -1;
		}
		if (compareMode.equals("DIST")) {
			long c1DistSquared = (long) x * x + (long) y * y;
			long c2DistSquared = (long) arg0.x * arg0.x + (long) arg0.y * arg0.y;
			if (c1DistSquared > c2DistSquared) return 1;
			if (c1DistSquared == c2DistSquared) return 0;
			return -1;
		}
		throw new IllegalStateException("Invalid compareMode or no compareMode found.");
	}
	
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
	
	@Override
	public Coord clone() {
		return new Coord(x, y);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Coord)) return false;
		Coord c = (Coord) obj;
		return c.x == x && c.y == y;
	}
}