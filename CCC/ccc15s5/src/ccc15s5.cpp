#include <bits/stdc++.h>

using namespace std;
/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */

int n, m;
int a[3003], b[103], dp[3003][2][103][103];

int f(int i, bool can, int L, int R) {
    int &ret = dp[i][can][L][R];
    if (ret != -1) return ret;
    ret = 0;
    if (i <= n) {
        ret = max(ret, f(i+1, true, L, R));
        if (can) ret = max(ret, a[i] + f(i+1, false, L, R));
    }
    if (L <= R) {
        ret = max(ret, f(i, true, L+1, R));
        if (can) ret = max(ret, b[R] + f(i, false, L, R-1));
    }
    return ret;
}

int main() {
    memset(dp, -1, sizeof(dp));
    scanf("%d", &n);
    for (int i = 1; i <= n; i++) scanf("%d", &a[i]);
    scanf("%d", &m);
    for (int i = 1; i <= m; i++) scanf("%d", &b[i]);
    sort(b+1, b+m+1);
    printf("%d\n", f(1, 1, 1, m));
}
