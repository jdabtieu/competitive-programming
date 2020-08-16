/*
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
unsigned long long duplicatebits(unsigned long long num) {
    num = (num | (num << 16)) & 281470681808895ULL;   //0000 FFFF 0000 FFFF
    num = (num | (num << 8)) & 71777214294589695ULL;  //00FF 00FF 00FF 00FF
    num = (num | (num << 4)) & 1085102592571150095ULL;//0F0F 0F0F 0F0F 0F0F
    num = (num | (num << 2)) & 3689348814741910323ULL;//3333 3333 3333 3333
    num = (num | (num << 1)) & 6148914691236517205ULL;//5555 5555 5555 5555
    return num | (num << 1);
}
/*
 * 16 -> 32-bit diagram:
 * +---+---------+---------+---------+---------+---------+---------+---------+---------+
 * | 0 | _ _ _ _ | _ _ _ _ | _ _ _ _ | _ _ _ _ | A B C D | E F G H | I J K L | M N O P |
 * +---+---------+---------+---------+---------+---------+---------+---------+---------+
 * | 1 | _ _ _ _ | _ _ _ _ | A B C D | E F G H | _ _ _ _ | _ _ _ _ | I J K L | M N O P |
 * +---+---------+---------+---------+---------+---------+---------+---------+---------+
 * | 2 | _ _ _ _ | A B C D | _ _ _ _ | E F G H | _ _ _ _ | I J K L | _ _ _ _ | M N O P |
 * +---+---------+---------+---------+---------+---------+---------+---------+---------+
 * | 3 | _ _ A B | _ _ C D | _ _ E F | _ _ G H | _ _ I J | _ _ K L | _ _ M N | _ _ O P |
 * +---+---------+---------+---------+---------+---------+---------+---------+---------+
 * | 4 | _ A _ B | _ C _ D | _ E _ F | _ G _ H | _ I _ J | _ K _ L | _ M _ N | _ O _ P |
 * +---+---------+---------+---------+---------+---------+---------+---------+---------+
 * | 5 | A A B B | C C D D | E E F F | G G H H | I I J J | K K L L | M M N N | O O P P |
 * +---+---------+---------+---------+---------+---------+---------+---------+---------+
 */