#include <bits/stdc++.h>

using namespace std;

bool w[1014751];
#include <bits/stdc++.h>

using namespace std;

bool w[1014751];

int main() {
    for (int i = 0; i < 1014751; i++) {
        int a = i % 32;
        int b = i % 1024 / 32;
        int c = i % 32768 / 1024;
        int d = i / 32768;
        bool win = false;
        if (a >= 2 && b >= 1 && d >= 2 && !w[i-65570]) win = true;
        if (a >= 1 && b >= 1 && c >= 1 && d >= 1 && !w[i-33825]) win = true;
        if (c >= 2 && d >= 1 && !w[i-34816]) win = true;
        if (b >= 3 && !w[i-96]) win = true;
        if (a >= 1 && d >= 1 && !w[i-32769]) win = true;
        w[i] = win;
    }
    int n; scanf("%d", &n);
    while (n--) {
        int a, b, c, d; scanf("%d%d%d%d", &a, &b, &c, &d);
        int i = a + b * 32 + c * 32 * 32 + d * 32 * 32 * 32;
        if (!w[i]) {
            printf("Roland\n");
        } else {
            printf("Patrick\n");
        }
    }
}

int main() {
    for (int i = 0; i < 1014751; i++) {
        int a = i % 32;
        int b = i % 1024 / 32;
        int c = i % 32768 / 1024;
        int d = i / 32768;
        bool win = false;
        if (a >= 2 && b >= 1 && d >= 2 && !w[i-65570]) win = true;
        if (a >= 1 && b >= 1 && c >= 1 && d >= 1 && !w[i-33825]) win = true;
        if (c >= 2 && d >= 1 && !w[i-34816]) win = true;
        if (b >= 3 && !w[i-96]) win = true;
        if (a >= 1 && d >= 1 && !w[i-32769]) win = true;
        w[i] = win;
    }
    int n; scanf("%d", &n);
    while (n--) {
        int a, b, c, d; scanf("%d%d%d%d", &a, &b, &c, &d);
        int i = a + b * 32 + c * 32 * 32 + d * 32 * 32 * 32;
        if (!w[i]) {
            printf("Roland\n");
        } else {
            printf("Patrick\n");
        }
    }
}
