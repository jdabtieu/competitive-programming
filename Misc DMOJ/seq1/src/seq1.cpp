#include <bits/stdc++.h>
/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */

typedef unsigned long long llu;
typedef long long ll;
typedef unsigned int uint;

using namespace std;

llu qpow(llu a, llu n, llu m);

int main() {
    llu num; scanf("%llu", &num);
    num = qpow(2, num, 1000000007) - 1;
    num = (num * 8) % 1000000007;
    num = (num + 3) % 1000000007;
    if (num < 0) num += 1000000007;
    printf("%llu\n", num);
}

// a^b % m --> qpow(a, b, m)

llu mul_mod(llu a, llu b, llu m) {
    if (m == 0) return a * b;
    llu r = 0;
    while (a > 0) {
        if (a & 1)
            if((r += b) > m) r %=m;
        a >>= 1;
        if ((b <<= 1) > m) b %= m;
    }
    return r;
}

llu qpow(llu a, llu n, llu m) {
    llu r = 1;
    while (n > 0) {
        if (n & 1)
            r = mul_mod(r, a, m);
        a = mul_mod(a, a, m);
        n >>= 1;
    }
    return r;
}