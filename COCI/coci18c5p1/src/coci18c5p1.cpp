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

struct subt {
    int id;
    string txt;
    ll tstart;
    ll tend;
};
/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
int main() {
    bool flag = false;
    vector<subt> sv;
    while (true) {
        int id, sh, sm, ss, sms, eh, em, es, ems;
        string txt;
        scanf("%d\n", &id);
        scanf("%d:%d:%d,%d --> %d:%d:%d,%d\n", &sh, &sm, &ss, &sms, &eh, &em, &es, &ems);
        while (true) {
            string s;
            getline(cin, s);
            if (s.compare("") == 0) break;
            txt += "\n";
            txt += s;
            if (s.compare("#") == 0) {
                flag = true;
                break;
            }
        }
        subt s;
        s.id = id;
        s.txt = txt;
        s.tstart = 3600000LL * sh + 60000 * sm + 1000 * ss + sms;
        s.tend = 3600000LL * eh + 60000 * em + 1000 * es + ems;
        sv.pb(s);
        if (flag) break;
    }
    int diff;
    cin >> diff;
    for (int i = 0; i < sv.size(); i++) {
        subt sub = sv[i];
        if (i != 0) {
            printf("\n\n");
        }
        sub.tstart += diff;
        sub.tend += diff;
        printf("%d\n", sub.id);
        printf("%02d:%02d:%02d,%03d --> %02d:%02d:%02d,%03d", sub.tstart / 3600000, sub.tstart % 3600000 / 60000, sub.tstart % 60000 / 1000, sub.tstart % 1000
                                                            , sub.tend / 3600000, sub.tend % 3600000 / 60000, sub.tend % 60000 / 1000, sub.tend % 1000);
        printf("%s", sub.txt.c_str());
    }
}
