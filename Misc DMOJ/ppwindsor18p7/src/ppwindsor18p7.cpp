#include <bits/stdc++.h>
#pragma GCC optimize ("Ofast")

using namespace std;
/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
int v[1001], dp[1001];
int main() {
    int n;
    cin >> n;
    for (int i = 1; i <= n; i++) cin >> v[i];
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= i; j++) {
            dp[i] = max(dp[i], dp[i-j]+v[j]);
        }
    }
    cout << dp[n] << endl;
}
