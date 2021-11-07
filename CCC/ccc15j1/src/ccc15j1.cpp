#include <stdio.h>
#include <unistd.h>
#pragma GCC optimize ("Ofast")

#include <sys/syscall.h>
#define BUF_SIZE 1024
int iPtr = 0;
int maxPtr = 0;
char ibuf[BUF_SIZE];
void Read(){maxPtr=syscall(SYS_read,0,&ibuf,BUF_SIZE);iPtr=0;}
char sc(){if(iPtr>=maxPtr)Read();return ibuf[iPtr++];}
unsigned int su(){unsigned int x=0;char c;while((c=sc())<=' ');do{x=x*10+(c-'0');}while((c=sc())>' ');return x;}

int main() {
    unsigned int m = su(), d = su();
    if (m < 2 || (m==2 && d < 18)) puts("Before");
    else if (m==2 && d==18) puts("Special");
    else puts("After");
}
