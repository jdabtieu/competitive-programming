import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int taskcount = 0;
		int objects = in.nextInt(), tasks = in.nextInt();
		ArrayList<String> obj = new ArrayList<String>(objects);
		for (int i = 0; i < objects; i++) obj.add(in.next());
		for (int i = 0; i < tasks; i++) {
		    int objReq = in.nextInt();
		    boolean possible = true;
		    for (int j = 0; j < objReq; j++) {
		        if (!obj.contains(in.next())) {
		            possible = false;
		        }
		    }
		    taskcount = possible ? taskcount + 1 : taskcount;
		    
		}
		System.out.println(taskcount);
	}
}
