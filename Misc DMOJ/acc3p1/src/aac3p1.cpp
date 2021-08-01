#include <bits/stdc++.h>
using namespace std;
const int MM = 1e6+5;
int n, k, a[MM], freq[MM], distinct;
long long ans;
/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
int main() {
    scanf("%d%d", &n, &k);
    for (int i = 0; i < n; i++) scanf("%d", &a[i]);
    for (int l = 0, r = 0; r < n; r++) {
        freq[a[r]]++;
        if (freq[a[r]] == 1) distinct++;
        while (distinct >= k) {
            ans += n - r;
            freq[a[l]]--;
            if (freq[a[l]] == 0) distinct--;
            l++;
        }
    }
    printf("%lld\n", ans);
}
