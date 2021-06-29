import java.util.*;
import java.io.*;

public class ccc13s3 {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    static int team;
    
    static HashMap<Table, Table> map = new HashMap();

    public static void main(String[] args) throws IOException {
        team = readInt();
        int games = readInt();
        
        Table table = new Table();
        for (int i = 0; i < games; i++) {
            int t1 = readInt(), t2 = readInt(), s1 = readInt(), s2 = readInt();
            if (s1 > s2) {
                table.matches[t1][t2] = 1;
                table.matches[t2][t1] = -1;
                table.pt[t1] += 3;
            } else if (s2 > s1) {
                table.matches[t1][t2] = -1;
                table.matches[t2][t1] = 1;
                table.pt[t2] += 3;
            } else {
                table.matches[t1][t2] = 0;
                table.matches[t2][t1] = 0;
                table.pt[t1] += 1;
                table.pt[t2] += 1;
            }
        }
        
        System.out.println(f(table.clone()));
    }
    
    public static int f(Table table) {
        map.put(table, table);
        int s = 0;
        boolean f = false;
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                if (table.matches[i][j] == Integer.MIN_VALUE) {
                    f = true;
                    Table copy = table.clone();
                    copy.matches[i][j] = 1;
                    copy.matches[j][i] = -1;
                    copy.pt[i] += 3;
                    if (!map.containsKey(copy)) s += f(copy);
                    copy = table.clone();
                    copy.matches[i][j] = -1;
                    copy.matches[j][i] = 1;
                    copy.pt[j] += 3;
                    if (!map.containsKey(copy)) s += f(copy);
                    copy = table.clone();
                    copy.matches[i][j] = 0;
                    copy.matches[j][i] = 0;
                    copy.pt[i] += 1;
                    copy.pt[j] += 1;
                    if (!map.containsKey(copy)) s += f(copy);
                }
            }
        }
        if (!f) {
            int p = 0;
            for (int i = 1; i < 5; i++) {
                if (i != team && table.pt[team] > table.pt[i]) p++;
            }
            if (p == 3) return 1;
        }
        return s;
    }
    
    public static class Table implements Cloneable {
        int[][] matches;
        int[] pt;
        
        public Table() {
            matches = new int[5][5];
            pt = new int[5];
            for (int i = 0; i < 5; i++) for (int j = 0; j < 5; j++) matches[i][j] = Integer.MIN_VALUE;
            for (int i = 0; i < 5; i++) matches[i][i] = -100;
        }
        
        public Table clone() {
            Table c = new Table();
            c.matches = Arrays.stream(matches).map(int[]::clone).toArray(int[][]::new);
            c.pt = pt.clone();
            return c;
        }
        
        public int hashCode() {
            return Arrays.hashCode(pt) + Arrays.stream(matches).map(Arrays::hashCode).reduce(Integer::sum).get();
        }
        
        public boolean equals(Object other) {
            if (other == null) return false;
            if (!(other instanceof Table)) return false;
            Table t = (Table) other;
            for (int i = 1; i < 5; i++) for (int j = 1; j < 5; j++) if (matches[i][j] != t.matches[i][j]) return false;
            return true;
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