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
/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
int main() {
    int cows[3];
    scanf("%d%d%d", &cows[0], &cows[1], &cows[2]);
    sort(cows, cows+3);
    int a1;
    if (cows[2] - cows[0] == 2) a1 = 0;
    else if (cows[1] - cows[0] == 2 || cows[2] - cows[1] == 2) a1 = 1;
    else a1 = 2;

    if (cows[1] - cows[0] < cows[2] - cows[1]) {
        int tmp = cows[0];
        cows[0] = cows[1] - (cows[2] - cows[1]);
        cows[2] = cows[1] - tmp + cows[1];
    }
    int a2 = cows[1] - cows[0] - 1;
    printf("%d\n%d\n", a1, a2);
}
