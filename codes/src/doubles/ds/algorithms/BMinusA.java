package doubles.ds.algorithms;

import java.util.Scanner;

public class BMinusA {
    public static void main(String[] args) {
        System.out.println("b - a를 출력하기");
        Scanner stdIn = new Scanner(System.in);

        System.out.print("a의 값 : ");
        int a = stdIn.nextInt();

        int b = 0;

        while (true) {
            System.out.print("b의 값 : ");
            b = stdIn.nextInt();
            if (b > a) {
                break;
            }
            System.out.println("a보다 큰 값을 입력하세요!");
        }

        System.out.println("b - a 는 " + (b - a) + " 입니다.");


    }
}
