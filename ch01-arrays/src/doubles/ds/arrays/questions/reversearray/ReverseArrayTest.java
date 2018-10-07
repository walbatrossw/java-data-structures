package doubles.ds.arrays.questions.reversearray;

public class ReverseArrayTest {
    public static void main(String[] args) {

        // 배열 선언
        int[] numbers = {1, 2, 3, 4, 5};

        // 배열 요소 교환 클래스의 인스턴스 생성
        ReverseArray reverseArray = new ReverseArray();

        // 배열 요소 교환 수행
        int[] reversedNumbers = reverseArray.reverseArray(numbers);

        // 순서가 바뀐 배열 출력
        for (int number : reversedNumbers) {
            System.out.print(number + " ");
        }

    }
}
