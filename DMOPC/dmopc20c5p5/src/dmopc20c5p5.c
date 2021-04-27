#include <stdio.h>
#pragma GCC optimize ("Ofast")
/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
int main() {
    int N, M; scanf("%d%d", &N, &M);
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if (__builtin_popcount(i + j) & 1) {
                printf("Y");
            } else {
                printf("B");
            }
        }
        printf("\n");
    }
}
