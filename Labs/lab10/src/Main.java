import java.util.*;

public class Main {
    public static void definition(List<Integer> list, int size) {
        for (int i = 0; i < size; i++) {
            list.add(size - i);
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        int size = scan.nextInt();
        scan.close();
        List<Integer> list = new ArrayList<Integer>();
        definition(list, size);

        Thread sort = new Thread(new Runnable() {
            @Override
            public void run() {
                Collections.sort(list, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer a, Integer b) {
                        return a - b;
                    }
                });
            }
        });
        System.out.println("Before sorting: ");
        for (int i = 0; i < size; i++) {
            System.out.print(list.get(i) + " ");
        }

        sort.start();

        try {
            sort.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\nAfter sorting: ");
        for (int i = 0; i < size; i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}