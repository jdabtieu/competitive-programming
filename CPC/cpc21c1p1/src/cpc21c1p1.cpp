#include <bits/stdc++.h>
#include <unistd.h>
#include <sys/syscall.h>
#pragma GCC optimize ("Ofast")

#define BUF_SIZE 65536

char ibuf[BUF_SIZE];
char obuf[BUF_SIZE];
int iPtr = 0;
int maxPtr = 0;
int oPtr = 0;
void Read() {maxPtr = syscall(SYS_read, 0, &ibuf, BUF_SIZE);iPtr = 0;}
void Write() {syscall(SYS_write, 1, &obuf, oPtr);oPtr = 0;}
void pc(char c) {if (oPtr >= BUF_SIZE) Write();obuf[oPtr++] = c;}
void _pi(int n) {if (n == 0) return;_pi(n / 10);pc((char) (n % 10 + '0'));}
void pi(int num) {if (num < 0) {pc('-');_pi(-num);} else if (num == 0) {pc('0');} else {_pi(num);}}
char sc() {if (iPtr >= maxPtr) Read();return ibuf[iPtr++];}
int si() {int x = 0;char c;while ((c = sc()) <= ' ');int neg = 0;if (c == '-') {neg = 1;c = sc();}do {x = x * 10 + (c - '0');} while ((c = sc()) > ' ');return neg ? -x : x;}
unsigned long long su() {unsigned long long x = 0;char c;while ((c = sc()) <= ' ');do {x = x * 10 + (c - '0');} while ((c = sc()) > ' ');return x;}

#define pb push_back
#define pii pair<int, int>
typedef unsigned long long llu;
typedef long long ll;
typedef unsigned int uint;
typedef __uint128_t lllu;
typedef __int128_t lll;

using namespace std;
/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
int main() {
    for (llu cases = su(); cases > 0; cases--) {
        llu n = su(), d = su();
        llu g = gcd(n, d);
        n /= g; d /= g;
        ll check = d;
        while (check % 2 == 0) check /= 2;
        while (check % 5 == 0) check /= 5;
        if (check != 1) {
            pc('-');
            pc('1');
            pc('\n');
            continue;
        }
        uint cnt = 0;
        while (n > 0) {
            n *= 10;
            n %= d;
            cnt++;
        }
        _pi(cnt);
        pc('\n');
    }
    Write();
}
