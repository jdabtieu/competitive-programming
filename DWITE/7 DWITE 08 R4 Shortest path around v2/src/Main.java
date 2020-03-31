import java.util.*;
import java.io.*;
public class Main {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (byte cases = 0; cases < 5; cases++) {
			int[][] grid = new int[8][8];
			Coord start = null, end = null;
			for (byte i = 0; i < 8; i++) {
				String row = br.readLine();
				for (byte j = 0; j < 8; j++) {
					if (row.charAt(j) == '#') grid[i][j] = -1;
					else if (row.charAt(j) == 'A') start = new Coord(i, j);
					else if (row.charAt(j) == 'B') end = new Coord(i, j);
				}
			}
			Queue<Coord> queue = new LinkedList<>();
			queue.add(start);
			while (!queue.isEmpty()) {
				Coord coord = queue.poll();
				if (coord.equals(end)) {
					break;
				}
				if (coord.getX() != 0) {
					if (grid[coord.getX()-1][coord.getY()] > grid[coord.getX()][coord.getY()]+1 || grid[coord.getX()-1][coord.getY()] == 0) {
						grid[coord.getX()-1][coord.getY()] = grid[coord.getX()][coord.getY()] + 1;
						queue.add(new Coord(coord.getX()-1, coord.getY()));
					}
					if (coord.getY() != 0) {
						if (grid[coord.getX()-1][coord.getY()-1] > grid[coord.getX()][coord.getY()]+1 || grid[coord.getX()-1][coord.getY()-1] == 0) {
							grid[coord.getX()-1][coord.getY()-1] = grid[coord.getX()][coord.getY()] + 1;
							queue.add(new Coord(coord.getX()-1, coord.getY()-1));
						}
					}
					if (coord.getY() != 7) {
						if (grid[coord.getX()-1][coord.getY()+1] > grid[coord.getX()][coord.getY()]+1 || grid[coord.getX()-1][coord.getY()+1] == 0) {
							grid[coord.getX()-1][coord.getY()+1] = grid[coord.getX()][coord.getY()] + 1;
							queue.add(new Coord(coord.getX()-1, coord.getY()+1));
						}
					}
				}
				if (coord.getX() != 7) {
					if (grid[coord.getX()+1][coord.getY()] > grid[coord.getX()][coord.getY()]+1 || grid[coord.getX()+1][coord.getY()] == 0) {
						grid[coord.getX()+1][coord.getY()] = grid[coord.getX()][coord.getY()] + 1;
						queue.add(new Coord(coord.getX()+1, coord.getY()));
					}
					if (coord.getY() != 0) {
						if (grid[coord.getX()+1][coord.getY()-1] > grid[coord.getX()][coord.getY()]+1 || grid[coord.getX()+1][coord.getY()-1] == 0) {
							grid[coord.getX()+1][coord.getY()-1] = grid[coord.getX()][coord.getY()] + 1;
							queue.add(new Coord(coord.getX()+1, coord.getY()-1));
						}
					}
					if (coord.getY() != 7) {
						if (grid[coord.getX()+1][coord.getY()+1] > grid[coord.getX()][coord.getY()]+1 || grid[coord.getX()+1][coord.getY()+1] == 0) {
							grid[coord.getX()+1][coord.getY()+1] = grid[coord.getX()][coord.getY()] + 1;
							queue.add(new Coord(coord.getX()+1, coord.getY()+1));
						}
					}
				}
				if (coord.getY() != 7) {
					if (grid[coord.getX()][coord.getY()+1] > grid[coord.getX()][coord.getY()]+1 || grid[coord.getX()][coord.getY()+1] == 0) {
						grid[coord.getX()][coord.getY()+1] = grid[coord.getX()][coord.getY()] + 1;
						queue.add(new Coord(coord.getX(), coord.getY()+1));
					}
				}
				if (coord.getY() != 0) {
					if (grid[coord.getX()][coord.getY()-1] > grid[coord.getX()][coord.getY()]+1 || grid[coord.getX()][coord.getY()-1] == 0) {
						grid[coord.getX()][coord.getY()-1] = grid[coord.getX()][coord.getY()] + 1;
						queue.add(new Coord(coord.getX(), coord.getY()-1));
					}
				}
			}
			System.out.println(grid[end.getX()][end.getY()]);
		}
	}

}

class Coord implements Comparable<Coord> {
	/**
	 * @author jdabtieu
	 * @version 1.0, 03/30/20
	 */
	private int x;
	private int y;
	private static String compareMode = "XY";
	
	/**
	 * Constructs a new Coord which stores the coordinate (x, y) in the Cartesian plane.
	 * @param x	x-coordiate
	 * @param y	y-coordinate
	 */
	Coord(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Constructs a new Coord which stores the coordinate (x, y) in the Cartesian plane.
	 * @param x	x-coordiate
	 * @param y	y-coordinate
	 */
	Coord(String x, String y) {
		try {
			this.x = Integer.parseInt(x);
			this.y = Integer.parseInt(y);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
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
	 * Sets the compare mode of Coords (default: XY).
	 * XY: X first, then Y
	 * YX: Y first, then X
	 * X: compare X only
	 * Y: compare Y only
	 * DIST: distance from origin, further away is higher
	 * @param 	newMode		new compare mode of Coords
	 */
	public void setCompareMode(String newMode) {
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
	
}
