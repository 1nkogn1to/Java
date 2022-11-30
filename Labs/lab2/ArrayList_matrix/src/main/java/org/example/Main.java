//Зезюлько Егор, 7 группа, 2 курс
/**Задание 18: Подсчитать количество строк заданной матрицы,
 * являющихся перестановкой чисел 1, 2, ..., 20. **/

package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void definition(ArrayList<ArrayList<Integer>> mat, int n) {
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> arr = new ArrayList<>(20);
            for (int j = 0; j < 20; j++) {
                arr.add(j, 20 - j);
            }
            if (i == 1 || i == 7) { // для того, чтобы было видно что программа работает, а не выводит количество строк
                arr.set(13, 15);
            }
            mat.add(i, arr);
        }
    }
    public static void print(ArrayList<ArrayList<Integer>> mat, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.print(mat.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
    public static void sort(ArrayList<Integer> arr) {
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19 - i; j++) {
                if (arr.get(j + 1) < arr.get(j)) {
                    int temp = arr.get(j + 1);
                    arr.set(j + 1, arr.get(j));
                    arr.set(j, temp);
                }
            }
        }
    }
    public static int check(ArrayList<ArrayList<Integer>> mat, int n) {
        int k, count = 0;
        ArrayList<Integer> arr;
        for (int i = 0; i < n; i++) {
            k = 0;
            arr = mat.get(i);
            sort(arr);
            mat.set(i, arr);
            for (int j = 0; j < 20; j++) {
                if (mat.get(i).get(j) == j + 1) {
                    k++;
                }
            }
            if (k == 20) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n, m;
        System.out.print("Введите число строк: ");
        n = scan.nextInt();
        System.out.print("Введите число столбов: ");
        m = scan.nextInt();
        if (m != 20) {
            System.out.println("Строки этой матрицы не могут являться перестановкой чисел от 1 до 20.");
        }
        else {
            ArrayList<ArrayList<Integer>> mat = new ArrayList<>();

            definition(mat, n);
            System.out.println("Тестовая матрица:");
            print(mat, n);

            System.out.println("Отсортированная матрица:");
            check(mat, n);
            print(mat, n);
            System.out.println(check(mat, n));
        }
    }
}