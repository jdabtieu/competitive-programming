import java.util.*;
public class coci15c1p1 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		ArrayList<Integer> P = new ArrayList<Integer>();
		ArrayList<Integer> K = new ArrayList<Integer>();
		ArrayList<Integer> H = new ArrayList<Integer>();
		ArrayList<Integer> T = new ArrayList<Integer>();
		
		String input = in.next();
		
		for (int i = 0; i < input.length() / 3; i++) {
			char type = input.charAt(3 * i);
			
			int number = 10 * Character.getNumericValue(input.charAt(3 * i + 1)) + Character.getNumericValue(input.charAt(3 * i + 2));
			if (type == 'P') {
				P.add(number);
			} else if (type == 'K') {
				K.add(number);
			} else if (type == 'H') {
				H.add(number);
			} else if (type == 'T') {
				T.add(number);
			}
		}
		
		Collections.sort(P);
		Collections.sort(K);
		Collections.sort(H);
		Collections.sort(T);
		
		for (int i = 0; i < P.size() - 1; i++) {
			if (P.get(i) == P.get(i + 1)) {
				System.out.println("GRESKA");
				System.exit(0);
			}
		}
		for (int i = 0; i < K.size() - 1; i++) {
			if (K.get(i) == K.get(i + 1)) {
				System.out.println("GRESKA");
				System.exit(0);
			}
		}
		for (int i = 0; i < H.size() - 1; i++) {
			if (H.get(i) == H.get(i + 1)) {
				System.out.println("GRESKA");
				System.exit(0);
			}
		}
		for (int i = 0; i < T.size() - 1; i++) {
			if (T.get(i) == T.get(i + 1)) {
				System.out.println("GRESKA");
				System.exit(0);
			}
		}
		
		int sizeP = 13 - P.size();
		int sizeK = 13 - K.size();
		int sizeH = 13 - H.size();
		int sizeT = 13 - T.size();
		System.out.println(sizeP + " " + sizeK + " " + sizeH + " " + sizeT);
	}
}