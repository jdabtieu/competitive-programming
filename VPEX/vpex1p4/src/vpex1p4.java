import java.io.*;
import java.util.*;

public class vpex1p4 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    static int n;

    static ArrayList<Coord>[] adj;
    static long[] dist;
    static int[] map;
    static Coord[] tour;
    static int maxp2;
    static int[][] tab;

    public static void main(String[] args) throws IOException {
        n = readInt();
        adj = new ArrayList[n + 1];
        dist = new long[n + 1];
        map = new int[n + 1];
        tour = new Coord[2 * n - 1];
        for (int i = 0; i <= n; i++)
            adj[i] = new ArrayList<>();
        int q = readInt();
        for (int i = 1; i < n; i++) {
            int x = readInt(), y = readInt(), d = readInt();
            adj[x].add(new Coord(y, d));
            adj[y].add(new Coord(x, d));
        }
        dfs1(1, 0);
        dfs2(1, 0, 0);
        maxp2 = log2(tour.length) + 1;
        tab = new int[tour.length][maxp2];
        make();
        long[] ans = {0, 0};
        int[] prev = {1, 1};
        while (q-- > 0) {
            int l1 = readInt(), l2 = readInt();
            long d = calc(l1, l2);
            long a0 = Math.min(ans[0] + calc(prev[0], l2) + d, ans[1] + calc(prev[1], l2) + d);
            long a1 = Math.min(ans[0] + calc(prev[0], l1) + d, ans[1] + calc(prev[1], l1) + d);
            ans[0] = a0;
            ans[1] = a1;
            prev[0] = l1;
            prev[1] = l2;
        }
        System.out.println(Math.min(ans[0], ans[1]));
    }
    
    static long calc(int src, int dest) {
        if (src == dest) return 0;
        int ps = map[src], pd = map[dest];
        if (pd < ps) {
            int tmp = ps;
            ps = pd;
            pd = tmp;
            tmp = src;
            src = dest;
            dest = tmp;
        }
        int d = pd - ps;
        int l2 = log2(d);
        
        int ans1 = tab[ps][l2], ans2 = tab[pd - (1 << l2)][l2];
        int lca = tour[ans1].getX() < tour[ans2].getX() ? tour[ans1].getY() : tour[ans2].getY();
        return dist[src] + dist[dest] - 2 * dist[lca];
    }
    
    static void make() {
        for (int i = 0; i < tour.length; i++) {
            tab[i][0] = i;
        }
        
        for (int j = 1; (1 << j) <= tour.length; j++) {
            for (int i = 0; i <= tour.length - (1 << j); i++) {
                if (tour[tab[i][j-1]].getX() < tour[tab[i + (1 << (j-1))][j-1]].getX()) {
                    tab[i][j] = tab[i][j-1];
                } else {
                    tab[i][j] = tab[i + (1 << (j-1))][j-1];
                }
            }
        }
    }

    static int log2(int v) {
        int r = 0xFFFF - v >> 31 & 0x10;
        v >>= r;
        int shift = 0xFF - v >> 31 & 0x8;
        v >>= shift;
        r |= shift;
        shift = 0xF - v >> 31 & 0x4;
        v >>= shift;
        r |= shift;
        shift = 0x3 - v >> 31 & 0x2;
        v >>= shift;
        r |= shift;
        r |= (v >> 1);
        return r;
    }

    static void dfs1(int curr, int pa) {
        for (Coord c : adj[curr]) {
            if (c.getX() == pa)
                continue;
            dist[c.getX()] = dist[curr] + c.getY();
            dfs1(c.getX(), curr);
        }
    }

    static int ptr = 0;

    static void dfs2(int curr, int pa, int deep) {
        map[curr] = ptr;
        tour[ptr++] = new Coord(deep, curr);
        for (Coord c : adj[curr]) {
            if (c.getX() == pa)
                continue;
            dfs2(c.getX(), curr, deep + 1);
            tour[ptr++] = new Coord(deep, curr);
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
     * Constructs a new Coord which stores the coordinate (x, y) in the Cartesian
     * plane.
     * 
     * @see #setLocation(int, int)
     * @param x x-coordiate
     * @param y y-coordinate
     */
    public Coord(int x, int y) {
        setLocation(x, y);
    }

    /**
     * Constructs a new Coord which stores the coordinate (x, y) in the Cartesian
     * plane.
     * 
     * @see #setLocation(String, String)
     * @param x x-coordiate
     * @param y y-coordinate
     */
    public Coord(String x, String y) {
        setLocation(x, y);
    }

    /**
     * Gets the x-coordinate of this Coord.
     * 
     * @return this Coordinate's x-value
     */
    public int getX() {
        return x;
    }

    /**
     * Gets the y-coordinate of this Coord.
     * 
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
     * 
     * @param x new x-coordinate
     * @param y new y-coordinate
     */
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Sets the location of this Coord to (x,y)
     * 
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
     * 
     * @see #translate(long, long)
     * @param dx Amount to move Coord by in the x-direction
     * @param dy Amount to move Coord by in the y-direction
     */
    public void translate(int dx, int dy) {
        translate((long) dx, (long) dy);
    }

    /**
     * Move this Coord to (x+dx, y+dy)
     * 
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
     * 
     * @see #translate(long, long)
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
     * 
     * @param arg0 Coord to calculate distance to
     * @return Euclidean distance between this and arg0
     * @deprecated
     */
    @Deprecated
    public double distanceTo(Coord arg0) {
        return eucDist(arg0);
    }

    /**
     * Gets the Euclidean distance from this to arg0
     * 
     * @param arg0 Coord to calculate distance to
     * @return Euclidean distance between this and arg0
     */
    public double eucDist(Coord arg0) {
        return Math.sqrt(((long) arg0.x - this.x) * ((long) arg0.x - this.x)
                + ((long) arg0.y - this.y) * ((long) arg0.y - this.y));
    }

    /**
     * Gets the Manhattan distance from this to arg0
     * 
     * @param arg0 Coord to calculate distance to
     * @return Manhattan distance between this and arg0
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
     * 
     * @param newMode new compare mode of Coords
     */
    public static void setCompareMode(String newMode) {
        newMode = newMode.toUpperCase();
        if (newMode.equals("XY") || newMode.equals("YX") || newMode.equals("X") || newMode.equals("Y")
                || newMode.equals("DIST")) {
            compareMode = newMode;
            return;
        }
        throw new IllegalArgumentException("Illegal compare mode. Please refer to documentation.");
    }

    /**
     * Compares two coordinates using the compareMode (default: XY)
     * 
     * @see #setCompareMode(String)
     * @param arg0 the coord being compared against
     * @return 1 if this > arg0, 0 if this == arg0, -1 if this < arg0
     */
    public int compareTo(Coord arg0) {
        if (compareMode.equals("XY")) {
            if (x > arg0.x || (x == arg0.x && y > arg0.y))
                return 1;
            if (x == arg0.x && y == arg0.y)
                return 0;
            return -1;
        }
        if (compareMode.equals("YX")) {
            if (y > arg0.y || (y == arg0.y && x > arg0.x))
                return 1;
            if (y == arg0.y && x == arg0.x)
                return 0;
            return -1;
        }
        if (compareMode.equals("X")) {
            if (x > arg0.x)
                return 1;
            if (x == arg0.x)
                return 0;
            return -1;
        }
        if (compareMode.equals("Y")) {
            if (y > arg0.y)
                return 1;
            if (y == arg0.y)
                return 0;
            return -1;
        }
        if (compareMode.equals("DIST")) {
            long c1DistSquared = (long) x * x + (long) y * y;
            long c2DistSquared = (long) arg0.x * arg0.x + (long) arg0.y * arg0.y;
            if (c1DistSquared > c2DistSquared)
                return 1;
            if (c1DistSquared == c2DistSquared)
                return 0;
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
