package doubles.ds.queues.array;

public class Main {
    public static void main(String[] args) {
        ArrQueue<String> queue = new ArrQueue<>();
        queue.add("A");
        queue.add("B");
        queue.add("C");
        queue.add("D");
        queue.add("E");

        queue.printQueue();
        System.out.println();

        System.out.println(queue.remove());
        queue.printQueue();
        System.out.println(queue.remove());
        queue.printQueue();
        System.out.println(queue.remove());
        queue.printQueue();

    }
}
