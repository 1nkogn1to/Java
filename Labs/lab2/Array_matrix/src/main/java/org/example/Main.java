//Зеззюлько Егор, 7 группа, 2 курс
/**Задание 4: Среди строк заданной матрицы,
 * содержащих только нечетные элементы,
 * найти строку с максимальной суммой модулей элементов.**/

package org.example;

public class Main {
    public static int module(int number) {
        if (number < 0) {
            return -number;
        } else {
            return number;
        }
    }
    public static int result(int[][] mat) {
        int sum = 0, sum2;
        for (int i = 0; i < 3; i++) {
            sum2 = 0;
            int k = 0;
            for (int j = 0; j < 3; j++) {
                if (mat[i][j] % 2 == 1 || mat[i][j] % 2 == -1) {
                    k++;
                }
            }
            if (k == 3) {
                for (int j = 0; j < 3; j++) {
                    sum2 += module(mat[i][j]);
                }
                if (sum < sum2) {
                    sum = sum2;
                }
            }
        }
        return sum;
    }
    public static void definition(int[][] mat) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                mat[i][j] = (int)((Math.round(Math.random() * 101) - 50) * 2 + 1);
            }
        }
    }
    public static void main(String[] args) {
        int [][] matrix = new int[3][3];
        definition(matrix);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(result(matrix));
    }
}