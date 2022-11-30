// Зезюлько Егор, 7 группа, 2 курс
/** Проверить является ли число шеснадцатиричным кодом цвета.**/

import java.util.Scanner;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number: ");
        String line = scan.nextLine();
        scan.close();

        Pattern pattern = Pattern.compile("[#][0-9a-f]{6}", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(line);                  // делает символы F и f эквивалентными

        if (matcher.find() && line.equals(line.substring(matcher.start(), matcher.end()))) {
            System.out.println("String is a valid hex color code.");
        } else {
            System.out.println("String is not a valid hex color code.");
        }
    }
}