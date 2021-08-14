import java.util.*;
import java.io.*;

public class canada21p3 {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        for (int cases = readInt(); cases > 0; cases--) {
            ll num = new ll();
            String s = readLine();
            for (int i = 0; i < s.length(); i++) {
                num.append(new node(s.charAt(i)));
            }
            
            int keys = readInt();
            PriorityQueue<node> pq = new PriorityQueue<>();
            node curr = num.first;
            while (curr != null && curr != num.last && keys > 0) {
                if (curr.val > curr.next.val) {
                    node tmp = curr == num.first ? curr.next : curr.prev;
                    num.delete(curr);
                    pq.add(curr);
                    keys--;
                    curr = tmp;
                } else {
                    curr = curr.next;
                }
            }
            
            while (keys-- > 0) {
                if (num.last == null) break;
                pq.add(num.last);
                num.delete(num.last);
            }
            
            while (!pq.isEmpty()) {
                num.append(pq.poll());
            }
            
            System.out.println(num);
        }
    }
    
    public static class node implements Comparable<node> {
        char val;
        node next;
        node prev;
        
        public node (char val) {
            this.val = val;
        }
        
        public int compareTo(node other) {
            return Character.compare(val, other.val);
        }
    }
    
    public static class ll {
        node first;
        node last;
        
        public void append(node n) {
            n.prev = last;
            n.next = null;
            if (first == null) {
                first = n;
            } else {
                last.next = n;
            }
            last = n;
        }
        
        public void delete(node n) {
            if (n == first && n == last) {
                first = null;
                last = null;
            } else if (n == first) {
                first = n.next;
                first.prev = null;
            } else if (n == last) {
                last = n.prev;
                last.next = null;
            } else {
                n.next.prev = n.prev;
                n.prev.next = n.next;
            }
        }
        
        public String toString() {
            node s = first;
            StringBuilder res = new StringBuilder();
            while (s != null) {
                res.append(s.val);
                s = s.next;
            }
            return res.toString();
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
