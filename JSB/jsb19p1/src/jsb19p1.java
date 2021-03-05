import java.lang.reflect.Method;
import java.io.*;
import java.lang.*;
public class jsb19p1 {
    public static void main(String[] args) {
        try {
            Class thisClass = Class.forName("Secret");
            Method f = thisClass.getDeclaredMethod("flag", null);
            f.setAccessible(true);
            f.invoke(thisClass.newInstance(), null);
        } catch (Exception e) {
            System.out.println("EXCEPTION CAUGHT");
        }
    }
}
