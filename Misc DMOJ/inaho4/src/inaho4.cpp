#include <bits/stdc++.h>
/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
using namespace std;

int main() {
    int dimensions; scanf("%d", &dimensions);

    double dist = 0;

    double posA[dimensions];
    for (int i = 0; i < dimensions; i++) scanf("%lf", &posA[i]);

    for (int i = 0; i < dimensions; i++) {
        double tmp; scanf("%lf", &tmp);
        dist += (tmp - posA[i]) * (tmp - posA[i]);
    }

    printf("%.6f", sqrt(dist));
}
