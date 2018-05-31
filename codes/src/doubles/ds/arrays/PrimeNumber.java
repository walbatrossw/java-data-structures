package doubles.ds.arrays;

// 1~1000까지의 소수 나열하기 1
public class PrimeNumber {

    public static void main(String[] args) {

        int counter = 0;

        // 2부터 1000까지 반복 수행 : 2 ~ n(정수) - 1

        // n은 자기자신
        for (int n = 2; n <= 1000; n++) {

            int i; // i는 나눌 숫자
            for (i = 2; i < n; i++) {
                counter++;
                if (n % i == 0) {   // 나누어 떨어지면 소수 아님
                    break;          // 반복문 종료
                }
            }
            // 마지막까지 나누어 떨어지지 않은 숫자 : 소수 출력
            if (n == i) {
                System.out.println(n);
            }
        }

        System.out.println("나눗셈을 수행한 횟수 : " + counter);
    }

}
