#include <bits/stdc++.h>
/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
using namespace std;

int main() {
    int cases; scanf("%d", &cases);
    for (; cases > 0; cases--) {
        bool found = true;
        int cars; scanf("%d", &cars);

        vector<int> top;
        stack<int> side;

        for (int i = 0; i < cars; i++) {
            int tmp; scanf("%d", &tmp);
            top.push_back(tmp);
        }

        int index = 1;

        while (!top.empty() || !side.empty()) {
            if (!top.empty() && top[top.size() - 1] == index) {
                top.erase(top.end() - 1);
                index++;
                continue;
            }
            if (!side.empty() && side.top() == index) {
                side.pop();
                index++;
                continue;
            }

            bool tmp = false;
            for (int i = top.size() - 1; i >= 0; i--) {
                if (top[i] == index) {
                    top.erase(top.begin() + i);
                    index++;
                    tmp = true;
                    break;
                } else {
                    side.push(top[i]);
                    top.erase(top.begin() + i);
                }
            }
            if (tmp) continue;

            printf("N\n");
            found = false;
            break;
        }
        if (found) printf("Y\n");
    }
}