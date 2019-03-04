package doubles.ds.lru;

public class App {
    public static void main(String[] args) {

        LRUCache cache = new LRUCache();

        cache.put(0, "A");
        cache.show();
        cache.put(1, "B");
        cache.show();
        cache.put(2, "C");
        cache.show();
        cache.put(3, "D");
        cache.show();

        cache.put(4, "E");
        cache.show();

        cache.put(5, "F");
        cache.show();

        cache.put(6, "G");
        cache.show();

        System.out.println(cache.get(6));
        cache.show();

        System.out.println(cache.get(3));
        cache.show();

        System.out.println(cache.get(4));
        cache.show();

    }
}
