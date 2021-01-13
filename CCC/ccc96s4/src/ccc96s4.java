import java.util.*;
import java.io.*;

public class ccc96s4 {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        for (int cases = readInt(); cases > 0; cases--) {
            String input = readLine();
            String[] pre = input.split("\\+");
            int a = parse(pre[0]), b = parse(pre[1].substring(0, pre[1].length() - 1));
            int res = a + b;
            if (res > 1000) {
                System.out.println(input + "CONCORDIA CUM VERITATE");
            } else {
                System.out.println(input + rparse(res));
            }
        }
    }
    
    static int parse(String numeral) {
        int sum = 0;
        char prev = numeral.charAt(0);
        int psum = conv(numeral.charAt(0));
        for (int i = 1; i < numeral.length(); i++) {
            if (numeral.charAt(i) == prev) {        // conv(numeral.charAt(i)) == conv(prev)
                psum += conv(numeral.charAt(i));
            } else if (conv(numeral.charAt(i)) < conv(prev)) {
                sum += psum;
                psum = conv(numeral.charAt(i));
                prev = numeral.charAt(i);
            } else {
                psum = conv(numeral.charAt(i)) - psum;
                prev = numeral.charAt(i);
            }
        }
        return sum + psum;
    }
    
    static int conv(char e) {
        switch (e) {
        case 'I':
            return 1;
        case 'V':
            return 5;
        case 'X':
            return 10;
        case 'L':
            return 50;
        case 'C':
            return 100;
        case 'D':
            return 500;
        case 'M':
            return 1000;
        }
        return 56986926;
    }
    
    static String rparse(int num) {
        String res = "";
        if (num >= 900) {
            res += "CM";
            num -= 900;
        }
        if (num >= 500) {
            res += 'D';
            num -= 500;
        }
        if (num >= 400) {
            res += "CD";
            num -= 400;
        }
        switch(num / 100) {
        case 3:
            num -= 100;
            res += "C";
        case 2:
            num -= 100;
            res += "C";
        case 1:
            num -= 100;
            res += "C";
        default:
            break;
        }
        if (num == 99) {
            res += "XCIX";
            return res;
        }
        if (num >= 50) {
            res += "L";
            num -= 50;
        }
        if (num == 49) {
            res += "XLIX";
            return res;
        }
        if (num == 39) {
            res += "XXXIX";
            return res;
        }
        if (num == 29) {
            res += "XXIX";
            return res;
        }
        if (num == 19) {
            res += "XIX";
            return res;
        }
        if (num >= 40) {
            res += "XXXVV";
            num -= 40;
        }
        if (num >= 30) {
            res += "XXX";
            num -= 30;
        }
        if (num >= 20) {
            res += "XX";
            num -= 20;
        }
        if (num >= 10) {
            res += "X";
            num -= 10;
        }
        if (num == 9) {
            res += "IX";
            return res;
        }
        if (num >= 5) {
            res += "V";
            num -= 5;
        }
        if (num == 4) {
            res += "IV";
            return res;
        }
        for (int i = 0; i < num; i++) res += 'I';
        return res;
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