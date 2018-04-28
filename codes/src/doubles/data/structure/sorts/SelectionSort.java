package doubles.data.structure.sorts;

// 선택 정렬
public class SelectionSort {
    public static void main(String[] args) {

        int[] intArray = {55, 11, -4, -13, 1, 4, 22, 15};

        printArray(intArray);


        for (int lastUnsortedIndex = intArray.length -1; lastUnsortedIndex > 0; lastUnsortedIndex--) {

            int largest = 0;

            for (int i = 1; i <= lastUnsortedIndex; i++) {

                if (intArray[i] > intArray[largest])
                    largest = i;

            }

            swap(intArray, largest, lastUnsortedIndex);
        }

        printArray(intArray);
    }

    private static void printArray(int[] array) {
        for (int i : array)
            System.out.print(+ i + " ");
        System.out.println();
    }

    private static void swap(int[] array, int i, int j) {

        if (i == j)
            return;

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }

}
