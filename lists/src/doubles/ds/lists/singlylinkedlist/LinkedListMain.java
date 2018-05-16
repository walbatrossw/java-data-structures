package doubles.ds.lists.singlylinkedlist;

public class LinkedListMain {

    public static void main(String[] args) {

        // Integer 타입의 연결 리스트
        List<Integer> integerList = new LinkedList<>();

        // 추가
        integerList.insert(10);
        integerList.insert(-2);
        integerList.insert(3);
        integerList.insert(100);

        // 연결 리스트 전체 탐색
        integerList.traverseList();

        // 삭제
        integerList.remove(3);

        // 연결 리스트 전체 탐색
        integerList.traverseList();

        System.out.println();

        // String 타입의 연결 리스트
        List<String> stringList = new LinkedList<>();

        // 추가
        stringList.insert("kim");
        stringList.insert("lee");
        stringList.insert("park");
        stringList.insert("choi");
        stringList.insert("yoon");

        // 연결 리스트 전체 탐색
        stringList.traverseList();

        // 삭제
        stringList.remove("kim");

        // 연결 리스트 전체 탐색
        stringList.traverseList();

        System.out.println();

        // 추상 데이터 타입의 연결 리스트
        List<Person> personList = new LinkedList<>();
        personList.insert(new Person("kim", 30));
        personList.insert(new Person("park", 26));
        personList.insert(new Person("lee", 22));
        personList.insert(new Person("choi", 32));

        Person yoon = new Person("yoon", 28);
        personList.insert(yoon);

        // 연결 리스트 전체 탐색
        personList.traverseList();

        // 삭제
        personList.remove(yoon);

        personList.traverseList();
    }

}
