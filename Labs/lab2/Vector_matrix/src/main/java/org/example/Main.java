//Зеззюлько Егор, 7 группа, 2 курс
/**Задание 32: Даны две действительные квадратные матрицы порядка n.
 * Получить новую матрицу путем прибавления к элементам каждого столбца
 * первой матрицы произведения элементов соответствующих строк второй матрицы.**/

package org.example;

import java.util.Vector;
import java.util.Scanner;

public class Main {
    public static void definition(Vector<Vector<Integer>> mat, int n) {
        for (int i = 0; i < n; i++) {
            Vector<Integer> arr = new Vector<>(n);
            for (int j = 0; j < n; j++) {
                arr.add(j, (int)(Math.random() * 51) - 25);
            }
            mat.addElement(arr);
        }
    }
    public static void print(Vector<Vector<Integer>> mat, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
    public static void transposition_print(Vector<Vector<Integer>> mat, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(mat.get(j).get(i) + " ");
            }
            System.out.println();
        }
    }
    public static void multiply(Vector<Vector<Integer>> mat_final,
                                Vector<Vector<Integer>> mat1,
                                Vector<Vector<Integer>> mat2, int size) {
        int m;
        for (int i = 0; i < size; i++) {
            m = 1;
            for (int j = 0; j < size; j++) {
                m *= mat2.get(i).get(j);
            }
            Vector<Integer> arr = new Vector<>(size);
            for (int j = 0; j < size; j++) {
                arr.add(j, mat1.get(j).get(i) + m);
            }
            mat_final.addElement(arr);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        System.out.print("Введите размерность матриц: ");
        size = scanner.nextInt();
        Vector<Vector<Integer>> matrix1 = new Vector<>(size);
        Vector<Vector<Integer>> matrix2 = new Vector<>(size);
        Vector<Vector<Integer>> matrix_final = new Vector<>(size);
        definition(matrix1, size);
        definition(matrix2, size);
        System.out.println("Первая матрица:");
        print(matrix1, size);
        System.out.println("Вторая матрица:");
        print(matrix2, size);
        multiply(matrix_final, matrix1, matrix2, size);
        System.out.println("Итоговая матрица:");
        transposition_print(matrix_final, size);
    }
}