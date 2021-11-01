import java.io.*;
import java.util.*;
import java.lang.reflect.*;

public class jsb19p3 {
    public static void main(String[] args) {
        Thread.currentThread().setUncaughtExceptionHandler((t, e) -> {});
        new Thread(() -> {
            try {
                Class thisClass = Class.forName("Secret");
                Method f = thisClass.getDeclaredMethod("flag", null);
                f.invoke(thisClass.newInstance(), null);
            } catch (Exception e) {}
        }).start();
    }
}
