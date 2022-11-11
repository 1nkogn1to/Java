import java.util.Scanner;

public class Facade {
    public void test_of_functionality() {
        new Tests().full_test(new Operations());
    }

    public void caller() {
        Scanner scan = new Scanner(System.in);
        Operations op = new Operations();
        System.out.println("Enter the number: ");
        int num = scan.nextInt();
        System.out.println(op.factorial(num));
        System.out.println(op.factorials_before_num1((long)num));
        System.out.println(op.factorials_before_num2((long)num));
        scan.close();
    }
}