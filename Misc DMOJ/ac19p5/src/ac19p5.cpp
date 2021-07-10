#include <bits/stdc++.h>
#pragma GCC optimize ("Ofast")

#define pb push_back
typedef unsigned long long llu;
typedef long long ll;
typedef unsigned int uint;
typedef __uint128_t lllu;
typedef __int128_t lll;
/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
using namespace std;

ll dp[1505][1505];
int grid[1505][1505];
bool vis[1505][1505];
int n;

void dfs(int x, int y);

int main() {
    scanf("%d", &n);
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            scanf("%d", &grid[i][j]);
        }
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (!vis[i][j]) dfs(i, j);
        }
    }

    ll ans = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            ans = max(ans, dp[i][j]);
        }
    }
    printf("%lld", ans-1);
}

void dfs(int x, int y) {
    vis[x][y] = true;
    ll ans = 0;
    if (x > 0 && grid[x][y] < grid[x-1][y]) {
        if (!vis[x-1][y]) dfs(x-1, y);
        ans = max(ans, dp[x-1][y]);
    }
    if (y > 0 && grid[x][y] < grid[x][y-1]) {
        if (!dp[x][y-1]) dfs(x, y-1);
        ans = max(ans, dp[x][y-1]);
    }
    if (x < n-1 && grid[x][y] < grid[x+1][y]) {
        if (!vis[x+1][y]) dfs(x+1, y);
        ans = max(ans, dp[x+1][y]);
    }
    if (y < n-1 && grid[x][y] < grid[x][y+1]) {
        if (!vis[x][y+1]) dfs(x, y+1);
        ans = max(ans, dp[x][y+1]);
    }
    dp[x][y] = ans + 1;
}
