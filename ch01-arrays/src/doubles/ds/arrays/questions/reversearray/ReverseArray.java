package doubles.ds.arrays.questions.reversearray;

// 배열 순서 뒤집기
public class ReverseArray {

    public int[] reverseArray(int[] numbers) {

        int startIndex = 0; // 시작 위치
        int endIndex = numbers.length - 1;  // 마지막 위치

        // 반복 1회에서 2개의 요소의 위치를 교환, n/2 반복만 수행하게 된다.
        while (endIndex > startIndex) {
            // 시작 인덱스와 마지막 인덱스 요소들을 교환 수행
            swap(numbers, startIndex, endIndex);
            // 시작, 마지막 인덱스 1씩 증가, 감소
            startIndex++;
            endIndex--;
        }

        // 순서가 바뀐 배열 반환
        return numbers;
    }

    // 교환
    private void swap(int[] numbers, int index1, int index2) {
        int temp = numbers[index1];
        numbers[index1] = numbers[index2];
        numbers[index2] = temp;
    }

}
