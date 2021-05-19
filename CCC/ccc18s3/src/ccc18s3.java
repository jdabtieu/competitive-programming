import java.util.*;
import java.io.*;

public class ccc18s3 {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    static Queue<Coord> queue = new LinkedList<Coord>();
    static int[][] grid;
    static int[][] dist;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        Coord begin = null;
        int rows = readInt(), cols = readInt();
        grid = new int[rows][cols];
        dist = new int[rows][cols];
        visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            String s = readLine();
            for (int j = 0; j < cols; j++) {
                switch(s.charAt(j)) {
                case 'W':
                    grid[i][j] = -2;
                    visited[i][j] = true;
                    break;
                case '.':
                    grid[i][j] = -1;
                    break;
                case 'C':
                    grid[i][j] = -3;
                    visited[i][j] = true;
                    break;
                case 'S':
                    // grid[i][j] == 0;
                    begin = new Coord(i, j);
                    break;
                case 'L':
                    grid[i][j] = -6;
                    break;
                case 'R':
                    grid[i][j] = -8;
                    break;
                case 'U':
                    grid[i][j] = -5;
                    break;
                case 'D':
                    grid[i][j] = -7;
                    break;
                }
            }
        }
        /*
         *   -1: empty
         * x -2: wall
         * x -3: camera
         *   -4: covered by camera
         *   -5: up
         *   -6: left
         *   -7: down
         *   -8: right
         */
        // calculate cameras
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] != -3) continue;
                // up
                for (int r = i - 1; r >= 0; r--) {
                    if (grid[r][j] == -2 || grid[r][j] == -3) break;
                    if (grid[r][j] < -1) continue;
                    grid[r][j] = -4;
                }
                // down
                for (int r = i + 1; r < rows; r++) {
                    if (grid[r][j] == -2 || grid[r][j] == -3) break;
                    if (grid[r][j] < -1) continue;
                    grid[r][j] = -4;
                }
                // left
                for (int c = j - 1; c >= 0; c--) {
                    if (grid[i][c] == -2 || grid[i][c] == -3) break;
                    if (grid[i][c] < -1) continue;
                    grid[i][c] = -4;
                }
                // right
                for (int c = j + 1; c < cols; c++) {
                    if (grid[i][c] == -2 || grid[i][c] == -3) break;
                    if (grid[i][c] < -1) continue;
                    grid[i][c] = -4;
                }
            }
        }
        /*
         *   -1: empty
         * x -2: wall
         * x -3: camera
         * x -4: covered by camera
         *   -5: up
         *   -6: left
         *   -7: down
         *   -8: right
         */
        // bfs
        if (grid[begin.getX()][begin.getY()] == -4) {
            grid[begin.getX()][begin.getY()] = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == -1 || grid[i][j] == -4) {
                        System.out.println(-1);
                    }
                }
            }
            return;
        }
        queue.add(begin);
        visited[begin.getX()][begin.getY()] = true;
        while (!queue.isEmpty()) {
            Coord curr = queue.poll();
            if (!visited[curr.getX() - 1][curr.getY()]) {
                visited[curr.getX() - 1][curr.getY()] = true;
                if (grid[curr.getX() - 1][curr.getY()] == -1) {
                    dist[curr.getX() - 1][curr.getY()] = dist[curr.getX()][curr.getY()] + 1;
                    queue.add(new Coord(curr.getX() - 1, curr.getY()));
                } else if (grid[curr.getX() - 1][curr.getY()] < -4) {
                    dist[curr.getX() - 1][curr.getY()] = dist[curr.getX()][curr.getY()] + 1;
                    Coord res = conveyor(curr.getX() - 1, curr.getY());
                    if (res != null) {
                        queue.add(new Coord(res.getX(), res.getY()));
                    }
                }
            }
            if (!visited[curr.getX() + 1][curr.getY()]) {
                visited[curr.getX() + 1][curr.getY()] = true;
                if (grid[curr.getX() + 1][curr.getY()] == -1) {
                    dist[curr.getX() + 1][curr.getY()] = dist[curr.getX()][curr.getY()] + 1;
                    queue.add(new Coord(curr.getX() + 1, curr.getY()));
                } else if (grid[curr.getX() + 1][curr.getY()] < -4) {
                    dist[curr.getX() + 1][curr.getY()] = dist[curr.getX()][curr.getY()] + 1;
                    Coord res = conveyor(curr.getX() + 1, curr.getY());
                    if (res != null) {
                        queue.add(new Coord(res.getX(), res.getY()));
                    }
                }
            }
            if (!visited[curr.getX()][curr.getY() - 1]) {
                visited[curr.getX()][curr.getY() - 1] = true;
                if (grid[curr.getX()][curr.getY() - 1] == -1) {
                    dist[curr.getX()][curr.getY() - 1] = dist[curr.getX()][curr.getY()] + 1;
                    queue.add(new Coord(curr.getX(), curr.getY() - 1));
                } else if (grid[curr.getX()][curr.getY() - 1] < -4) {
                    dist[curr.getX()][curr.getY() - 1] = dist[curr.getX()][curr.getY()] + 1;
                    Coord res = conveyor(curr.getX(), curr.getY() - 1);
                    if (res != null) {
                        queue.add(new Coord(res.getX(), res.getY()));
                    }
                }
            }
            if (!visited[curr.getX()][curr.getY() + 1]) {
                visited[curr.getX()][curr.getY() + 1] = true;
                if (grid[curr.getX()][curr.getY() + 1] == -1) {
                    dist[curr.getX()][curr.getY() + 1] = dist[curr.getX()][curr.getY()] + 1;
                    queue.add(new Coord(curr.getX(), curr.getY() + 1));
                } else if (grid[curr.getX()][curr.getY() + 1] < -4) {
                    dist[curr.getX()][curr.getY() + 1] = dist[curr.getX()][curr.getY()] + 1;
                    Coord res = conveyor(curr.getX(), curr.getY() + 1);
                    if (res != null) {
                        queue.add(new Coord(res.getX(), res.getY()));
                    }
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == -4) {
                    System.out.println(-1);
                }
                if (grid[i][j] == -1) {
                    System.out.println(dist[i][j] > 0 ? dist[i][j] : -1);
                }
            }
        }
    }
    /*
     *   -1: empty
     * x -2: wall
     * x -3: camera
     * x -4: covered by camera
     *   -5: up
     *   -6: left
     *   -7: down
     *   -8: right
     * x -9: impossible conveyor
     */
    final static List<Integer> BANNED = Arrays.asList(-2, -3, -4, -9);
    static Coord conveyor(int r, int c) {
        visited[r][c] = true;
        if (BANNED.contains(grid[r][c])) {
            return null;
        }
        if (grid[r][c] == -5) {
            if (visited[r - 1][c]) {
                return grid[r - 1][c] >= -1 ? new Coord(r - 1, c) : null;
            }
            dist[r - 1][c] = dist[r][c];
            Coord res = conveyor(r - 1, c);
            if (res == null) {
                grid[r][c] = -9;
                return null;
            }
            return res;
        } else if (grid[r][c] == -7) {
            if (visited[r + 1][c]) {
                return grid[r + 1][c] >= -1 ? new Coord(r + 1, c) : null;
            }
            dist[r + 1][c] = dist[r][c];
            Coord res = conveyor(r + 1, c);
            if (res == null) {
                grid[r][c] = -9;
                return null;
            }
            return res;
        } else if (grid[r][c] == -6) {
            if (visited[r][c - 1]) {
                return grid[r][c - 1] >= -1 ? new Coord(r, c - 1) : null;
            }
            dist[r][c - 1] = dist[r][c];
            Coord res = conveyor(r, c - 1);
            if (res == null) {
                grid[r][c] = -9;
                return null;
            }
            return res;
        } else if (grid[r][c] == -8) {
            if (visited[r][c + 1]) {
                return grid[r][c + 1] >= -1 ? new Coord(r, c + 1) : null;
            }
            dist[r][c + 1] = dist[r][c];
            Coord res = conveyor(r, c + 1);
            if (res == null) {
                grid[r][c] = -9;
                return null;
            }
            return res;
        } else {
            return grid[r][c] > -2  ? new Coord(r, c) : null;
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