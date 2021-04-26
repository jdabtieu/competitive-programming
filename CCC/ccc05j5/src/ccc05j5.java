import java.io.*;

public class ccc05j5 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    public static void main(String[] args) throws IOException {
        while (true) {
            String s = readLine();
            if (s.equals("X")) return;
            int len = s.length();
            while (true) {
                s = s.replaceAll("(AN)+A", "A").replaceAll("B(AN)*AS", "A");
                if (s.length() == len) break;
                else len = s.length();
            }
            System.out.println(s.equals("A") ? "YES" : "NO");
        }
    }

    static String readLine() throws IOException {
        return br.readLine();
    }
}
