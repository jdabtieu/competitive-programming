import java.util.*;
import java.io.*;

public class dmopc20c1p1 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        for (int cases = Integer.parseInt(br.readLine()); cases > 0; cases--) {
            String s = br.readLine();
            int score = 0;
            if (s.contains("M")) score++;
            if (s.contains("C")) score++;
            switch (score) {
                case 0:
                    System.out.println("PASS");
                    break;
                case 1:
                    System.out.println("FAIL");
                    break;
                case 2:
                    System.out.println("NEGATIVE MARKS");
                    break;
            }
        }
    }
}