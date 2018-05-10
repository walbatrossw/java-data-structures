package doubles.ds.lists.arraylist;

import doubles.ds.Employee;

import java.util.ArrayList;
import java.util.List;

// ArrayList 활용연습
public class ArrayListMain {

    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();

        // ArrayList 데이터 삽입
        employeeList.add(new Employee(1, "김사원", "사원", 27));
        employeeList.add(new Employee(2, "이대리", "대리", 30));
        employeeList.add(new Employee(3, "박대리", "대리", 31));
        employeeList.add(new Employee(4, "백차장", "차장", 35));
        employeeList.add(new Employee(5, "최과장", "과장", 37));
        employeeList.add(new Employee(6, "윤전무", "전무", 40));

        // ArrayList 출력
        employeeList.forEach(employee -> System.out.println(employee));

        // ArrayList 배열의 인덱스로 데이터 가져오기
        System.out.println(employeeList.get(1));

        // ArrayList 비어있는지 확인
        System.out.println(employeeList.isEmpty());

        // ArrayList 특정 인덱스의 데이터 변경
        employeeList.set(1, new Employee(7, "양상무", "상무", 44));

        // ArrayList 출력
        employeeList.forEach(employee -> System.out.println(employee));

        // ArrayList 사이즈
        System.out.println(employeeList.size());

        // ArrayList 특정 인덱스에 데이터 삽입
        employeeList.add(1, new Employee(8, "김대리", "대리", 29));

        // ArrayList 출력
        employeeList.forEach(employee -> System.out.println(employee));

        System.out.println("--------------------");

        // ArrayList 출력
        Employee[] employeeArray = employeeList.toArray(new Employee[employeeList.size()]);
        for (Employee employee : employeeArray)
            System.out.println(employee);

        // ArrayList 특정 데이터 존재 유무 확인 : equals, hashcode 코드 반드시 작성
        System.out.println(employeeList.contains(new Employee(6, "윤전무", "전무", 40)));

        // ArrayList 특정 데이터의 인덱스 확인
        System.out.println(employeeList.indexOf(new Employee(6, "윤전무", "전무", 40)));

        // ArrayList 특정 인덱스의 데이터 삭제
        System.out.println(employeeList.remove(2));

        System.out.println("--------------------");

        // ArrayList 출력
        employeeList.forEach(employee -> System.out.println(employee));
    }

}
