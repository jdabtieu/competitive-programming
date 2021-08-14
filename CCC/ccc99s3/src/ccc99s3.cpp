#include <bits/stdc++.h>
#include <unistd.h>
#pragma GCC optimize ("Ofast")

#ifdef WIN64
char sc() {return getchar();}
void pc(char c) {putchar(c);}
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
bool g[6][243][243];

int pow3(int n) {
    switch(n) {
    case 0: return 1;
    case 1: return 3;
    case 2: return 9;
    case 3: return 27;
    case 4: return 81;
    case 5: return 243;
    default: return -1;
    }
}

void expand(int i1, int i2) {
    for (int i = 0; i < pow3(i1); i++) {
        for (int j = 0; j < pow3(i1); j++) {
            g[i2][i*3][j*3] = g[i1][i][j];
            g[i2][i*3+1][j*3] = g[i1][i][j];
            g[i2][i*3+2][j*3] = g[i1][i][j];
            g[i2][i*3][j*3+1] = g[i1][i][j];
            g[i2][i*3+1][j*3+1] = g[i1][i][j];
            g[i2][i*3+2][j*3+1] = g[i1][i][j];
            g[i2][i*3][j*3+2] = g[i1][i][j];
            g[i2][i*3+1][j*3+2] = g[i1][i][j];
            g[i2][i*3+2][j*3+2] = g[i1][i][j];
        }
    }
}

void construct() {
    g[0][0][0] = true;
    for (int i = 1; i <= 5; i++) {
        expand(i-1, i);
        for (int k = 0; k < pow3(i); k++) {
            for (int j = 0; j < pow3(i); j++) {
                if ((k % 3 == 1) && (j % 3 == 1)) {
                    g[i][k][j] = false;
                }
            }
        }
    }
}


int main() {
    construct();
    int T = su();
    while (T--) {
        int n = su(), b = su(), t = su(), l = su(), r = su();
        b = pow3(n) - b;
        t = pow3(n) - t;
        l--;
        for (int i = t; i <= b; i++) {
            for (int j = l; j < r; j++) {
                pc(g[n][i][j] ? '*' : ' ');
                if (j != r) pc(' ');
            }
            pc('\n');
        }
        pc('\n');
    }
    Write();
}
