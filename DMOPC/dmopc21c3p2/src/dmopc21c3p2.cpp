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

using namespace std;
/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
bool triangle(ll x) {
    ll sr = sqrt(2 * x);
    return sr * (sr + 1) == 2 * x;
}

int main() {
    ll k;
    cin >> k;
    if (k == 0) {
        printf("1\n1\n");
        return 0;
    }
    if (triangle(k)) {
        ll sz = sqrt(2 * k);
        printf("%d\n0", sz);
        for (ll i = 1; i < sz; i++) {
            printf(" 0");
        };
        printf("\n");
        return 0;
    }
    for (ll m = 1; m <= 1000000; m++) {
        if (triangle(k - (m+1)*m/2)) {
            ll n = sqrt(2 * (k - (m+1)*m/2));
            if(m+n+1 > 1000000) continue;
            printf("%d\n0", m+n+1);
            for (int i = 1; i < m; i++) printf(" 0");
            printf(" 1");
            for (int i = 0; i < n; i++) printf(" 0");
            printf("\n");
            return 0;
        }
    }
    printf("-1\n");
}
