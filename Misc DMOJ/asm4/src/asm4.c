#include <stdio.h>
/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
int mul_mod(int a, int b, int m) {
    if (m == 0) return a * b;
    int r = 0;
    while (a > 0) {
        if (a & 1)
            if((r += b) > m) r %=m;
        a >>= 1;
        if ((b <<= 1) > m) b %= m;
    }
    return r;
}

int qpow(int a, int n, int m) {
    int r = 1;
    while (n > 0) {
        if (n & 1)
            r = mul_mod(r, a, m);
        a = mul_mod(a, a, m);
        n >>= 1;
    }
    return r;
}

int main() {
    int a, b, c; scanf("%i%i%i", &a, &b, &c);
    printf("%i\n", qpow(a, b, c));
}