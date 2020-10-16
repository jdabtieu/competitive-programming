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
    int trolleys, days; scanf("%d%d", &trolleys, &days);
    int sums[trolleys];
    scanf("%d", &sums[0]);
    for (int i = 1; i < trolleys; i++) {
        int temp; scanf("%d", &temp);
        sums[i] = temp + sums[i - 1];
    }

    int start = 0, end = trolleys - 1;
    while (days--) {
        int temp; scanf("%d", &temp);
        int a = sums[temp - 1 + start] - (start == 0 ? 0 : sums[start - 1]), b = sums[end] - sums[temp - 1 + start];
        if (a >= b) {
            printf("%d\n", a);
            start = start + temp;
        }
        else {
            printf("%d\n", b);
            end = start + temp - 1;
        }
    }
}