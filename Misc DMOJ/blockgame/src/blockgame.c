#include <stdio.h>

int main() {
    int n, k, d;
    scanf("%d%d%d", &n, &k, &d);
    double jdabtieu;
    scanf("%lf", &jdabtieu);
    while (n--) {
        int a, b;
        scanf("%d%d", &a, &b);
        k += a;
        d += b;
    }
    if (d == 0) printf("stop hacking!\n");
    else printf((double) k / d >= jdabtieu ? "Y\n" : "N\n");
}
