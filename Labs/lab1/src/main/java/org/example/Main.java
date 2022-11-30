//Зеззюлько Егор, 7 группа, 2 курс
/*Задание 4. Разложить через ряд Тейлора функцию (1+x)^(1/2)*/

package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;
import java.text.*;

public class Main {
    public static double factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            double result = 1;
            for (int i = 1; i <= n; i++) {
                result *= i;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(3);
        Scanner scan = new Scanner(System.in);

        double x;
        System.out.print("Введите число x из интервала (-1; 1): ");
        x = scan.nextDouble();
        if (x <= -1 || x >= 1) {
            System.out.println("Введён неверный x:(");
            System.exit(1);
        }

        int k;
        System.out.print("Введите натуральное число k: ");
        k = scan.nextInt();


        System.out.println("Стандартная функция корня: " + formatter.format(Math.sqrt(1 + x)));

        BigDecimal x_BD, a = new BigDecimal(-1), b = new BigDecimal(1);
        System.out.print("Введите число x из интервала (-1; 1): ");
        x_BD = scan.nextBigDecimal();
        if (x_BD.max(a) == a || b.max(x_BD) == x_BD) {
            System.out.println("Введён неверный x:(");
            System.exit(1);
        }
        System.out.print("Введите натуральное число k: ");
        k = scan.nextInt();

        BigDecimal slag_BD = new BigDecimal("0"), result_BD = new BigDecimal("0");
        int n = 0;
        result_BD.setScale(10, RoundingMode.HALF_UP);
        BigDecimal st = new BigDecimal(Math.pow(10, -k));
        do {
            BigDecimal pow_1_n = new BigDecimal(Math.pow(-1, n)),
                    f2n = new BigDecimal(factorial(2 * n)),
                    pow_x_n = new BigDecimal(Math.pow(x_BD.doubleValue(), n)),
                    sub = new BigDecimal(1 - 2 * n),
                    pow_fn_2 = new BigDecimal(Math.pow(factorial(n), 2)),
                    pow_4_n = new BigDecimal(Math.pow(4, n));
            slag_BD = new BigDecimal(pow_1_n.multiply(f2n.multiply(pow_x_n)).divide(sub.multiply(pow_fn_2.multiply(pow_4_n)), 10, RoundingMode.HALF_UP).doubleValue());
            result_BD = new BigDecimal(result_BD.add(slag_BD).doubleValue());
            n++;
        } while (st.max(slag_BD) == slag_BD);

        result_BD.setScale(3, RoundingMode.HALF_UP);
        System.out.println("Разложение через ряд Тейлора (BigDecimal): " + result_BD + "\n");
    }
}