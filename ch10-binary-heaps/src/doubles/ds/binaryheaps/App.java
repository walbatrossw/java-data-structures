package doubles.ds.binaryheaps;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        Heap heap = new Heap(8); // 힙 생성

        // 삽입
        heap.insert(20);
        heap.insert(4);
        heap.insert(45);
        heap.insert(11);
        heap.insert(7);
        heap.insert(33);
        heap.insert(70);
        heap.insert(35);

        // 힙 출력
        heap.printHeap();

        // 힙 최대값 반환
        System.out.println(heap.getMax());

        // 힙 삭제
        System.out.println(heap.poll());

        // 힙 출력
        heap.printHeap();

        // 힙 정렬
        heap.heapsort();
    }
}
