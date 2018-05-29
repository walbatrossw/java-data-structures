package doubles.ds.algorithms;

import java.util.Scanner;

public class Digits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int no;

        System.out.println("2자리 정수 입력...");

        do {
            System.out.print("입력 : ");
            no = scanner.nextInt();
        } while (no < 10 || no > 99);

        System.out.println("변수 no의 값은 " + no + " 입니다.");
    }
}
