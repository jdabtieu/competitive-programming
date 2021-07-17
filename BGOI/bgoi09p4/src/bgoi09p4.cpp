#include <unistd.h>
#include <sys/syscall.h>
#pragma GCC optimize ("Ofast")
#define pb push_back
typedef unsigned long long llu;
typedef long long ll;
typedef unsigned int uint;
typedef __uint128_t lllu;
typedef __int128_t lll;

int heights[1000001];
int ans[1000001];
int stk[1000001];

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
/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
int main() {
        int n = su();
        for (int i = n - 1; i >= 0; i--) {
            heights[i] = su();
        }
        for (int i = 0; i < n; i++) {
            ans[i] = su();
        }
        int ptr = -1;
        for (int i = 0; i < n; i++) {
            while (ptr >= 0 && stk[ptr] <= heights[i]) ptr--;

            if (ans[n-i-1] == 0) {
                ans[n-i-1] = heights[i];
            } else if (ans[n-i-1] <= (ptr+1)) {
                ans[n-i-1] = stk[ptr+1-ans[n-i-1]];
            } else {
                ans[n-i-1] = -1;
            }

            stk[++ptr] = heights[i];
        }
        for (int i = 0; i < n; i++) {
            pi(ans[i]);
            pc(' ');
        }
        Write();
    }
