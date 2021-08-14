import java.util.*;
import java.io.*;

public class canada21p4 {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        long n = readLong(), speed = readLong();
        int prevTime = readInt();
        long xsmall = readLong(), width = 0, ysmall = readLong(), height = 0;
        long xlarge = xsmall, ylarge = ysmall;
        
        while (--n > 0) {
            int thisTime = readInt();
            long maxMove = speed * (thisTime - prevTime);
            prevTime = thisTime;
            
            long x = readLong(), y = readLong();
            //  xs   xl   x
            //  xs  x    xl
            //  x   xs   xl
            if (x > xlarge) {
                long tmp = xlarge + width + maxMove;
                if (tmp <= x) {
                    width += x - tmp;
                    xlarge = x - width;
                    xsmall = xlarge;
                } else {
                    xlarge = Math.min(x, xlarge + maxMove);
                    xsmall = Math.max(x - width, xsmall - maxMove);
                }
            } else if (x > xsmall) {
                xlarge = x;
                xsmall = Math.max(xsmall - maxMove, x - width);
            } else {
                long tmp = xsmall - maxMove;
                if (tmp >= x) {
                    width += tmp - x;
                    xsmall = x;
                    xlarge = xsmall;
                } else {
                    xsmall = Math.max(x - width, xsmall - maxMove);
                    xlarge = x;
                }
            }
            
            //  xs   xl   x
            //  xs  x    xl
            //  x   xs   xl
            if (y > ylarge) {
                long tmp = ylarge + height + maxMove;
                if (tmp <= y) {
                    height += y - tmp;
                    ylarge = y - height;
                    ysmall = ylarge;
                } else {
                    ylarge = Math.min(y, ylarge + maxMove);
                    ysmall = Math.max(y - height, ysmall - maxMove);
                }
            } else if (y > ysmall) {
                ylarge = y;
                ysmall = Math.max(ysmall - maxMove, y - height);
            } else {
                long tmp = ysmall - maxMove;
                if (tmp >= y) {
                    height += tmp - y;
                    ysmall = y;
                    ylarge = ysmall;
                } else {
                    ysmall = Math.max(y - height, ysmall - maxMove);
                    ylarge = y;
                }
            }
        }
        System.out.println(Math.max(width, height));
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