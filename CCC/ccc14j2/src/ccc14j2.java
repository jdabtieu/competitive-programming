import java.util.*;
public class ccc14j2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = 0, b = 0;
        String votes = sc.next();
        for (int i = 0; i < n; i++) {
            if (votes.charAt(i) == 'A') {
                a++;
            } else {
                b++;
            }
        }
        if (a > b) {
            System.out.println('A');
        } else if (b > a) {
            System.out.println('B');
        } else {
            System.out.println("Tie");
        }
    }
}
