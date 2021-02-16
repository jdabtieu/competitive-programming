import java.util.*;
import java.io.*;

public class ccc09s3 {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    static ArrayList<ArrayList<Integer>> connections = new ArrayList();

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 50; i++) connections.add(new ArrayList());
        add(2, 6);
        add(1, 6);
        add(6, 7);
        add(7, 8);
        add(8, 9);
        add(9, 10);
        add(10, 11);
        add(11, 12);
        add(12, 9);
        add(12, 13);
        add(13, 14);
        add(13, 15);
        add(3, 15);
        add(3, 4);
        add(3, 5);
        add(4, 5);
        add(3, 6);
        add(4, 6);
        add(5, 6);
        add(16, 17);
        add(17, 18);
        add(16, 18);
        char command = readChar();
        while (command != 'q') {
            int x, y;
            switch (command) {
            case 'i':
                x = readInt();
                y = readInt();
                if (connections.get(x).contains(y)) break;
                add(x, y);
                break;
            case 'd':
                x = readInt();
                y = readInt();
                connections.get(x).remove((Object) y);
                connections.get(y).remove((Object) x);
                break;
            case 'n':
                x = readInt();
                System.out.println(connections.get(x).size());
                break;
            case 'f':
                x = readInt();
                ArrayList<Integer> friends = connections.get(x);
                ArrayList<Integer> fof = new ArrayList<Integer>();
                for (int i : friends) {
                    for (int j : connections.get(i)) {
                        if (j == x) continue;
                        if (friends.contains(j)) continue;
                        if (fof.contains(j)) continue;
                        fof.add(j);
                    }
                }
                System.out.println(fof.size());
                break;
            case 's':
                x = readInt();
                y = readInt();
                int[] dist = new int[50];
                Queue<Integer> queue = new LinkedList();
                queue.add(x);
                while (!queue.isEmpty()) {
                    int e = queue.poll();
                    for (int t : connections.get(e)) {
                        if (dist[t] != 0) continue;
                        dist[t] = dist[e] + 1;
                        queue.add(t);
                    }
                }
                System.out.println(dist[y] == 0 ? "Not connected" : dist[y]);
                break;
            }
            
            
            command = readChar();
        }
    }
    
    static void add(int a, int b) {
        connections.get(a).add(b);
        connections.get(b).add(a);
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