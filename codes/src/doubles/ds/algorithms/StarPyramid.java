package doubles.ds.algorithms;

import java.util.Scanner;

public class StarPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        System.out.println("별 피라미드 출력");

        do {
            System.out.println("단수는 : ");
            n = scanner.nextInt();
        } while (n <= 0);

        starPyramid(n);
    }

    private static void starPyramid(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print("   ");
            }
            for (int j = 1; j <= (i - 1) * 2 + 1; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }
}

