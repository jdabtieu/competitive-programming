import java.util.*;
import java.io.*;

public class ccc12s3 {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        Pair[] counts = new Pair[1001];
        for (int i = 0; i < 1001; i++) counts[i] = new Pair(i);
        
        for (int sensors = readInt(); sensors > 0; sensors--) {
            counts[readInt()].inc();
        }
        Arrays.sort(counts);
        int maxIndex = counts[1000].key;
        int min = counts[999].value;
        int minIndex = counts[999].key;
        int diff = Math.abs(maxIndex - minIndex);
        for (int i = 998; i >= 0; i--) {
            if (counts[i].value != min) break;
            if (Math.abs(counts[i].key - maxIndex) > diff) {
                diff = Math.abs(counts[i].key - maxIndex);
                minIndex = counts[i].key;
            }
        }
        System.out.println(diff);
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

class Pair implements Comparable<Pair> {
    int key, value;
    Pair(int key) {
        this.key = key;
        value = 0;
    }
    
    void inc() {
        value++;
    }

    public boolean equals(Pair arg0) {
        return this.value == arg0.value;
    }
    
    @Override
    public int compareTo(Pair arg0) {
        if (this.value == arg0.value) return 0;
        return this.value > arg0.value ? 1 : -1;
    }
    
    public String toString() {
        return key + " : " + value;
    }
}