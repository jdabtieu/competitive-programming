import java.util.*;
import java.io.*;

public class btoi07p3 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;

	public static void main(String[] args) throws IOException {
		int samples = readInt(), length = readInt(), deviation = readInt();
		boolean silenceFound = false;
		
		ArrayDeque<Coord> findMax = new ArrayDeque<Coord>();
		ArrayDeque<Coord> findMin = new ArrayDeque<Coord>();
		
		int i = 1;
		for (; i < length; i++) {
			Coord current = new Coord(readInt(), i);
			if (findMax.isEmpty()) findMax.add(current);
			else if (findMax.peek().getX() < current.getX()) {
				findMax.clear();
				findMax.add(current);
			}
			else /* if (findMax.peek().getX() >= current.getX()) */ {
				while (!findMax.isEmpty()) {
					if (findMax.peekLast().getX() < current.getX()) findMax.removeLast();
					else break;
				}
				findMax.add(current);
			}
			
			if (findMin.isEmpty()) findMin.add(current);
			else if (findMin.peek().getX() > current.getX()) {
				findMin.clear();
				findMin.add(current);
			}
			else /* if (findMin.peek().getX() <= current.getX()) */ {
				while (!findMin.isEmpty()) {
					if (findMin.peekLast().getX() > current.getX()) findMin.removeLast();
					else break;
				}
				findMin.add(current);
			}
		}
		
		
		for (; i <= samples; i++) {
			Coord current = new Coord(readInt(), i);
			if (findMax.isEmpty()) findMax.add(current);
			else if (findMax.peek().getX() < current.getX()) {
				findMax.clear();
				findMax.add(current);
			}
			else /* if (findMax.peek().getX() >= current.getX()) */ {
				while (!findMax.isEmpty()) {
					if (findMax.peekLast().getX() < current.getX()) findMax.removeLast();
					else break;
				}
				findMax.add(current);
			}
			
			while (!findMax.isEmpty()) {
				if (findMax.peek().getY() < i - length + 1) findMax.removeFirst();
				else break;
			}
			
			if (findMin.isEmpty()) findMin.add(current);
			else if (findMin.peek().getX() > current.getX()) {
				findMin.clear();
				findMin.add(current);
			}
			else /* if (findMin.peek().getX() <= current.getX()) */ {
				while (!findMin.isEmpty()) {
					if (findMin.peekLast().getX() > current.getX()) findMin.removeLast();
					else break;
				}
				findMin.add(current);
			}
			
			while (!findMin.isEmpty()) {
				if (findMin.peek().getY() < i - length + 1) findMin.removeFirst();
				else break;
			}
			
			if (findMax.peek().getX() - findMin.peek().getX() <= deviation) {
				System.out.println(i - length + 1);
				silenceFound = true;
			}
			
		}
		
		if (!silenceFound) System.out.println("NONE");
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
	 * @author jdabtieu (jonathan.wu3@outlook.com)
	 * @version Adapted from 1.2.0, 07/11/20
	 */
	private int x;
	private int y;
	
	/**
	 * Constructs a new Coord which stores the coordinate (x, y) in the Cartesian plane.
	 * @see		#setLocation(int, int)
	 * @param x	x-coordiate
	 * @param y	y-coordinate
	 */
	public Coord(int x, int y) {
		setLocation(x, y);
	}
	
	/**
	 * Constructs a new Coord which stores the coordinate (x, y) in the Cartesian plane.
	 * @see		#setLocation(String, String)
	 * @param x	x-coordiate
	 * @param y	y-coordinate
	 */
	public Coord(String x, String y) {
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
	 * Sets the x-coordinate of this Coord.
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
			setLocation(Integer.parseInt(x.trim()), Integer.parseInt(y.trim()));
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
	 * Compares two coordinates using the compareMode (default: XY)
	 * @see 	#setCompareMode(String)
	 * @param 	arg0	the coord being compared against
	 * @return			1 if this > arg0, 0 if this == arg0, -1 if this < arg0
	 */
	public int compareTo(Coord arg0) {
		if (x > arg0.x) return 1;
		if (x == arg0.x) return 0;
		return -1;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Coord))
			return false;
		Coord other = (Coord) obj;
		return x == other.x && y == other.y;
	}
}