#include <bits/stdc++.h>
/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
using namespace std;

bool primality[100001];
int sum[100001];

int main() {
    primality[0] = false;
    primality[1] = false;
    sum[0] = 0;
    sum[1] = 0;
    for (int i = 2; i < 100001; i++) primality[i] = true;
    for (int i = 2; i < 314; i++) if (primality[i]) {
        for (int j = 2; j <= 100000 / i; j++) primality[i * j] = false;
    }

    for (int i = 2; i < 100001; i++) sum[i] = primality[i] ? sum[i - 1] + i : sum[i - 1];

    for (int i = 0; i < 5; i++) {
        int num; scanf("%d", &num);
        printf("%d\n", sum[num]);
    }
}
