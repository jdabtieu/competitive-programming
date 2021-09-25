import java.io.*;
import java.util.*;

public class dt16l2p2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        line = line.replace("Germany", "Polska");
        line = line.replace("Czech Republic", "Polska");
        line = line.replace("Slovakia", "Polska");
        line = line.replace("Ukraine", "Polska");
        line = line.replace("Belarus", "Polska");
        line = line.replace("Lithuania", "Polska");
        line = line.replace("Kaliningrad Oblast", "Polska");
        System.out.println(line);
    }
}
