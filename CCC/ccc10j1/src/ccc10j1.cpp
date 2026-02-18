#include <bits/stdc++.h>

using namespace std;

int main() {
    cin.tie(0); cin.sync_with_stdio(0);
    int n, ans = 0;
    cin >> n;
    for (int i = min(n, 5); i >= 1; i--) {
        if (n - i > i) break;
        ans++;
    }
    cout << ans << "\n";
}
