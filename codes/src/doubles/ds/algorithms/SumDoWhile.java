package doubles.ds.algorithms;

import java.util.Scanner;

public class SumDoWhile {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.println("1부터 n까지 합 구하기, do while문");
        int n;

        do {
            System.out.print("n의 값 : ");
            n = stdIn.nextInt();
        } while (n <= 0);

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        System.out.println("1부터 " + n + " 까지의 합은 " + sum + " 입니다.");
    }
}
