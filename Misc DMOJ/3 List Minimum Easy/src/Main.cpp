#include <bits/stdc++.h>
#include <iostream>
#include <string>
using namespace std;
/* 
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
int main()
{
  int max;
  cin >> max;
  for (int i = 1; i < max - 2; i+= 3) {
    cout << i << " " << i + 1 << " " << i + 2 << " ";
  }
  if (max % 3 == 0) {
	    cout << max - 2 << " " << max - 1 << " " << max;
    } else if (max % 3 == 1) {
	    cout << max;
	} else {
	    cout << max - 1 << " " << max;   
	}
  
  return 0;
}