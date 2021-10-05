import java.io.*;
import java.util.*;

public class coci10c7p1 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        if (n == 4 || n == 7) {
            System.out.println(-1);
            return;
        }
        int f = n / 5;
        while (true) {
            if ((n - 5*f) % 3 == 0) {
                System.out.println(f + (n-5*f)/3);
                return;
            }
            f--;
        }
    }
}
