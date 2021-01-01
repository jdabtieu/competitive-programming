#include <bits/stdc++.h>
/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */

typedef unsigned long long llu;
typedef long long ll;
typedef unsigned int uint;

using namespace std;

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);

    string num;
    cin >> num;

    if (num.length() > 2) {
        puts("999999998");
        return 0;
    }

    ll len = stoll(num);
    if (len > 16) {
        puts("999999998");
        return 0;
    }
    if (len == 16) {
        puts("99999998");
        return 0;
    }
    if (len == 1) {
        puts("9");
        return 0;
    }
    printf("1");
    if (len & 1) printf("0");
    for (ll i = len / 2 - 1; i > 0; i--) printf("9");
    puts("8");
}
