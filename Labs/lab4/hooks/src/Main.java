// Зезюлько Егор, 7 группа, 2 курс
/** Задача со скобками(удалить всё, что находится во внешних скобках) **/

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("src/output.txt"))) {
            String fullText = "", line;
            while ((line = br.readLine()) != null) {
                fullText += line + "\n";
            }
            int counter = 0;
            StringBuffer full = new StringBuffer(fullText);
            for (int i = 0; i < full.length(); i++) {
                if (full.charAt(i) == '(') {
                    counter++;
                } else if (full.charAt(i) == ')') {
                    counter--;
                }
                if (counter == 1) {
                    full.deleteCharAt(i);
                    i--;
                }
            }
            bw.write(full.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}