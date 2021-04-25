import java.util.*;
import java.io.*;

public class ccc16s3 {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    static HashMap<Integer, ArrayList<Integer>> map;
    static boolean[] isPho;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        int restaurants = readInt(), pho = readInt();
        isPho = new boolean[restaurants];
        visited = new boolean[restaurants];
        int guaranteedPho = -1;
        for (int i = 0; i < pho; i++) {
            guaranteedPho = readInt();
            isPho[guaranteedPho] = true;
        }
        map = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 1; i < restaurants; i++) {
            int a = readInt(), b = readInt();
            if (!map.containsKey(a)) map.put(a, new ArrayList<Integer>());
            map.get(a).add(b);
            if (!map.containsKey(b)) map.put(b, new ArrayList<Integer>());
            map.get(b).add(a);
        }
        dfsRemove(guaranteedPho, true);
        int edges = countEdges();
        visited = new boolean[restaurants];
        int f1 = findFurthest(guaranteedPho);
        visited = new boolean[restaurants];
        int f2 = findFurthest(f1);
        visited = new boolean[restaurants];
        visited[f1] = true;
        int dist = dist(f1, f2, 0);
        System.out.println(edges - dist);
        
    }
    
    static boolean dfsRemove(int safe, boolean first) {
        visited[safe] = true;
        if(!map.containsKey(safe) || map.get(safe).isEmpty()) return true;
        if(map.get(safe).size() == 1 && !first) return !isPho[safe];
        ArrayList<Integer> todo = map.get(safe);
        for (int i = todo.size() - 1; i >= 0; i--) {
            if (!visited[todo.get(i)] && dfsRemove(todo.get(i), false)) {
                map.get(todo.get(i)).remove((Integer) safe);
                todo.remove(i);
            }
        }
        return todo.size() == 1 && !isPho[safe];
    }
    
    static int countEdges() {
        int sum = 0;
        for (ArrayList<Integer> list : map.values()) sum += list.size();
        return sum;
    }
    
    static int findFurthest(int src) {
        visited[src] = true;
        Queue<Integer> queue = new LinkedList();
        queue.add(src);
        while (true) {
            int n = queue.poll();
            for (int i : map.get(n)) if (!visited[i]) {
                visited[i] = true;
                queue.add(i);
            }
            if (queue.isEmpty()) return n;
        }
    }
    
    static int dist(int src, int dest, int currDist) {
        ArrayList<Integer> todo = map.get(src);
        if(todo.contains(dest)) return currDist + 1;
        for (int i : todo) {
            if (!visited[i]) {
                visited[i] = true;
                int p = dist(i, dest, currDist + 1);
                if (p != -1) return p;
            }
        }
        return -1;
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