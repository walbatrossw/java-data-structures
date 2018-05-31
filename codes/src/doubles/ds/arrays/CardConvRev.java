package doubles.ds.arrays;

import java.util.Scanner;

// 기수 변환 : 입력받은 정수 10진수를 2진수 ~ 36진수로 변환하기
public class CardConvRev {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num;    // 변환할 정수
        int cd;     // 진수
        int dno;    // 변환 후 자릿수
        int retry;  // 변환 후 다시 시도 여부
        char[] cno = new char[32]; // 변환후 각자리의 숫자를 넣어두는 문자 배열

        System.out.println("10진수를 기수변환합니다.");

        do {
            // 정수 값 입력
            do {
                System.out.print("음이 아닌 변환할 정수값 : ");
                num = scanner.nextInt();
            } while (num < 0);

            // 진수 값 입력
            do {
                System.out.print("몇진수로 변환? (2 ~ 36) : ");
                cd = scanner.nextInt();
            } while (cd < 2 || cd > 36);

            // 기수 변환 수행
            dno = cardConv(num, cd, cno);

            // 변환된 n진수 출력 : 윗자리부터 차례로
//            System.out.print(cd + "진수로는 ");
//            for (int i = dno - 1; i >= 0; i--) {
//                System.out.print(cno[i]);
//            }

            // 변환된 n진수 출력 : 이미 윗자리부터 정렬되있기 때문에 순서대로 출력
            System.out.print(cd + "진수로는 ");
            for (int i = 0; i < dno; i++) {
                System.out.print(cno[i]);
            }
            System.out.println(" 입니다.");

            // 기수 변환 수행 여부 확인
            System.out.print("한번더 기수 변환을 수행할까요? (1.예 / 0.아니오) : ");
            retry = scanner.nextInt();

        } while (retry == 1);

    }

    // 기수 변환 메서드
    private static int cardConv(int num, int r, char[] d) {

        // 변환 후 자릿수
        int digits = 0;

        // 2 ~ 36진수에 사용될 숫자, 문자열
        String dChar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // 나눌 값(정수)이 0이 될때 까지 반복
        do {
            // 정수 num을 r(진수깂)로 나눈 나머지를 통해 dChar의 숫자, 알파벳을 배열에 저장
            d[digits++] = dChar.charAt(num % r);
            num /= r;   // 10진수 / 진수값
        } while (num != 0);

        // 출력을 역순으로 하지 않기 위해 배열에 저장된 요소 역순정렬
        for (int i = 0; i < digits / 2; i++) {
            char temp = d[i];
            d[i] = d[digits - i - 1];
            d[digits - i - 1] = temp;
        }

        return digits;
    }

}
