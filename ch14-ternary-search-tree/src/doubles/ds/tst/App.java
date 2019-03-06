package doubles.ds.tst;

public class App {
    public static void main(String[] args) {
        TST tst = new TST();
        tst.put("cat", 1);
        tst.put("apple", 2);
        tst.put("car", 3);
        tst.put("carrot", 4);
        tst.put("cow", 5);

        System.out.println(tst.get("car"));
        System.out.println(tst.get("carrot"));
        System.out.println(tst.get("cow"));
        System.out.println(tst.get("hello"));
    }
}
