import java.util.*;
import java.io.*;

public class ccc00s2 {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    static ArrayList<Double> streams = new ArrayList<Double>();
    
    public static void main(String[] args) throws IOException {
        streams.add(-1.0);
        int ogCount = readInt();
        for (int i = 0; i < ogCount; i++) streams.add(readDouble());
        int input = readInt();
        while (input != 77) {
            if (input == 99) {
                int index = readInt();
                double percentage = readInt() / 100.0;
                double tmp = streams.get(index);
                streams.set(index, tmp * percentage);
                streams.add(index + 1, tmp * (1 - percentage));
            } else {
                int index = readInt();
                double tmp = streams.get(index) + streams.get(index + 1);
                streams.set(index, tmp);
                streams.remove(index + 1);
            }
            input = readInt();
        }
        System.out.print((int) (streams.get(1) + 0.5));
        for (int i = 2; i < streams.size(); i++) System.out.print(" " + ((int) (streams.get(i) + 0.5)));
        System.out.println();
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