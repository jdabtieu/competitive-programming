import java.io.*;
import java.util.*;
public class fizzcoke {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;
	
	public static void main(String[] args) throws IOException {
		String[] outs = new String[100001];
		Arrays.fill(outs, "");
		int m = readInt(), n = readInt();
		Map<Integer, String> map = new TreeMap();
		for (int i = 0; i < m; i++) {
            map.put(readInt(), next());
        }
        for (int entry : map.keySet()) {
            for (int i = entry; i <= n; i += entry) {
                outs[i] += map.get(entry);
            }
        }
        for (int i = 1; i <= n; i++) {
            if (outs[i].equals("")) {
                System.out.println(i);
            } else {
                System.out.println(outs[i]);
            }
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
