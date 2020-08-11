public class toosimple {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) {
		int one = Byte.MAX_VALUE / Byte.MAX_VALUE;
		int two = one + one;
		int four = two + two;
		int eight = four + four;
		int sixt = eight + eight;
		int sixtf = eight * eight;
		System.out.print((char) (sixtf + eight));
		System.out.print((char) (sixtf + sixt + sixt + four + one));
		System.out.print((char) (sixtf + eight * four + eight + four));
		System.out.print((char) (sixtf + eight * four + eight + four));
		System.out.print((char) (sixt * eight - sixt - one));
		System.out.print((char) (sixt + sixt + sixt - four));
		System.out.print((char) (sixt + sixt));
		System.out.print((char) (sixtf + sixt + eight - one));
		System.out.print((char) (sixt * eight - sixt - one));
		System.out.print((char) (sixt * eight - sixt + two));
		System.out.print((char) (sixtf + eight * four + eight + four));
		System.out.print((char) (sixtf + sixt + sixt + four));
		System.out.print((char) (sixt + sixt + one));
	}
}