import java.util.*;
public class crci09p2 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		byte[] height = new byte[in.nextByte()];
		
		byte piece = in.nextByte();
		
		short arrangements = 0;
		
		for (byte i = 0; i < height.length; i++) {
			height[i] = in.nextByte();
		}
		
		//Piece 1
		/*
		 	0
		 	0
		 	0
		 	0
		 */
		if (piece == 1) {
			arrangements = (short) height.length;
			for (byte i = 0; i < height.length - 3; i++) {
				if (height[i] == height[i + 1] && height[i + 2] == height[i + 3] && height[i] == height[i + 2]) {
					arrangements++;
				}
			}
		} else if (piece == 2) {
		//Piece 2
		/*
		 	00
		 	00
		 */
			for (byte i = 0; i < height.length - 1; i++) {
				if (height[i] == height[i + 1]) {
					arrangements++;
				}
			}
		} else if (piece == 3) {
			//Piece 3
			/*
			 	 00
			 	00
			 */
			for (byte i = 0; i < height.length - 1; i++) {
				if (height[i] == height[i + 1] + 1) {
					arrangements++;
				}
			}
			for (byte i = 0; i < height.length - 2; i++) {
				if (height[i] == height[i + 1] && height[i] == height[i + 2] - 1) {
					arrangements++;
				}
			}
		} else if (piece == 4) {
			//Piece 4
			/*
			 	00
			 	 00
			 */
			for (byte i = 0; i < height.length - 1; i++) {
				if (height[i] == height[i + 1] - 1) {
					arrangements++;
				}
			}
			for (byte i = 0; i < height.length - 2; i++) {
				if (height[i + 2] == height[i + 1] && height[i] == height[i + 2] + 1) {
					arrangements++;
				}
			}
		} else if (piece == 5) {
			//Piece 5
			/*
			 	 0
			 	000
			 */
			for (byte i = 0; i < height.length - 1; i++) {
				if ((height[i] == height[i + 1] + 1) || (height[i] == height[i + 1] - 1)) {
					arrangements++;
				}
			}
			for (byte i = 0; i < height.length - 2; i++) {
				if ((height[i] == height[i + 2] && height[i] == height[i + 1] + 1) || (height[i] == height[i + 1] && height[i] == height[i + 2])) {
					arrangements++;
				}
			}
		} else if (piece == 6) {
			//Piece 6
			/*
			 	  0
			 	000
			 */
			for (byte i = 0; i < height.length - 1; i++) {
				if ((height[i] == height[i + 1] + 2) || (height[i] == height[i + 1])) {
					arrangements++;
				}
			}
			for (byte i = 0; i < height.length - 2; i++) {
				if ((height[i + 1] == height[i + 2] && height[i] == height[i + 1] - 1) || (height[i] == height[i + 1] && height[i] == height[i + 2])) {
					arrangements++;
				}
			}
		} else if (piece == 7) {
			//Piece 7
			/*
			 	0
			 	000
			 */
			for (byte i = 0; i < height.length - 1; i++) {
				if ((height[i] == height[i + 1] - 2) || (height[i] == height[i + 1])) {
					arrangements++;
				}
			}
			for (byte i = 0; i < height.length - 2; i++) {
				if ((height[i] == height[i + 2] + 1 && height[i] == height[i + 1]) || (height[i] == height[i + 1] && height[i] == height[i + 2])) {
					arrangements++;
				}
			}
		}
	System.out.println(arrangements);
	}

}