// Зезюлько Егор, 7 группа, 2 курс
/**4.	Словом в строке считается последовательность букв латинского алфавита,
 * остальные символы являются разделителями между словами.
 * За один просмотр символов строки найти все слова с максимальной долей гласных букв
 * (т.е. прописных и строчных символов ’a’, ’e’, ’i’, ’o’, ’u’, ’y’) и занести их в новую строку.
 * Слова в исходной строке разделяются некоторым множеством разделителей.
 * Слова в новой строке должны разделяться ровно одним пробелом. **/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/input.txt"), 1024);
             BufferedWriter bw = new BufferedWriter(new FileWriter("src/output.txt"))) {

            String line = br.readLine(), result = "";
            StringTokenizer st = new StringTokenizer(line, " \t\n\r,.");

            double max = 0, max_help;
            while (st.hasMoreTokens()) {
                line = st.nextToken();
                int count = 0; max_help = 0;

                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == 'a' || line.charAt(i) == 'e' || line.charAt(i) == 'i' || line.charAt(i) == 'o' || line.charAt(i) == 'u' || line.charAt(i) == 'y') {
                        count++;
                    }
                }
                max_help = (double)(count / line.length());
                if (max_help > max) {
                    max = max_help;
                    result = line;
                } else if (max_help == max) {
                    result = result + " " + line;
                }
            }
            bw.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}