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
    int a, b; scanf("%d%d", &a, &b);
    if (a >= 3 && b <= 4) puts("TroyMartian");
    if (a <= 6 && b >= 2) puts("VladSaturnian");
    if (a <= 2 && b <= 3) puts("GraemeMercurian");
}
