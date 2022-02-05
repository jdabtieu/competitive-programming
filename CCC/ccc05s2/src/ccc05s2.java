import java.util.*;
import java.io.*;

public class ccc05s2 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        int maxX = readInt(), maxY = readInt();
        int posX = 0, posY = 0;
        while (true) {
            int x = readInt(), y = readInt();
            if (x == 0 && y == 0) {
                return;
            }
            posX += x;
            posY += y;
            if (posX > maxX) posX = maxX;
            else if (posX < 0) posX = 0;
            
            if (posY > maxY) posY = maxY;
            else if (posY < 0) posY = 0;
            System.out.println(posX +   + posY);
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