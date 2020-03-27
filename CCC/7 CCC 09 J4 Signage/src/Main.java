import java.util.*;
public class Main {
	/*
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int length = in.nextInt();
		String[] trivial = {"", "", "", "", "", "", "", "WELCOME\nTO..CCC\nGOOD...\nLUCK...\nTODAY..", "WELCOME.\nTO...CCC\nGOOD....\nLUCK....\nTODAY..."
		                    , "WELCOME..\nTO....CCC\nGOOD.LUCK\nTODAY....", "WELCOME.TO\nCCC...GOOD\nLUCK.TODAY", 
		                    "WELCOME..TO\nCCC....GOOD\nLUCK..TODAY", "WELCOME...TO\nCCC.....GOOD\nLUCK...TODAY", 
		                    "WELCOME....TO\nCCC.GOOD.LUCK\nTODAY........", "WELCOME.TO.CCC\nGOOD......LUCK\nTODAY.........", "WELCOME..TO.CCC\nGOOD.LUCK.TODAY"
		                    , "WELCOME..TO..CCC\nGOOD..LUCK.TODAY", "WELCOME...TO..CCC\nGOOD..LUCK..TODAY", "WELCOME...TO...CCC\nGOOD...LUCK..TODAY", 
		                    "WELCOME.TO.CCC.GOOD\nLUCK..........TODAY", "WELCOME..TO.CCC.GOOD\nLUCK...........TODAY", "WELCOME..TO..CCC.GOOD\nLUCK............TODAY"
		                    , "WELCOME..TO..CCC..GOOD\nLUCK.............TODAY", "WELCOME...TO..CCC..GOOD\nLUCK..............TODAY", "WELCOME.TO.CCC.GOOD.LUCK\nTODAY..................."
		                    , "WELCOME..TO.CCC.GOOD.LUCK\nTODAY....................", "WELCOME..TO..CCC.GOOD.LUCK\nTODAY.....................",
		                    "WELCOME..TO..CCC..GOOD.LUCK\nTODAY......................", "WELCOME..TO..CCC..GOOD..LUCK\nTODAY.......................",
		                    "WELCOME...TO..CCC..GOOD..LUCK\nTODAY........................", "WELCOME.TO.CCC.GOOD.LUCK.TODAY"};
		if (length <= 30) {
			System.out.println(trivial[length]);
			System.exit(0);
		}
		int mod5 = length % 5;
		int div5 = length / 5 - 5;
		System.out.print("WELCOME");
		for (int i = 0; i < div5; i++) System.out.print(".");
		if (mod5-- > 0) System.out.print(".");
		System.out.print("TO");
		for (int i = 0; i < div5; i++) System.out.print(".");
		if (mod5-- > 0) System.out.print(".");
		System.out.print("CCC");
		for (int i = 0; i < div5; i++) System.out.print(".");
		if (mod5-- > 0) System.out.print(".");
		System.out.print("GOOD");
		for (int i = 0; i < div5; i++) System.out.print(".");
		if (mod5-- > 0) System.out.print(".");
		System.out.print("LUCK");
		for (int i = 0; i < div5; i++) System.out.print(".");
		if (mod5-- > 0) System.out.print(".");
		System.out.println("TODAY");
	}
}