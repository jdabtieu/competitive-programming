import java.util.*;
public class ccc17j1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // quad 1: ++
        // quad 2: -+
        // quad 3: --
        // quad 4: +-
        int x = sc.nextInt(), y = sc.nextInt();
        if (x > 0 && y > 0) {
            System.out.println(1);
        } else if (x < 0 && y > 0) {
            System.out.println(2);
        } else if (x < 0 && y < 0) {
            System.out.println(3);
        } else {
            System.out.println(4);
        }
    }
}
