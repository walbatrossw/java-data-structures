package doubles.data.structure.list.array;

public class ArrayListTest {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        list.add("G");
        list.add("H");

        for (int i = 0; i < list.getSize(); i ++) {
            System.out.println(list.get(i));
        }

        list.remove(1);
    }

}
