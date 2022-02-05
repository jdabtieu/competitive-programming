#include <bits/stdc++.h>

using namespace std;
/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
int a[100];
int main() {
    int n; cin >> n;
    for (int i = 0; i < n; i++) cin >> a[i];
    sort(a, a+n);
    int l = (n-1)/2, r = l+1;
    while (l >= 0) {
        cout << a[l--] << " ";
        if (r < n) cout << a[r++] << " ";
    }
    cout << endl;
}
