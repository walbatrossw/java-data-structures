package doubles.ds.algorithms;

import java.util.Scanner;

public class SumGauss {
    public static void main(String[] args) {

        Scanner stdIn = new Scanner(System.in);
        System.out.println("1부터 n까지의 합");
        System.out.println("n의 값 : ");
        int n = stdIn.nextInt();

        int sum = (1 + n) * n/2;

        System.out.println("1부터 n까지의 합은 "+sum+" 입니다.");
    }
}
