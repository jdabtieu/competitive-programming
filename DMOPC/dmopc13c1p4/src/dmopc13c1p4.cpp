#include <bits/stdc++.h>
/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */

typedef unsigned long long llu;
typedef long long ll;
typedef unsigned int uint;
typedef __uint128_t lllu;
typedef __int128_t lll;

using namespace std;

int readInt();

int main() {
    for (int cases = readInt(); cases > 0; cases--) {
        int cols = readInt(), rows = readInt();
        int visited[rows][cols];
        pair<int, int> start, end;
        for (int i = 0; i < rows; i++) {
            char row[cols + 1]; scanf("%s", &row[0]);
            for (int j = 0; j < cols; j++) {
                switch (row[j]) {
                case 'O':
                    visited[i][j] = 0;
                    break;
                case 'X':
                    visited[i][j] = -1;
                    break;
                case 'C':
                    visited[i][j] = 0;
                    start = make_pair(i, j);
                    break;
                case 'W':
                    visited[i][j] = 0;
                    end = make_pair(i, j);
                    break;
                }
            }
        }

        queue<pair<int, int>> queue;
        queue.push(start);
        while (!queue.empty()) {
            pair <int, int> curr = queue.front();
            queue.pop();
            if (curr.first > 0 && visited[curr.first - 1][curr.second] == 0) {
                queue.push(make_pair(curr.first - 1, curr.second));
                visited[curr.first - 1][curr.second] = visited[curr.first][curr.second] + 1;
            }
            if (curr.second > 0 && visited[curr.first][curr.second - 1] == 0) {
                queue.push(make_pair(curr.first, curr.second - 1));
                visited[curr.first][curr.second - 1] = visited[curr.first][curr.second] + 1;
            }
            if (curr.first < rows - 1 && visited[curr.first + 1][curr.second] == 0) {
                queue.push(make_pair(curr.first + 1, curr.second));
                visited[curr.first + 1][curr.second] = visited[curr.first][curr.second] + 1;
            }
            if (curr.second < cols - 1 && visited[curr.first][curr.second + 1] == 0) {
                queue.push(make_pair(curr.first, curr.second + 1));
                visited[curr.first][curr.second + 1] = visited[curr.first][curr.second] + 1;
            }
        }
        int count = visited[end.first][end.second];
        if (count >= 60 || count < 1) puts ("#notworth");
        else printf("%d\n", count);
    }
}


int readInt() {
    int tmp; scanf("%i", &tmp);
    return tmp;
}
