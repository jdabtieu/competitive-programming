#include <bits/stdc++.h>
#pragma GCC optimize ("Ofast")

using namespace std;
/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
int g[1001][1001];
const int mod = 1000000007;
int main() {
    int r, c;
    cin >> r >> c;
    for (int i = 0; i < r; i++) {
        string s;
        cin >> s;
        for (int j = 0; j < c; j++) {
            if (s[j] == '#') g[i][j] = -1;
        }
    }
    g[0][0] = 1;
    for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
            if (g[i][j] == -1) continue;
            if (g[i+1][j] != -1) g[i+1][j] = (g[i+1][j] + g[i][j]) % mod;
            if (g[i][j+1] != -1) g[i][j+1] = (g[i][j+1] + g[i][j]) % mod;
        }
    }
    cout << g[r-1][c-1] << endl;
}
