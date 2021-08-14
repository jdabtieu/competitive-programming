import java.util.*;
import java.io.*;

public class canada21p2 {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    static int[][][] grid = new int[101][101][101];

    public static void main(String[] args) throws IOException {
        Queue<wool> queue = new LinkedList();
        for (int i = 0; i < 101; i++) for (int j = 0; j < 101; j++) for (int k = 0; k < 101; k++) grid[i][j][k] = Integer.MAX_VALUE;
        
        int n = readInt(), q = readInt();
        for (int i = 1; i <= n; i++) {
            wool x = new wool(readInt(), readInt(), readInt());
            grid[x.x][x.y][x.z] = i;
            queue.add(x);
        }
        
        while (!queue.isEmpty()) {
            wool curr = queue.poll();
            if (curr.x > 0 && grid[curr.x-1][curr.y][curr.z] == Integer.MAX_VALUE) {
                grid[curr.x-1][curr.y][curr.z] = grid[curr.x][curr.y][curr.z];
                queue.add(new wool(curr.x-1, curr.y, curr.z));
            }
            if (curr.y > 0 && grid[curr.x][curr.y-1][curr.z] == Integer.MAX_VALUE) {
                grid[curr.x][curr.y-1][curr.z] = grid[curr.x][curr.y][curr.z];
                queue.add(new wool(curr.x, curr.y-1, curr.z));
            }
            if (curr.z > 0 && grid[curr.x][curr.y][curr.z-1] == Integer.MAX_VALUE) {
                grid[curr.x][curr.y][curr.z-1] = grid[curr.x][curr.y][curr.z];
                queue.add(new wool(curr.x, curr.y, curr.z-1));
            }
            if (curr.x < 100 && grid[curr.x+1][curr.y][curr.z] == Integer.MAX_VALUE) {
                grid[curr.x+1][curr.y][curr.z] = grid[curr.x][curr.y][curr.z];
                queue.add(new wool(curr.x+1, curr.y, curr.z));
            }
            if (curr.y < 100 && grid[curr.x][curr.y+1][curr.z] == Integer.MAX_VALUE) {
                grid[curr.x][curr.y+1][curr.z] = grid[curr.x][curr.y][curr.z];
                queue.add(new wool(curr.x, curr.y+1, curr.z));
            }
            if (curr.z < 100 && grid[curr.x][curr.y][curr.z+1] == Integer.MAX_VALUE) {
                grid[curr.x][curr.y][curr.z+1] = grid[curr.x][curr.y][curr.z];
                queue.add(new wool(curr.x, curr.y, curr.z+1));
            }
        }
        while (q-- > 0) {
            System.out.println(grid[readInt()][readInt()][readInt()]);
        }
    }
    
    public static class wool {
        int x, y, z;
        public wool (int a, int b, int c) {
            x = a; y = b; z = c;
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