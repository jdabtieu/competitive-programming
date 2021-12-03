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
#define MOD 1000000007
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
int d, dx, y;
void extendedEuclid(int A, int B){
int temp;                           /* C */
    if(B == 0)
    {
        d = A;
        dx = 1;
        y = 0;
    }
    else
    {
        extendedEuclid(B,A%B);
        temp = dx;
        dx = y;
        y = temp - (A/B)*y;
    }
}
int modInv(int A, int M){
    extendedEuclid(A,M);
    if (dx < 0)                      /* fix */
        dx += M;                     /* fix */
    return dx;                     /* fix */
}

int x[100000];
ll c[100000];
int main() {
    int n = su(), k = su();
    for (int i = 0; i < n; i++) x[i] = su();
    c[k-1] = 1;
    for (int i = k; i < n; i++) {
        c[i] = c[i-1] * i % MOD * modInv(i - (k - 1), MOD) % MOD;
    }
    sort(x, x+n);
    ll ans = 0;
    for (int i = k - 1; i < n; i++) {
        ans = (ans + x[i] * c[i]) % MOD;
    }
    cout << ans;
}