import java.lang.reflect.*;

class BACL extends ClassLoader {
    public BACL() {
        super();
    }

    public Class<?> go(String name, byte[] bytes, int off, int len) {
        Class<?> clazz = defineClass(name, bytes, off, len);
        resolveClass(clazz);
        return clazz;
    }
}

public class jsb19p4 {
    public static void main(String[] args) throws Exception {
        byte[] b = new byte[2000];
        int read = Class.forName("Secret").getResourceAsStream("Secret.class").read(b);
        int i = 315;
        i++; // array bytecode starts here
        i++; // push 1 onto stack
        for (int j = 0; j < 36; j++) {
            i++; // dup stack val
            if (b[i] == 16) { // push byte as int onto stack
                i += 2;
            } else { // push const onto stack
                i++;
            }
            i++; // push next 2 bytes on stack
            i += 2;
            i++; // store to array
        }
        for (;; i++) {
            /**
             * Replace String flag = new String(deobfuscated); return false ? flag : "NO U";
             * with return NOP NOP NOP new String(deobfuscated);
             */
            if ((b[i] & 0xff) == 0x4e && (b[i + 1] & 0xff) == 0x12 && (b[i + 3] & 0xff) == 0xb0) {
                b[i] = 0;
                b[i + 1] = 0;
                b[i + 2] = 0;
                break;
            }
        }
        // Rename class from Secret to Mecret to avoid naming conflict
        b[0xc1] = 'M';
        // Load class
        Class<?> clazz = new BACL().go("Mecret", b, 0, read);
        // Call getFlag
        Method m = clazz.getDeclaredMethod("getFlag");
        m.setAccessible(true);
        System.out.println(m.invoke(clazz.newInstance()));
    }
}
