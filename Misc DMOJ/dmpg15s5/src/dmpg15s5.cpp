#include <bits/stdc++.h>
#pragma GCC optimize ("Ofast")

#define pb push_back
typedef unsigned long long llu;
typedef long long ll;
typedef unsigned int uint;
typedef __uint128_t lllu;
typedef __int128_t lll;

using namespace std;

const int MAX = 1e4+5;

static bool grid[MAX][MAX];
static bool a[MAX];
/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
int main() {
    int n, m;
    scanf("%d%d", &n, &m);
    while (m--) {
        int x, y, w, h;
        scanf("%d%d%d%d", &x, &y, &w, &h);
        grid[x][y] = !grid[x][y];
        grid[x+w][y] = !grid[x+w][y];
        grid[x][y+h] = !grid[x][y+h];
        grid[x+w][y+h] = !grid[x+w][y+h];
    }
    int ans = 0;
    for (int i = 0; i < n; i++) {
        int x = 0;
        for (int j = 0; j < n; j++) {
            a[j] ^= grid[i][j];
            x ^= a[j];
            ans += x;
        }
    }
    printf("%d", ans);
}
