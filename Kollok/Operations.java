import java.util.*;

public class Operations {
    private List<Long> list = new ArrayList<>();
    Operations() {
        list.add(1l);
        Long fac = 1l;
        for (int i = 1; i < 21; i++) {
            fac = fac * i;
            list.add(fac);
        }
    }
    public Long factorial(int num) {
        return (num < list.size() || num < 0) ? list.get(num) : -1l;
    }
    public List<Long> factorials_before_num1(Long num) {
        if (num > list.size() || num < 0) { return new ArrayList<>(Arrays.asList(-1l)); }
        List<Long> help_list = new ArrayList<>();
        for (int i = 0; i <= num; i++) {
            help_list.add(factorial(i));
        }
        return help_list;
    }
    public List<Long> factorials_before_num2(Long num) {
        if (num > list.size() || num < 0) { return new ArrayList<>(Arrays.asList(-1l)); }
        List<Long> help_list = new ArrayList<>();
        for (int i = 0; i <= num; i++) {
            help_list.add(list.get(i));
        }
        return help_list;
    }
}