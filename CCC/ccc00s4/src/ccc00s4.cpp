#include <bits/stdc++.h>

using namespace std;

int dp[5381];
vector<int> clubs;

int main() {
    memset(dp, 0x3f, 5281 * sizeof(int));
    int n, c; cin >> n >> c;
    for (int i = 0; i < c; i++) {
        int x; cin >> x;
        clubs.push_back(x);
    }
    dp[0] = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < c; j++) {
            dp[i+clubs[j]] = min(dp[i+clubs[j]], dp[i] + 1);
        }
    }
    if (dp[n] == 0x3f3f3f3f) {
        cout << "Roberta acknowledges defeat.\n";
    } else {
        cout << "Roberta wins in " << dp[n] << " strokes.\n";
    }
}
