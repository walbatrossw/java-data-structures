package doubles.data.structure.sort;

public class BubbleSort {

    public static void main(String[] args) {

        int[] intArray = {11, 55, -4, -13, 1, 4, 22, 15};

        printArray(intArray);

        for (int lastUnsortedIndex = intArray.length -1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            for (int i = 0; i < lastUnsortedIndex; i++) {
                if (intArray[i] > intArray[i+1])
                    swap(intArray, i, i+1);
            }
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
