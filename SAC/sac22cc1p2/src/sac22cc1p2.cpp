#include <bits/stdc++.h>

using namespace std;

int main() {
    int l, h, w, d;
    cin >> l >> h >> w >> d;
    cout << h * (l * w - 3.14169265359 * d * d / 4) << "\n";
}
