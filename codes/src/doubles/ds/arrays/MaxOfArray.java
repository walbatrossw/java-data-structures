package doubles.ds.arrays;

import java.util.Scanner;

// 배열 요소 중에서 최대값 구하기
public class MaxOfArray {

    public static void main(String[] args) {
        System.out.println("최장신 찾기");
        Scanner scanner = new Scanner(System.in);

        System.out.print("사람 수 입력 : ");
        int num = scanner.nextInt();

        int[] height = new int[num];

        for (int i = 0; i < num; i++) {
            System.out.print("height[" + i + "] : ");
            height[i] = scanner.nextInt();
        }

        System.out.println("최장신은 " + maxOf(height) + "입니다.");


    }

    // 최대값 구하기
    private static int maxOf(int[] a) {
        int max = a[0];

        // 배열 길이만큼 반복
        for (int i = 0; i < a.length; i++) {
            // 요소값 비교
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }
}
