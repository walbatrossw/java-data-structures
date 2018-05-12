package doubles.ds.lists.siglylinkedlist;

import doubles.ds.Employee;

public class SinglyLinkedListMain {

    public static void main(String[] args) {

        Employee kim = new Employee(1, "김사원", "사원", 27);
        Employee lee = new Employee(2, "이대리", "대리", 30);
        Employee park = new Employee(3, "박대리", "대리", 31);
        Employee beak = new Employee(4, "백차장", "차장", 35);
        Employee choi = new Employee(5, "최과장", "과장", 37);
        Employee yoon = new Employee(6, "윤전무", "전무", 40);

        EmployeeSingleLinkedList list = new EmployeeSingleLinkedList();

        System.out.println(list.isEmpty());

        list.addToFront(kim);
        list.addToFront(lee);
        list.addToFront(park);
        list.addToFront(beak);
        list.addToFront(choi);
        list.addToFront(yoon);

        System.out.println(list.getSize());

        list.printList();

        list.removeFormFront();
        System.out.println(list.getSize());
        list.printList();

    }

}
