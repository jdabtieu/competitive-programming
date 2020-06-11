import java.util.*;
import java.io.*;

public class Main {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;

	public static void main(String[] args) throws IOException {
		for (int cases = 0; cases < 4; cases++) {
			draw(readInt());
			System.out.println();
		}
		draw(readInt());
	}

	static void draw(int size) {
		if (size == 1) {
			System.out.println( "          |\n" + 
								"       \\  |  /\n" + 
								"        \\ | /\n" + 
								"         \\|/\n" + 
								"       XXXXXXX\n" + 
								"      X       X\n" + 
								"     X  O   O  X\n" + 
								"    X     V     X\n" + 
								"W   X  X     X  X\n" + 
								" \\   X  XXXXX  X\n" + 
								"  \\   X       X\n" + 
								"   \\   XXXXXXX\n" + 
								"    \\ X       X---\n" + 
								"     X    O    X  \\\n" + 
								"    X           X  \\\n" + 
								"     XXXXXXXXXXX    \\\n" + 
								"      OOOO OOOO      M\n" + 
								"      OOOO OOOO");
			return;
		} else if (size == 2) {
			System.out.println( "          |\n" + 
								"       \\  |  /\n" + 
								"        \\ | /\n" + 
								"         \\|/\n" + 
								"       XXXXXXX\n" + 
								"      X       X\n" + 
								"     X  O   O  X\n" + 
								"    X     V     X\n" + 
								"W   X  X     X  X\n" + 
								" \\   X  XXXXX  X\n" + 
								"  \\   X       X\n" + 
								"   \\   XXXXXXX\n" + 
								"    \\ X       X---\n" + 
								"     X    O    X  \\\n" + 
								"    X           X  \\\n" + 
								"     XXXXXXXXXXX    \\\n" + 
								"     X         X     M\n" + 
								"    X     O     X\n" + 
								"   X      O      X\n" + 
								"  X               X\n" + 
								"   XXXXXXXXXXXXXXX\n" + 
								"      OOOO OOOO\n" + 
								"      OOOO OOOO");
			return;
		} else if (size == 3) {
			System.out.println( "           |\n" + 
								"        \\  |  /\n" + 
								"         \\ | /\n" + 
								"          \\|/\n" + 
								"        XXXXXXX\n" + 
								"       X       X\n" + 
								"      X  O   O  X\n" + 
								"     X     V     X\n" + 
								" W   X  X     X  X\n" + 
								"  \\   X  XXXXX  X\n" + 
								"   \\   X       X\n" + 
								"    \\   XXXXXXX\n" + 
								"     \\ X       X---\n" + 
								"      X    O    X  \\\n" + 
								"     X           X  \\\n" + 
								"      XXXXXXXXXXX    \\\n" + 
								"      X         X     M\n" + 
								"     X     O     X\n" + 
								"    X      O      X\n" + 
								"   X               X\n" + 
								"    XXXXXXXXXXXXXXX\n" + 
								"    X             X\n" + 
								"   X       O       X\n" + 
								"  X        O        X\n" + 
								" X         O         X\n" + 
								"X                     X\n" + 
								" XXXXXXXXXXXXXXXXXXXXX");
		} else if (size == 4) {
			System.out.println( "               |\n" + 
								"            \\  |  /\n" + 
								"             \\ | /\n" + 
								"              \\|/\n" + 
								"            XXXXXXX\n" + 
								"           X       X\n" + 
								"          X  O   O  X\n" + 
								"         X     V     X\n" + 
								"     W   X  X     X  X\n" + 
								"      \\   X  XXXXX  X\n" + 
								"       \\   X       X\n" + 
								"        \\   XXXXXXX\n" + 
								"         \\ X       X---\n" + 
								"          X    O    X  \\\n" + 
								"         X           X  \\\n" + 
								"          XXXXXXXXXXX    \\\n" + 
								"          X         X     M\n" + 
								"         X     O     X\n" + 
								"        X      O      X\n" + 
								"       X               X\n" + 
								"        XXXXXXXXXXXXXXX\n" + 
								"        X             X\n" + 
								"       X       O       X\n" + 
								"      X        O        X\n" + 
								"     X         O         X\n" + 
								"    X                     X\n" + 
								"     XXXXXXXXXXXXXXXXXXXXX\n" + 
								"     X                   X\n" + 
								"    X          O          X\n" + 
								"   X           O           X\n" + 
								"  X            O            X\n" + 
								" X             O             X\n" + 
								"X                             X\n" + 
								" XXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		} else if (size == 5) {
			System.out.println( "                    |\n" + 
								"                 \\  |  /\n" + 
								"                  \\ | /\n" + 
								"                   \\|/\n" + 
								"                 XXXXXXX\n" + 
								"                X       X\n" + 
								"               X  O   O  X\n" + 
								"              X     V     X\n" + 
								"          W   X  X     X  X\n" + 
								"           \\   X  XXXXX  X\n" + 
								"            \\   X       X\n" + 
								"             \\   XXXXXXX\n" + 
								"              \\ X       X---\n" + 
								"               X    O    X  \\\n" + 
								"              X           X  \\\n" + 
								"               XXXXXXXXXXX    \\\n" + 
								"               X         X     M\n" + 
								"              X     O     X\n" + 
								"             X      O      X\n" + 
								"            X               X\n" + 
								"             XXXXXXXXXXXXXXX\n" + 
								"             X             X\n" + 
								"            X       O       X\n" + 
								"           X        O        X\n" + 
								"          X         O         X\n" + 
								"         X                     X\n" + 
								"          XXXXXXXXXXXXXXXXXXXXX\n" + 
								"          X                   X\n" + 
								"         X          O          X\n" + 
								"        X           O           X\n" + 
								"       X            O            X\n" + 
								"      X             O             X\n" + 
								"     X                             X\n" + 
								"      XXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n" + 
								"      X                           X\n" + 
								"     X              O              X\n" + 
								"    X               O               X\n" + 
								"   X                O                X\n" + 
								"  X                 O                 X\n" + 
								" X                  O                  X\n" + 
								"X                                       X\n" + 
								" XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		} else if (size == 6) {
			System.out.println( "                          |\n" + 
								"                       \\  |  /\n" + 
								"                        \\ | /\n" + 
								"                         \\|/\n" + 
								"                       XXXXXXX\n" + 
								"                      X       X\n" + 
								"                     X  O   O  X\n" + 
								"                    X     V     X\n" + 
								"                W   X  X     X  X\n" + 
								"                 \\   X  XXXXX  X\n" + 
								"                  \\   X       X\n" + 
								"                   \\   XXXXXXX\n" + 
								"                    \\ X       X---\n" + 
								"                     X    O    X  \\\n" + 
								"                    X           X  \\\n" + 
								"                     XXXXXXXXXXX    \\\n" + 
								"                     X         X     M\n" + 
								"                    X     O     X\n" + 
								"                   X      O      X\n" + 
								"                  X               X\n" + 
								"                   XXXXXXXXXXXXXXX\n" + 
								"                   X             X\n" + 
								"                  X       O       X\n" + 
								"                 X        O        X\n" + 
								"                X         O         X\n" + 
								"               X                     X\n" + 
								"                XXXXXXXXXXXXXXXXXXXXX\n" + 
								"                X                   X\n" + 
								"               X          O          X\n" + 
								"              X           O           X\n" + 
								"             X            O            X\n" + 
								"            X             O             X\n" + 
								"           X                             X\n" + 
								"            XXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n" + 
								"            X                           X\n" + 
								"           X              O              X\n" + 
								"          X               O               X\n" + 
								"         X                O                X\n" + 
								"        X                 O                 X\n" + 
								"       X                  O                  X\n" + 
								"      X                                       X\n" + 
								"       XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n" + 
								"       X                                     X\n" + 
								"      X                   O                   X\n" + 
								"     X                    O                    X\n" + 
								"    X                     O                     X\n" + 
								"   X                      O                      X\n" + 
								"  X                       O                       X\n" + 
								" X                        O                        X\n" + 
								"X                                                   X\n" + 
								" XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		} else if (size == 7) {
			System.out.println( "                                 |\n" + 
								"                              \\  |  /\n" + 
								"                               \\ | /\n" + 
								"                                \\|/\n" + 
								"                              XXXXXXX\n" + 
								"                             X       X\n" + 
								"                            X  O   O  X\n" + 
								"                           X     V     X\n" + 
								"                       W   X  X     X  X\n" + 
								"                        \\   X  XXXXX  X\n" + 
								"                         \\   X       X\n" + 
								"                          \\   XXXXXXX\n" + 
								"                           \\ X       X---\n" + 
								"                            X    O    X  \\\n" + 
								"                           X           X  \\\n" + 
								"                            XXXXXXXXXXX    \\\n" + 
								"                            X         X     M\n" + 
								"                           X     O     X\n" + 
								"                          X      O      X\n" + 
								"                         X               X\n" + 
								"                          XXXXXXXXXXXXXXX\n" + 
								"                          X             X\n" + 
								"                         X       O       X\n" + 
								"                        X        O        X\n" + 
								"                       X         O         X\n" + 
								"                      X                     X\n" + 
								"                       XXXXXXXXXXXXXXXXXXXXX\n" + 
								"                       X                   X\n" + 
								"                      X          O          X\n" + 
								"                     X           O           X\n" + 
								"                    X            O            X\n" + 
								"                   X             O             X\n" + 
								"                  X                             X\n" + 
								"                   XXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n" + 
								"                   X                           X\n" + 
								"                  X              O              X\n" + 
								"                 X               O               X\n" + 
								"                X                O                X\n" + 
								"               X                 O                 X\n" + 
								"              X                  O                  X\n" + 
								"             X                                       X\n" + 
								"              XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n" + 
								"              X                                     X\n" + 
								"             X                   O                   X\n" + 
								"            X                    O                    X\n" + 
								"           X                     O                     X\n" + 
								"          X                      O                      X\n" + 
								"         X                       O                       X\n" + 
								"        X                        O                        X\n" + 
								"       X                                                   X\n" + 
								"        XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n" + 
								"        X                                                 X\n" + 
								"       X                         O                         X\n" + 
								"      X                          O                          X\n" + 
								"     X                           O                           X\n" + 
								"    X                            O                            X\n" + 
								"   X                             O                             X\n" + 
								"  X                              O                              X\n" + 
								" X                               O                               X\n" + 
								"X                                                                 X\n" + 
								" XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		} else if (size == 8) {
			System.out.println( "                                         |\n" + 
								"                                      \\  |  /\n" + 
								"                                       \\ | /\n" + 
								"                                        \\|/\n" + 
								"                                      XXXXXXX\n" + 
								"                                     X       X\n" + 
								"                                    X  O   O  X\n" + 
								"                                   X     V     X\n" + 
								"                               W   X  X     X  X\n" + 
								"                                \\   X  XXXXX  X\n" + 
								"                                 \\   X       X\n" + 
								"                                  \\   XXXXXXX\n" + 
								"                                   \\ X       X---\n" + 
								"                                    X    O    X  \\\n" + 
								"                                   X           X  \\\n" + 
								"                                    XXXXXXXXXXX    \\\n" + 
								"                                    X         X     M\n" + 
								"                                   X     O     X\n" + 
								"                                  X      O      X\n" + 
								"                                 X               X\n" + 
								"                                  XXXXXXXXXXXXXXX\n" + 
								"                                  X             X\n" + 
								"                                 X       O       X\n" + 
								"                                X        O        X\n" + 
								"                               X         O         X\n" + 
								"                              X                     X\n" + 
								"                               XXXXXXXXXXXXXXXXXXXXX\n" + 
								"                               X                   X\n" + 
								"                              X          O          X\n" + 
								"                             X           O           X\n" + 
								"                            X            O            X\n" + 
								"                           X             O             X\n" + 
								"                          X                             X\n" + 
								"                           XXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n" + 
								"                           X                           X\n" + 
								"                          X              O              X\n" + 
								"                         X               O               X\n" + 
								"                        X                O                X\n" + 
								"                       X                 O                 X\n" + 
								"                      X                  O                  X\n" + 
								"                     X                                       X\n" + 
								"                      XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n" + 
								"                      X                                     X\n" + 
								"                     X                   O                   X\n" + 
								"                    X                    O                    X\n" + 
								"                   X                     O                     X\n" + 
								"                  X                      O                      X\n" + 
								"                 X                       O                       X\n" + 
								"                X                        O                        X\n" + 
								"               X                                                   X\n" + 
								"                XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n" + 
								"                X                                                 X\n" + 
								"               X                         O                         X\n" + 
								"              X                          O                          X\n" + 
								"             X                           O                           X\n" + 
								"            X                            O                            X\n" + 
								"           X                             O                             X\n" + 
								"          X                              O                              X\n" + 
								"         X                               O                               X\n" + 
								"        X                                                                 X\n" + 
								"         XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n" + 
								"         X                                                               X\n" + 
								"        X                                O                                X\n" + 
								"       X                                 O                                 X\n" + 
								"      X                                  O                                  X\n" + 
								"     X                                   O                                   X\n" + 
								"    X                                    O                                    X\n" + 
								"   X                                     O                                     X\n" + 
								"  X                                      O                                      X\n" + 
								" X                                       O                                       X\n" + 
								"X                                                                                 X\n" + 
								" XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		} else if (size == 9) {
			System.out.println( "                                                  |\n" + 
								"                                               \\  |  /\n" + 
								"                                                \\ | /\n" + 
								"                                                 \\|/\n" + 
								"                                               XXXXXXX\n" + 
								"                                              X       X\n" + 
								"                                             X  O   O  X\n" + 
								"                                            X     V     X\n" + 
								"                                        W   X  X     X  X\n" + 
								"                                         \\   X  XXXXX  X\n" + 
								"                                          \\   X       X\n" + 
								"                                           \\   XXXXXXX\n" + 
								"                                            \\ X       X---\n" + 
								"                                             X    O    X  \\\n" + 
								"                                            X           X  \\\n" + 
								"                                             XXXXXXXXXXX    \\\n" + 
								"                                             X         X     M\n" + 
								"                                            X     O     X\n" + 
								"                                           X      O      X\n" + 
								"                                          X               X\n" + 
								"                                           XXXXXXXXXXXXXXX\n" + 
								"                                           X             X\n" + 
								"                                          X       O       X\n" + 
								"                                         X        O        X\n" + 
								"                                        X         O         X\n" + 
								"                                       X                     X\n" + 
								"                                        XXXXXXXXXXXXXXXXXXXXX\n" + 
								"                                        X                   X\n" + 
								"                                       X          O          X\n" + 
								"                                      X           O           X\n" + 
								"                                     X            O            X\n" + 
								"                                    X             O             X\n" + 
								"                                   X                             X\n" + 
								"                                    XXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n" + 
								"                                    X                           X\n" + 
								"                                   X              O              X\n" + 
								"                                  X               O               X\n" + 
								"                                 X                O                X\n" + 
								"                                X                 O                 X\n" + 
								"                               X                  O                  X\n" + 
								"                              X                                       X\n" + 
								"                               XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n" + 
								"                               X                                     X\n" + 
								"                              X                   O                   X\n" + 
								"                             X                    O                    X\n" + 
								"                            X                     O                     X\n" + 
								"                           X                      O                      X\n" + 
								"                          X                       O                       X\n" + 
								"                         X                        O                        X\n" + 
								"                        X                                                   X\n" + 
								"                         XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n" + 
								"                         X                                                 X\n" + 
								"                        X                         O                         X\n" + 
								"                       X                          O                          X\n" + 
								"                      X                           O                           X\n" + 
								"                     X                            O                            X\n" + 
								"                    X                             O                             X\n" + 
								"                   X                              O                              X\n" + 
								"                  X                               O                               X\n" + 
								"                 X                                                                 X\n" + 
								"                  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n" + 
								"                  X                                                               X\n" + 
								"                 X                                O                                X\n" + 
								"                X                                 O                                 X\n" + 
								"               X                                  O                                  X\n" + 
								"              X                                   O                                   X\n" + 
								"             X                                    O                                    X\n" + 
								"            X                                     O                                     X\n" + 
								"           X                                      O                                      X\n" + 
								"          X                                       O                                       X\n" + 
								"         X                                                                                 X\n" + 
								"          XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n" + 
								"          X                                                                               X\n" + 
								"         X                                        O                                        X\n" + 
								"        X                                         O                                         X\n" + 
								"       X                                          O                                          X\n" + 
								"      X                                           O                                           X\n" + 
								"     X                                            O                                            X\n" + 
								"    X                                             O                                             X\n" + 
								"   X                                              O                                              X\n" + 
								"  X                                               O                                               X\n" + 
								" X                                                O                                                X\n" + 
								"X                                                                                                   X\n" + 
								" XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		} else {
			System.out.println( "                                                            |\n" + 
								"                                                         \\  |  /\n" + 
								"                                                          \\ | /\n" + 
								"                                                           \\|/\n" + 
								"                                                         XXXXXXX\n" + 
								"                                                        X       X\n" + 
								"                                                       X  O   O  X\n" + 
								"                                                      X     V     X\n" + 
								"                                                  W   X  X     X  X\n" + 
								"                                                   \\   X  XXXXX  X\n" + 
								"                                                    \\   X       X\n" + 
								"                                                     \\   XXXXXXX\n" + 
								"                                                      \\ X       X---\n" + 
								"                                                       X    O    X  \\\n" + 
								"                                                      X           X  \\\n" + 
								"                                                       XXXXXXXXXXX    \\\n" + 
								"                                                       X         X     M\n" + 
								"                                                      X     O     X\n" + 
								"                                                     X      O      X\n" + 
								"                                                    X               X\n" + 
								"                                                     XXXXXXXXXXXXXXX\n" + 
								"                                                     X             X\n" + 
								"                                                    X       O       X\n" + 
								"                                                   X        O        X\n" + 
								"                                                  X         O         X\n" + 
								"                                                 X                     X\n" + 
								"                                                  XXXXXXXXXXXXXXXXXXXXX\n" + 
								"                                                  X                   X\n" + 
								"                                                 X          O          X\n" + 
								"                                                X           O           X\n" + 
								"                                               X            O            X\n" + 
								"                                              X             O             X\n" + 
								"                                             X                             X\n" + 
								"                                              XXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n" + 
								"                                              X                           X\n" + 
								"                                             X              O              X\n" + 
								"                                            X               O               X\n" + 
								"                                           X                O                X\n" + 
								"                                          X                 O                 X\n" + 
								"                                         X                  O                  X\n" + 
								"                                        X                                       X\n" + 
								"                                         XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n" + 
								"                                         X                                     X\n" + 
								"                                        X                   O                   X\n" + 
								"                                       X                    O                    X\n" + 
								"                                      X                     O                     X\n" + 
								"                                     X                      O                      X\n" + 
								"                                    X                       O                       X\n" + 
								"                                   X                        O                        X\n" + 
								"                                  X                                                   X\n" + 
								"                                   XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n" + 
								"                                   X                                                 X\n" + 
								"                                  X                         O                         X\n" + 
								"                                 X                          O                          X\n" + 
								"                                X                           O                           X\n" + 
								"                               X                            O                            X\n" + 
								"                              X                             O                             X\n" + 
								"                             X                              O                              X\n" + 
								"                            X                               O                               X\n" + 
								"                           X                                                                 X\n" + 
								"                            XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n" + 
								"                            X                                                               X\n" + 
								"                           X                                O                                X\n" + 
								"                          X                                 O                                 X\n" + 
								"                         X                                  O                                  X\n" + 
								"                        X                                   O                                   X\n" + 
								"                       X                                    O                                    X\n" + 
								"                      X                                     O                                     X\n" + 
								"                     X                                      O                                      X\n" + 
								"                    X                                       O                                       X\n" + 
								"                   X                                                                                 X\n" + 
								"                    XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n" + 
								"                    X                                                                               X\n" + 
								"                   X                                        O                                        X\n" + 
								"                  X                                         O                                         X\n" + 
								"                 X                                          O                                          X\n" + 
								"                X                                           O                                           X\n" + 
								"               X                                            O                                            X\n" + 
								"              X                                             O                                             X\n" + 
								"             X                                              O                                              X\n" + 
								"            X                                               O                                               X\n" + 
								"           X                                                O                                                X\n" + 
								"          X                                                                                                   X\n" + 
								"           XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n" + 
								"           X                                                                                                 X\n" + 
								"          X                                                 O                                                 X\n" + 
								"         X                                                  O                                                  X\n" + 
								"        X                                                   O                                                   X\n" + 
								"       X                                                    O                                                    X\n" + 
								"      X                                                     O                                                     X\n" + 
								"     X                                                      O                                                      X\n" + 
								"    X                                                       O                                                       X\n" + 
								"   X                                                        O                                                        X\n" + 
								"  X                                                         O                                                         X\n" + 
								" X                                                          O                                                          X\n" + 
								"X                                                                                                                       X\n" + 
								" XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		}
		System.out.print("  ");
		for (int i = 1; i < size; i++) for (int j = -1; j < i; j++) System.out.print(" ");
		System.out.println("OOOO OOOO");
		System.out.print("  ");
		for (int i = 1; i < size; i++) for (int j = -1; j < i; j++) System.out.print(" ");
		System.out.println("OOOO OOOO");
	}
	
	static String next() throws IOException {
		while (in == null || !in.hasMoreTokens())
			in = new StringTokenizer(br.readLine());
		return in.nextToken();
	}

	static long readLong() throws IOException {
		return Long.parseLong(next());
	}

	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}

	static double readDouble() throws IOException {
		return Double.parseDouble(next());
	}

	static String readLine() throws IOException {
		return br.readLine();
	}
}
