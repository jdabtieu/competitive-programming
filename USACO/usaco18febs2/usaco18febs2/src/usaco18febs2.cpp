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
bool dp[251][251];
int path[251];
pair<int, int> boots[251];
int main() {
    int n, b; scanf("%d%d", &n, &b);
    for (int i = 0; i < n; i++) {
        scanf("%d", &path[i]);
    }
    for (int i = 0; i < b; i++) {
        int a, b; scanf("%d%d", &a, &b);
        boots[i] = {a, b};
    }
    for (int i = 0; i < b; i++) dp[0][i] = true;
    for (int i = 0; i < n; i++) {
        bool good = false;
        for (int j = 0; j < b; j++) {
            if (!dp[i][j] && !good) continue;
            if (!dp[i][j] && boots[j].first < path[i]) continue;
            for (int k = i + 1; k <= min(n, i+boots[j].second); k++) {
                if (path[k] <= boots[j].first) dp[k][j] = true;
            }
            good = true;
        }
    }
    for (int i = 0; i < b; i++) {
        if (dp[n][i]) {
            printf("%d\n", i);
            return 0;
        }
    }
}
