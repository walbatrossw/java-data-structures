package doubles.ds.algorithms;

import java.util.Scanner;

// 3개의 정수중 중앙값 판별하기
public class IntMedian3 {
    public static void main(String[] args) {

        Scanner stdIn = new Scanner(System.in);
        System.out.println("세 정수의 중앙 값 구하기");

        System.out.print("a의 값 입력 : ");
        int a = stdIn.nextInt();

        System.out.print("b의 값 입력 : ");
        int b = stdIn.nextInt();

        System.out.print("c의 값 입력 : ");
        int c = stdIn.nextInt();

        System.out.println("중앙 값은 " + median3method1(a, b, c) + "입니다.");
        System.out.println("중앙 값은 " + median3method2(a, b, c) + "입니다.");
    }

    private static int median3method1(int a, int b, int c) {

        if (a >= b) {
            if (b >= c) {
                return b;
            } else if (a <= c) {
                return a;
            } else {
                return c;
            }
        } else if (a > c) {
            return a;
        } else if (b > c) {
            return c;
        } else {
            return b;
        }

    }

    private static int median3method2(int a, int b, int c) {

        if ((b >= a && c <= a) || (b <= a && c >= a)) {
            return a;
        } else if ((a > b && c < b) || (a < b && c > b)) {
            return b;
        }
        return c;

    }
}
