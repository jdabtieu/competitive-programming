#include <bits/stdc++.h>
/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */

typedef unsigned long long llu;
typedef long long ll;
typedef unsigned int uint;
typedef __uint128_t lllu;

using namespace std;

bool isProbablePrime(llu n);

int main() {
    int cases; scanf("%d", &cases);
    while (cases--) {
        llu num; scanf("%llu", &num);
        puts(isProbablePrime(num) ? "PRIME" : "NOT");
    }
}

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

bool checkComposite(llu n, llu a, llu d, int p){
    llu x = qpow(a, d, n);
    if (x == 1 || x == n-1) return false;
    for (int i = 1; i < p; i++){
        x = mul_mod(x, x, n);
        if (x == n - 1) return false;
    }
    return true;
}

bool isProbablePrime(llu num){
    if (num < 4) return num == 2 || num == 3;
    if (!(num & 1)) return false;
    int p = 0;
    llu d = num - 1;
    while (!(d & 1)){
        d >>= 1;
        p++;
    }
    for (int a: {2, 5}){
        if (checkComposite(num, a, d, p)) return false;
    }
    return true;
}