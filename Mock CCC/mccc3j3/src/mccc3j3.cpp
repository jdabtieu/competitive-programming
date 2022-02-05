#include <bits/stdc++.h>

using namespace std;

int fa[26], fb[26];
int main() {
    int S, T;
    string s, t;
    cin >> S >> T >> s >> t;
    for (char &c : s) fa[c - 'A']++;
    for (char &c : t) fb[c - 'A']++;
    int maxa = 0;
    for (int &e : fa) maxa = max(maxa, e);
    int mina = 0x3f3f3f3f;
    for (int i = 0; i < 26; i++) {
        if (fb[i] && fa[i] < mina) {
            mina = fa[i];
        }
    }
    long long ans = 0;
    for (int i = 0; i < 26; i++) {
        ans += (long long) fa[i] * fb[i];
    }
    cout << ans + maxa - mina << "\n";
}