package doubles.ds.binaryheaps;

public class App {
    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.insert(20);
        heap.insert(4);
        heap.insert(45);
        heap.insert(11);
        heap.insert(7);
        heap.insert(33);
        heap.insert(70);
        System.out.println(heap.getMax());
    }
}
