package doubles.ds.arrays;

import java.util.Random;
import java.util.Scanner;

// 배열 최대값 구하기, 난수 사용
public class MaxOfArrayRandom {

    public static void main(String[] args) {
        Random random = new Random();

        System.out.println("최장신 찾기, 난수 입력받기");
        Scanner scanner = new Scanner(System.in);

        System.out.print("사람 수 입력 : ");
        int num = scanner.nextInt();

        int[] height = new int[num];

        for (int i = 0; i < num; i++) {
            height[i] = 100 + random.nextInt(90);
            System.out.println("height[" + i + "] : " + height[i]);
        }

        System.out.println("최장신은 " + maxOf(height) + "입니다.");

    }

    private static int maxOf(int[] a) {
        int max = a[0];

        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }

        return max;
    }
}
