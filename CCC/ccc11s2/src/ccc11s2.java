import java.util.*;
public class ccc11s2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] stu = new String[n];
        for (int i = 0; i < n; i++) {
            stu[i] = sc.next();
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (sc.next().equals(stu[i])) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
