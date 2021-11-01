import java.lang.reflect.Method;
import java.io.*;
public class jsb19p2 {
    public static void main(String[] args) {
        System.setSecurityManager(null);
        try {
            Class thisClass = Class.forName("Secret");
            Method f = thisClass.getDeclaredMethod("flag", null);
            f.setAccessible(true);
            f.invoke(thisClass.newInstance(), null);
        } catch (Exception e) {}
    }
}
