import java.io.*;

public class DecoratorOutput extends BufferedOutputStream {
    public DecoratorOutput(String name) throws IOException {
        super(new FileOutputStream(name));
    }
    
    public void write(int b) throws IOException {
        super.write(Character.toLowerCase((char)b));
    }

    public void write(String s) throws IOException {
        byte b[] = s.getBytes();
        super.write(b, 0, b.length);
    }
    
    public void write(byte b[], int offset, int len) throws IOException {
        for (int i = offset; i < offset + len; i++) {
            b[i] = (byte)Character.toLowerCase((char)b[i]);
        }
        super.write(b, offset, len);
    }
}