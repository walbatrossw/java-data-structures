package doubles.ds.arrlist;

public class Test {
    public static void main(String[] args) {
        ArrList<String> arrList = new ArrList<>();
        arrList.insertLast("자동차1");
        arrList.insertLast("자동차2");
        arrList.insertLast("자동차3");
        arrList.insertLast("자동차4");
        arrList.insertLast("자동차5");
        arrList.insertLast("자동차6");

        for (int i = 0; i < arrList.getSize(); i++) {
            System.out.print(arrList.peek(i) + " ");
        }

        System.out.println();
        arrList.delete(2);

        for (int i = 0; i < arrList.getSize(); i++) {
            System.out.print(arrList.peek(i) + " ");
        }
    }
}
