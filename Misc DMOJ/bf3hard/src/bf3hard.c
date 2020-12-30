#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#include <math.h>
/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */

#define llu unsigned long long
#define bool int
#define false 0
#define true 1

const llu SMALL_PRIME_PRODUCT = 152125131763605LL;

bool isProbablePrime(llu num);
int getLowestSetBit(llu num);
int bitLength(llu num);
llu mul_mod(llu a, llu b, llu m);
llu qpow(llu a, llu n, llu m);

int main() {
    int ceiling = 479909;
    bool A[479909] = {0};
    for (int i = 2; i < sqrt(ceiling); i++) if (!A[i]) {
        for (int j = i * i; j < ceiling; j += i) A[j] = true;
    }

    srand(time(NULL));
    llu num; scanf("%llu", &num);

    if (num <= 2) {
        puts("2");
        return 0;
    }

    if ((num & 1) && isProbablePrime(num)) {
        bool flag = true;
        for (int i = 2; i < ceiling; i++) if (!A[i] && num % i == 0) {
            flag = false;
            break;
        }
        if (flag) {
            printf("%llu\n", num);
            return 0;
        }
    }

    llu result = num + 1;
    if (result % 2 == 0) result++;

    while (true) {
        if (result >= 64) {
            long r = result % SMALL_PRIME_PRODUCT;
            if ((r % 3 == 0)  || (r % 5 == 0)  || (r % 7 == 0)  || (r % 11 == 0) ||
                (r % 13 == 0) || (r % 17 == 0) || (r % 19 == 0) || (r % 23 == 0) ||
                (r % 29 == 0) || (r % 31 == 0) || (r % 37 == 0) || (r % 41 == 0)) {
                    result += 2;
                    continue;
            }
        }

        if (result < 8) {
            printf("%llu\n", result);
            return 0;
        }

        if (isProbablePrime(result)) {
            bool flag = true;
            for (int i = 2; i < ceiling; i++) if (!A[i] && result % i == 0) {
                flag = false;
                break;
            }
            if (flag) {
                printf("%llu\n", result);
                return 0;
            }
        }

        result += 2;
    }
}

bool isProbablePrime(llu num) {
    llu thisMinusOne = num - 1;
    int a = 1;
    llu m = thisMinusOne >> a;

    for (int i = 0; i < 100; i++) {
        llu b;
        do {
            b = rand() % (llu) pow(2, bitLength(num));
        } while (b <= 1 || b >= num);

        llu z = qpow(b, m, num);
        if (!(z == 1 || z == thisMinusOne)) return false;
    }
    return true;
}

int getLowestSetBit(llu num) {
    if (num & 1) return 1;
    int res = 1;
    while (true) {
        num >>= 1;
        res <<= 1;
        if (num & 1) return res;
    }
}

int bitLength(llu num) {
    return floor(log2(num)) + 1;
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