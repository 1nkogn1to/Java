import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (DecoratorInput din = new DecoratorInput("input.txt");
            DecoratorOutput dout = new DecoratorOutput("output.txt")) {
            String str = " ";
            while ((str = din.readLine()) != null) {
                System.out.println(str);
                dout.write(str + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}