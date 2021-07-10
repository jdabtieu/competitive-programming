#include <bits/stdc++.h>
#pragma GCC optimize ("Ofast")
/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
#define pb push_back

typedef unsigned long long llu;
typedef long long ll;
typedef unsigned int uint;
typedef __uint128_t lllu;
typedef __int128_t lll;

using namespace std;

const int MM = 5e5+5;
int n;
int d1[MM];
int d2[MM];
int p[MM];
int ans[MM];
vector<int> adj[MM];

void dfs1(int curr, int pa);
void dfs2(int curr, int pa);

int main() {
    scanf("%d", &n);
    for (int i = 1; i < n; i++) {
        int x, y;
        scanf("%d%d", &x, &y);
        adj[x].pb(y);
        adj[y].pb(x);
    }
    dfs1(1, 0);
    dfs2(1, 0);
    for (int i = 1; i <= n; i++) {
        printf("%d\n", ans[i]);
    }
}

void dfs2(int curr, int pa) {
    ans[curr] = max(p[curr], d1[curr]) + 1;
    for (int node : adj[curr]) {
        if (node == pa) continue;
        if (d1[curr] == d1[node] + 1) {
            p[node] = max(p[curr], d2[curr]) + 1;
        } else {
            p[node] = max(p[curr], d1[curr]) + 1;
        }
        dfs2(node, curr);
    }
}

void dfs1(int curr, int pa) {
    for (int node : adj[curr]) {
        if (node == pa) continue;
        dfs1(node, curr);
        if (d1[node] >= d1[curr]) {
            d2[curr] = d1[curr];
            d1[curr] = d1[node] + 1;
        } else if (d1[node] >= d2[curr]) {
            d2[curr] = d1[node] + 1;
        }
    }
}
