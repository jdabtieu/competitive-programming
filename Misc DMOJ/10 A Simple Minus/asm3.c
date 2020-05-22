#include <stdio.h>
/* 
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
int main() {
    int length; scanf("%i\n", &length);
    length--;
    int XOR[length];
    int x, y; scanf("%i", &y);
    for (int i = 0; i < length; i++) {
        x = y;
        scanf("%i", &y);
        XOR[i] = x ^ y;
    }
    x = 214748364, y = -214748364;
    for (int i = 0; i < length; i++) {
        if (XOR[i] < x) x = XOR[i];
        if (XOR[i] > y) y = XOR[i];
    }
    printf("%i\n", y - x);
    return 0;
}
