#include <bits/stdc++.h>
/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
using namespace std;
int main() {
char q = 34;
char n = 10;
char c = 44;
const char *arr[12] = {
"#include <bits/stdc++.h>",
"using namespace std;",
"int main() {",
"char q = 34;",
"char n = 10;",
"char c = 44;",
"const char *arr[12] = {",
"};",
"for (int i = 0; i < 7; i++) cout << arr[i] << n;",
"for (int i = 0; i < 12; i++) cout << q << arr[i] << q << c << n;",
"for (int i = 7; i < 12; i++) cout << arr[i] << n;",
"}",
};
for (int i = 0; i < 7; i++) cout << arr[i] << n;
for (int i = 0; i < 12; i++) cout << q << arr[i] << q << c << n;
for (int i = 7; i < 12; i++) cout << arr[i] << n;
}
