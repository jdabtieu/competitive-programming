#include <bits/stdc++.h>
#pragma GCC optimize ("Ofast")

typedef unsigned long long llu;
typedef long long ll;
typedef unsigned int uint;
typedef __uint128_t lllu;
typedef __int128_t lll;

using namespace std;

vector<int> g;
/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
int binSearch(int n) {
    int lo = 0, hi = g.size();
    while (hi - lo > 1) {
        int mid = (lo + hi) / 2;
        if (g[mid] > n) hi = mid;
        else if (g[mid] == n) return mid;
        else lo = mid;
    }
    return lo;
}

int main() {
    int gates, planes; scanf("%d%d", &gates, &planes);
    for (int i = 1; i <= gates; i++) g.push_back(i);

    for (int i = 0; i < planes; i++) {
        int n; scanf("%d", &n);
        if (g[0] > n) {
            printf("%d\n", i);
            return 0;
        }
        g.erase(g.begin()+binSearch(n));
    }
    printf("%d\n", planes);
}
