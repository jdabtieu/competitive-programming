#include <stdio.h>
/* 
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
#define mod 1000000007

int main() {
	int r, c; scanf("%d %d", &r, &c);
	int dp[r + 1][c + 1];
	
	for (int i = 0; i <= r; i++) dp[i][0] = 1;
	for (int i = 0; i <= c; i++) dp[0][i] = 1;
	for (int i = 1; i <= r; i++) dp[i][1] = dp[i - 1][1] + 3 + i;
	for (int i = 1; i <= c; i++) dp[1][i] = dp[1][i - 1] + 3 + i;
	
	for (int i = 2; i <= r; i++) {
		for (int j = 2; j <= c; j++) {
			dp[i][j] = (int) ((dp[i - 1][j] + (4L * j * dp[i - 1][j - 1]) % mod + (j * (j - 1L) * dp[i - 1][j - 2] / 2) % mod + ((i - 1L) * j * dp[i - 2][j - 1]) % mod) % mod);
		}
	}
	printf("%d\n", dp[r][c] - 1);
	return 0;
}
