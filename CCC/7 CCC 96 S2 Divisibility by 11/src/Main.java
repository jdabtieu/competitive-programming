import java.io.*;
import java.util.*;
public class Main {
	/*
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static int length;
	
	public static ArrayList<Byte> convert(String number) {
		length = number.length();
		ArrayList<Byte> la = new ArrayList<Byte>(length);
    	for (int i = 0; i < length; i++) {
    		la.add(Byte.parseByte(number.substring(i, i+1)));
    	}
    	return la;
	}
	
	public static void subtract (ArrayList<Byte> dividend) throws IllegalStateException {
		byte lastDigit = dividend.remove(dividend.size() - 1);
		if (dividend.get(length - 2) >= lastDigit) {
			dividend.set(length - 2, (byte) (dividend.get(length - 2) - lastDigit));
			length--;
			printPretty(dividend);
			return;
		}
		dividend.set(length - 2, (byte) (dividend.get(length - 2) + 10 - lastDigit));
		dividend.set(length - 3, (byte) (dividend.get(length - 3)-1));
		if (dividend.get(length - 3) != -1) {
			length--;
			if(dividend.get(0) == 0) {
				dividend.remove(0);
				length--;
			}
			printPretty(dividend);
			return;
		}
		
		for (int i = dividend.size() - 1; i > 0; i--) if (dividend.get(i) == -1) {
			dividend.set(i, (byte) (dividend.get(i) + 10));
			dividend.set(i-1, (byte) (dividend.get(i-1)-1));
			if (dividend.get(i-1) != -1) {
				break;
			}
		}
		
		length--;
		if(dividend.get(0) == 0) {
			dividend.remove(0);
			length--;
		}
		printPretty(dividend);
		return;
	}
	
	public static void printPretty(ArrayList<Byte> num) {
		for (int i = 0; i < num.size(); i++) {
			System.out.print(num.get(i));
		}
		System.out.println();
	}

	public static void main(String[] args) throws IOException, IllegalStateException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    for (int cases = Integer.parseInt(br.readLine()); cases > 0; cases--) {
	    	String num = br.readLine();
	    	ArrayList<Byte> la = convert(num);
	    	System.out.println(num);
	    	while (length > 2) {
				subtract(la);
			}
	    	try {
	    		if ((10 * la.get(0) + la.get(1)) % 11 == 0) {
		    		System.out.println("The number " + num + " is divisible by 11.");
		    	} else {
		    		System.out.println("The number " + num + " is not divisible by 11.");
		    	}
	    	} catch (IndexOutOfBoundsException e) {
	    		System.out.println(la.get(0) == 0 ? "The number " + num + " is divisible by 11." : "The number " + num + " is not divisible by 11.");
	    	}
	    	
	    }
	}
}