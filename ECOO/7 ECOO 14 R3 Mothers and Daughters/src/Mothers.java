import java.util.*;
public class Mothers {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static Scanner in = new Scanner(System.in);
	static public void main(String[] args) {
		String[] mothers = new String[in.nextInt()];
		String[] daughters = new String[mothers.length];
		
		for (int i = 0; i < mothers.length; i++) {
			mothers[i] = in.next();
			daughters[i] = in.next();
		}
		
		for (byte cases = 0; cases < 10; cases++) {
			int sisters =  -1;
			int cousins = 0;
			
			String subject = in.next();
			String mother = "";
			
			for (int element = 0; element < daughters.length; element++) {
				if (daughters[element].equals(subject)) {
					mother = mothers[element];
					break;	
				}
			}
			
			for (int element = 0; element < mothers.length; element++) {
				if (mothers[element].equals(mother)) {
					sisters++;		
				}
			}
			
			for (int element = 0; element < daughters.length; element++) {
				if (daughters[element].equals(mother)) {
					mother = mothers[element];
					break;	
				}
			}
			
			ArrayList<String> aunts = new ArrayList<String>();
			for (int element = 0; element < daughters.length; element++) {
				if (mothers[element].equals(mother)) {
					aunts.add(daughters[element]);
				}
			}
			
			for (int i = 0; i < aunts.size(); i++) {
				for (int element = 0; element < mothers.length; element++) {
					if (aunts.get(i).equals(mothers[element])) {
						cousins++;
					}
				}
			}
			System.out.println("Cousins: " + (cousins - sisters - 1) + ", Sisters: " + sisters);
		}
	}
}