#include <bits/stdc++.h>

using namespace std;

int cols, rows, tgtr, tgtc;
char ans[2000][2000];

int main() {
    cin.tie(0); cin.sync_with_stdio(0);
    cin >> rows >> cols >> tgtr >> tgtc;
    // lemma: will always be possible if tgtr < rows && tgtc < cols
    // if tgtr == rows, it is possible if tgtc % 2 == cols % 2 or cols is odd
    // if tgtc == cols, it is possible if tgtr % 2 == tgtr % 2 or rows is odd
    // special case if tgtr == 0 or tgtc == 0
    if (tgtr < rows && tgtc < cols) {
        for (int i = 0; i < tgtr; i++) {
            for (int j = 0; j < cols; j++) {
                ans[i][j] = 'a';
            }
        }
        for (int i = 0; i < tgtc; i++) {
            for (int j = 0; j < rows; j++) {
                ans[j][i] = 'a';
            }
        }
        for (int i = tgtr; i < rows; i++) {
            for (int j = tgtc; j < cols; j++) {
                ans[i][j] = 'b';
            }
        }
        if (tgtr == 0 && tgtc == 0) {
            for (int i = 0; i < rows; i++) ans[i][0] = 'd';
            for (int i = 0; i < cols; i++) ans[0][i] = 'd';
            ans[0][0] = 'e';
        } else if (tgtr == 0) {
            for (int i = tgtc; i < cols; i++) ans[rows-1][i] = 'f';
        } else if (tgtc == 0) {
            for (int i = tgtr; i < rows; i++) ans[i][cols-1] = 'f';
        }
    } else if (tgtr == rows && tgtc == cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ans[i][j] = 'a';
            }
        }
    } else if (tgtr == rows) {
        if (tgtc % 2 != cols % 2) {
            if (cols % 2 == 0) {
                this_thread::sleep_for(chrono::milliseconds(300));
                cout << "IMPOSSIBLE\n";
                return 0;
            }
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    ans[i][j] = 'a';
                }
            }
            int chg = cols - tgtc;
            ans[0][cols/2] = 'm';
            for (int i = cols / 2 - chg / 2; i <= cols / 2 + chg / 2; i++) {
                ans[0][i] = 'm';
            }
        } else {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    ans[i][j] = 'a';
                }
            }
            int l, r;
            if (tgtc % 2 == 1) {
                l = (cols / 2) - tgtc / 2; // [0, l)
                r = (cols / 2) + (tgtc + 1) / 2; // [r, cols)
            } else {
                l = cols / 2 - tgtc / 2;
                r = cols / 2 + tgtc / 2;
            }
            for (int i = 0; i < l; i++) ans[0][i] = 'b';
            for (int i = r; i < cols; i++) ans[0][i] = 'b';
        }
    } else if (tgtc == cols) {
        if (tgtr % 2 != rows % 2) {
            if (rows % 2 == 0) {
                this_thread::sleep_for(chrono::milliseconds(300));
                cout << "IMPOSSIBLE\n";
                return 0;
            }
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    ans[i][j] = 'a';
                }
            }
            int chg = rows - tgtr;
            ans[rows/2][0] = 'm';
            for (int i = rows / 2 - chg / 2; i <= rows / 2 + chg / 2; i++) {
                ans[i][0] = 'm';
            }
        }
        else {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    ans[i][j] = 'a';
                }
            }
            int l, r;
            if (tgtr % 2 == 1) {
                l = (rows / 2) - tgtr / 2; // [0, l)
                r = (rows / 2) + (tgtr + 1) / 2; // [r, cols)
            } else {
                l = rows / 2 - tgtr / 2;
                r = rows / 2 + tgtr / 2;
            }
            for (int i = 0; i < l; i++) ans[i][0] = 'b';
            for (int i = r; i < rows; i++) ans[i][0] = 'b';
        }
    }
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            cout << ans[i][j];
        }
        cout << "\n";
    }
}
