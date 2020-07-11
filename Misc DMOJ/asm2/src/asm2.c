#include <stdlib.h>
#include <stdio.h>
/* 
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
int main(void) {
    int a, b;
    scanf("%i\n%i", &a, &b);
    int numbers[201];
    for (int i = 0; i < 201; i++) numbers[i] = 0;
    numbers[b + 100]++;
    while (a > 1) {
        scanf("%i", &b);
        numbers[b + 100]++;
        a--;
    }
    int max = 0;
    for (int i = 0; i < 201; i++) if (numbers[i] > max) max = numbers[i];
    for (int i = 0; i < 201; i++) if (numbers[i] == max) {
        printf("%i\n", i - 100);
        return 0;
    }
}