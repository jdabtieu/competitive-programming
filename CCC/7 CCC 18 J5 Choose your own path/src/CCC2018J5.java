import java.io.*;
import java.util.*;

public class CCC2018J5 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	
	//I decided not to store the connections in a graph, but rather as a chart like so
	/* 1 | 2, 3, 5, 8
	 * 2 | 1, 4, 3
	 * 3 | 0
	 * 4 | 3, 7, 8
	 * etc where the left number leads (one way) to all of the right numbers, and 0 means that it leads to no page
	 */
	public static void noIsolate(short pageCount, short[] redIndex, ArrayList<Short> red) {
		byte[] hasVisited = new byte[pageCount + 1];
		Queue<Short> queue = new LinkedList<>();
		
		short index = 1;
		
		while (1 > 0) {
			short floor = redIndex[index];
			short ceiling = 1;
			if (index == pageCount) {
				ceiling = (short) (redIndex.length - 1);
			} else ceiling = (short) (redIndex[index + 1] - 1);
			
			hasVisited[index] = 1;
			
			for (short i = floor; i <= ceiling; i++) {
				queue.add(red.get(i));
			}
			
			index = queue.poll();
			
			while (hasVisited[index] == 1 && queue.size() > 0) {
				index = queue.poll();
			}
			if (queue.size() == 0) break;
		}
		
		for (int i = 1; i < hasVisited.length; i++) {
			if (hasVisited[i] == 0) {
				System.out.println("N");
				break;
			}
			if (i == hasVisited.length - 1) System.out.println("Y"); 
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer in = new StringTokenizer(br.readLine());
		
		ArrayList<Short> redirects = new ArrayList<Short>();
		short numPages = Short.parseShort(in.nextToken());
		short[] redirectIndex = new short[numPages + 1];
				
		for (short i = 0; i < numPages; i++) {
			in = new StringTokenizer(br.readLine());
			redirectIndex[i + 1] = (short) redirects.size();
			short temp = Short.parseShort(in.nextToken());
			for (short j = temp; j > 0; j--) {
				redirects.add(Short.parseShort(in.nextToken()));
			}
			if (temp == 0) redirects.add((short) 0);
		}
		if (redirects.get(0) == 0) {
			System.out.println(numPages == 1 ? "Y\n0" : "N\n0");
			System.exit(0);
		}
		
		noIsolate(numPages, redirectIndex, redirects);
		
		short[] pathLength = new short[numPages + 1];
		pathLength[1] = 0;
		
		Queue<Short> evenQueue = new LinkedList<>();
		Queue<Short> oddQueue = new LinkedList<>();
		
		evenQueue.add((short) 1);
		
		while(evenQueue.size() + oddQueue.size() != 0) {
			while(evenQueue.size() != 0) {
				short index = evenQueue.poll();
				short floor = redirectIndex[index];
				short ceiling = 1;
				if (index == numPages) {
					ceiling = (short) (redirectIndex.length - 1);
				} else ceiling = (short) (redirectIndex[index + 1] - 1);
				for (short i = floor; i <= ceiling; i++) {
					if (pathLength[redirects.get(i)] == 0 && redirects.get(i) != 1) {
						pathLength[redirects.get(i)] = (short) (pathLength[index] + 1);
						oddQueue.add(redirects.get(i));
					}
				}
			}
			
			while(oddQueue.size() != 0) {
				short index = oddQueue.poll();
				short floor = redirectIndex[index];
				short ceiling = 1;
				if (index == numPages) {
					ceiling = (short) (redirects.size() - 1);
				} else ceiling = (short) (redirectIndex[index + 1] - 1);
				for (short i = floor; i <= ceiling; i++) {
					if (pathLength[redirects.get(i)] == 0 && redirects.get(i) != 1) {
						pathLength[redirects.get(i)] = (short) (pathLength[index] + 1);
						evenQueue.add(redirects.get(i));
					}
				}
			}
		}
		
		short shortestPath = 32767;
		for (short i = 2; i <= numPages; i++) {
			short floor = redirectIndex[i];
			if (redirects.get(floor) == 0 && pathLength[i] > 0 && pathLength[i] < shortestPath) shortestPath = pathLength[i];
		}
		System.out.println(shortestPath + 1);
	}
}