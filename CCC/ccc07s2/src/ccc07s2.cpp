#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef long double ld;
typedef pair<int,int> pii;
typedef pair<ll,ll> pll;
#define mp make_pair

ll n, m;

struct box {
    int l, w, h;
} box;

struct box boxes[1001];
int tmp[3];
int main() {
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    cin >> n;
    for (ll i = 0; i < n; ++i) {
        cin >> tmp[0] >> tmp[1] >> tmp[2];
        sort(tmp, tmp+3);
        boxes[i] = {tmp[0], tmp[1], tmp[2]};
    }
    sort(boxes, boxes+n, [](auto &lhs, auto &rhs) {
         return lhs.l*lhs.w*lhs.h < rhs.l*rhs.w*rhs.h;
    });
    cin >> m;
    for (ll i = 0; i < m; ++i) {
        cin >> tmp[0] >> tmp[1] >> tmp[2];
        sort(tmp, tmp+3);
        bool fits=false;
        for (ll j = 0; j < n; ++j) {
            if (boxes[j].l >= tmp[0] && boxes[j].w >= tmp[1] && boxes[j].h >= tmp[2]) {
                cout << boxes[j].l*boxes[j].w*boxes[j].h << "\n";
                fits = true;
                break;
            }
        }
        if (!fits) cout << "Item does not fit.\n";
    }
}
