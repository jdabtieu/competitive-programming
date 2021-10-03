import java.io.*;
import java.util.*;

public class nccc6j2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String orig = "pusheen";
        int count = 0;
        for (int i = 0; i < 7; i++) {
            if (s.charAt(i) != orig.charAt(i)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
