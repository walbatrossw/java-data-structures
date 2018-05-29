package doubles.ds.algorithms;

import java.util.Scanner;

public class Square {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        System.out.println("정사각형 출력하기");
        do {
            System.out.println("단수 : ");
            n = scanner.nextInt();
        } while (n <= 0);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j ++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

}
