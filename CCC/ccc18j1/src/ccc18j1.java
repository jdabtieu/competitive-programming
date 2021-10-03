import java.util.*;
public class ccc18j1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] n = new int[4];
        for (int i = 0; i < 4; i++) {
            n[i] = sc.nextInt();
        }
        if ((n[0] == 8 || n[0] == 9) && (n[3] == 8 || n[3] == 9) && n[1] == n[2]) {
            System.out.println("ignore");
            return;
        }
        System.out.println("answer");
    }
}
