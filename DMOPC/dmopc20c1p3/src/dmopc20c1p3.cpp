#include <bits/stdc++.h>

#define uint_64 unsigned long long
#define int_64 long long
#define uint unsigned int

using namespace std;

int main() {
    int nums; scanf("%d", &nums);
    int set[nums];
    int max = -1000000000, maxIndex = 0;
    int_64 t = 0;

    for (int i = 0; i < nums; i++) {
        scanf("%d", &set[i]);
        if (set[i] > max) {
            max = set[i];
            maxIndex = i;
        }
    }
    for (int i = 1; i < maxIndex; i++) {
        if (set[i] < set[i - 1]) {
            t += set[i - 1] - set[i];
            set[i] = set[i - 1];
        }
    }
    for (int i = nums - 2; i > maxIndex; i--) {
        if (set[i] < set[i + 1]) {
            t += set[i + 1] - set[i];
            set[i] = set[i + 1];
        }
    }
    printf("%lld\n", t);
}