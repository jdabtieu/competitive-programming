#include <bits/stdc++.h>
/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
using namespace std;

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);

    string in; cin >> in;
    int len; cin >> len;

    string out = in.substr(0, len);
    for (int i = 1; i < in.length() - len + 1; i++) {
        if (in.substr(i, len).compare(out) < 0) out = in.substr(i, len);
    }
    cout << out;
}