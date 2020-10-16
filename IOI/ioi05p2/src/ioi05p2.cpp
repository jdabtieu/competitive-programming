#include <bits/stdc++.h>

#define uint_64 unsigned long long
#define int_64 long long
#define uint unsigned int

using namespace std;
/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
int main() {
    int nums; scanf("%d", &nums);
    int a, b; scanf("%d", &a);
    int upperBound = a, lowerBound = -2000000000;

    int co = 0;

    for (int i = 1; i < nums; i++) {
        scanf("%d", &b);
        if (i % 2 == 0) {
            int tmp = b - a - a + co;
            if (tmp < upperBound) upperBound = tmp;
        } else {
            int tmp = a + a - co - b;
            if (tmp > lowerBound) lowerBound = tmp;
        }
        if (upperBound < lowerBound) {
            printf("0\n");
            exit(0);
        }
        co = a + a - co;
        a = b;
    }
    printf("%d\n", upperBound - lowerBound + 1);
}