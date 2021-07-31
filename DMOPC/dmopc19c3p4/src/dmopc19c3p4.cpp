#include <bits/stdc++.h>
#pragma GCC optimize ("Ofast")
/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
#define pb push_back
typedef unsigned long long llu;
typedef long long ll;
typedef unsigned int uint;
typedef __uint128_t lllu;
typedef __int128_t lll;
#include <unistd.h>
#include <sys/syscall.h>

#define BUF_SIZE 65536

char ibuf[BUF_SIZE];
char obuf[BUF_SIZE];
int iPtr = 0;
int maxPtr = 0;
int oPtr = 0;

void Read() {
    maxPtr = syscall(SYS_read, 0, &ibuf, BUF_SIZE);
    iPtr = 0;
}

void Write() {
    syscall(SYS_write, 1, &obuf, oPtr);
    oPtr = 0;
}

void pc(char c) {
    if (oPtr >= BUF_SIZE) Write();
    obuf[oPtr++] = c;
}

void _pi(int n) {
    if (n == 0) return;
    _pi(n / 10);
    pc((char) (n % 10 + '0'));
}

void pi(int num) {
    if (num < 0) {
        pc('-');
        _pi(-num);
    } else if (num == 0) {
        pc('0');
    } else {
        _pi(num);
    }
}

char sc() {
    if (iPtr >= maxPtr) Read();
    return ibuf[iPtr++];
}

int si() {
    int x = 0;
    char c;
    while ((c = sc()) <= ' ');
    int neg = 0;
    if (c == '-') {
        neg = 1;
        c = sc();
    }
    do {
        x = x * 10 + (c - '0');
    } while ((c = sc()) > ' ');
    return neg ? -x : x;
}

unsigned int su() {
    int x = 0;
    char c;
    while ((c = sc()) <= ' ');
    do {
        x = x * 10 + (c - '0');
    } while ((c = sc()) > ' ');
    return x;
}

using namespace std;

const int MMOD = 1000000007;
bool red[300005];
vector<int> adj[300005];
ll ans = 0;
ll dp[300005];

void dfs1(int curr, int pa) {
    ll sum = 0;
    ll c = 0;
    for (int node : adj[curr]) {
        if (node == pa) continue;
        dfs1(node, curr);
        c = (c + (sum * dp[node] % MMOD) + (c * dp[node]) % MMOD) % MMOD;
        sum = (sum + dp[node]) % MMOD;
    }
    dp[curr] = red[curr] ? (sum + c + 1) % MMOD : (sum + c) % MMOD;
    ans = (ans + (red[curr] ? (sum + c + 1) % MMOD : c)) % MMOD;
}

void dfs2(int curr, int pa) {
    ll sum = 0;
    ll c = 0;
    for (int node : adj[curr]) {
        if (node == pa) continue;
        dfs2(node, curr);
        c = (c + (sum * dp[node] % MMOD) + (c * dp[node]) % MMOD) % MMOD;
        sum = (sum + dp[node]) % MMOD;
    }
    dp[curr] = !red[curr] ? (sum + c + 1) % MMOD : (sum + c) % MMOD;
    ans = (ans + (!red[curr] ? (sum + c + 1) % MMOD : c)) % MMOD;
}

int main() {
    int n = su();
    for (int i = 0; i < n; i++) {
        red[i+1] = sc() == 'R';
    }

    for (int i = 1; i < n; i++) {
        int x = su(), y = su();
        adj[x].pb(y);
        adj[y].pb(x);
    }
    dfs1(1, 0);
    dfs2(1, 0);
    printf("%lld\n", ans % MMOD);

}
