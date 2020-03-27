import java.io.*;
import java.util.*;
public class Division {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	public static void divFunction (ArrayList<Byte> dividend, ArrayList<Byte> divisor) throws ClassNotFoundException {
		int lengthA = dividend.size(), lengthB = divisor.size();
		@SuppressWarnings("unchecked")
		ArrayList<Byte> modifiedDivisor = (ArrayList<Byte>) divisor.clone();
		int modifiedDigits = 0;
		for (int i = 0; i < 1; i++) {
			if (modifiedDivisor.get(0) == 0) {
				modifiedDivisor.add(modifiedDivisor.remove(0));
				modifiedDigits++;
				i--;
			}
		}
		int[] countDig = new int[lengthA];
		for (;;) {
			while (dividendLargerEqualToModifiedDivisor(dividend, modifiedDivisor)) {
    			dividend = subtract(dividend, modifiedDivisor);
    			countDig[modifiedDigits]++;
    		}
			if (modifiedDigits == 0) break;
    		modifiedDivisor.add(0, (byte) 0);
    		modifiedDivisor.remove(modifiedDivisor.size()-1);
    		modifiedDigits--;
		}
    		
		String returned = "";
		for (int i = 0; i < countDig.length; i++) {
			returned = countDig[i] + returned;
		}
		for (int i = 0; i < 1; i++) {
			if (returned.length() == 0) {
				returned = "0";
				break;
			}
			if (returned.charAt(0) == '0') {
				i--;
				returned = returned.substring(1);
			}
		}
		for (int i = 0; i < 1; i++) {
			if (dividend.size() == 0) {
				dividend.add((byte) 0);
				break;
			}
			if (dividend.get(0) == 0) {
				i--;
				dividend.remove(0);
			}
		}
		
		System.out.println(returned);
		for (int i = 0; i < dividend.size(); i++) {
			System.out.print(dividend.get(i));
		}
		System.out.println("\n");
	}
	
	public static boolean dividendLargerEqualToModifiedDivisor (ArrayList<Byte> dividend, ArrayList<Byte> modifiedDivisor) {
		for (int i = 0; i < dividend.size(); i++) {
			if (dividend.get(i) > modifiedDivisor.get(i)) return true;
			if (modifiedDivisor.get(i) > dividend.get(i)) return false;
		}
		return true;
	}
	
	public static ArrayList<Byte> subtract (ArrayList<Byte> dividend, ArrayList<Byte> modifiedDivisor) throws ClassNotFoundException {
		ArrayList<Byte> result = new ArrayList<Byte>();
		for (int i = 0; i < dividend.size(); i++) result.add((byte) 0);
		for (int i = dividend.size() - 1; i >= 0; i--) {
			if (dividend.get(i) >= modifiedDivisor.get(i)) {
				if (result.get(i) == -1 && dividend.get(i) - modifiedDivisor.get(i) == 0) {
					result.set(i, (byte) (result.get(i) + 10 + dividend.get(i) - modifiedDivisor.get(i)));
					if (i == 0) throw new ClassNotFoundException();
					else result.set(i-1, (byte) (result.get(i-1)-1));
				}
				else result.set(i, (byte) (result.get(i) + dividend.get(i) - modifiedDivisor.get(i)));
			} else {
				result.set(i, (byte) (result.get(i) + 10 + dividend.get(i) - modifiedDivisor.get(i)));
				if (i == 0) throw new ClassNotFoundException();
				else result.set(i-1, (byte) (result.get(i-1)-1));
			}
		}
		
		return result;
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    for (int cases = Integer.parseInt(br.readLine()); cases > 0; cases--) {
	    	String a = br.readLine();
	    	String b = br.readLine();
	    	if (b.length() > a.length() ) {
	    		System.out.println(0 + "\n" + a + "\n");
	    	} else {
	    		ArrayList<Byte> la = new ArrayList<Byte>();
		    	ArrayList<Byte> lb = new ArrayList<Byte>();
		    	for (int i = 0; i < a.length(); i++) {
		    		la.add(Byte.parseByte(a.substring(i, i+1)));
		    	}
		    	for (int i = 0; i < b.length(); i++) {
		    		lb.add(Byte.parseByte(b.substring(i, i+1)));
		    	}
		    	for (int i = 0; i < a.length() - b.length(); i++) {
		    		lb.add(0, (byte) 0);
		    	}
		    	divFunction(la, lb);
	    	}
	    	
	    }
	}
}