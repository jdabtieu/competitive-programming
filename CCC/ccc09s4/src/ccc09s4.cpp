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

int n, m, d;
vector<pii> adj[5001];
int dist[5001];
bool vis[5001];
vector<pii> stores;

int main() {
    memset(dist, 0x3f, 5001*sizeof(int));
    n = su(); m = su();
    for (int i = 0; i < m; i++) {
        int x = su(), y = su(), c = su();
        adj[x].pb({y, c});
        adj[y].pb({x, c});
    }
    int k = su();
    while (k--) {
        int x = su(), p = su();
        stores.pb({x, p});
    }
    d = su();
    dist[d] = 0;
    priority_queue<pii> q;
    q.push({0, d});
    while (!q.empty()) {
        pii x = q.top(); q.pop();
        if (vis[x.second]) continue;
        vis[x.second] = true;
        for (pii& node : adj[x.second]) {
            if (dist[node.first] > x.first + node.second) {
                dist[node.first] = x.first + node.second;
                q.push({dist[node.first], node.first});
            }
        }
    }
    int ans = 0x3f3f3f3f;
    for (pii &store : stores) {
        ans = min(ans, dist[store.first] + store.second);
    }
    cout << ans << "\n";
}
