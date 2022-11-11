// decorator for reading and writing to a file

import java.io.*;


public class DecoratorInput extends BufferedReader {
    public DecoratorInput(String name) throws IOException {
        super(new FileReader(name));
    }
    
    public String readLine() throws IOException {
        String str = super.readLine();
        if (str != null) {
            str = str.toLowerCase();
        }
        return str;
    }
}
