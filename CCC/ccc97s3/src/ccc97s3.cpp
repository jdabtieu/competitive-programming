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
int main() {
    int T = su();
    while (T--) {
        int u = su(), o = 0, e = 0, r = 0;
        while (u + o > 2) {
            printf("Round %d: %d undefeated, %d one-loss, %d eliminated\n", r, u, o, e);
            e += o / 2;
            o -= o / 2;
            o += u / 2;
            u -= u / 2;
            r++;
        }
        printf("Round %d: %d undefeated, %d one-loss, %d eliminated\n", r, u, o, e);
        if (u == 2) {
            u--;
            o++;
            r++;
            printf("Round %d: %d undefeated, %d one-loss, %d eliminated\n", r, u, o, e);
        }
        if (u == 1 && o == 1) {
            u--;
            o++;
            r++;
            printf("Round %d: %d undefeated, %d one-loss, %d eliminated\n", r, u, o, e);
        }
        o--;
        e++;
        r++;
        printf("Round %d: %d undefeated, %d one-loss, %d eliminated\n", r, u, o, e);
        printf("There are %d rounds.\n", r);
    }

}
