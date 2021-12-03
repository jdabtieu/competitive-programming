#include <bits/stdc++.h>
#pragma GCC optimize ("Ofast")


#define pb push_back
#define pii pair<int, int>
typedef unsigned long long llu;
typedef long long ll;
typedef unsigned int uint;
typedef __uint128_t lllu;
typedef __int128_t lll;

using namespace std;

int pv[200000];
int ans[200000];
int nxt[200000];
int main() {
    int n;
    scanf("%d", &n);
    for (int i = 0; i < n; i++) scanf("%d", &pv[i]);
    int bsz = (int) sqrt(n);
    nxt[n-1] = n;
    ans[n-1] = 1;
    for (int i = n - 2; i >= 0; i--) {
        if (i + pv[i] >= n) { // end
            nxt[i] = n;
            ans[i] = 1;
        } else {
            if (i+pv[i] >= bsz * (i / bsz + 1)) { // next block
                nxt[i] = i+pv[i];
                ans[i] = 1;
            } else {
                nxt[i] = nxt[i+pv[i]];
                ans[i] = ans[i+pv[i]] + 1;
            }
        }
    }
    int queries;
    scanf("%d", &queries);
    for (; queries > 0; queries--) {
        int type;
        scanf("%d", &type);
        if (type == 1) {
            int sqr;
            scanf("%d", &sqr);
            int a = 0;
            while (sqr != n) {
                a += ans[sqr];
                sqr = nxt[sqr];
            }
            printf("%d\n", a);
        } else {
            int sqr;
            scanf("%d", &sqr);
            scanf("%d", &pv[sqr]);
            for (int i = sqr; i >= (i / bsz) * bsz; i--) {
                if (i + pv[i] >= n) { // end
                    nxt[i] = n;
                    ans[i] = 1;
                } else {
                    if (i+pv[i] >= bsz * (i / bsz + 1)) { // next block
                        nxt[i] = i+pv[i];
                        ans[i] = 1;
                    } else {
                        nxt[i] = nxt[i+pv[i]];
                        ans[i] = ans[nxt[i]] + 1;
                    }
                }
            }
        }
    }
}
