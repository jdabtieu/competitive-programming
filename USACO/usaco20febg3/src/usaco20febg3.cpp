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
int n;
vector<int> adj[100001];
bool ans;
int f(int curr, int pa, int len);
int main() {
    n = su();
    for (int i = 1; i < n; i++) {
        int x = su(), y = su();
        adj[x].pb(y);
        adj[y].pb(x);
    }
    for (int i = 1; i < n; i++) {
        if ((n - 1) % i != 0) {
            pc('0');
            continue;
        }
        ans = true;
        f(1, 0, i);
        pc(ans ? '1' : '0');
    }
    pc('\n');
    Write();
}

int f(int curr, int pa, int len) {
    vector<int> a;
    for (int node : adj[curr]) {
        if (node == pa) continue;
        int n = f(node, curr, len);
        if (n == -1) return -1;
        if (n + 1 != len) a.pb(n+1);
    }
    sort(a.begin(), a.end());
    int ptrl = 0, ptrr = a.size() - 1;
    bool pass = true;
    int passthru = -1;
    while (ptrl < ptrr) {
        if (a[ptrl] + a[ptrr] == len) {
            ptrl++;
            ptrr--;
        } else if (a[ptrl] + a[ptrr] > len) {
            if (!pass) {
                ans = false;
                return -1;
            }
            passthru = a[ptrr];
            pass = false;
            ptrr--;
        } else if (a[ptrl] + a[ptrr] < len) {
            if (!pass) {
                ans = false;
                return -1;
            }
            passthru = a[ptrl];
            pass = false;
            ptrl++;
        }
    }
    if (ptrl == ptrr) {
        if (pass) return a[ptrl];
        else {
            ans = false;
            return -1;
        }
    }
    if (pass) return 0;
    return passthru;
}
