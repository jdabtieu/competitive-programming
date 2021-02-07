#include <bits/stdc++.h>

typedef unsigned long long llu;
typedef long long ll;
typedef unsigned int uint;
typedef __uint128_t lllu;
typedef __int128_t lll;

using namespace std;
/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
int main() {
    int cases; scanf("%d", &cases);
    while (cases--) {
        vector<char> v;
        int n; scanf("%d", &n);
        if (n == 0) {
            puts("0000");
            continue;
        }
        while (n > 0) {
            v.insert(v.begin(), (n & 1) + '0');
            n >>= 1;
        }
        int t = 4 - v.size() % 4;
        if (t != 4) while (t--) v.insert(v.begin(), '0');
        for (int i = 0; i < v.size(); i++) {
            printf("%c", v[i]);
            if (i % 4 == 3) printf(" ");
        }
        puts("");
    }
}