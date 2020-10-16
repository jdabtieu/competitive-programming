#include <bits/stdc++.h>

#define uint_64 unsigned long long

using namespace std;

/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
int main() {
    uint_64 table[34] = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600, 1932053504, 1278945280, 2004310016, 2004189184, 4006445056, 3396534272, 109641728, 2192834560, 3099852800, 3772252160, 862453760, 3519021056, 2076180480, 2441084928, 1484783616, 2919235584, 3053453312, 1409286144, 738197504, 2147483648, 2147483648};
    int cases; scanf("%d", &cases);
    while (cases--) {
        uint_64 num; scanf("%llu", &num);
        if (num >= 34) {
            printf("0\n");
            continue;
        }
        printf("%llu\n", table[num]);
    }
}