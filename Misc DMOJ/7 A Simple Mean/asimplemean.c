#include <stdio.h>
#include <stdlib.h>
int main(void) {
    int *a = (int *)malloc(sizeof(int)), *b = (int *)malloc(sizeof(int)), *c = (int *)malloc(sizeof(int));
    scanf("%i %i %i", a, b, c);
    printf("%i\n", (*a + *b + *c) / 3);
    free(a);
    free(b);
    free(c);
}