import java.util.*;

public class Tests {

    public void full_test(Operations op) {
        test_fact_1(op);
        test_fact_2(op);
        test_fact_3(op);
        test_fact_4(op);
        test_fact_5(op);
        test_fact_6(op);
    }

    public void test_fact_1(Operations op) {
        System.out.println((op.factorial(13) == 6227020800l) ? "Test 1: passed" : "Test 1: failed");
    }
    public void test_fact_2(Operations op) {
        System.out.println((op.factorial(8) == 40320l) ? "Test 2: passed" : "Test 2: failed");
    }
    public void test_fact_3(Operations op) {
        System.out.println((op.factorials_before_num2(4l).equals(new ArrayList<>(Arrays.asList(1l, 1l, 2l, 6l, 24l)))) ? "Test 3: passed" : "Test 3: failed");
    }
    public void test_fact_4(Operations op) {
        System.out.println((op.factorials_before_num2(7l).equals(new ArrayList<>(Arrays.asList(1l, 1l, 2l, 6l, 24l, 120l, 720l, 5040l)))) ? "Test 4: passed" : "Test 4: failed");
    }
    public void test_fact_5(Operations op) {
        System.out.println((op.factorials_before_num2(4l).equals(new ArrayList<>(Arrays.asList(1l, 1l, 2l, 6l, 24l)))) ? "Test 5: passed" : "Test 5: failed");
    }
    public void test_fact_6(Operations op) {
        System.out.println((op.factorials_before_num2(7l).equals(new ArrayList<>(Arrays.asList(1l, 1l, 2l, 6l, 24l, 120l, 720l, 5040l)))) ? "Test 6: passed" : "Test 6: failed");
    }
}