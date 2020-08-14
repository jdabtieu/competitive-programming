#include <bits/stdc++.h>
/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
using namespace std;

int main() {
    int num, cost = 0; scanf("%d", &num);

    while (num > 1) {
		int div = 2, ceil = floor(sqrt(num)) + 1;
		while (div < ceil && num % div != 0) div++;

		if (div < num && num % div == 0) {
			int tmp = num / div;
			num -= tmp;
			cost += num / tmp;
		} else cost += --num;

	}
	printf("%d", cost);
}
