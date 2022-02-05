#include <bits/stdc++.h>

using namespace std;

typedef unsigned long long llu;

int f(deque<int> ba, deque<int> bb);

int main() {
    string _a, _b; cin >> _a >> _b;
    deque<int> la, lb, ba, bb;
    int oa = 0, ob = 0;
    for (char &c : _a) {
        if (c == '1') {
            la.push_back(oa);
            oa = 0;
        } else if (c == '2') {
            la.push_back(oa);
            oa = 1;
        } else if (c == 'U') {
            if (oa < 0) oa--;
            oa /= 2;
            oa += la.back(); la.pop_back();
        } else if (c == 'L') {
            oa--;
        } else {
            oa++;
        }
    }
    la.push_back(oa);
    for (char &c : _b) {
        if (c == '1') {
            lb.push_back(ob);
            ob = 0;
        } else if (c == '2') {
            lb.push_back(ob);
            ob = 1;
        } else if (c == 'U') {
            if (ob < 0) ob--;
            ob /= 2;
            ob += lb.back(); lb.pop_back();
        } else if (c == 'L') {
            ob--;
        } else {
            ob++;
        }
    }
    lb.push_back(ob);
    int overflow = 0;
    for (auto it = la.rbegin(); it != la.rend(); ++it) {
        int val = *it + overflow;
        ba.push_front(val & 1);
        if (val < 0) val--;
        overflow = val / 2;
    }
    ba.pop_front();
    ba.push_front(1);

    overflow = 0;
    for (auto it = lb.rbegin(); it != lb.rend(); ++it) {
        int val = *it + overflow;
        bb.push_front(val & 1);
        if (val < 0) val--;
        overflow = val / 2;
    }
    bb.pop_front();
    bb.push_front(1);

    llu ans = 0;
    while (ba.size() > bb.size()) {
        ba.pop_back(); ans++;
    }
    while (bb.size() > ba.size()) {
        bb.pop_back(); ans++;
    }
    int ba_sz = ba.size();
    int first_diff_bit = f(ba, bb);
    if (first_diff_bit == ba.size()) {
        cout << ans << "\n";
        return 0;
    }
    if (ba[first_diff_bit] == 1) {
        deque<int> tmp = ba;
        ba = bb;
        bb = tmp;
    }
    deque<int> subtract;
    int CF = 0;
    for (auto ita = ba.rbegin(), itb = bb.rbegin(); ita != ba.rend(); ++ita, ++itb) {
        int res = *itb - *ita - CF;
        if (res < 0) CF = 1;
        else CF = 0;
        subtract.push_front(res & 1);
    }
    int first_set_bit = 0;
    for (auto it = subtract.begin(); it != subtract.end(); ++it) {
        if (*it == 0) first_set_bit++;
        else break;
    }
    while (first_set_bit < ba_sz - 4) {
        ba.pop_back();
        bb.pop_back();
        subtract.pop_back();
        ans += 2;
        ba_sz--;
    }

    int fans = 0x3f3f3f3f;
    while (true) {
        int dist = 0;
        subtract.clear();
        CF = 0;
        for (auto ita = ba.rbegin(), itb = bb.rbegin(); ita != ba.rend(); ++ita, ++itb) {
            int res = *itb - *ita - CF;
            if (res < 0) CF = 1;
            else CF = 0;
            subtract.push_front(res & 1);
        }
        for (auto it = subtract.begin(); it != subtract.end(); ++it) {
            dist <<= 1;
            dist += *it;
        }
        if (dist + ans < fans) {
            fans = dist + ans;
        } else {
            break;
        }
        ans += 2;
        ba.pop_back();
        bb.pop_back();
    }
    cout << fans << "\n";
}

int f(deque<int> ba, deque<int> bb) {
    int i = 0;

    for (auto ita = ba.begin(), itb = bb.begin(); ita != ba.end(); ++ita, ++itb, i++) {
        if (*ita != *itb) return i;
    }
    return i;
}
