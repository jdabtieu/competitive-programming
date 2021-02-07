#include <stdio.h>
/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */

typedef unsigned long long llu;
typedef long long ll;
typedef unsigned int uint;


const uint MOD = 1000000013;

llu qpow(llu a, llu n, llu m);

int main() {
    llu num; scanf("%llu", &num);
    if (num == 1) {
        puts("1");
        return 0;
    }

    llu out = qpow(2, num - 2, MOD);
    llu out2 = qpow(2, num / 2 - 1, MOD);
    switch (num % 8) {
        case 3:
        case 4:
        case 5:
            out2 = (-out2 + MOD) % MOD;
            break;
        case 2:
        case 6:
            out2 = 0;
            break;
    }
    out = (out + out2) % MOD;
    if (out < 0) out += MOD;
    printf("%llu\n", out);
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