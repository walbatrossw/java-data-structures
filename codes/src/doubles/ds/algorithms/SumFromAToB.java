package doubles.ds.algorithms;

import java.util.Scanner;

public class SumFromAToB {
    public static void main(String[] args) {

        Scanner stdIn = new Scanner(System.in);
        System.out.println("a와 b를 포함하여 그 사이의 모든 정수의 합 구하기");

        System.out.print("a의 값 : ");
        int a = stdIn.nextInt();

        System.out.print("b의 값 : ");
        int b = stdIn.nextInt();

        System.out.println("정수 a, b 사이의 모든 정수의 합은 " + sumFromAtoB(a, b) + " 입니다.");
    }

    private static int sumFromAtoB(int a, int b) {

        int min;
        int max;

        if (a < b) {
            min = a;
            max = b;
        } else {
            min = b;
            max = a;
        }

        int sum = 0;
        for (int i = min; i <= max; i++) {
            sum += i;
        }

        return sum;
    }
}
