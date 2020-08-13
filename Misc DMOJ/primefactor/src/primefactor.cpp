#include <bits/stdc++.h>
/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
using namespace std;

int main() {
    int cases; scanf("%d", &cases);
    while (cases--) {
        int num; scanf("%d", &num);

        while (num % 2 == 0) {
            printf("%d ", 2);
            num /= 2;
        }

        int ceil = floor(sqrt(num));
        for (int i = 3; i <= ceil; i += 2) {
            if (num % i == 0) {
                printf("%d ", i);
                num /= i;
                i -= 2;
            }
        }
        if (num == 1) printf("\n");
        else printf("%d\n", num);
    }
}