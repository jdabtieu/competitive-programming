import java.util.*;
import java.io.*;

public class ccc07s4 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;

	static class Pair implements Comparable<Pair> {
		int val, source;
		Pair (int v, int src) {
			val = v;
			source = src;
		}
		@Override
		public int compareTo(Pair p) {
			if (p.val > val) return 1;
			return p.val < val ? -1 : 0;
		}
		@Override
		public boolean equals(Object o) {
			if (o instanceof Pair) {
				Pair p = (Pair) o;
				return p.val == val && p.source == source;
			}
			return false;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		ArrayList<ArrayList<Integer>> children = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Pair>> parents = new ArrayList<ArrayList<Pair>>();
		int points = readInt();
		int[] paths = new int[points + 1];
		paths[points] = 1;
		
		for (int i = 0; i <= points; i++) {
			children.add(new ArrayList<Integer>());
			parents.add(new ArrayList<Pair>());
		}
		
		while (true) {
			int a = readInt(), b = readInt();
			if (a == 0 && b == 0) break;
			children.get(a).add(b);
			parents.get(b).add(new Pair(a, b));
		}
		
		
		PriorityQueue<Pair> queue = new PriorityQueue<Pair>();
		for (int i = 0; i < parents.get(points).size(); i++) queue.offer(parents.get(points).get(i));
		while (!queue.isEmpty()) {
			Pair point = queue.poll();
			paths[point.val] += paths[point.source];
			for (int i = 0; i < parents.get(point.val).size(); i++) if (!queue.contains(parents.get(point.val).get(i))) queue.add(parents.get(point.val).get(i));
		}
		
		System.out.println(paths[1]);
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