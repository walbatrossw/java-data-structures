package doubles.ds.arrays;

import java.util.Scanner;

// 배열 역순 정렬, 합계
public class ReverseArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("요소의 개수 : ");
        int num = scanner.nextInt();

        int[] x = new int[num];

        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = scanner.nextInt();
        }

        reverse(x);

        System.out.println();
        System.out.println("배열을 역순으로 정렬");
        for (int i = 0; i < num; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }

        System.out.println();
        System.out.println("배열 합계 : " + sumOf(x));
    }

    // 위치 교환
    private static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    // 배열 역순 정렬
    private static void reverse(int[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            System.out.println();
            System.out.println("a[" + i + "]와 a[" + (a.length - i - 1) + "]를 교환합니다.");
            swap(a, i, a.length - i - 1);
            printArray(a);
        }
    }

    // 배열 출력
    private static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    // 배열 요소 합계
    private static int sumOf(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }
}
