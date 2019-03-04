> 본 글은 [Udemy의 자바 자료구조 강의](https://www.udemy.com/algorithms-and-data-structures/)를 듣고 개인적으로 
학습한 내용 복습하기 위해 작성된 글로 내용상 오류가 있을 수 있습니다. 오류가 있다면 지적 부탁 드리겠습니다.

# Linked List(연결 리스트)

## 1. Linked List란?

![linked-list](https://github.com/walbatrossw/java-data-structures/blob/master/ch02-linked-list/img/linked-list.png?raw=true)

**Linked List는 동적 메모리 할당을 이용해 리스트를 구현하는 가장 간단한 형태의 자료구조이다.
동적 메모리를 할당 받아 노드를 저장하고 노드는 참조를 이용하여 다음 노드를 가리키도록 만들어
노드들을 한 줄로 연결한다.**

하나의 노드는 `integer`, `double`, custom object와 같은 데이터를 포함하고 있으며
다음 노드를 가리키는 참조변수를 포함하고 있다.

### 1.1 Linked List의 구성

Linked List의 노드는 데이터와 참조값으로 구성되는데 참조값은 한노드에서 다른 노드를 가리키는
포인터 역할을 한다. 그리고 마지막 참조값은 null을 가리키게 된다.

![linked-list2](https://github.com/walbatrossw/java-data-structures/blob/master/ch02-linked-list/img/linked-list2.png?raw=true)

```java
class Node<T> {
    T data;
    Node nextNode;
}
```
### 1.2 Linked List 특성

- Linked List는 단순하고 매우 일반적인 데이터 구조로 Stack, Queue 등의 다른 일반적인
데이터 유형을 구현하는 데 사용할 수 있다.
- Linked List 자체로는 데이터에 대한 랜덤 액세스를 허용하지 않으므로 인덱스를
사용할 수 없다.
- 리스트의 마지막 노드를 가져오거나, 지정된 데이터가 들어 있는 노드를 찾거나,
새 노드를 삽입할 위치를 찾는 등의 많은 기본 작업을 수행하려면 대부분 또는 전체
리스트의 요소를 순차적으로 검사해야만 한다.

## 2. Linked List 장점

- 배열과 다르게 연결리스트는 동적 자료구조이기 때문에 런타임 시에 필요한 메모리를
할당 할 수 있다.
- 첫번째 요소 조작에 매우 효율적이다.
- 구현이 간편하다.
- 크기가 서로 다른 요소를 저장할 수 있다.
- Linked List의 크기는 유기적으로 확장할 수 있지만, 배열의 경우 최초에 배열의
크기를 미리 예측하여 결정해야하고, 확장해야할 경우에는 다시 생성해야만한다.

## 3. Linked List 단점

- 참조로 인해 메모리 낭비가 된다.
- 연결리스트는 항목을 탐색하려면 항상 첫 노드부터 원하는 노드를 찾을 때까지 차례로
방문하는 순차 탐색을 해야만한다.
- 역방향 이동에는 제약이 발생하기 때문에 이중연결리스트를 구현해야하고, 이렇게 되면
이전 노드의 참조가 필요하게 됨으로 메모리가 추가적으로 필요하게 된다.

## 4. Linkde List 연산

### 4.1 Linked List 삽입 연산 : 맨 앞에 노드를 삽입할 경우

![linked-list-insert-front](https://github.com/walbatrossw/java-data-structures/blob/master/ch02-linked-list/img/linked-list-insert-front.gif?raw=true)

```java
linkedList.insertAtStart(10); // 10 첫노드에 삽입
linkedList.insertAtStart(4);  // 4 첫노드에 삽입
linkedList.insertAtStart(-5); // -5 첫노드에 삽입
```

Linked List에 새로운 노드를 맨 앞에 삽입하는 방법은 새로운 노드의 참조값을 첫 노드로
변경하기만 하면 된다.

### 4.2 Linked List 삽입 연산 : 맨 뒤에 노드를 삽입할 경우

![linked-list-insert-last](https://github.com/walbatrossw/java-data-structures/blob/master/ch02-linked-list/img/linked-list-insert-last.gif?raw=true)

```java
linkedList.insertAtEnd(25); // 25 마지막 노드에 삽입
```

Linked List에 새로운 노드를 맨 마지막에 삽입하는 것은 비교적 간단하지는 않다.
연결리스트의 첫번째 노드부터 마지막 노드(참조값이 null인 노드)까지 탐색을 한 뒤
마지막 노드의 참조값을 새로운 노드로 변경하고, 새로운 노드의 참조값을 null을
가리키게 하면된다.

### 4.3 Linked List 삭제 연산 : 맨 앞의 노드를 삭제할 경우

![linked-list-remove-front](https://github.com/walbatrossw/java-data-structures/blob/master/ch02-linked-list/img/linked-list-remove-front.gif?raw=true)

```java
linkedList.removeStart()
```

Linked List의 첫 노드는 매우 빠르게 제거할 수 있다. 노드를 추가적으로 탐색할 필요가
없으므로 참조값만 변경하면 된다.

### 4.3 Linked List 삭제 연산 : 특정 데이터를 가진 노드를 삭제할 경우

![linked-list-remove-index](https://github.com/walbatrossw/java-data-structures/blob/master/ch02-linked-list/img/linked-list-remove-index.gif?raw=true)

```java
linkedList.remove(10)
```

Linked List에서 특정 데이터를 가진 노드를 제거하는 것은 빠르지 않을수도 있다.
만약 특정 데이터를 가진 노드가 마지막에 존재한다면 첫번째 노드부터 마지막 노드까지
탐색을 해야되기 때문이다. 특정 데이터를 가진 노드의 탐색을 완료한 뒤 특정 데이터를
가진 노드의 이전 노드가 다음 노드를 가리키도록 참조값을 변경해주면된다.

## 5. Linked Listd의 문제점

![linked-list-problem](https://github.com/walbatrossw/java-data-structures/blob/master/ch02-linked-list/img/linked-list-problem.png?raw=true)

위의 그림에서 보면 4에서 25까지 탐색을 수행할 수 있지만 역으로 25에서 4로 탐색을
수행할 수 없다. 그 이유는 참조 값의 반대방향이기 때문이다.

![doubly-linked-list](https://github.com/walbatrossw/java-data-structures/blob/master/ch02-linked-list/img/doubly-linked-list.png?raw=true)

이중 연결리스트 구현을 통해 역방향으로도 탐색이 가능하게 할 수 있다.
Doubly Linked List는 노드에 두개의 참조값을 가지는데 하나는 다음노드,
또다른 하나는 이전 노드를 가진다. 하지만 Doubly Linked List는 참조값이 2개이기
때문에 Linked List에 비해 메모리의 공간을 더 많이 차지하게 되는 단점이 존재한다.

## 6. Linked List와 Array 차이점

### 6.1 검색

- Array는 random access 가능하기 때문에 Linked List보다 검색이 빠르다.
- Array는 index를 통해 검색하는 속도가 빠르지만, Linked List는 특정 요소를 검색하기
위해 모든 항목을 탐색해야만 한다.

### 6.2 삭제

- Linked List의 삭제 작업은 참조값을 변경하면 되기 때문에 Array보다 빠르게 수행이
가능하다.
- Array의 경우 삭제 작업을 할 때 배열을 재구성해야하기 때문에 Linked List보다 상대적으로
느리다.

### 6.3 메모리

- Array의 경우 추가적으로 메모리가 필요하지 않다.
- Linked List는 참조값 때문에 추가적으로 메모리가 필요하다.

## 7. Linked List 구현

```java
// 노드 클래스
public class Node<T extends Comparable<T>> {

    private T data;             // 데이터
    private Node<T> nextNode;   // 다음 노드

    // Getter, Setter, toString 메서드
    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return this.data.toString();
    }
    
}
```

```java
// 리스트 인터페이스
public interface List<T> {

    public void insert(T data); // 삽입 연산
    public void remove(T data); // 삭제 연산
    public void traverseList(); // 리스트 전체 탐색
    public int size();          // 리스트 사이즈 반환

}
```

```java
// Linked List(연결리스트)
public class LinkedList<T extends Comparable<T>> implements List<T> {

    private Node<T> root;
    private int sizeOfList;

    @Override
    public void insert(T data) {
        // 사이즈 1증가
        ++this.sizeOfList;
        // 리스트가 비어있으면 첫노드를 새로운 노드로
        if (root == null) {
            this.root = new Node<>(data);
        // 리스트가 비어있지 않으면
        } else {
            insertDataBeginning(data);
        }
    }

    // 노드 추가 : 처음, O(1) 시간 복잡도
    private void insertDataBeginning(T data) {
        Node<T> newNode = new Node<>(data); // 새로운 노드 생성
        newNode.setNextNode(root);          // 새로운 노드의 다음 노드를 현재 root 노드로 설정
        this.root = newNode;                // root 노드를 새로운 노드로 변경
    }

    // 노드 추가 : 마지막 , O(N) 시간 복잡도
    private void insertDataAtEnd(T data, Node<T> node) {
        // 노드의 다음 노드가 null이 아니면, 즉 마지막 노드가 아니면
        if (node.getNextNode() != null) {
            // 재귀 호출
            insertDataAtEnd(data, node.getNextNode());
        // 마지막 노드이면
        } else {
            Node<T> newNode = new Node<>(data); // 새로운 노드 생성
            node.setNextNode(newNode);          // 마지막 노드의 다음노드(null)을 새로운 노드로 변경
        }
    }

    // 노드 삭제 : 특정 데이터를 가진 노드
    @Override
    public void remove(T data) {
        // 리스트가 비어있으면 메서드 종료
        if (this.root == null) {
            return;
        }
        --this.sizeOfList; // 사이즈 크기 1 감소
        // 데이터 비교 : 삭제할 데이터와 첫 노드의 데이터가 같으면
        if (this.root.getData().compareTo(data) == 0) {
            this.root = this.root.getNextNode(); // 첫노드를 첫노드의 다음 노드로 설정
        // 첫노드의 데이터와 삭제할 데이터가 다르면
        } else {
            // 해당 데이터를 가진 노드까지 탐색 후 삭제
            remove(data, root, root.getNextNode());
        }
    }

    // 특정 데이터를 가진 노드를 탐색 후 삭제처리
    private void remove(T dataToRemove, Node<T> prevNode, Node<T> actualNode) {
        // 리스트 전체 탐색
        while (actualNode != null) {
            // 데이터 비교 : 삭제할 데이터와 현재 노드의 데이터가 같으면 삭제처리
            if (actualNode.getData().compareTo(dataToRemove) == 0) {
                // 이전 노드의 다음 노드를 삭제할 노드의 다음 노드로 설정
                prevNode.setNextNode(actualNode.getNextNode());
                // 삭제할 노드를 null로 변경하고 메서드 종료
                actualNode = null;
                return;
            }
            // 다음 노드 탐색을 위해 이전노드, 다음노드 변경
            prevNode = actualNode;
            actualNode = actualNode.getNextNode();
        }
    }

    @Override
    public void traverseList() {
        // 리스트가 비어있으면 메서드 종료
        if (this.root == null) {
            return;
        }
        Node<T> actualNode = this.root;
        // 리스트 전체 탐색
        while (actualNode != null) {
            System.out.print(actualNode + " --> ");
            actualNode = actualNode.getNextNode();
        }
        System.out.println("null");
    }

    @Override
    public int size() {
        return this.sizeOfList;
    }
}
```

```java
// 리스트 테스트 클래스
public class App {
    public static void main(String[] args) {
        List<String> myLinkedList = new LinkedList<>();

        myLinkedList.insert("A");
        myLinkedList.insert("B");
        myLinkedList.insert("C");
        myLinkedList.insert("D");

        System.out.println(myLinkedList.size());
        myLinkedList.traverseList();

        myLinkedList.remove("D");
        myLinkedList.traverseList();

        myLinkedList.remove("A");
        myLinkedList.traverseList();
    }
}
```

```
// 테스트 결과
4
D --> C --> B --> A --> null
C --> B --> A --> null
C --> B --> null
```

## 8. Questions

### 8.1 Linked List의 가운데 노드 찾기

- Suppose we have a standard linked list. Construct an in-place (without
extra memory) algorithm thats able to find the middle node !

1. 첫번째 해결책 : 리스트를 반복하여 요소의 갯수(count)를 세고, 그 다음 리스트
를 count/2를 갖는 index를 갖는 노드까지 탐색면 그 노드가 가운데 노드이다.

2. 두번째 해결책 : 두개의 포인터를 사용한다. 첫번째 포인터는 한번에 한 노드씩
리스트를 탐색하고, 두번째 포인터는 한번에 두 노드씩 리스트를 탐색한다. 두번째 포인터가
마지막 노드에 도달했을 때 첫번째 포인터가 가리키는 노드가 가운데 노드이다.

```java
// List 인터페이스
public void reverse(); // 리스트 역방향으로 변환
```

```java
// LinkedList 클래스
// 가운데 노드 반환 메서드 구현
@Override
public Node<T> getMiddleNode() {

    Node<T> fastPointer = this.root;
    Node<T> slowPointer = this.root;

    // 마지막 노드까지 반복수행
    while (fastPointer.getNextNode() != null && fastPointer.getNextNode().getNextNode() != null) {
        fastPointer = fastPointer.getNextNode().getNextNode();
        slowPointer = slowPointer.getNextNode();
    }

    return slowPointer;
}
```

```java
// 리스트 테스트 클래스
public class App {
    public static void main(String[] args) {
        List<String> myLinkedList = new LinkedList<>();

        myLinkedList.insert("A");
        myLinkedList.insert("B");
        myLinkedList.insert("C");
        myLinkedList.insert("D");
        myLinkedList.insert("E");
        myLinkedList.insert("F");
        myLinkedList.insert("G");
        System.out.println(myLinkedList.getMiddleNode());
    }
}
```

```
// 결과 출력
D
```

### 8.2 Linked List 역방향으로 변환

- Construct an in-place algorithm to reverse a linked list!

1. 첫번째 해결책 : 모든 노드를 하나씩 고려한 다음 역순으로 Linked List를 구성하는
방법이 있는데 O(N) 공간복잡도를 가지기 때문에 적절한 해결책이 될수 없다.
2. 두번째 해결책 : 포인터를 사용하는 방법으로 아래와 같이 구현이 가능하다.

![linked-list-reverse](https://github.com/walbatrossw/java-data-structures/blob/master/ch02-linked-list/img/linked-list-reverse.gif?raw=true)

```java
@Override
public void reverse() {
    Node<T> currentNode = this.root;
    Node<T> prevNode = null;
    Node<T> nextNode = null;

    // 마지막 노드까지 반복수행
    while (currentNode != null) {
        nextNode = currentNode.getNextNode(); // 현재 노드의 다음노드를 다음노드로 세팅
        currentNode.setNextNode(prevNode);    // 현재 노드의 다음노드를 이전 노드로 변경 (역순으로 변경됨)
        prevNode = currentNode;               // 현재 노드를 이전노드로 세팅
        currentNode = nextNode;               // 다음 노드를 현재노드로 세팅
    }

    this.root = prevNode;
}
```

그렇다면 위의 코드가 어떻게 작동하는지 자세히 알아보자.

![linked-list-reverse1](https://github.com/walbatrossw/java-data-structures/blob/master/ch02-linked-list/img/linked-list-reverse1.png?raw=true)

아래의 코드와 같이 현재 `prevNode`, `nextNode`는 `null`을 가리키고, `currentNode`는
Liked List의 head인 `root`를 가리키고 있다.

```java
Node<T> currentNode = this.root;
Node<T> prevNode = null;
Node<T> nextNode = null;
```

![linked-list-reverse2](https://github.com/walbatrossw/java-data-structures/blob/master/ch02-linked-list/img/linked-list-reverse2.png?raw=true)

그리고 `while`반복문에서 첫번째로 현재노드(`currentNode`)의 다음노드를
`nextNode`에 세팅한다.

```java
nextNode = currentNode.getNextNode(); // 현재 노드의 다음노드를 다음노드로 세팅
```

![linked-list-reverse3](https://github.com/walbatrossw/java-data-structures/blob/master/ch02-linked-list/img/linked-list-reverse3.png?raw=true)

현재 노드(`currentNode`)의 다음노드(`nextNode`)를 이전노드(`prevNode`)로
변경해준다. 이렇게 하면 역순으로 변경이 된다.

```java
currentNode.setNextNode(prevNode);    // 현재 노드의 다음노드를 이전 노드로 변경 (역순으로 변경됨)
```

![linked-list-reverse4](https://github.com/walbatrossw/java-data-structures/blob/master/ch02-linked-list/img/linked-list-reverse4.png?raw=true)

이제 포인터를 뒤로 한 칸씩 이동시키기 위해 현재 노드(`currentNode`)를 이전
노드(`prev`)로 세팅한다.

```java
prevNode = currentNode; // 현재 노드를 이전노드로 세팅
```

![linked-list-reverse5](https://github.com/walbatrossw/java-data-structures/blob/master/ch02-linked-list/img/linked-list-reverse5.png?raw=true)

그리고 나서 다음노드(`nextNode`)를 현재 노드(`currentNode`)로 세팅한다.

```java
currentNode = nextNode; // 다음 노드를 현재노드로 세팅
```

이렇게 한 번의 반복이 끝나고, 현재 노드(`currentNode`)가 `null`일 때 까지 계속
while 반복문을 수행한다. 마지막에는 역순으로 바뀌기 전의 Linked List의 끝
노드(`preNode`)를 head(`root`)로 세팅을 하면 최종적으로 Liked List의 역순이
끝나게 된다.

아래와 같이 확인을 해보면 Linked List가 역순으로 바뀐 것을 확인할 수 있다.

```java
// 리스트 테스트 클래스
public class App {
    public static void main(String[] args) {
        List<String> myLinkedList = new LinkedList<>();

        myLinkedList.insert("A");
        myLinkedList.insert("B");
        myLinkedList.insert("C");
        myLinkedList.insert("D");
        myLinkedList.insert("E");
        myLinkedList.insert("F");
        myLinkedList.insert("G");
        myLinkedList.insert("H");
        myLinkedList.traverseList();
        myLinkedList.reverse();
        myLinkedList.traverseList();
    }
}
```

```
// 결과 확인
H --> G --> F --> E --> D --> C --> B --> A --> null
A --> B --> C --> D --> E --> F --> G --> H --> null
```