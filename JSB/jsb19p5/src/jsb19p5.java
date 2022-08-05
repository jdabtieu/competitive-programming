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

public class jsb19p5 {
    public static void main(String[] args) throws Exception{
        byte[] bytes = new byte[1000];
        // Read the Secret.class file from the JAR
        int len = Class.forName("agent.Agent").getResourceAsStream("/secret/Secret.class").read(bytes);
        // https://en.wikipedia.org/wiki/Java_class_file
        // The name of the class is hardcoded in both the class file and Agent
        // If we change the name of the class, it will slip through the cracks
        // Using Wikipedia + hexdump tells me the location of the name string
        // By replacing S with M, I effectively rename the class to secret.Mecret
        // which is not blacklisted
        bytes[0xb2] = 77;
        // Load the nodified class
        BACL ld = new BACL();
        Class<?> clazz = ld.go("secret.Mecret", bytes, 0, len);
        clazz.getDeclaredMethod("flag").invoke(null);
    }
}
