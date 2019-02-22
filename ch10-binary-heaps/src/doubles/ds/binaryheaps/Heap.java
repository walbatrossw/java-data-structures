package doubles.ds.binaryheaps;

public class Heap {

    private int[] heap;     // heap
    private int heapSize;   // heap 사이즈

    // 생성자
    public Heap(int capacity) {
        this.heap = new int[capacity];
    }

    // 삽입
    // running time : 삽입은 O(1)이 걸리지만 heap 속성을 위반한 경우 fixUp()를 수행해야 하기 때문에 O(logN)
    public void insert(int item) {

        // heap이 차있는지 체크
        if (isHeapFull()) {
            throw new RuntimeException("Heap is full...");
        }

        this.heap[heapSize] = item; // 항목 삽입
        heapSize = heapSize + 1;    // 사이즈 증가
        fixUp(heapSize - 1); // heap 속성을 위반한 경우 heap 속성 재구성

    }

    // heap 속성을 위반한 경우 교환 수행
    // running time : O(logN)
    private void fixUp(int currentIndex) {

        int parentIndex = (currentIndex - 1) / 2; // 상위 노드의 인덱스 계산

        // 루트노드 X, 상위노드의 항목보다 햔제노드의 항목이 클 경우
        if (currentIndex > 0 && heap[currentIndex] > heap[parentIndex]) {
            swap(currentIndex, parentIndex); // 현재 노드와 상위 노드 교환 수행
            fixUp(parentIndex); // 루트노드까지 반복 수행하기 위해 재귀 호출
        }

    }

    // heap 최대값 반환
    // running time : O(1)
    public int getMax() {
        return this.heap[0];
    }

    // heap 최대값 반환 + 항목 제거
    // running time : 0(logN)
    public int poll() {
        int max = getMax();     // 최대값
        swap(0, heapSize - 1);  // 최상위 노드와 최하위노드 교환
        this.heapSize--;        // heap 사이즈 감소
        fixDown(0);       // heap 속성을 위반할 경우 heap 속성 재구성
        return max;
    }

    // heap 속성을 위반한 경우 교환 수행
    private void fixDown(int index) {

        int indexLeft = 2 * index + 1;  // 왼쪽 하위노드 인덱스 계산
        int indexRight = 2 * index + 2; // 오른쪽 하위노드 인덱스 계산
        int indexLargest = index;       // 상위 노드의 인덱스
        
        // 왼쪽 하위노드가 상위노드보다 큰 경우
        if (indexLeft < heapSize && heap[indexLeft] > heap[index]) {
            indexLargest = indexLeft;
        }
        
        // 오른쪽 하위노드가 왼쪽 하위노드보다 큰 경우
        if (indexRight < heapSize && heap[indexRight] > heap[indexLargest]) {
            indexLargest = indexRight;
        }
        
        // 왼쪽 or 오른쪽 하위노드가 상위노드보다 큰 경우
        if (index != indexLargest) {
            swap(index, indexLargest); // 교환 수행
            fixDown(indexLargest);     // 최하위 노드까지 반복수행하기 위해 재귀 호출
        }

    }

    // 힙정렬
    public void heapsort() {
        int size = this.heapSize;
        System.out.print("[ ");
        // 힙 사이즈 만큼 반복수행
        for (int i = 0; i < size; i++) {
            int max = poll();            // 현재 heap의 최대값 추출
            System.out.print(max + " "); // 최대값 출력
        }
        System.out.print("]");
    }

    // 노드의 교환 수행
    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    // heap이 차있는지 체크
    private boolean isHeapFull() {
        return this.heap.length == this.heapSize;
    }

    public void printHeap() {
        System.out.print("[ ");
        for (int i = 0; i < heapSize; i++) {
            System.out.print( heap[i] + " ");
        }
        System.out.print("]");
        System.out.println();
    }
}
