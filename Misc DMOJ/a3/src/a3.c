#include <stdio.h>
#pragma GCC optimize ("Ofast")

typedef unsigned long long llu;
typedef long long ll;
typedef unsigned int uint;
typedef __uint128_t lllu;
typedef __int128_t lll;

/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
int main() {
    int cases; scanf("%d", &cases);
    while (cases--) {
        int n; scanf("%d", &n);
        int a = n / 1000;
        int b = n % 1000;
        if (b < 192) b = 192;
        else if (b < 442) b = 442;
        else if (b < 692) b = 692;
        else if (b < 942) b = 942;
        else {
            a++;
            b = 192;
        }
        printf("%d\n", a * 1000 + b);
    }
}
