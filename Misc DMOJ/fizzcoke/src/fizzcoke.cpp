#include <bits/stdc++.h>

using namespace std;

string outs[100001];

void fast();

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    fast();
}

void fast() {
    for (int i = 1; i <= 10000; i++) {
        outs[i] = string("");
    }
    int m, n;
    cin >> m >> n;
    map<int, string> map;
    while (m--) {
        int x;
        string y;
        cin >> x >> y;
        map[x] = y;
    }
    for (std::map<int, string>::iterator it = map.begin(); it != map.end(); ++it) {
        for (int i = it->first; i <= n; i += it->first) {
            outs[i] += it->second;
        }
    }
    for (int i = 1; i <= n; i++) {
        if (outs[i] == "") {
            cout << i << "\n";
        } else {
            cout << outs[i] << "\n";
        }
    }
}
