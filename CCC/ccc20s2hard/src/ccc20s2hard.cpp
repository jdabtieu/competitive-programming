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

int fast_vector_data[16000001];
unsigned int fast_vector_unallocated_index = 0;
class fast_vector {
    private:
        unsigned int start = 0;
        unsigned int sz = 0;
    public:
        fast_vector() = default;
        void alloc(int capacity) {
            start = fast_vector_unallocated_index;
            fast_vector_unallocated_index += capacity;
        }
        void push_back(int x) {
            fast_vector_data[start + sz++] = x;
        }
        bool empty() {
            return sz == 0;
        }
        unsigned int size() {
            return sz;
        }
        int operator[](int i) {
            return fast_vector_data[start + i];
        }
};

int vec_cap[16000001];
fast_vector ma[16000001];
bool enqueued[16000001];

bool dfs(int x) {
    if (x == 1) return true;
    auto &v = ma[x];
    for (int i = v.size() - 1; i >= 0; i--) {
        int p = v[i];
        if (!enqueued[p]) {
            enqueued[p] = true;
            if (dfs(p)) return true;
        }
    }
    return false;
}

bool can_escape(int m, int n, vector<vector<int>> g) {
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            ++vec_cap[g[i][j]];
        }
    }
    for (int i = 1; i < 16000001; i++) {
        if (vec_cap[i] > 0) {
            ma[i].alloc(vec_cap[i]);
        } else {
            enqueued[i] = true;
        }
    }
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            ma[g[i][j]].pb(i * j);
        }
    }

    if (ma[m*n].empty()) {
        return false;
    }
    enqueued[m*n] = true;
    return dfs(m*n);
}
