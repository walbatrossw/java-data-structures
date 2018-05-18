package doubles.ds.lists.arraylist;

public class ArrListMain {
    public static void main(String[] args) {

        ArrList<String> stringArrList = new ArrList<>();

        // 리스트 마지막에 데이터 추가
        stringArrList.addLast("A");
        stringArrList.addLast("B");
        stringArrList.addLast("D");
        stringArrList.addLast("E");
        stringArrList.addLast("G");

        System.out.println(stringArrList);

        // 리스트 특정 인덱스에 데이터 추가
        stringArrList.add("C", 2);
        stringArrList.add("F", 5);
        stringArrList.add("H", 7);

        System.out.println(stringArrList);

        // 리스트 특정 인덱스의 데이터 가져오기
        System.out.println(stringArrList.get(1));

        // 리스트 사이즈
        System.out.println(stringArrList.size());

        // 리스트 특정 인덱스 데이터 삭제
        System.out.println(stringArrList.remove(2));

        System.out.println(stringArrList);
    }
}
