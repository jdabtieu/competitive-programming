#include <bits/stdc++.h>

using namespace std;

int arr[5000];
int ans[5001];
int n;

int main() {
    cin.tie(0); cin.sync_with_stdio(0);
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    fill(ans, ans+5001, 0x3f3f3f3f);
    for (int c = 0; c < n; c++) { // center, odd len crops
        int diff = 0;
        for (int i = 1; c - i >= 0 && c + i < n; i++) {
            int key = 2 * i + 1;
            diff += abs(arr[c+i] - arr[c-i]);
            ans[key] = min(ans[key], diff);
        }
    }
    for (int c = 1; c < n; c++) { // center, even len crops
        int diff = 0;
        for (int i = 1; c+i-1 < n && c - i >= 0; i++) {
            int key = 2 * i;
            diff += abs(arr[c+i-1] - arr[c-i]);
            ans[key] = min(ans[key], diff);
        }
    }
    ans[1] = 0;
    for (int i = 1; i < n; i++) cout << ans[i] << " ";
    cout << ans[n] << "\n";
}
