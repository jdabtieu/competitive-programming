import java.util.*;
import java.io.*;

public class ccc01s3 {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    static ArrayList<ArrayList<Integer>> graph = new ArrayList();
    static ArrayList<ArrayList<Integer>> counter = new ArrayList();
    static boolean[] visited = new boolean[26];
    
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 26; i++) {
            graph.add(new ArrayList());
            counter.add(new ArrayList());
        }
        {
            String input = readLine();
            while (!input.equals("**")) {
                int a = input.charAt(0) - 'A', b = input.charAt(1) - 'A';
                graph.get(a).add(b);
                graph.get(b).add(a);
                counter.get(a).add(0);
                counter.get(b).add(0);
                input = readLine();
            }
        }
        visited[0] = true;
        int total = recurse(0);
        if (total == 0) {
            System.out.println("There are 0 disconnecting roads.");
            return;
        }
        ArrayList<String> roads = new ArrayList();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                if (counter.get(i).get(j) == total) roads.add((char) (i + 'A') + "" + (char) (graph.get(i).get(j) + 'A'));
            }
        }
        for (String e : roads) {
            System.out.println(e);
        }
        System.out.println("There are " + roads.size() + " disconnecting roads.");
    }
    
    static int recurse(int start) {
        if (start == 1) return 1;
        int total = 0;
        for (int i = 0; i < graph.get(start).size(); i++) {
            if (!visited[graph.get(start).get(i)]) {
                visited[graph.get(start).get(i)] = true;
                int res = recurse(graph.get(start).get(i));
                counter.get(start).set(i, res + counter.get(start).get(i));
                visited[graph.get(start).get(i)] = false;
                total += res;
            }
        }
        return total;
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