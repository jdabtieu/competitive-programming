#include <stdio.h>
#include <stdlib.h>
#include <string.h>
/* 
 * Copy-pasting code is NOT cool! Please do not copy and paste my code 
as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
char *binConvert(int num);

int main() {
    int a, b, c; scanf("%i %i %i", &a, &b, &c);
    char *binB = binConvert(b);
    int bDigits = strlen(binB);
    int sums[bDigits];
    sums[0] = a;
    for (int i = 1; i < bDigits; i++) {
        sums[i] = (int) (((long) sums[i - 1] * sums[i - 1]) % c);
    }
    int res = 1;
    for (int i = 0; i < bDigits; i++) {
        if (binB[i] != '0') {
            res = (int) ((res * (long) sums[i]) % c);
        }
    }
    if (res < 0) res += c;
    printf("%i\n", res);
}


char *binConvert(int num) {
    int i = num;
    int bits = 0;
    while (i >>= 1) bits++;
    bits++;

    char *bin = malloc((bits + 1) * sizeof(char));
    for (i = 0; i < bits; i++) {
        bin[i] = num % 2 + '0';
        num = num / 2;
    }

    return bin;
}
