#include <bits/stdc++.h>

using namespace std;

int main() {
    int cases; scanf("%d", &cases);
    while (cases--) {
        int max = -1;
        int n; scanf("%d", &n);
        while (n--) {
            int k; scanf("%d", &k);
            if (k > max) max = k;
        }
        printf("%d\n", max);
    }
}
