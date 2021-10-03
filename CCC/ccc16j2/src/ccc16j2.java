import java.util.*;
public class ccc16j2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[][] s = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                s[i][j] = sc.nextInt();
            }
        }
        int proper = s[0][0] + s[0][1] + s[0][2] + s[0][3];
        for (int i = 0; i < 4; i++) {
            int sum = 0;
            for (int j = 0; j < 4; j++) {
                sum += s[i][j];
            }
            if (sum != proper) {
                System.out.println("not magic");
                return;
            }
        }
        for (int i = 0; i < 4; i++) {
            int sum = 0;
            for (int j = 0; j < 4; j++) {
                sum += s[j][i];
            }
            if (sum != proper) {
                System.out.println("not magic");
                return;
            }
        }
        System.out.println("magic");
    }
}
