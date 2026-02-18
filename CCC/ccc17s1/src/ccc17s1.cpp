#include <bits/stdc++.h>

using namespace std;

int main() {
    cin.tie(0); cin.sync_with_stdio(0);
    int n; cin >> n;
    int a[n];
    for (int i = 0; i < n; i++) cin >> a[i];
    int ans = 0, bal = 0;
    for (int c, i = 0; i < n; i++) {
        cin >> c;
        bal += a[i] - c;
        if (bal == 0) ans = i + 1;
    }
    cout << ans << "\n";
}
