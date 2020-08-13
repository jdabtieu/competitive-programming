#include <bits/stdc++.h>
/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
using namespace std;

bool prime(int n);

int main() {
    int n; scanf("%d", &n);

    if (n <= 2) {
        printf("%d", 2);
        return 0;
    }

    if (n % 2 == 0) n++;

    for (; true; n += 2) {
        if (prime(n)) {
            printf("%d", n);
            return 0;
        }
    }
}

bool prime(int n) {
    int ceil = floor(sqrt(n));

    for (int i = 3; i <= ceil; i += 2) {
        if (n % i == 0) return false;
    }

    return true;
}