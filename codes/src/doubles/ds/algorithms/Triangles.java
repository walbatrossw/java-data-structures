package doubles.ds.algorithms;

import java.util.Scanner;

public class Triangles {

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int n;

        System.out.println("4가지의 직각 삼각형 출력하기");

        do {
            System.out.print("단수는 ：");
            n = stdIn.nextInt();
        } while (n <= 0);

        System.out.println("왼쪽 아래가 직각인 삼각형");
        triangleLeftBottom(n);

        System.out.println("왼쪽 위가 직각인 삼각형");
        triangleLeftUp(n);

        System.out.println("오른쪽 위가 직각인 삼각형");
        triangleRightUp(n);

        System.out.println("오른쪽 아래가 직각인 삼각형");
        triangleRightBottom(n);
    }

    // 왼쪽 아래가 직각인 이등변삼각형을 출력
    private static void triangleLeftBottom(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

    // 왼쪽 위가 직각인 이등변삼각형을 출력
    private static void triangleLeftUp(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

    // 오른쪽 위가 직각인 이등변삼각형을 출력
    private static void triangleRightUp(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                System.out.print("   ");
            }
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

    // 오른쪽 아래가 직각인 이등변삼각형을 출력
    private static void triangleRightBottom(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print("   ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }
}
