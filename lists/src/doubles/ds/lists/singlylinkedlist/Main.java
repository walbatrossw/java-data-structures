package doubles.ds.lists.singlylinkedlist;

public class Main {

    public static void main(String[] args) {

        List<Integer> integerList = new LinkedList<>();
        integerList.insert(10);
        integerList.insert(-2);
        integerList.insert(3);
        integerList.insert(100);

        integerList.traverseList();

        integerList.remove(3);

        integerList.traverseList();

        System.out.println();

        List<String> stringList = new LinkedList<>();
        stringList.insert("kim");
        stringList.insert("lee");
        stringList.insert("park");
        stringList.insert("choi");
        stringList.insert("yoon");

        stringList.traverseList();

        stringList.remove("kim");

        stringList.traverseList();

        System.out.println();

        List<Person> personList = new LinkedList<>();
        personList.insert(new Person("kim", 30));
        personList.insert(new Person("park", 26));
        personList.insert(new Person("lee", 22));
        personList.insert(new Person("choi", 32));

        Person yoon = new Person("yoon", 28);
        personList.insert(yoon);

        personList.traverseList();

        personList.remove(yoon);

        personList.traverseList();
    }

}
