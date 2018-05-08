package doubles.datastructure.sorts;

// 버블 정렬
public class BubbleSort {

    public static void main(String[] args) {

        int[] intArray = {55, 11, -4, -13, 1, 4, 22, 15};

        printArray(intArray);

        // 배열의 마지막 index부터 1씩 감소하면서 반복 수행
        for (int lastUnsortedIndex = intArray.length -1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            // 배열의 마지막 index까지 1씩 증가하면서 반복 수행
            for (int i = 0; i < lastUnsortedIndex; i++) {
                // 현재 요소와 다음요소의 크기 비교
                if (intArray[i] > intArray[i+1])
                    // 위치 교환
                    swap(intArray, i, i+1);
            }
        }

        printArray(intArray);
    }

    // 교환
    private static void swap(int[] array, int i, int j) {

        if (i == j)
            return;

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }

    // 배열 출력t
    private static void printArray(int[] array) {
        for (int i : array)
            System.out.print(+ i + " ");
        System.out.println();
    }

}
