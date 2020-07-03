import java.util.*;
import java.io.*;

public class ccc00s1 {
	/*
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;

	public static void main(String[] args) throws IOException {
		int quarters = readInt(), maplays = readInt(), mbplays = readInt(), mcplays = readInt();
		int current = 1;
		int count = 0;
		while (quarters > 0) {
		    quarters--;
		    count++;
		    if (current == 1) {
		        maplays++;
		        if (maplays == 35) {
		            quarters += 30;
		            maplays = 0;
		        }
		    } else if (current == 2) {
		        mbplays++;
		        if (mbplays == 100) {
		            quarters += 60;
		            mbplays = 0;
		        }
		    } else {
		        mcplays++;
		        if (mcplays == 10) {
		            quarters += 9;
	                mcplays = 0;
		        }
		    }
		    current = (current + 1) % 3;
		}
		System.out.println("Martha plays " + count + " times before going broke.");
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