#include <bits/stdc++.h>

using namespace std;

typedef long long ll;

int ans[1000000];

int main() {
    int n, maxp; cin >> n >> maxp;
    ll tgt; cin >> tgt;
    if (tgt < n) {
        cout << -1 << "\n";
        return 0;
    }
    ll sum = 0; int i = 0, emaxp = 0;
    for (; i < maxp; i++) { // phase 1 - fill 1 -> n
        if (sum + (n - i - 1) + (i+1) > tgt) break;
        ans[i] = i + 1;
        sum += ans[i];
        emaxp++;
    }
    for (; i < n; i++) { // phase 2 - repeat
        if (sum + emaxp + (n - i - 1) <= tgt) {
            ans[i] = ans[i - emaxp];
            sum += emaxp;
        } else {
            ans[i] = ans[i - (int) (tgt - (n - i - 1) - sum)];
            sum += tgt - (n - i - 1) - sum;
            break;
        }
    }
    i++;
    for (; i < n; i++) { // phase 3 - fill 1
        ans[i] = ans[i-1];
        sum += ans[i];
    }
    if (sum < tgt) cout << -1 << "\n";
    else {
        cout << ans[0];
        for (i = 1; i < n; i++) {
            cout << " " << ans[i];
        }
        cout << "\n";
    }
}
