package doubles.ds.algorithms;

import java.util.Scanner;

// 정수의 양수, 음수, 0 판별
public class JudgeSign {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("정수를 입력하세요 : ");
        int n = stdIn.nextInt();

        if (n > 0) {
            System.out.println("양수 입니다.");
        } else if (n < 0) {
            System.out.println("음수 입니다.");
        } else {
            System.out.println("0 입니다");
        }
    }

}
