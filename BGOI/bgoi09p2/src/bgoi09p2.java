import java.util.*;
import java.io.*;

public class bgoi09p2 {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        for (int cases = 0; cases < 2; cases++) {
            int boxes = readInt();
            ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i <= boxes; i++) graph.add(new ArrayList<Integer>());
            for (int i = 1; i <= boxes; i++) {
                int n = readInt();
                graph.get(n).add(i);
                graph.get(i).add(n);
            }
            
            boolean[] visited = new boolean[boxes + 1];
            int breaks = 0;
            for (int i = 1; i <= boxes; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    Queue<Integer> queue = new LinkedList();
                    for (int j : graph.get(i)) if (!visited[j]) queue.add(j);
                    while (!queue.isEmpty()) {
                        int n = queue.poll();
                        visited[n] = true;
                        for (int j : graph.get(n)) if (!visited[j]) queue.add(j);
                    }
                    breaks++;
                }
            }
            System.out.print(breaks + " ");
        }
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