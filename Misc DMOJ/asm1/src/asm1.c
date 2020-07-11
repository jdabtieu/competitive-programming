#include <stdio.h>
/* 
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
int main(void) {
    int a, b, c, d;
    scanf("%i\n%i", &a, &b);
    while (a > 1) {
        scanf("%i", &c);
        if (c > b) {
            b = c;
        }
        if (c < d) {
            d = c;
        }
        a--;
    }
    printf("%i %i\n", d, b);
}