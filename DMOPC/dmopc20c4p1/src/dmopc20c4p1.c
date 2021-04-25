#include <stdio.h>
#pragma GCC optimize ("Ofast")
#pragma GCC target("avx,avx2,fma")

int main() {
    int cases; scanf("%d", &cases);
    while (cases--) {
        int n, sum; scanf("%d%d", &n, &sum);
        int diff = (int) (n * (n + 1LL) / 2 - sum);
        int L = 1, H = diff - 1;
        if (H > n) {
            L = diff - n;
            H = n;
        }
        printf("%d\n", (H - L + 1)/2);
    }
}
