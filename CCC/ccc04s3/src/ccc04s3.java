import java.util.*;
import java.io.*;

public class ccc04s3 {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    static int[][] grid = new int[10][10];
    static ArrayList<ArrayList<Integer>> formulas = new ArrayList();
    public static void main(String[] args) throws IOException {
        
        for (int i = 0; i < 100; i++) formulas.add(new ArrayList());
        for (int i = 0; i < 100; i++) {
            if (i % 10 == 0) continue;
            String in = next();
            try {
                grid[i / 10][i % 10] = Integer.parseInt(in);
            } catch (Exception e) {
                String[] tmp = in.split("\\+");
                for (String t : tmp) {
                    int row = t.charAt(0) - 'A';
                    int col = t.charAt(1) - '0';
                    formulas.get(i).add(10 * row + col);
                }
            }
        }
        for (int i = 0; i < 100; i++) {
            grid[i / 10][i % 10] = recurse(i);
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.print(grid[i][j] == -1 ? "* " : grid[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    static int recurse(int i) {
        if (formulas.get(i).size() == 0) return grid[i / 10][i % 10];
        int sum = 0;
        try {
            for (int e : formulas.get(i)) {
                int tmp = recurse(e);
                if (tmp == -1) {
                    sum = -1;
                    break;
                } else sum += tmp;
            }
        } catch (StackOverflowError e) {
            sum = -1;
        }
        if (sum > 1000000000) sum = -1;
        grid[i / 10][i % 10] = sum;
        formulas.set(i, new ArrayList());
        return sum;
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