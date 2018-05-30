package doubles.ds.arrays;

import java.util.Scanner;

// 배열 요소 비교
public class ArrayEqual {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("배열 a의 요소의 개수 : ");
        int arrANum = scanner.nextInt();

        int[] a = new int[arrANum];

        for (int i = 0; i < arrANum; i++) {
            System.out.print("a[" + i + "] : ");
            a[i] = scanner.nextInt();
        }

        System.out.print("배열 b의 요소의 개수 : ");
        int arrBNum = scanner.nextInt();

        int[] b = new int[arrBNum];

        for (int i = 0; i < arrBNum; i++) {
            System.out.print("b[" + i + "] : ");
            b[i] = scanner.nextInt();
        }

        System.out.println("배열 a와 b는 " + (equals(a, b) ? "같습니다." : "같지 않습니다."));
    }

    private static boolean equals(int[] a, int[] b) {
        // 길이가 같이 않으면
        if (a.length != b.length) {
            return false;
        }
        // 배열 a와 b의 요소 비교
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}
