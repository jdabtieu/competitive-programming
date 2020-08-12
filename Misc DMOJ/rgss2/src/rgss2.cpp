#include <bits/stdc++.h>
/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
using namespace std;

int main() {
    int num, minX = -1000, minY = -1000, maxX = 1000, maxY = 1000; scanf("%d", &num);

    for (int i = 0; i < num; i++) {
        int x, y; scanf("%d%d", &x, &y);

        if (x < maxX) maxX = x;
        else if (x > minX) minX = x;

        if (y < maxY) maxY = y;
        else if (y > minY) minY = y;
    }

    printf("%d", (maxX - minX) * (maxY - minY));
}
