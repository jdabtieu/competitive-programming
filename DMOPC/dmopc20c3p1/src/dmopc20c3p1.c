#include <stdio.h>
#include <stdbool.h>
#pragma GCC optimize ("Ofast")
/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */

bool x[1000001];

int main() {
    int n; scanf("%d", &n);
    while (n--) {
        int p; scanf("%d", &p);
        if (x[p]) {
            puts("NO");
            return 0;
        } else {
            x[p] = true;
        }
    }
    puts("YES");
}
