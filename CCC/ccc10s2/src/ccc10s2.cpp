#include <bits/stdc++.h>

using namespace std;
/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
int main() {
    unordered_map<string, string> m;
    int n; cin >> n;
    for (int i = 0; i < n; i++) {
        string a, b;
        cin >> a >> b;
        m[b] = a;
    }
    string x; cin >> x;
    for (int i = 0, j = 1; i < x.length(); j++) {
        if (m.find(x.substr(i, j)) != m.end()) {
            cout << m[x.substr(i, j)];
            i += j;
            j = 0;
        }
    }
    cout << "\n";
}
