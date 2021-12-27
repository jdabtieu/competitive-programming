import java.util.*;
import java.io.*;
public class usaco21febb1 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        int n = Integer.parseInt(br.readLine());
        String[] yrs = {"Ox", "Tiger", "Rabbit", "Dragon", "Snake", "Horse", "Goat", "Monkey", "Rooster", "Dog", "Pig", "Rat"};
        HashMap<String, pii> map = new HashMap<>();
        map.put("Bessie", new pii(0, 0));
        while (n-- > 0) {
            String[] inp = br.readLine().split(" ");
            String curr = inp[0];
            int mult = inp[3].contains("prev") ? -1 : 1;
            String y = inp[4];
            String relto = inp[7];
            
            int idx;
            for (idx = 0; idx < 12; idx++) {
                if (yrs[idx].equals(y)) break;
            }
            int prevIdx = map.get(relto).idx;
            int offset = map.get(relto).offset;
            if (idx < prevIdx && mult == -1) {
                offset += idx - prevIdx;
            } else if (idx < prevIdx && mult == 1) {
                offset += 12 + idx - prevIdx;
            } else if (idx > prevIdx && mult == 1) {
                offset += idx - prevIdx;
            } else if (idx > prevIdx && mult == -1) {
                offset -= 12 - idx + prevIdx;
            } else if (mult == 1) {
                offset += 12;
            } else {
                offset -= 12;
            }
            map.put(curr, new pii(idx, offset));
        }
        System.out.println(Math.abs(map.get("Elsie").offset));
    }
    
    static class pii {
        int idx, offset;
        public pii(int a, int b) {
            idx = a;
            offset = b;
        }
    }
}
