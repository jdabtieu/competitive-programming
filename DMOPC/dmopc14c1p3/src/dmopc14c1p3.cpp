#include <bits/stdc++.h>
#pragma GCC optimize ("Ofast")

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
    int n; scanf("%d", &n);
    ll sum = 0;
    for (int i = 0; i < n; i++) {
        int x; scanf("%d", &x);
        sum += x;
    }
    int x; scanf("%d", &x);
    x += n;
    for (int i = n + 1; i <= x; i++) {
        int p; scanf("%d", &p);
        sum += p;
        printf("%.3lf\n", (double) sum / i);
    }
}
