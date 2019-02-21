package doubles.ds.binaryheaps;

public class Heap {

    private Integer[] heap; // 데이터를 저장활 배열

    private int currentPosition = -1;   // 데이터가 저장된 위치, -1로 초기화

    // 생성자
    public Heap(int size) {
        this.heap = new Integer[size];
    }

    // 삽입
    public void insert(int item) {
        // heap이 차있는지 확인
        if (isFull()) {
            throw new RuntimeException("Heap is Full...");
        }
        // 항목 삽입
        this.heap[++currentPosition] = item;
        // heap 속성 확인 및 속성에 충족하도록 수정처리
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
            System.out.print(temp + " ");
            this.heap[0] = this.heap[currentPosition - i];
            this.heap[currentPosition - i] = temp;
            fixDown(0, currentPosition - i - 1);
        }
        System.out.println();
    }

    // Heap 속성에 맞게 상위 노드와 하위 노드의 위치 교환
    private void fixUp(int index) {

        // 상위노드 인덱스 계산
        int parentIndex = (index - 1) / 2;

        // 상위 노드가 루트 노드이고, 상위 노드가 더 클 때까지 반복 수행
        while (parentIndex >= 0 && this.heap[parentIndex] < this.heap[index]) {

            // 현재노드와 부모노드 교환 수행
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

    // Heap이 차있는지 확인
    private boolean isFull() {
        return this.currentPosition == this.heap.length;
    }

}
