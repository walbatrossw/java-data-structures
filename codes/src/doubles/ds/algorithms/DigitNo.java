package doubles.ds.algorithms;

import java.util.Scanner;

public class DigitNo {
    public static void main(String[] args) {

        Scanner stdIn = new Scanner(System.in);
        System.out.println("양의 정수의 자릿수 구하기");

        int a;
        do {
            System.out.print("양의 정수 값 : ");
            a = stdIn.nextInt();
        } while (a <= 0);

        int digitNo = 0;

        while (a > 0) {
            a /= 10;
            digitNo++;
        }

        System.out.println(digitNo + " 자리입니다.");
    }
}
