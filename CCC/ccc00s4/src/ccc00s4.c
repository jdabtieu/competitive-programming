#include <stdio.h>
/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
int main() {
    int dist, clubCount; scanf("%d%d", &dist, &clubCount);
    int strokes[dist + 1];
    int clubs[clubCount];
    strokes[0] = 0;
    for (int i = 1; i <= dist; i++) strokes[i] = 10000;
    for (int i = 0; i < clubCount; i++) scanf("%d", &clubs[i]);

    for (int i = 0; i <= dist; i++) {
        if (strokes[i] == 10000) continue;
        for (int j = 0; j < clubCount; j++) {
            if (i + clubs[j] <= dist && strokes[i + clubs[j]] > strokes[i] + 1) strokes[i + clubs[j]] = strokes[i] + 1;
        }
    }

    if (strokes[dist] == 10000) printf("Roberta acknowledges defeat.");
    else printf("Roberta wins in %d strokes.", strokes[dist]);
    return 0;
}