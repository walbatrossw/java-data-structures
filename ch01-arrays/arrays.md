> 본 글은 [Udemy의 자바 자료구조 강의](https://www.udemy.com/algorithms-and-data-structures/)를 듣고 개인적으로 
학습한 내용 복습하기 위해 작성된 글로 내용상 오류가 있을 수 있습니다. 오류가 있다면 지적 부탁 드리겠습니다.

# Arrays(배열)

## 1. Arrays란?

**Array는 동일한 타입의 원소들이 연속적인 메모리 공간에 할당되어 각 항목이 하나의
원소에 저장되어 있는 기본적인 자료구조이다.**

### 1.1 Array의 구성

- 배열의 인덱스 또는 키로 식별되는 요소 / 값의 컬렉션
    - 인덱스는 0부터 시작
    - 인덱스 때문에 랜덤 엑세스가 가능

### 1.2 Array의 특성

- 배열은 동일한 유형의 타입을 저장하기 위한 자료구조
- 배열은 인덱스를 키로 사용
- 배열은 원하는 만큼의 차원을 가질 수 있음, 1차원/2차원/3차원 배열 등
- 동적배열 : 배열의 크기가 동적으로 변경되는 경우
- 응용 프로그램에는 table, hashtable, heap이 있음

## 2. Array의 장점

- 인덱스, 즉 키 때문에 랜덤 엑세스가 가능하다.
- 구현 및 사용이 쉽다.
- 매우 빠른 자료구조로 항목을 반복해서 추가하거나, 삭제하려고할 때 주어진 인덱스를
통해 빠르게 처리가 가능하다.

## 3. Array의 단점

- 컴파일 시점에 배열의 크기를 알아야하기 때문에 동적 자료구조가 아니다.
- 배열이 다 찾을 경우, 더 큰 배열을 만들어야하고 다 찬 배열의 데이터를 다시 복사해
옮겨야만 한다.
- 다른 유형의 데이터를 저장할 수 없다.

## 4. Array의 연산

### 4.1 삽입 엽산

배열에 34, 12, 120, -5를 차례로 추가한다면 아래와 같이 연산을 한다.

![array-operation-add](https://github.com/walbatrossw/java-data-structures/blob/master/ch01-arrays/img/array-operation-add.gif?raw=true)

- 배열이 가득 차지 않는 한 배열에 값을 계속 추가할 수 있다.
- 새로운 값을 리스트에 추가할 때, 다음 인덱스에 삽입하면 되기 때문에 매우 빠르다.
- 데이터의 양과 상관없이 빠르게 처리할 수 있기 때문에 O(1)의 시간 복잡도를 가진다.

### 4.2 특정 인덱스의 삽입 연산

배열의 인덱스 1에 23을 추가하려고 한다면, 아래와 같이 연산을 수행한다.

![array-operation-add-index](https://github.com/walbatrossw/java-data-structures/blob/master/ch01-arrays/img/array-operation-add-index.gif?raw=true)

- 주어진 인덱스에 값을 위와 같이 추가할 수 있다.
- 문제점은 새로운 값을 주어진 인덱스 위치에 삽입하기 위해서는 기존에 저장된 값들을
이동해야 된다.
- 저장된 데이터가 많으면 많을수록 처리시간이 증가하기 때문에 O(N)의 시간 복잡도를
가진다.

### 4.3 삭제 연산

배열에 저장된 값들을 뒤에서부터 차례로 삭제하는 연산은 아래와 같은데 배열의 마지막
요소부터 삭제하는 연산은 매우 간단하다.

![array-operation-remove](https://github.com/walbatrossw/java-data-structures/blob/master/ch01-arrays/img/array-operation-remove.gif?raw=true)

- 저장된 데이터의 양과 상관 없이 빠르게 처리할 수 있기 때문에 O(1)의 시간복잡도를
가진다.

### 4.4 특정 인덱스의 삭제 연산

배열의 특정 인덱스의 값을 삭제하는 연산은 아래와 같은데 배열의 마지막 값을 삭제하는
것처럼 간단하지 않다. 해당 인덱스의 값을 삭제하고, 배열에 공백을 채우기 위해 값들을
앞으로 한칸씩 이동시켜야 한다.

![array-operation-remove-index](https://github.com/walbatrossw/java-data-structures/blob/master/ch01-arrays/img/array-operation-remove-index.gif?raw=true)

- 저장된 데이터가 많으면 많을수록 이동시켜야할 데이터가 증가하기 때문에 O(1)의 시간복잡도를
갖는다.

## 5. Array 사용

```java
public class ArrApp {
    public static void main(String[] args) {

        // 배열 선언
        int[] nums = new int[5];

        // 배열에 값 저장
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }

        // O(1) 시간복잡도, random index
        int num = nums[0];
        System.out.println(num);

        // O(N) Linear Search(선형 탐색) --> O(LogN) Binary Tree(이진트리) --> O(1) HashTable(해쉬)
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 4) {
                System.out.println("index found : " + i);
            }
        }
    }
}
```

```
0
index found : 4
```

## 6. ArrayList 구현

```java
public class ArrayList<E> {

    private E arr[];      // 리스트에 항목을 저장할 배열
    private int size;   // 리스트의 항목 수

    public ArrayList() {
        arr = (E[]) new Object[1]; // 최초 1개의 원소를 가진 배열 생성
        size = 0;
    }

    // 특정 인덱스의 요소 탐색
    public E peek(int index) {
        if (size == 0) {
            throw new NoSuchElementException(); // underflow 경우 프로그램 정지
        }
        return arr[index];
    }

    // 삽입 연산 : 마지막
    public void addLast(E newItem) {
        // 배열의 빈공간이 없으면 배열의 크기 2배 확장
        if (size == arr.length) {
            resize(2 * arr.length);
        }
        arr[size++] = newItem; // 새로운 데이터 삽입, 사이즈 증가
        System.out.println("added : " + newItem);
    }

    // 삽입 연산 : 특정 인덱스
    public void add(E newItem, int index) {
        // 배열의 빈공간이 없으면 배열의 크기 2배 확장
        if (size == arr.length) {
            resize(2 * arr.length);
        }
        // 특정인덱스부터 한칸씩 뒤로 이동
        for (int i = size - 1; i >= index; i--) {
            arr[i + 1] = arr[i];
        }
        // 새로운 데이터 삽입
        arr[index] = newItem;
        size++; // 배열 사이즈 증가
        System.out.println("added : " + newItem);
    }

    public void addFirst(E newItem) {
        add(newItem, 0);
    }

    // 삭제 연산 : 특정 인덱스
    public void remove(int index) {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E item = arr[index];
        // 특정 인덱스부터 데이터를 한칸씩 앞으로 이동
        for (int i = index; i < size; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        // 배열에 저장된 항목들이 1/4만 차지한다면 배열을 1/2 크기로 축소
        if (size > 0 && size == arr.length / 4) {
            resize(arr.length / 2);
        }
        System.out.println("removed : " + item);
    }

    // 삭제 연산 : 첫번째
    public void removeFirst() {
        remove(0);
    }

    // 삭제 연산 : 마지막
    public void removeLast() {
        remove(size - 1);
    }

    // 배열 공백확인
    private boolean isEmpty() {
        return size == 0;
    }

    // 배열 크기 조절
    private void resize(int newSize) {
        // newSize 크기의 새로운 배열 생성
        Object[] newArr = new Object[newSize];
        // 기존의 배열의 데이터를 새로운 배열에 복사
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        arr = (E[]) newArr; // 새로운 벼열을 기존의 배열에 복사
    }

    // 리스트 출력
    public void printList() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
```

```java
public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
//        list.peek(0);
//        list.delete(0);

        list.addLast("b");
        list.addLast("c");
        list.printList();

        list.addLast("e");
        list.printList();

        list.addLast("f");
        list.addLast("g");
        list.printList();

        list.addFirst("a");
        list.add("d", 3);
        list.printList();

        list.removeFirst(); // a 제거
        list.removeLast();  // g 제거
        list.remove(1); // c 제거
        list.printList();

        list.removeLast();  // f 제거
        list.removeLast();  // e 제거
        list.printList();
    }
}
```

```
added : b
added : c
b c 
added : e
b c e null 
added : f
added : g
b c e f g null null null 
added : a
added : d
a b c d e f g null 
removed : a
removed : g
removed : c
b d e f null null null null 
removed : f
removed : e
b d null null 
```

## 6. Questions

### 6.1 배열에 저장된 데이터의 순서 바꾸기

- The problem is that we want to reverse a T[] array in O(N) linear time
complexity and we want the algorithm to be in-place as well!
- For example: input is [1,2,3,4,5] then the output is [5,4,3,2,1]

> 해결방법은 첫번째 인덱스와 마지막 인덱스의 요소를 교환하고, 첫번째 인덱스와 마지막
인덱스를 각각 1씩 증가, 감소 시키는 작업을 마지막 인덱스가 시작 인덱스보다 같거나 작아질
때까지 반복 수행하도록 한다.


```java
// 배열 순서 뒤집기
public class ReverseArray {

    public int[] reverseArray(int[] numbers) {

        int startIndex = 0; // 시작 위치
        int endIndex = numbers.length - 1;  // 마지막 위치

        // 반복 1회에서 2개의 요소의 위치를 교환, n/2 반복만 수행하게 된다.
        while (endIndex > startIndex) {
            // 시작 인덱스와 마지막 인덱스 요소들을 교환 수행
            swap(numbers, startIndex, endIndex);
            // 시작, 마지막 인덱스 1씩 증가, 감소
            startIndex++;
            endIndex--;
        }

        // 순서가 바뀐 배열 반환
        return numbers;
    }

    // 교환
    private void swap(int[] numbers, int index1, int index2) {
        int temp = numbers[index1];
        numbers[index1] = numbers[index2];
        numbers[index2] = temp;
    }

}
```

```java
public class ReverseArrayTest {
    public static void main(String[] args) {

        // 배열 선언
        int[] numbers = {1, 2, 3, 4, 5};

        // 배열 요소 교환 클래스의 인스턴스 생성
        ReverseArray reverseArray = new ReverseArray();

        // 배열 요소 교환 수행
        int[] reversedNumbers = reverseArray.reverseArray(numbers);

        // 순서가 바뀐 배열 출력
        for (int number : reversedNumbers) {
            System.out.print(number + " ");
        }

    }
}
```

```
5 4 3 2 1 
```

### 6.2 아나그램 문제 : 두개의 문자 배열의 알파벳들이 일치하는지 확인하기

- Construct an algorithm to check whether two words (or phrases) are anagrams or not!
- "An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once"
- example : restful --> fluster

> 해결방법은 두개의 문자 배열의 길이를 비교하고, 길이가 같다면 문자배열들을 정렬한다. 그리고 나서 배열의 요소들을 반복문을 통해 서로 일치하는지 확인한다.

```java
public class AnagramProblem {

    public boolean solve(char[] s1, char[] s2) {

        // 비교할 문자 배열의 길이가 같이 않으면 메서드 종료
        if (s1.length != s2.length) {
            return false;
        }

        // 문자 배열 정렬
        Arrays.sort(s1);
        Arrays.sort(s2);

        // 문자 배열 비교, 같지 않으면 메서드 종료
        for (int i = 0; i < s1.length; i++) {
            if (s1[i] != s2[i]) {
                return false;
            }
        }

        return true;
    }

}
```

```java
public class AnagramProblemTest {
    public static void main(String[] args) {

        char[] s1 = {'r', 'e', 's', 't', 'f', 'u', 'l'};
        char[] s2 = {'f', 'l', 'u', 's', 't', 'e', 'r'};

        AnagramProblem anagramProblem = new AnagramProblem();
        System.out.println(anagramProblem.solve(s1, s2));

    }
}
```

```
true
```

### 6.3 일차원 배열에서 중복된 정수값 찾기

- The problem is that we want to find duplicates in a T[] one-dimensional
array of integers in O(N) running time where the integer values are smaller
than the length of the array!

> 해결방법은 brute-force approach(O(n<sup>2</sup>)), hashmap, 절대값 사용하기(O(N))와
같이 3가지 방법이 존재하는데 절대값을 사용하여 값을 비교하는 것을 구현할 것이다.


1. 배열을 통해 반복
2. 각 요소에 대해 배열에서 `T[abs(T[i])]`를 찾고 양수인 경우 해당 값을 음수로 설정
3. 2단계에서 음수를 만나면 배열의 인덱스 `i`에 있는 요소가 중복

```
array = [1, 2, 2, 3, 1]

i = 0
array[Math.abs(arr[0])] = 2 양수를 음수로 변환

array = [1, -2, 2, 3, 1]

i = 1
array[Math.abs(arr[1])] = 2 양수를 음수로 변환

array = [1, -2, -2, 3, 1]

i = 2
array[Math.abs(arr[2])] = -2 음수이기때문에 중복값

i = 3
array[Math.abs(arr[3])] = 3 양수를 음수로 변환

array = [1, -2, -2, -3, 1]

i = 4
array[Math.abs(arr[4])] = -2 음수이기 때문에 중복값

중복된 값은 1, 2 이다.
```

```java
public class RepeatedIntegersProblem {

    public void solve(int[] array) {

        // 배열 수행
        for (int i = 0; i < array.length; i++) {
            // 양수이면, 음수로 변환
            if (array[Math.abs(array[i])] > 0) {
                // 음수 변환
                array[Math.abs(array[i])] = -array[Math.abs(array[i])];
            // 음수이면, 중복된 요소 출력
            } else {
                System.out.println("중복된 요소 : " + Math.abs(array[i]));
            }
        }
    }

}
```

```java
public class RepeatedIntegersProblemTest {
    public static void main(String[] args) {
        int[] array = {1, 2, 2, 3, 1};
        RepeatedIntegersProblem repeatedIntegersProblem = new RepeatedIntegersProblem();
        repeatedIntegersProblem.solve(array);
    }
}
```

```
중복된 요소 : 2
중복된 요소 : 1
```
