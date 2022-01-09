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


int ans[101];
/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
int main() {
    unordered_set<int> taken[101];
    vector<int> adj[151];
    int n, m; scanf("%d%d", &n, &m);
    for (int i = 0; i < m; i++) {
        int a, b;
        scanf("%d%d", &a, &b);
        adj[a].pb(b);
        adj[b].pb(a);
    }
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= 4; j++) {
            if (taken[i].find(j) != taken[i].end()) continue;
            ans[i] = j;
            for (auto &e : adj[i]) {
                taken[e].emplace(j);
            }
            break;
        }
    }
    for (int i = 1; i <= n; i++) printf("%d", ans[i]);
}
