#include <bits/stdc++.h>

using namespace std;

int main() {
    cin.tie(0); cin.sync_with_stdio(0);
    unordered_map<int, int> r;
    int n; cin >> n;
    for (int i = 0; i < n; i++) {
        int x; cin >> x;
        r[x]++;
    }
    int hi = -1, freq = 0, prev = -1, key = -1;
    for (auto const& [ k, v ] : r) {
        if (v > hi) {
            prev = hi;
            hi = v;
            freq = 1;
            key = k;
        } else if (v == hi) {
            freq++;
        }
    }
    if (freq == 1) { // one high reading
        int a1 = n, a2 = 0;
        for (auto const& [ k, v ] : r) {
            if (v == prev) {
                a1 = min(a1, k);
                a2 = max(a2, k);
            }
        }
        cout << max(key - a1, a2 - key) << "\n";
    } else { // two high
        int a1 = n, a2 = 0;
        for (auto const& [ k, v ] : r) {
            if (v == hi) {
                a1 = min(a1, k);
                a2 = max(a2, k);
            }
        }
        cout << a2 - a1 << "\n";
    }
}
