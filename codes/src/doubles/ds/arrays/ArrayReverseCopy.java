package doubles.ds.arrays;

import java.util.Scanner;

// 배열 복사 : 역순으로
public class ArrayReverseCopy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("배열 a의 요소 개수 : ");
        int arrANum = scanner.nextInt();
        int[] a = new int[arrANum];

        for (int i = 0; i < arrANum; i++) {
            System.out.print("a[" + i + "] : ");
            a[i] = scanner.nextInt();
        }

        System.out.print("배열 b의 요소 개수 : ");
        int arrBNum = scanner.nextInt();
        int[] b = new int[arrBNum];

        for (int i = 0; i < arrBNum; i++) {
            System.out.print("b[" + i + "] : ");
            b[i] = scanner.nextInt();
        }

        reverseCopy(a, b);

        System.out.println("배열 b의 모든 요소를 배열 a에 역순으로 복사");
        for (int i = 0; i < arrANum; i++) {
            System.out.println("a[" + i + "] = " + a[i]);
        }
    }

    private static void reverseCopy(int[] a, int[] b) {
        // 배열 a의 길이가 b의 길이보다 작거나 같으면 배열 a의 길이로
        // 아니면 배열 b의 길이로
        int num = a.length <= b.length ? a.length : b.length;

        // 배열 b의 끝 요소부터 배열 a에 복사
        for (int i = 0; i < num; i++) {
            a[i] = b[b.length - i - 1];
        }
    }
}
