package doubles.ds.arrays;

// 1~1000까지의 소수 나열하기 1
public class PrimeNumber2 {

    public static void main(String[] args) {
        int counter = 0;                // 나눗셈 횟수
        int primeCounter = 0;           // 찾은 소수의 개수
        int[] primes = new int[500];    // 소수 저장 배열

        primes[primeCounter++] = 2;     // 소수 2

        // 3부터 1000까지 홀수만 반복 수행
        for (int n = 3; n <= 1000; n += 2) {
            int i;
            // 이미 찾은 소수로 나눔
            for (i = 1; i < primeCounter; i++) {
                counter++;
                // 나누어 떨어지면 소수 X
                if (n % primes[i] == 0) {
                    break;  // 내부 반복문 실행 종료
                }
            }
            // 마지막까지 나누어 떨어지자 않음
            if (primeCounter == i) {
                primes[primeCounter++] = n; // 소수 저장
            }
        }

        for (int i = 0; i < primeCounter; i++) {
            System.out.println(primes[i]);
        }
        System.out.println("나눗셈을 수행한 횟수 : " + counter);
    }

}
