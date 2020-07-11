#include <stdio.h>
#include <math.h>
/* 
 * This is a modified version of the following code from Wikipedia
 * https://en.wikipedia.org/wiki/Longest_increasing_subsequence
 */
int X[1000000];
int P[1000000] = {0};
int M[1000001] = {0};

int main() {
	int nums; scanf("%d", &nums);
	for (int i = 0; i < nums; i++) scanf("%d", &X[i]);

	int length = 0;
	
	for (int i = 0; i < nums; i++) {
	    int lo = 1, hi = length;
	    while (lo <= hi) {
	        int mid = (int) ceil((lo + hi) / 2.0);
	        if (X[M[mid]] < X[i]) lo = mid + 1;
	        else hi = mid - 1;
	    }

	    P[i] = M[lo - 1];
	    M[lo] = i;
	    
	    if (lo > length) length = lo;
	}
	printf("%d\n", length);
	return 0;
}
