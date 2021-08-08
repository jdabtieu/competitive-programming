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
unsigned int su() {int x = 0;char c;while ((c = sc()) <= ' ');do {x = x * 10 + (c - '0');} while ((c = sc()) > ' ');return x;}

#define pb push_back
#define pii pair<int, int>
typedef unsigned long long llu;
typedef long long ll;
typedef unsigned int uint;
typedef __uint128_t lllu;
typedef __int128_t lll;
/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
using namespace std;

const ll MMOD = 1125899839733759LL;
const int PRIME = 7507;

int l;
ll has = 0;

int cnt[26], cnt2[26];

string small, big;

bool check() {
    for (int i = 0; i < 26; i++) if (cnt[i] != cnt2[i]) return false;
    return true;
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin >> small >> big;
    l = small.length();
    if (l > big.length()) {
        printf("0\n");
        return 0;
    }
    ll power = 1;
    for (int i = 0; i < l; i++) power = power * PRIME % MMOD;
    unordered_set<ll> found;
    for (int i = 0; i < l; i++) {
        cnt[small[i] - 'a']++;
        cnt2[big[i] - 'a']++;
        has = (has * PRIME + big[i] - 'a') % MMOD;
    }
    
    if (check()) {
        found.insert(has);
    }
    
    for (int i = l; i < big.length(); i++) {
        cnt2[big[i - l] - 'a']--;
        cnt2[big[i] - 'a']++;
        has = (has * PRIME + big[i] - 'a') % MMOD;
        has -= (big[i - l] - 'a') * power % MMOD;
        if (has < 0) has += MMOD;
        if (check()) {
            found.insert(has);
        }
    }
    printf("%d\n", found.size());
}
