#include <bits/stdc++.h>
#include <unistd.h>
#pragma GCC optimize ("Ofast")

#ifdef _WIN32
int __c = true;
char sc() {return getchar();}
void pc(char c) {if(__c)puts("*=*=*Did you call Write();?*=*=*"),__c=false;putchar(c);}
void Write() {return;}
#else
#include <sys/syscall.h>
#define BUF_SIZE 65536
int iPtr = 0;
int maxPtr = 0;
int oPtr = 0;
char ibuf[BUF_SIZE];
char obuf[BUF_SIZE];
void Read(){maxPtr=syscall(SYS_read,0,&ibuf,BUF_SIZE);iPtr=0;}
void Write(){syscall(SYS_write,1,&obuf,oPtr);oPtr=0;}
char sc(){if(iPtr>=maxPtr)Read();return ibuf[iPtr++];}
void pc(char c){if(oPtr>=BUF_SIZE)Write();obuf[oPtr++]=c;}
#endif // _WIN32
void _pi(int n){if(n==0)return;_pi(n/10);pc((char)(n%10+'0'));}
void pi(int num){if(num<0){pc('-');_pi(-num);}else if(num==0){pc('0');}else{_pi(num);}}
int si(){int x=0;char c;while((c=sc())<=' ');int neg=0;if(c=='-'){neg=1;c=sc();}do{x=x*10+(c-'0');}while((c=sc())>' ');return neg?-x:x;}
unsigned int su(){unsigned int x=0;char c;while((c=sc())<=' ');do{x=x*10+(c-'0');}while((c=sc())>' ');return x;}

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
unordered_map<int, int> fac[10001];
int main() {
    for (int i = 2; i <= 10000; i++) {
        int x = i;
        for (int j = 2; j <= x; j++) {
            while (x % j == 0) {
                fac[i][j]++;
                x /= j;
            }
        }
    }
    for (int cases = 0; cases < 5; cases++) {
        int n = su();
        map<int, int> f;
        for (int i = 2; i <= n; i++) {
            for (auto &x : fac[i]) {
                f[x.first] += x.second;
            }
        }
        bool first = true;
        for (auto &x : f) {
            if (first) {
                first = false;
            } else {
                printf(" * ");
            }
            printf("%d^%d", x.first, x.second);
        }
        printf("\n");
    }
}
