package doubles.ds.algorithms;

import java.util.Scanner;

// 1, 2, ..., n의 합 구하기 : for문 사용
public class SumFor {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("1부터 n까지의 합");
        System.out.println("n의 값 : ");
        int n = stdIn.nextInt();

        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        System.out.println("1부터 n까지의 합은 " + sum + "입니다.");
    }
}
