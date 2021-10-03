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

vector<int> adj[10001];
int ans[10001][10001];

int n;
/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
vector<int> dfs(int curr, int pa) {
    vector<int> c;
    c.pb(1);
    for (int node : adj[curr]) {
        if (node == pa) continue;
        vector<int> l = dfs(node, curr);
        l.pb(0);
        rotate(l.rbegin(), l.rbegin() + 1, l.rend());
        for (int i = 0; i < c.size(); i++) {
            for (int j = 0; j < l.size(); j++) {
                ans[i][j] += c[i] * l[j];
            }
        }
        while (c.size() < l.size()) c.pb(0);
        for (int i = 0; i < l.size(); i++) c[i] += l[i];
    }
    return c;
}

int main() {
    n = si();
    for (int i = 1; i < n; i++) {
        int x = si(), y = si();
        adj[x].pb(y);
        adj[y].pb(x);
    }
    dfs(1, 0);
    int q = si();
    while (q--) {
        int a = si(), b = si();
        pi(ans[a][b] + ans[b][a]);
        pc('\n');
    }
    Write();
}
