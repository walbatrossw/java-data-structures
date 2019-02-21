package doubles.ds.binaryheaps;

public class Heap {

    private Integer[] heap; // 데이터를 저장활 배열

    private int currentPosition = -1;   // 데이터가 저장될 위치, -1f로 초기화

    // 생성자
    public Heap(int size) {
        this.heap = new Integer[size];
    }

    // 삽입
    public void insert(int item) {
        if (isFull()) {
            throw new RuntimeException("Heap is Full...");
        }
        this.heap[++currentPosition] = item;
        fixUp(currentPosition);
    }

    // 최대값 반환
    public int getMax() {
        int result = this.heap[0];
        this.heap[0] = this.heap[currentPosition--];
        this.heap[currentPosition + 1] = null;
        fixDown(0, -1);
        return result;
    }

    // Heap 정렬
    public void heapSort() {
        for (int i = 0; i <= currentPosition; i++) {
            int temp = this.heap[0];
            System.out.println(temp + " ");
            this.heap[0] = this.heap[currentPosition - i];
            this.heap[currentPosition - i] = temp;
            fixDown(0, currentPosition - i - 1);
        }
    }


    private void fixUp(int index) {

        int parentIndex = (index - 1) / 2;

        while (parentIndex >= 0 && this.heap[parentIndex] < this.heap[index]) {
            int temp = this.heap[index];
            this.heap[index] = this.heap[parentIndex];
            this.heap[parentIndex] = temp;
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }

    }

    private void fixDown(int index, int upto) {
        if (upto < 0) {
            upto = currentPosition;
        }

        while (index <= upto) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            if (leftChild <= upto) {

                int childToSwap;

                if (rightChild > upto) {
                    childToSwap = leftChild;
                } else {
                    childToSwap = (this.heap[leftChild] > this.heap[rightChild]) ? leftChild : rightChild;
                }

                if (this.heap[index] < this.heap[childToSwap]) {
                    int temp = this.heap[index];
                    this.heap[index] = this.heap[childToSwap];
                    this.heap[childToSwap] = temp;
                } else {
                    break;
                }

                index = childToSwap;

            } else {
                break;
            }
        }
    }

    private boolean isFull() {
        return this.currentPosition == this.heap.length;
    }

}
