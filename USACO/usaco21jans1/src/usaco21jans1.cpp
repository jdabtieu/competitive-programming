#include <bits/stdc++.h>
#include <unistd.h>
#pragma GCC optimize ("Ofast")

#define pb push_back
#define pii pair<int, int>
typedef unsigned long long llu;
typedef long long ll;
typedef unsigned int uint;
typedef __uint128_t lllu;
typedef __int128_t lll;

using namespace std;
#define SZ 100001

/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
int nxt[SZ];
unordered_set<int> path[SZ];
int ans[SZ];

int main() {
    int n, k; scanf("%d%d", &n, &k);
    for (int i = 1; i <= n; i++) {
        nxt[i] = i;
        path[i].emplace(i);
    }
    for (int i = 0; i < k; i++) {
        int x, y; scanf("%d%d", &x, &y);
        path[nxt[x]].emplace(y);
        path[nxt[y]].emplace(x);
        int tmp = nxt[x];
        nxt[x] = nxt[y];
        nxt[y] = tmp;
    }
    for (int i = 1; i <= n; i++) {
        if (ans[i] != 0) continue;
        unordered_set<int> cnt;
        vector<int> pass;
        cnt.insert(path[i].begin(), path[i].end());
        pass.pb(i);
        int curr = nxt[i];
        while (curr != i) {
            cnt.insert(path[curr].begin(), path[curr].end());
            pass.pb(curr);
            curr = nxt[curr];
        }
        for (auto &it : pass) {
            ans[it] = cnt.size();
        }
    }
    for (int i = 1; i <= n; i++) {
        printf("%d\n", ans[i]);
    }
}
