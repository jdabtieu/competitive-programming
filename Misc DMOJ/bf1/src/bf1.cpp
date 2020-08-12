#include <bits/stdc++.h>
/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
using namespace std;

int main() {
    int nums; scanf("%d", &nums);
    priority_queue<int, vector<int>, greater<int>> queue;
    for (int i = 0; i < nums; i++) {
        int tmp; scanf("%d", &tmp);
        queue.push(tmp);
    }
    for (int i = 0; i < nums; i++) {
        printf("%d\n", queue.top());
        queue.pop();
    }
    return 0;
}