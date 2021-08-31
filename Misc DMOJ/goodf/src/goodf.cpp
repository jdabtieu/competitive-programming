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
#endif // WIN64
void _pi(int n){if(n==0)return;_pi(n/10);pc((char)(n%10+'0'));}
void pi(int num){if(num<0){pc('-');_pi(-num);}else if(num==0){pc('0');}else{_pi(num);}}
int si(){int x=0;char c;while((c=sc())<=' ');int neg=0;if(c=='-'){neg=1;c=sc();}do{x=x*10+(c-'0');}while((c=sc())>' ');return neg?-x:x;}
long long sl(){long long x=0;char c;while((c=sc())<=' ');int neg=0;if(c=='-'){neg=1;c=sc();}do{x=x*10+(c-'0');}while((c=sc())>' ');return neg?-x:x;}
unsigned int su(){unsigned int x=0;char c;while((c=sc())<=' ');do{x=x*10+(c-'0');}while((c=sc())>' ');return x;}

#define pb push_back
#define pii pair<int, int>
typedef unsigned long long llu;
#define double long double
typedef long long ll;
typedef unsigned int uint;
typedef __uint128_t lllu;
typedef __int128_t lll;

ll gcd(ll a, ll b) {
    if (b == 0) return a;
    return gcd(b, a % b);
}

struct Team {
    ll s;
    ll dist;
    int freq, id;
    Team(){}
    Team(ll dx, ll dy, ll dist, int freq, int id) {
        const ll g = gcd(abs(dx), abs(dy));
        this->s = dx/g * (int)(1e9) + dy/g;
        this->dist = dist;
        this->freq = freq;
        this->id = id;
    }

    bool operator<(const Team& rhs) const {
        return dist < rhs.dist;
    }
};
/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
using namespace std;

int main() {
    int teams = si(), queries = si(), tx = si(), ty = si();
    Team v[teams+1];
    unordered_map<ll, vector<Team>> m;
    for (int i = 1; i <= teams; i++) {
        ll nx = sl(), ny = sl();
        int f = si();
        v[i] = Team(nx - tx, ny - ty, (nx - tx) * (nx - tx) + (ny - ty) * (ny - ty), f, i);
        m[v[i].s].pb(v[i]);
    }
    ll ans[teams+1];
    for (auto& [ key, value ] : m) {
        sort(value.begin(), value.end());
        ans[value[0].id] = value[0].freq;
        for (int i = 1; i < value.size(); i++) {
            ans[value[i].id] = ans[value[i-1].id] + value[i].freq;
        }
    }

    for (int i = 0; i < queries; i++) {
        printf("%lld\n", ans[si()]);
    }
}
