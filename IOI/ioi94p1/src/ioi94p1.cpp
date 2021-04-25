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
    int rows; scanf("%d", &rows);
    int dp[rows+1] = {0};
    for (int i = 0; i < rows; i++) {
        int dp1[rows+1] = {0};
        for (int j = 0; j <= i; j++) {
            int x; scanf("%d", &x);
            dp1[j+1] = max(dp[j], dp[j+1]) + x;
        }
        for (int j = 0; j <= rows; j++) dp[j] = dp1[j];
    }
    int max = 0;
    for (int i = 0; i < rows; i++) {
        if (dp[i] > max) max = dp[i];
    }
    printf("%d\n", max);
}
