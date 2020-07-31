import java.util.Scanner;
public class dwite08c3p3 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			int origNum = in.nextInt();
			String u1 = in.next();
			String u2 = in.next();
			u2 = in.next();
			if (u1.equals("oz")) {
				if (u2.equals("oz")) {
					System.out.println(origNum);
				} else if (u2.equals("gill")) {
					System.out.println(origNum / 5);
				} else if (u2.equals("pt")) {
					System.out.println(origNum / 20);
				} else if (u2.equals("qt")) {
					System.out.println(origNum / 40);
				} else if (u2.equals("gal")) {
					System.out.println(origNum / 160);
				}
			} else if (u1.equals("gill")) {
				if (u2.equals("gill")) {
					System.out.println(origNum);
				} else if (u2.equals("oz")) {
					System.out.println(origNum * 5);
				} else if (u2.equals("pt")) {
					System.out.println(origNum / 4);
				} else if (u2.equals("qt")) {
					System.out.println(origNum / 8);
				} else if (u2.equals("gal")) {
					System.out.println(origNum / 32);
				}
			} else if (u1.equals("pt")) {
				if (u2.equals("pt")) {
					System.out.println(origNum);
				} else if (u2.equals("gill")) {
					System.out.println(origNum *4);
				} else if (u2.equals("oz")) {
					System.out.println(origNum * 20);
				} else if (u2.equals("qt")) {
					System.out.println(origNum / 2);
				} else if (u2.equals("gal")) {
					System.out.println(origNum / 8);
				}
			} else if (u1.equals("qt")) {
				if (u2.equals("qt")) {
					System.out.println(origNum);
				} else if (u2.equals("gill")) {
					System.out.println(origNum * 8);
				} else if (u2.equals("pt")) {
					System.out.println(origNum * 2);
				} else if (u2.equals("oz")) {
					System.out.println(origNum * 40);
				} else if (u2.equals("gal")) {
					System.out.println(origNum / 4);
				}
			} else if (u1.equals("gal")) {
				if (u2.equals("gal")) {
					System.out.println(origNum);
				} else if (u2.equals("gill")) {
					System.out.println(origNum * 32);
				} else if (u2.equals("pt")) {
					System.out.println(origNum * 8);
				} else if (u2.equals("qt")) {
					System.out.println(origNum * 4);
				} else if (u2.equals("oz")) {
					System.out.println(origNum * 160);
				}
			}
		}
	}
}