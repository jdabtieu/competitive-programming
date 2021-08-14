#include <bits/stdc++.h>
#include <unistd.h>
#pragma GCC optimize ("Ofast")

int oPtr = 0;
#ifdef WIN64
char sc() {return getchar();}
void pc(char c) {putchar(c);}
void Write() {return;}
#else
#include <sys/syscall.h>
#define BUF_SIZE 61846
int iPtr = 0;
int maxPtr = 0;
char ibuf[BUF_SIZE];
char obuf[BUF_SIZE];
void Read() {maxPtr = syscall(SYS_read, 0, &ibuf, BUF_SIZE);iPtr = 0;}
void Write() {syscall(SYS_write, 1, &obuf, oPtr);oPtr = 0;}
char sc() {if (iPtr >= maxPtr) Read();return ibuf[iPtr++];}
void pc(char c) {if (oPtr >= BUF_SIZE) Write();obuf[oPtr++] = c;}
#endif // WIN64
void _pi(int n) {if (n == 0) return;_pi(n / 10);pc((char) (n % 10 + '0'));}
void pi(int num) {if (num < 0) {pc('-');_pi(-num);} else if (num == 0) {pc('0');} else {_pi(num);}}
int si() {int x = 0;char c;while ((c = sc()) <= ' ');int neg = 0;if (c == '-') {neg = 1;c = sc();}do {x = x * 10 + (c - '0');} while ((c = sc()) > ' ');return neg ? -x : x;}
unsigned int su() {int x = 0;char c;while ((c = sc()) <= ' ');do {x = x * 10 + (c - '0');} while ((c = sc()) > ' ');return x;}

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
    int n = si();
    vector<int> d;
    for (int i = 0; i < n; i++) d.pb(si());

    sort(d.begin(), d.end());
    int pA = 0, pB = n-1;
    while (pB > pA) {
        pi(d[pA++]);
        pc(' ');
        pi(d[pB--]);
        pc(' ');
    }
    if (pA == pB) {
        pi(d[pA]);
    } else {
    oPtr--;
    }
    pc('\n');
    for (int i = 0; i < n / 2; i++) {
        pc('B');
        pc('S');
    }
    if (n & 1) {
        pc('E');
    }
    pc('\n');
    Write();
}
