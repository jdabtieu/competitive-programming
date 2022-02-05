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

int N, K;
/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
ll dp[2][100001];
int psa[100001];
int pre[201][100001];
double f(int a, int b, int cur) {
    if (psa[a] == psa[b]) return -1e18;
    return ((dp[cur][a] - (ll) psa[a] * psa[N]) - (dp[cur][b] - (ll) psa[b] * psa[N])) / (1.0 * psa[b] - psa[a]);
}

int main() {
    scanf("%d%d", &N, &K);
    for (int i = 1; i <= N; i++) {
        scanf("%d", &psa[i]);
        psa[i] += psa[i-1];
    }
    dp[0][0] = 0;
    int cur = 1, prev = 0;
    for (int k = 1; k <= K; k++) {
        deque<int> Q;
        Q.pb(0);
        memset(dp[cur], -0x3f, sizeof(dp[cur]));
        for (int i = 1; i <= N; i++) {
            while (Q.size() > 1 && f(Q[0], Q[1], prev) <= psa[i]) Q.pop_front();
            int j = Q.front();
            dp[cur][i] = dp[prev][j] + (ll) (psa[i] - psa[j]) * (psa[N] - psa[i]);
            pre[k][i] = j;
            while (Q.size() > 1 && f(Q[Q.size() - 2], Q[Q.size() - 1], prev) >= f(Q[Q.size() - 1], i, prev)) Q.pop_back();
            Q.pb(i);
        }
        swap(prev, cur);
    }
    ll ans = -1;
    int pos = -1;
    for (int i = 1; i <= N; i++) {
        if (dp[prev][i] > ans) {
            ans = dp[prev][i];
            pos = i;
        }
    }
    printf("%lld\n", ans);
    for (int i = K; i > 0; i--) {
        printf("%d ", pos);
        pos = pre[i][pos];
    }
}
