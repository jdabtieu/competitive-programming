import java.util.*;
import java.io.*;


public class Main {
	/*
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer in = new StringTokenizer(br.readLine());
		int numOfStudents = Integer.parseInt(in.nextToken());
		
		in = new StringTokenizer(br.readLine());
		int numOfConnections = Integer.parseInt(in.nextToken());

		int [] inDegree = new int[numOfStudents];
        	int [] visit = new int[numOfStudents];
   	 	List<List<Integer>> graph = new ArrayList<List<Integer>>();
		
        	for(int i = 0; i < numOfStudents; i++) graph.add(new ArrayList<Integer>());
		
        	for(int i = 0; i < numOfConnections; i++) {
			in = new StringTokenizer(br.readLine());
        		int xCoordinate = Integer.parseInt(in.nextToken()) - 1;
			int yCoordinate = Integer.parseInt(in.nextToken()) - 1;
            		
			inDegree[yCoordinate]++;
			
            		visit[xCoordinate] = 1;
            		visit[yCoordinate] = 1;

            		graph.get(xCoordinate).add(yCoordinate);
        	}
		
        	Queue<Integer>queue = new LinkedList<Integer>();
		
        	for(int i = 0; i < numOfStudents; i ++) if(inDegree[i] == 0 && visit[i] == 1) queue.offer(i);
		
        	if(queue.isEmpty()) {
        		System.out.println("N");
            		System.exit(0);
        	}

       		while(!queue.isEmpty()) {
            		int x = queue.poll();
            		for(int i: graph.get(x)) {
                		inDegree[i]--;
                		if(inDegree[i] == 0) queue.offer(i);
            		}
        	}
		
        	for(int i = 0; i < numOfStudents; i++) if(visit[i] == 1 && inDegree[i] != 0){
            		System.out.println("N");
                	System.exit(0);
        	}
		
        	System.out.println("Y");
	}
}