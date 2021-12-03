#include <bits/stdc++.h>
#pragma GCC optimize ("Ofast")

#define pb push_back
#define pii pair<int, int>
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
int a[10001];
int main() {
    int n;
    scanf("%d", &n);
    for (int i = 1; i < n; i += 2) {
        printf("? %d %d\n", i, i+1);
        printf("? %d %d\n", i, i+1);
        fflush(stdout);
        ll r1, r2;
        scanf("%lld%lld", &r1, &r2);
        a[i+1] = r2 / 2;
        a[i] = r1 + a[i+1];
    }
    if (n % 2 == 1) {
        printf("? %d %d\n", n-1, n);
        fflush(stdout);
        ll r1;
        scanf("%lld", &r1);
        a[n] = 2 * a[n-1] - r1;
    }
    printf("!");
    for (int i = 1; i <= n; i++) {
        printf(" %d", a[i]);
    }
    printf("\n");
}
