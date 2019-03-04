> 본 글은 [Udemy의 자바 자료구조 강의](https://www.udemy.com/algorithms-and-data-structures/)를 듣고 개인적으로
학습한 내용 복습하기 위해 작성된 글로 내용상 오류가 있을 수 있습니다. 오류가 있다면 지적 부탁 드리겠습니다.

# Least Recently Used Cache

## 1. Cache 기본 개념

캐시는 데이터나 값을 미리 복사해 놓는 임시 장소를 가리킨다. 캐시는 접근 시간에 비해 원래 데이터를 접근하는 시간이 오래 걸리는 경우나 값을 다시 계산하는 시간을 절약하고 싶은 경우 사용한다. 캐시에 데이터를 미리 복사해 놓으면 계산이나 접근 시간 없이 더 빠른 속도로 데이터에 접근할 수 있다.

## 2. LRU Cache 기본 개념

LRU는 OS의 페이지 교체 알고리즘의 하나로 최근에 가장 오랫동안 사용하지 않은 페이지를 교체하는 기법이다. 캐시에 공간이 부족하면 가장 최근에 사용하지 않은 항목을 제거한다.

## 3. LRU Cache 구현

![lru-cache1](https://github.com/walbatrossw/java-data-structures/blob/master/ch12-least-recently-used-cache/img/lru-cache1.gif?raw=true)

LRU Cache 구현은 Doubly Linked List를 통해 구현한다. head에 가까운 데이터일수록 최근에 사용한 데이터이고, tail에 가까울수록 가장 오랫동안 사용하지 않은 데이터로 간주하여 새로운 데이터를 삽입할 때 가장 먼저 삭제되도록 한다.

![lru-cache2](https://github.com/walbatrossw/java-data-structures/blob/master/ch12-least-recently-used-cache/img/lru-cache2.gif?raw=true)

삽입된 데이터를 사용하게 되면 head로 옮겨 우선순위를 높이게 되고, 삭제될 우선순위에서 멀어지게 된다.


### 3.1 클래스 작성

```java
// 노드 클래스
public class Node {

    private int id;         // 해시테이블 키
    private String data;    // 해시테이블 데이터
    private Node prevNode;  // 이전 노드
    private Node nextNode;  // 다음 노드

    public Node() {
    }

    public Node(int id, String data) {
        this.id = id;
        this.data = data;
    }

    // getter, setter, toString
}
```

```java
// 이중연결리스트 클래스
public class DoublyLinkedList {

    private Node headNode;  // 첫번째 노드
    private Node tailNode;  // 마지막 노드

    // getter, setter
    public Node getHeadNode() {
        return headNode;
    }

    public void setHeadNode(Node headNode) {
        this.headNode = headNode;
    }

    public Node getTailNode() {
        return tailNode;
    }

    public void setTailNode(Node tailNode) {
        this.tailNode = tailNode;
    }
}
```

```java
// 캐시 크기를 상수로 선언한 클래스
public class Constants {

    public Constants() {
    }

    public static final int CAPACITY = 4;

}
```

```java
// LRU 캐시 클래스
public class LRUCache {

    private int actualSize;
    private Map<Integer, Node> map;
    private DoublyLinkedList linkedList;

    // 생성자
    public LRUCache() {
        this.map = new HashMap<>();
        this.linkedList = new DoublyLinkedList();
    }

    // 삽입 매서드
    // 노드 삽입 처리 메서드
    // tail 노드 삭제 메서드
    // 특정 노드 반환 + 반환된 노드를 head 노드로 변경 메서드
    // 캐시 출력 메서드
    // 업데이트 메서드

}
```

### 3.2 삽입 메서드

```java
// 삽입
public void put(int id, String data) {

    // 기존의 노드는 업데이트
    if (map.containsKey(id)) {
        Node node = this.map.get(id);
        node.setData(data);
        update(node);
        return;
    }

    // 새 노드 생성
    Node newNode = new Node(id, data);

    // 지정된 저장공간보다 실제 사이즈가 작으면 그대로 삽입 수행
    if (this.actualSize < Constants.CAPACITY) {
        this.actualSize++;
        add(newNode); // 삽입
    } else { // 지정된 저장공간보다 실제 사이즈가 크거나 같으면 마지막 노드를 제거하고 삽입 수행
        System.out.println("cache is full... remove tail");
        removeTail(); // 마지막 노드 제거
        add(newNode); // 삽입
    }
}
```

```java
// 노드 삽입 처리
private void add(Node newNode) {

    // 새 노드의 다음노드를 기존의 head 노드로 세팅 : 새노드 -> head 노드
    newNode.setNextNode(this.linkedList.getHeadNode());
    newNode.setPrevNode(null);

    // 기존의 head 노드의 이전노드를 새 노드로 세팅 : 새노드 <- head 노드
    if (linkedList.getHeadNode() != null) {
        linkedList.getHeadNode().setPrevNode(newNode);
    }

    // 새 노드를 head 노드로 세팅 : head 노드 = 새 노드
    linkedList.setHeadNode(newNode);

    // tail 노드가 없으면(즉, 첫번째로 삽입되는 노드) tail 노드를 새 노드로 세팅
    // tail 노드 = 새노드
    if (linkedList.getTailNode() == null) {
        linkedList.setTailNode(newNode);
    }

    // map에 저장
    this.map.put(newNode.getId(), newNode);

}
```

```java
// 연결리스트 변경
private void update(Node node) {

    // 이전, 다음 노드 추출
    Node prevNode = node.getPrevNode();
    Node nextNode = node.getNextNode();

    // head 노드가 아니면(middle 노드인 경우)
    if (prevNode != null) {
        // 이전노드 -> 노드 -> 다음노드
        // 이전노드 ---------> 다음노드
        prevNode.setNextNode(nextNode);
    } else { // head 노드인 경우
        // 노드(head) -> 다음노드
        // 다음노드(head) ->
        this.linkedList.setHeadNode(nextNode); // 다음노드를 head 노드로 세팅
    }

    // tail 노드가 아니면(middle 노드인 경우)
    if (nextNode != null) {
        // 이전노드 <- 노드 <- 다음노드
        // 이전노드 <-------- 다음노드
        nextNode.setPrevNode(prevNode);         
    } else { // tail 노드인 경우
        // 이전노드 -> 노드(tail)
        // -> 이전노드(tail)
        this.linkedList.setTailNode(prevNode);  // tail 노드를 이전노드로 변경
    }

    // 노드를 새로 삽입하여 head노드로 변경
    add(node);
}
```


### 3.3 tail 삭제 메서드

```java
// tail 노드 삭제
private void removeTail() {

    // tail 노드 추출
    Node lastNode = this.map.get(this.linkedList.getTailNode().getId());

    // tail 노드의 이전노드를 tail 노드로 변경
    // 이전 노드 -> tail 노드
    // 이전 노드(tail)
    this.linkedList.setTailNode(linkedList.getTailNode().getPrevNode());

    // 기존의 tail 노드를 null로 변경
    if (this.linkedList.getTailNode() != null) {
        this.linkedList.getTailNode().setNextNode(null);
    }

    lastNode = null; // 추출한 기존의 tail 노드를 null로 초기화
}
```

### 3.4 특정 노드 반환 처리 및 반환된 노드를 head 노드로 변경

```java
// 특정 노드 반환 + 반환된 노드를 head 노드로 변경
public Node get(int id) {

    // id에 대응되는 키값이 map에 존재하지 않으면 null 반환
    if (!this.map.containsKey(id)) {
        return null;
    }

    // id값에 해당하는 노드 추출
    Node node = this.map.get(id);

    // 추출한 노드를 head 노드로 변경
    update(node);
    return node;
}
```


### 3.5 캐시 출력

```java
// 캐시 출력
public void show() {
    Node actualNode = this.linkedList.getHeadNode();
    while (actualNode != null) {
        System.out.print(actualNode + " <--> ");
        actualNode = actualNode.getNextNode();
    }
    System.out.println();
}
```

### 3.6 테스트

```java
public class App {
    public static void main(String[] args) {

        LRUCache cache = new LRUCache();

        cache.put(0, "A");
        cache.show();
        cache.put(1, "B");
        cache.show();
        cache.put(2, "C");
        cache.show();
        cache.put(3, "D");
        cache.show();

        cache.put(4, "E");
        cache.show();

        cache.put(5, "F");
        cache.show();

        cache.put(6, "G");
        cache.show();

        System.out.println(cache.get(6));
        cache.show();

        System.out.println(cache.get(3));
        cache.show();

        System.out.println(cache.get(4));
        cache.show();

    }
}
```

```console
0 - A <-->
1 - B <--> 0 - A <-->
2 - C <--> 1 - B <--> 0 - A <-->
3 - D <--> 2 - C <--> 1 - B <--> 0 - A <-->
cache is full... remove tail
4 - E <--> 3 - D <--> 2 - C <--> 1 - B <-->
cache is full... remove tail
5 - F <--> 4 - E <--> 3 - D <--> 2 - C <-->
cache is full... remove tail
6 - G <--> 5 - F <--> 4 - E <--> 3 - D <-->
6 - G
6 - G <--> 5 - F <--> 4 - E <--> 3 - D <-->
3 - D
3 - D <--> 6 - G <--> 5 - F <--> 4 - E <-->
4 - E
4 - E <--> 3 - D <--> 6 - G <--> 5 - F <-->
```
