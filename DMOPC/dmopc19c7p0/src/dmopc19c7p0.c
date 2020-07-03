#include <stdio.h>
/* 
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
int main() {
    int a, b, c, d;
    scanf("%i%i%i%i", &a, &b, &c, &d);
    printf("%.6f\n", (a + b)/2.0);
    printf("%.6f\n", (a + c)/2.0);
    printf("%.6f\n", (a + d)/2.0);
    printf("%.6f\n", (b + c)/2.0);
    printf("%.6f\n", (b + d)/2.0);
    printf("%.6f\n", (c + d)/2.0);
    printf("%.6f\n", (a + b + c)/3.0);
    printf("%.6f\n", (a + b + d)/3.0);
    printf("%.6f\n", (a + c + d)/3.0);
    printf("%.6f\n", (b + c + d)/3.0);
    printf("%.6f\n", (a + b + c + d)/4.0);
    return 0;
}