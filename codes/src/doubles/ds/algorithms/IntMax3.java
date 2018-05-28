package doubles.ds.algorithms;

import java.util.Scanner;

// 3개의 정수값 입력, 최대값 구하기
public class IntMax3 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("세 정수의 최대값 구하기");

        // 3개의 정수 입력 받기
        System.out.println("a의 값 : ");
        int a = stdIn.nextInt();

        System.out.println("b의 값 : ");
        int b = stdIn.nextInt();

        System.out.println("c의 값 : ");
        int c = stdIn.nextInt();

        // 최대값 판별
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }

        System.out.println("최대값은 " + max + " 입니다.");
    }
}
