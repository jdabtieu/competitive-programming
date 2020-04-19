#include <stdio.h>
/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
int main(void) {
	int quarters, maplays, mbplays, mcplays;
	scanf("%i%i%i%i", &quarters, &maplays, &mbplays, &mcplays);
	int current = 1;
	int count = 0;
	while (quarters > 0) {
	    quarters--;
	    count++;
	    if (current == 1) {
	        maplays++;
	        if (maplays == 35) {
	            quarters += 30;
	            maplays = 0;
	        }
	    } else if (current == 2) {
	        mbplays++;
	        if (mbplays == 100) {
	            quarters += 60;
	            mbplays = 0;
	        }
	    } else {
	        mcplays++;
	        if (mcplays == 10) {
	            quarters += 9;
                mcplays = 0;
	        }
	    }
	    current = (current + 1) % 3;
	}
	printf("Martha plays %i times before going broke.", count);
}