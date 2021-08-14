import java.io.*;
import java.util.*;
public class cpc21c1p5 {
	/*
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;
	
	static ArrayList<Rect> ans = new ArrayList<>();
	
	static int MM = (int) 1e9;
	
	public static void main(String[] args) throws Exception {
		int n = readInt();
		int l, r;
		while (n-- > 0) {
			int L = 1, R = MM, B = 1, T = MM;
			l = L;
			r = R;
			while (l <= r) { // find left
				int tmp = (l + r) / 2;
				System.out.printf("? %d %d %d %d\n", tmp, R, B, T);
				f();
				if (rem(tmp, R, B, T, readInt()) > 0) {
					L = tmp;
					l = tmp + 1;
				} else {
					r = tmp - 1;
				}
			}
			l = L;
			r = R;
			while (l <= r) { // find right
				int tmp = (l + r) / 2;
				System.out.printf("? %d %d %d %d\n", L, tmp, B, T);
				f();
				if (rem(L, tmp, B, T, readInt()) > 0) {
					R = tmp;
					r = tmp - 1;
				} else {
					l = tmp + 1;
				}
			}
			l = B;
			r = T;
			while (l <= r) { // find bottom
				int tmp = (l + r) / 2;
				System.out.printf("? %d %d %d %d\n", L, R, tmp, T);
				f();
				if (rem(L, R, tmp, T, readInt()) > 0) {
					B = tmp;
					l = tmp + 1;
				} else {
					r = tmp - 1;
				}
			}
			l = B;
			r = T;
			while (l <= r) { // find top
				int tmp = (l + r) / 2;
				System.out.printf("? %d %d %d %d\n", L, R, B, tmp);
				f();
				if (rem(L, R, B, tmp, readInt()) > 0) {
					T = tmp;
					r = tmp - 1;
				} else {
					l = tmp + 1;
				}
			}
			ans.add(new Rect(L, R, B, T));
		}
		System.out.println("!");
		for (Rect rect : ans) {
			System.out.printf("%d %d %d %d\n", rect.l, rect.r, rect.b, rect.t);
		}
	}
	
	static int rem(int l, int r, int b, int t, int q) throws Exception {
		if (q == -1) {
			throw new Exception();
		}
		int cnt = 0;
		for (Rect rect : ans) {
			if (rect.l >= l && rect.r <= r && rect.b >= b && rect.t <= t) cnt++;
		}
		return q - cnt;
	}
	
	static class Rect {
		int l, r, b, t;
		public Rect(int l, int r, int b, int t) {
			this.l = l;
			this.r = r;
			this.b = b;
			this.t = t;
		}
	}
	
	static void f() {
		System.out.flush();
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
