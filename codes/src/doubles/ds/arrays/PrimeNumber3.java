package doubles.ds.arrays;

public class PrimeNumber3 {
    public static void main(String[] args) {
        int counter = 0;                // 나눗셈 횟수
        int primeCounter = 0;           // 찾은 소수의 개수
        int[] primes = new int[500];    // 소수를 저장하는 배열

        primes[primeCounter++] = 2;     // 소수 2
        primes[primeCounter++] = 3;     // 소수 3

        // 5부터 1000까지 홀수만 반복
        for (int n = 5; n <= 1000; n += 2) {
            boolean flag = false;

            // n의 제곱근 이하의 어떤 소수도 나누어 떨어지 않을 때까지
            for (int i = 1; primes[i] * primes[i] <= n; i++) {
                counter += 2; // 제곱근 구하기, 나누기 연산과정 포함되있기 때문에 2씩 증가
                if (n % primes[i] == 0) {   // 나누어 떨어지면 소수 아님
                    flag = true;
                    break;  // 내부 반복문 실행 종료
                }
            }

            // 마지막까지 나누어 떨어지지 않으면
            if (!flag) {
                primes[primeCounter++] = n; // 배열에 소수저장
                counter++;
            }
        }

        for (int i = 0; i < primeCounter; i++) {
            System.out.println(primes[i]);
        }

        System.out.println("곱셉과 나눗셈을 수행한 횟수 : " + counter);
    }
}
