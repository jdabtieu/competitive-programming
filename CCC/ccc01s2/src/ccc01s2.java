import java.util.*;
import java.io.*;

public class ccc01s2 {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    static int[][] grid = new int[10][10]; 

    public static void main(String[] args) throws IOException {
        int start = readInt(), end = readInt();
        int direction = 2, steps = 1, os = 1;
        int x = 4, y = 4;
        while (start <= end) {
            grid[x][y] = start;
            steps--;
            if (steps < 0) {
                direction++;
                if (direction > 3) direction -= 4;
                if ((direction & 1) == 0) os++;
                steps = os - 1;
            }
            switch (direction) {
            case 0:
                y--;
                break;
            case 1:
                x--;
                break;
            case 2:
                y++;
                break;
            case 3:
                x++;
                break;
            }
            start++;
        }
        for (int i = 0; i < 10; i++) {
            boolean flag = false;
            for (int j = 0; j < 10; j++) if (grid[j][i] != 0) flag = true;
            if (!flag) continue;
            for (int j = 0; j < 10; j++) {
                flag = false;
                for (int k = 0; k < 10; k++) if (grid[j][k] != 0) flag = true;
                if (!flag) continue;
                if (grid[j][i] == 0) System.out.print("   ");
                else System.out.printf("%2d ", grid[j][i]);
            }
            System.out.println();
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