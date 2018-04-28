package doubles.data.structure.lists.linked.singly;

public class SingleLinkedListTest {
    public static void main(String[] args) {

        SingleLinkedList<String> list = new SingleLinkedList<>();
        list.addFirst("월");
        list.addLast("화");
        list.addLast("수");
        list.addLast("목");
        list.addLast("금");
        list.addLast("토");
        list.addFirst("일");
        list.printLinkedList(list);

        list.remove("수");
        list.removeLast();
        list.printLinkedList(list);
        System.out.println(list.indexOf("월"));

        list.remove(10);



    }



}
