#include <stdio.h>

typedef unsigned long long llu;
typedef long long ll;
typedef unsigned int uint;
typedef __uint128_t lllu;
typedef __int128_t lll;

using namespace std;
/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
int main() {
    int cases; scanf("%d", &cases);
    while (cases--) {
        llu n; scanf("%llu", &n);
        puts((n & (n-1)) == 0 ? "T" : "F");
    }
}
