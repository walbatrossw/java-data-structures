package doubles.ds.algorithms;

import java.util.Scanner;

// 1, 2, ..., n의 합 구하기 : while문 사용
public class SumWhile {

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("1부터 n까지의 합");
        System.out.println("n의 값 : ");
        int n = stdIn.nextInt();

        int sum = 0;
        int i = 1;
        while (i <= n) {
            sum += i;
            i++;
        }
        System.out.println("1부터 n까지의 합은 " + sum + "입니다.");
    }

}
