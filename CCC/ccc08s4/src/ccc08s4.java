import java.io.*;
import java.util.*;
public class ccc08s4 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        for (int cases = readInt(); cases > 0; cases--) {
            int[] c = new int[4];
            for (int i = 0; i < 4; i++) c[i] = readInt();
            HashSet<Integer> res[] = new HashSet[16];
            for (int i = 0; i < 16; i++) res[i] = new HashSet<>();
            // 1
            for (int i = 0; i < 4; i++) res[1 << i].add(c[i]);
            // 2
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (i == j) continue;
                    int key = (1 << i) | (1 << j);
                    res[key].add(c[i] + c[j]);
                    res[key].add(c[i] - c[j]);
                    res[key].add(c[j] - c[i]);
                    res[key].add(c[i] * c[j]);
                    if (c[i] % c[j] == 0) res[key].add(c[i] / c[j]);
                    if (c[j] % c[i] == 0) res[key].add(c[j] / c[i]);
                }
            }
            // 3
            for (int i = 1; i < 16; i++) {
                if (Integer.bitCount(i) != 2) continue;
                for (int j = 0; j < 4; j++) {
                    if ((i | (1 << j)) == i) continue;
                    int key = i | (1 << j);
                    for (int num : res[i]) {
                        res[key].add(num + c[j]);
                        res[key].add(num - c[j]);
                        res[key].add(c[j] - num);
                        res[key].add(num * c[j]);
                        if (c[j] != 0 && num % c[j] == 0) res[key].add(num / c[j]);
                        if (num != 0 && c[j] % num == 0) res[key].add(c[j] / num);
                    }
                }
            }
            // 4
            for (int i = 1; i < 16; i++) {
                if (Integer.bitCount(i) == 3) {
                    for (int j = 0; j < 4; j++) {
                        if ((i | (1 << j)) == i) continue;
                        int key = 15;
                        for (int num : res[i]) {
                            res[key].add(num + c[j]);
                            res[key].add(num - c[j]);
                            res[key].add(c[j] - num);
                            res[key].add(num * c[j]);
                            if (c[j] != 0 && num % c[j] == 0) res[key].add(num / c[j]);
                            if (num != 0 && c[j] % num == 0) res[key].add(c[j] / num);
                        }
                    }
                } else if (Integer.bitCount(i) == 2) {
                    for (int j = 0; j < 16; j++) {
                        if ((i ^ j) != 15) continue;
                        int key = 15;
                        for (int n1 : res[i]) {
                            for (int n2 : res[j]) {
                                res[key].add(n1 + n2);
                                res[key].add(n1 - n2);
                                res[key].add(n2 - n1);
                                res[key].add(n1 * n2);
                                if (n2 != 0 && n1 % n2 == 0) res[key].add(n1 / n2);
                                if (n1 != 0 && n2 % n1 == 0) res[key].add(n2 / n1);
                            }
                        }
                    }
                }
            }
            int largest = 0;
            for (int e : res[15]) {
                if (e > 24) continue;
                largest = Math.max(largest, e);
            }
            System.out.println(largest);
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
