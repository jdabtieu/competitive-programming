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

bool eden[1 << 20];
int arr[6][7];
int dist[1 << 20];

/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
int main() {
    fill(eden, eden + (1 << 20), true);
    int m, n, a, b, c; cin >> m >> n >> a >> b >> c;
    for (int i = 0; i < (1 << (m * n)); i++) {
        for (int j = 0; j < m; j++) {
            for (int k = 0; k < n; k++) {
                arr[j+1][k+1] = (i >> (j * n + k)) & 1;
            }
        }
        int key = 0;
        for (int j = 1; j <= m; j++) {
            for (int k = 1; k <= n; k++) {
                int sum = 0;
                sum += arr[j-1][k-1];
                sum += arr[j][k-1];
                sum += arr[j+1][k-1];
                sum += arr[j-1][k];
                sum += arr[j+1][k];
                sum += arr[j-1][k+1];
                sum += arr[j][k+1];
                sum += arr[j+1][k+1];
                if (arr[j][k] > 0 && sum >= a && sum <= b) key |= (1 << ((j - 1) * n + k - 1));
                if (arr[j][k] == 0 && sum > c) key |= (1 << ((j - 1) * n + k - 1));
            }
        }
        eden[key] = false;
    }
    fill(dist, dist + (1 << 20), 0x3f3f3f3f);
    for (int i = 0; i < (1 << (m*n)); i++) {
        if (!eden[i]) continue;
        dist[i] = 0;
        int f = i;
        while (true) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    arr[j+1][k+1] = (f >> (j * n + k)) & 1;
                }
            }
            int key = 0;
            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= n; k++) {
                    int sum = 0;
                    sum += arr[j-1][k-1];
                    sum += arr[j][k-1];
                    sum += arr[j+1][k-1];
                    sum += arr[j-1][k];
                    sum += arr[j+1][k];
                    sum += arr[j-1][k+1];
                    sum += arr[j][k+1];
                    sum += arr[j+1][k+1];
                    if (arr[j][k] > 0 && sum >= a && sum <= b) key |= (1 << ((j - 1) * n + k - 1));
                    if (arr[j][k] == 0 && sum > c) key |= (1 << ((j - 1) * n + k - 1));
                }
            }
            if (dist[key] <= dist[f] + 1) break;
            dist[key] = dist[f] + 1;
            f = key;
        }

    }
    int key = 0;
    for (int i = 0; i < m; i++) {
        string s; cin >> s;
        for (int j = 0; j < n; j++) {
            if (s[j] == '*') key |= (1 << (i * n + j));
        }
    }
    if (dist[key] != 0x3f3f3f3f) cout << dist[key] << "\n";
    else cout << -1 << "\n";
}
