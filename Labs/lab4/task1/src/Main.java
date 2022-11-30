// Зезюлько Егор, 7 группа, 2 курс
/** Словом в строке считается последовательность букв латинского алфавита,
 * остальные символы являются разделителями между словами.
 * За один просмотр символов строки найти все слова с максимальной долей гласных букв
 * (т.е. прописных и строчных символов ’a’, ’e’, ’i’, ’o’, ’u’, ’y’) и занести их в новую строку.
 * Слова в исходной строке разделяются некоторым множеством разделителей.
 * Слова в новой строке должны разделяться ровно одним пробелом. **/

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/output.txt"));
        String text = "", line;
        while ((line = br.readLine()) != null) {
            text += line + " ";
        }
        br.close();
        Pattern p = Pattern.compile("[aeyuio]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(text);
        int max = 0, count = 0;
        List<Double> arr_of_percents = new ArrayList<>();
        List<String> words = new ArrayList<>();
        for (String word : text.split(" ")) {
            m.reset(word);
            while (m.find()) {
                count++;
            }
            double percent = (double) count / word.length() * 100;
            arr_of_percents.add(percent);
            words.add(word);
            if (percent > max) {
                max = (int)percent;
            }
            count = 0;
        }
        for (int i = 0; i < arr_of_percents.size(); i++) {
            if (arr_of_percents.get(i) == max) {
                bw.write(words.get(i) + " ");
            }
        }
        bw.close();
    }
}