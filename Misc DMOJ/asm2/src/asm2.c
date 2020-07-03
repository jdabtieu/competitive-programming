#include <stdlib.h>
#include <stdio.h>

int main(void) {
    int *a = (int *)malloc(sizeof(int)), *b = (int *)malloc(sizeof(int));
    scanf("%i\n%i",a ,b);
    int numbers[201];
    for (int i = 0; i < 201; i++) numbers[i] = 0;
    numbers[*b + 100]++;
    while (*a > 1) {
        scanf(" %i", b);
        numbers[*b + 100]++;
        (*a)--;
    }
    free(a);
    free(b);
    int max = 0;
    for (int i = 0; i < 201; i++) if (numbers[i] > max) max = numbers[i];
    for (int i = 0; i < 201; i++) if (numbers[i] == max) {
        printf("%i\n", i - 100);
        return 0;
    }
}