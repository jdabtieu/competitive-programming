#include <bits/stdc++.h>
/* 
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
#define int64 long long

using namespace std;

int main() {
    int cases; scanf("%d", &cases);
    for (; cases > 0; cases--) {
        int64 a, b, c; scanf("%lld%lld%lld", &a, &b, &c);
        if (a * b == c) printf("POSSIBLE DOUBLE SIGMA\n");
        else printf("16 BIT S/W ONLY\n");
    }
    return 0;
}
