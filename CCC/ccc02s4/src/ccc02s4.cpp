#include <bits/stdc++.h>

using namespace std;

int best[101];
string name[101];
int tim[101];

void ans(int idx) {
    if (idx < 1) return;
    ans(best[idx]);
    for (int i = best[idx] + 1; i < idx; i++) cout << name[i] << " ";
    cout << name[idx] << "\n";
}

int main() {
    int m, q; cin >> m >> q;
    for (int i = 1; i <= q; i++) {
        cin >> name[i] >> tim[i];
    }
    int dp[q+1];
    memset(dp, 0x3f, (q+1) * sizeof(int));
    dp[0] = 0;
    for (int i = 1; i <= q; i++) {
        for (int j = 1; j <= min(i, m); j++) {
            int maxt = 0;
            for (int k = i - j + 1; k <= i; k++) maxt = max(maxt, tim[k]);
            if (dp[i-j] + maxt < dp[i]) {
                dp[i] = dp[i-j] + maxt;
                best[i] = i - j;
            }
        }
    }
    cout << "Total Time: " << dp[q] << "\n";
    ans(q);
}
