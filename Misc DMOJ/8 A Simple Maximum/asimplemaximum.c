#include <stdio.h>
#include <stdlib.h>
int main(void) {
    int *a = (int *)malloc(sizeof(int)), *b = (int *)malloc(sizeof(int)), *c = (int *)malloc(sizeof(int)), *d = (int *)malloc(sizeof(int));
    scanf("%i\n%i", a, b);
    while (*a > 1) {
        scanf(" %i", c);
        if (*c > *b) {
            *b = *c;
        }
        if (*c < *d) {
            *d = *c;
        }
        (*a)--;
    }
    printf("%i %i\n", *d, *b);
    free(a);
    free(b);
    free(c);
    free(d);
}