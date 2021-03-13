#include <stdio.h>
#include <math.h>
#pragma GCC optimize ("Ofast")
#pragma GCC target("avx,avx2,fma")
/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */

int main() {
    int x; scanf("%d", &x);
    int target = sqrt(2 * x) - 1;
    int tmp = target * target / 2 + (target + 1);
    if (tmp < x) target++;
    printf("%d\n", target);
}
