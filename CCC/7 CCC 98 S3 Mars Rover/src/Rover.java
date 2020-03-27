import java.util.Scanner;
public class Rover {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static Scanner in = new Scanner(System.in);
	static public void main(String[] args) {
		int cases = in.nextInt();
		for (int i = 0; i < cases; i++) {
			short northSouth = 0;
			short eastWest = 0;
			byte facing = 0;
			
			for (;;) {
				byte instruction = in.nextByte();
				
				if (instruction == 1) {
					if (facing == 0) {
						northSouth += in.nextShort();
					} else if (facing == 1) {
						eastWest += in.nextShort();
					} else if (facing == 2) {
						northSouth -= in.nextShort();
					} else if (facing == 3) {
						eastWest -= in.nextShort();
					}
				} else if (instruction == 2) {
					facing++;
					if (facing == 4) facing = 0;
				} else if (instruction == 3) {
					facing--;
					if (facing == -1) facing = 3;
				} else break;
			}
			System.out.println("Distance is " + (Math.abs(northSouth) + Math.abs(eastWest)));
			
			while (Math.abs(northSouth) + Math.abs(eastWest) != 0) {
				if (facing == 0 && northSouth < 0) {
					System.out.println(1);
					System.out.println(-1 * northSouth);
					northSouth = 0;
				} else if (facing == 2 && northSouth > 0) {
					System.out.println(1);
					System.out.println(northSouth);
					northSouth = 0;
				} else if (facing == 1 && eastWest < 0) {
					System.out.println(1);
					System.out.println(-1 * eastWest);
					eastWest = 0;
				} else if (facing == 3 && eastWest > 0) {
					System.out.println(1);
					System.out.println(eastWest);
					eastWest = 0;
				} else {
					if (facing == 0) {
						if (eastWest > 0) {
							System.out.println(3);
							facing = 3;
						} else {
							System.out.println(2);
							facing = 1;
						}
					} else if (facing == 2) {
						if (eastWest > 0) {
							System.out.println(2);
							facing = 3;
						} else {
							System.out.println(3);
							facing = 1;
						}
					} else if (facing == 1) {
						if (northSouth > 0) {
							System.out.println(2);
							facing = 2;
						} else {
							System.out.println(3);
							facing = 0;
						}
					} else {
						if (northSouth > 0) {
							System.out.println(3);
							facing = 2;
						} else {
							System.out.println(2);
							facing = 0;
						}
					}
				}
			}
			if (i != cases - 1)	System.out.println("");
		}
	}
}
