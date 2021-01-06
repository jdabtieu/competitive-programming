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
    int floors = readInt(), rows = readInt(), cols = readInt();
    bool visited[rows][cols];
    for (int i = 0; i < rows; i++) {
        char row[cols + 1]; scanf("%s", &row[0]);
        for (int j = 0; j < cols; j++) {
            visited[i][j] = row[j] == 'I' ? true : false;
        }
    }

    vector<int> list;
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            if (!visited[i][j]) {
                int count = 0;
                queue<pair<int, int>> queue;
                queue.push(make_pair(i, j));
                while (!queue.empty()) {
                    pair <int, int> curr = queue.front();
                    queue.pop();
                    if (curr.first > 0 && !visited[curr.first - 1][curr.second]) {
                        queue.push(make_pair(curr.first - 1, curr.second));
                        count++;
                        visited[curr.first - 1][curr.second] = true;
                    }
                    if (curr.second > 0 && !visited[curr.first][curr.second - 1]) {
                        queue.push(make_pair(curr.first, curr.second - 1));
                        count++;
                        visited[curr.first][curr.second - 1] = true;
                    }
                    if (curr.first < rows - 1 && !visited[curr.first + 1][curr.second]) {
                        queue.push(make_pair(curr.first + 1, curr.second));
                        count++;
                        visited[curr.first + 1][curr.second] = true;
                    }
                    if (curr.second < cols - 1 && !visited[curr.first][curr.second + 1]) {
                        queue.push(make_pair(curr.first, curr.second + 1));
                        count++;
                        visited[curr.first][curr.second + 1] = true;
                    }
                }
                list.push_back(count);
            }
        }
    }
    sort(list.begin(), list.end(), greater<int>());
    int count = 0;
    for (auto &i : list) {
        printf("%d :: %d\n", i, floors);
        if (i <= floors) {
            floors -= i;
            count++;
            continue;
        }
        break;
    }
    if (count == 1) printf("1 room, %d square metre(s) left over\n", floors);
    else printf("%d rooms, %d square metre(s) left over\n", count, floors);
}

int readInt() {
    int tmp; scanf("%i", &tmp);
    return tmp;
}

