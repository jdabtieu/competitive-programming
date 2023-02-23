#include <bits/stdc++.h>

using namespace std;

int arr[200002][2];
int n;

int main() {
    cin.tie(0); cin.sync_with_stdio(0);
    cin >> n;
    for (int i = 1; i <= n; i++) cin >> arr[i][0];
    for (int i = 1; i <= n; i++) cin >> arr[i][1];

    int ans = 0;
    for (int i = 1; i <= n; i++) { // top row
        if (arr[i][0] == 0) continue;
        if (i % 2 == 0) ans++; // top row
        if (i % 2 == 1 && arr[i][1] == 0) ans++;
        if (arr[i-1][0] == 0) ans++;
        if (arr[i+1][0] == 0) ans++;
    }
    for (int i = 1; i <= n; i++) { // bottom row
        if (arr[i][1] == 0) continue;
        if (i % 2 == 0) ans++; // top row
        if (i % 2 == 1 && arr[i][0] == 0) ans++;
        if (arr[i-1][1] == 0) ans++;
        if (arr[i+1][1] == 0) ans++;
    }
    cout << ans << "\n";
}
