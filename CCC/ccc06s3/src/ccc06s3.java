import java.util.*;
import java.io.*;

public class ccc06s3 {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        Coord start = new Coord(readInt(), readInt());
        Coord end = new Coord(readInt(), readInt());
        double slope = 1.0 * (end.getY() - start.getY()) / (end.getX() - start.getX());
        boolean vertical = Double.isInfinite(slope);
        
        ArrayList<Shape> shapes = new ArrayList<Shape>();
        
        for (int i = readInt(); i > 0; i--) {
            Shape shape = new Shape();
            for (int j = readInt(); j > 0; j--) {
                shape.coords.add(new Coord(readInt(), readInt()));
            }
            shapes.add(shape);
        }
        
        int blockcnt = 0;
        for (Shape building : shapes) {
            boolean blocked = false;
            for (Coord coord : building.coords) {
                if (coord.getX() > end.getX() || coord.getX() < start.getX()) continue;
                if (Math.abs(slope * (coord.getX() - start.getX()) + start.getY() - coord.getY()) < 0.00001 || (vertical && coord.getX() == start.getX())) {
                    // line passes through corner
                    blocked = true;
                    break;
                }
            }
            
            if (blocked) {
                blockcnt++;
                continue;
            }
            
            for (int i = 1; i < building.coords.size(); i++) {
                Coord s = building.coords.get(i-1);
                Coord e = building.coords.get(i);
                
                int tmp = 0;
                double l1y = slope * (s.getX() - start.getX()) + start.getY();
                double l2y = slope * (e.getX() - start.getX()) + start.getY();
                
                if (s.getX() == e.getX()) {
                    // vertical line
                    if ((l1y < e.getY() && l1y > s.getY()) || (l1y < s.getY() && l1y > e.getY())) {
                        blocked = true;
                        break;
                    }
                }
                
                if (l1y > s.getY()) tmp++;
                else tmp--;
                
                if (l2y > s.getY()) tmp++;
                else tmp--;
                
                if (tmp == 0) {
                    // check if the intersection point is out of bounds
                    double m2 = 1.0*(e.getY()-s.getY())/(e.getX()-s.getX());
                    double calc = (slope * start.getX() - start.getY() - m2 * s.getX() + s.getY()) / (slope - m2);
                    if (calc >= start.getX() && calc <= end.getX()) {
                        blocked = true;
                        break;
                    }
                }
                if (vertical) {
                    double m2 = 1.0*(e.getY()-s.getY())/(e.getX()-s.getX());
                    double calc = m2 * (start.getX() - s.getX()) + s.getY();
                    if (calc >= start.getY() && calc <= end.getY()) {
                        blocked = true;
                        break;
                    }
                }
            }
            {
                Coord s = building.coords.get(building.coords.size() - 1);
                Coord e = building.coords.get(0);
                int tmp = 0;
                double l1y = slope * (s.getX() - start.getX()) + start.getY();
                double l2y = slope * (e.getX() - start.getX()) + start.getY();
                
                if (s.getX() == e.getX()) {
                    // vertical line
                    if ((l1y < e.getY() && l1y > s.getY()) || (l1y < s.getY() && l1y > e.getY())) {
                        blocked = true;
                        break;
                    }
                }
                
                if (l1y > s.getY()) tmp++;
                else tmp--;
                
                if (l2y > s.getY()) tmp++;
                else tmp--;
                
                if (tmp == 0) {
                    // check if the intersection point is out of bounds
                    double m2 = 1.0*(e.getY()-s.getY())/(e.getX()-s.getX());
                    double calc = (slope * start.getX() - start.getY() - m2 * s.getX() + s.getY()) / (slope - m2);
                    if (calc >= start.getX() && calc <= end.getX()) {
                        blocked = true;
                    }
                }
            }
            if (blocked) blockcnt++;
        }
        
        System.out.println(blockcnt);
    }
    
    public static class Shape {
        ArrayList<Coord> coords;
        
        public Shape() {
            coords = new ArrayList<Coord>();
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
     * @author jdabtieu (jonathan.wu3@outlook.com)
     * @version 1.3.0, 01/14/21
     */
    public static final Coord ORIGIN = new Coord(0, 0);
    private int x;
    private int y;
    
    private static String compareMode = "XY";
    
    /**
     * Constructs a new Coord which stores the coordinate (x, y) in the Cartesian plane.
     * @see     #setLocation(int, int)
     * @param x x-coordiate
     * @param y y-coordinate
     */
    public Coord(int x, int y) {
        setLocation(x, y);
    }
    
    /**
     * Constructs a new Coord which stores the coordinate (x, y) in the Cartesian plane.
     * @see     #setLocation(String, String)
     * @param x x-coordiate
     * @param y y-coordinate
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
     * @see      #translate(long, long)
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
     * Gets the Euclidean distance from this to arg0
     * @param arg0 Coord to calculate distance to
     * @return     Euclidean distance between this and arg0
     * @deprecated
     */
    @Deprecated
    public double distanceTo(Coord arg0) {
        return eucDist(arg0);
    }
    
    /**
     * Gets the Euclidean distance from this to arg0
     * @param arg0 Coord to calculate distance to
     * @return     Euclidean distance between this and arg0
     */
    public double eucDist(Coord arg0) {
        return Math.sqrt(((long) arg0.x - this.x) * ((long) arg0.x - this.x) + ((long) arg0.y - this.y) * ((long) arg0.y - this.y));
    }
    
    /**
     * Gets the Manhattan distance from this to arg0
     * @param arg0 Coord to calculate distance to
     * @return     Manhattan distance between this and arg0
     */ 
    public long manDist(Coord arg0) {
        return Math.abs((long) this.x - arg0.x) + Math.abs((long) this.y - arg0.y);
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
     * @see     #setCompareMode(String)
     * @param   arg0    the coord being compared against
     * @return          1 if this > arg0, 0 if this == arg0, -1 if this < arg0
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