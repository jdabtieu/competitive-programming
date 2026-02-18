#include <bits/stdc++.h>

using namespace std;

typedef pair<int, int> pii;

map<pii, pii, less<pii>> en;
vector<pii> g[101];
int m;

// cost, dst

int f(int root, bool ignorem) {
    int ans = 0;
    bool vis[101];
    fill(vis, vis+101, 0);
    if (ignorem) vis[m] = true;
    priority_queue<pii, vector<pii>, greater<pii>> q;
    q.push({0, root});
    while (!q.empty()) {
        pii cur = q.top();
        q.pop();
        if (vis[cur.second]) continue;
        ans += cur.first;
        vis[cur.second] = true;
        for (pii node : g[cur.second]) {
            if (vis[node.second]) continue;
            q.push(node);
        }
    }
    for (int i = 0; i < m; i++) if (!vis[i]) ans = f(root, false);
    return ans;
}

int main() {
    cin.tie(0); cin.sync_with_stdio(0);
    cin >> m;
    for (int i = 0; i < m; i++) {
        int e; cin >> e;
        int cn[e+1], cs[e+1];
        for (int j = 0; j < e; j++) {
            cin >> cn[j];
        }
        for (int j = 0; j < e; j++) {
            cin >> cs[j];
        }
        cn[e] = cn[0];
        cs[e] = cs[0];
        for (int j = 0; j < e; j++) {
            int es = min(cn[j], cn[j+1]), ee = max(cn[j], cn[j+1]);
            pii cur = {es, ee};
            if (en.find(cur) == en.end()) {
                en[cur] = {i, cs[j]};
            } else {
                int dst = en[cur].first;
                g[dst].push_back({cs[j], i});
                g[i].push_back({cs[j], dst});
                en.erase(cur);
            }
        }
    }
    for (auto const &[ k, v ] : en) {
        int src = v.first, cst = v.second;
        g[src].push_back({cst, m});
        g[m].push_back({cst, src});
    }
    int ans = 1e9;
    for (int i = 0; i <= m; i++) {
        int x = f(i, i != m);
        //cout << i << " " << x << "\n";
        ans = min(ans, x);
    }
    cout << ans << "\n";
}
