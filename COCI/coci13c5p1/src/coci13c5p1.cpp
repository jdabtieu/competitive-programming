#include <bits/stdc++.h>
#pragma GCC optimize ("Ofast")

#define pb push_back
#define pii pair<int, int>
typedef unsigned long long llu;
typedef long long ll;
typedef unsigned int uint;
typedef __uint128_t lllu;
typedef __int128_t lll;

using namespace std;

int main() {
    int n;
    cin >> n;
    unordered_set<string> set;
    while (n--) {
        string s;
        cin >> s;
        string rev = string(s.rbegin(), s.rend());
        if (set.find(rev) == set.end()) {
            set.insert(s);
        }
        if (set.find(rev) != set.end()) {
            cout << s.length() << " " << s[s.length() / 2] << "\n";
            return 0;
        }
    }
}
