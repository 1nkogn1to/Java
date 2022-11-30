// Зезюлько Егор, 2 курс, 7 группа
/**4. Задан текстовый файл input.txt. Требуется определить строки этого файла,
содержащие максимальную по длине строго возрастающую подстроку.
Если таких строк несколько, найти первые 10.
Результат вывести на консоль в форме, удобной для чтения.**/


// В файле 11 строк с наибольшей возрастающей подпоследовательностью букв и 15 строк всего
/**abcde
fgefg
fghij
klmno
pqrst
uvwxy
mnopq
evwvwfeu
xyzab
cdefg
hijkl
mnopq
rstuv
wxyzab
cdefg**/

// Программа выведет 10 строк с наибольшей возрастающей подпоследовательностью букв

import java.io.*;
import java.util.*;

public class Main {
    public static String sort(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
    public static String largest_subString(String line, String line_help, int[][] dp) {
        String str_result = "";
        for (int i = line.length(), j = line.length(); i > 0 && j > 0;) {
            if (line_help.charAt(i - 1) == line.charAt(j - 1)) {
                str_result = line_help.charAt(i - 1) + str_result;
                i--; j--;
            } else {
                if (dp[i][j - 1] > dp[i - 1][j]) { j--; }
                else { i--; }
            }
        }
        return str_result;
    }

    public static int counter(String line) {
        String line_help = sort(line);
        int[][] dp = new int[line.length() + 1][line.length() + 1];
        for (int i = 0; i < line.length() + 1; i++) {
            for (int j = 0; j < line.length() + 1; j++) {
                if (i == 0 || j == 0) { dp[i][j] = 0; }
                else if (line_help.charAt(i - 1) == line.charAt(j - 1)) { dp[i][j] = dp[i - 1][j - 1] + 1; }
                else { dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); }
            }
        }
        int counter_max = 0;

        String result = largest_subString(line, line_help, dp);

        counter_max = Math.max(counter_max, result.length());
        return counter_max;
    }
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/input.txt"), 1024);
             BufferedWriter bw = new BufferedWriter(new FileWriter("src/output.txt"))) {
            int counter_max = 0, counter = 0;
            List<String> arr = new ArrayList<String>();
            List<Integer> arr_counter = new ArrayList<Integer>();

            while (br.ready()) {
                String line = br.readLine();
                counter = counter(line);
                counter_max = Math.max(counter_max, counter);
                counter = counter(line);
                arr.add(line);
                arr_counter.add(counter);
                counter_max = Math.max(counter_max, counter);
            }

            int counter_lines = 0;
            for (int i = 0; i < arr.size(); i++) {
                if (arr_counter.get(i) == counter_max) {
                    bw.write(arr.get(i) + "\n");
                    counter_lines += 1;
                }
                if (counter_lines == 10) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}