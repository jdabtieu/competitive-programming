import java.io.*;
import java.util.*;

public class Attempt4 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 * Currently in progress
	 */
	public static void binAdd(ArrayList<Integer> list, int element) {
        int searchResult = binarySearch(list, element);
        list.add(searchResult, element);
    }

    public static int binarySearch(ArrayList<Integer> list, Integer value) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            Integer midVal = list.get(mid);
            int cmp = midVal.compareTo(value);

            if (cmp < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return mid;
        }
        return low;
    }
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer in = new StringTokenizer(br.readLine());
		
		int samples = Integer.parseInt(in.nextToken());
		int silenceLength = Integer.parseInt(in.nextToken());
		int maxAllowedNoise = Integer.parseInt(in.nextToken());
		ArrayList<Integer> findMin = new ArrayList<Integer>(samples);
		Queue<Integer> queue = new LinkedList<>();
		in = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < silenceLength; i++) {
			int t = Integer.parseInt(in.nextToken());
			binAdd(findMin, t);
			queue.offer(t);
		}
		boolean silenceFound = false;
		if (findMin.get(findMin.size() - 1) - findMin.get(0) <= maxAllowedNoise) {
			silenceFound = true;
			System.out.println(1);
		}
		
		for (int i = 0; i < samples - silenceLength; i++) {
			int temp = Integer.parseInt(in.nextToken());
			binAdd(findMin, temp);
			queue.offer(temp);
			findMin.remove(Collections.binarySearch(findMin, queue.poll()));
			if (findMin.get(findMin.size() - 1) - findMin.get(0) <= maxAllowedNoise) {
				silenceFound = true;
				System.out.println(i + 2);
			}
		}
		if (!silenceFound) System.out.println("NONE");
		
	}

}