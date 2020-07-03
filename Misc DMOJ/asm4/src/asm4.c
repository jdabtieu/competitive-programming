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
    int sums = a;
    int res = 1;
    if (binB[0] != '0') res = sums;

    for (int i = 1; i < bDigits; i++) {
        sums = (int) (((long) sums * sums) % c);
        if (binB[i] != '0') {
            res = (int) ((res * (long) sums) % c);
        }
    }
    if (res < 0) res += c;
    printf("%i\n", res);
    free(binB);
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