import java.util.*;
public class ccc18j2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String f = sc.next();
        String s = sc.next();
        int c = 0;
        for (int i = 0; i < n; i++) {
            if (f.charAt(i) == 'C' && s.charAt(i) == 'C') c++;
        }
        System.out.println(c);
    }
}
