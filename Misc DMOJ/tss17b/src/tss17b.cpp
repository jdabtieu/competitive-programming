#include <bits/stdc++.h>
#include <unistd.h>
#include <sys/syscall.h>
/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
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

long long si() {
    long long x = 0;
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

int fun[1414215];

int main() {
    int n = su(), queries = su();
    for (int i = 0; i < n; i++) {
        long long x = si(), y = si();
        int res = (int) ceil(sqrt(x * x + y * y));
        fun[res]++;
    }
    for (int i = 1; i < 1414215; i++) {
        fun[i] += fun[i-1];
    }
    
    for (int i = 0; i < queries; i++) {
        int x = su();
        pi(fun[x]);
        pc('\n');
    }
    Write();
}
