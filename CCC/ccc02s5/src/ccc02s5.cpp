#include <bits/stdc++.h>
/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */

typedef unsigned long long llu;
typedef long long ll;
typedef unsigned int uint;
typedef __uint128_t lllu;
typedef __int128_t lll;

using namespace std;

bool corner(int posX, int width);

int main() {

    int width, height, x, slopeY, bounces = 0; scanf("%i%i%i%i", &width, &height, &x, &slopeY);
    int slopeX = width - x;
    double posX = x;
    const double deltaX = (double) slopeX * height / slopeY;
    const double edgeCheck = 5.0 * slopeX / slopeY;
    const int slopeCheck = slopeY / slopeX;

    for (int i = 0; i < 40000; i++) {
        posX += deltaX;
        bounces += posX / width;
        posX = fmod(posX, width);
        if (posX + edgeCheck > width) {
            printf("%i\n", bounces + i + 1);
            return 0;
        }
        if (corner(posX, width)) {
            if (slopeCheck <= 1) bounces--;
            printf("%i\n", bounces + i);
            return 0;
        }
    }
    puts("0");
    return 0;

}

bool corner(int posX, int width) {
    return posX < 5 || (posX + 5 > width);
}

