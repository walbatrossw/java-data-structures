package doubles.data.structure.list.linked.singly;

public class SingleLinkedListTest {
    public static void main(String[] args) {
        SingleLinkedList<String> list = new SingleLinkedList<>();
        list.addFirst("월");
        list.addLast("화");
        list.addLast("수");
        list.addLast("목");
        list.addLast("금");
        list.addLast("토");
        list.addLast("일");


        System.out.println(list.get(2));
        System.out.println(list.indexOf("월"));

    }
}
