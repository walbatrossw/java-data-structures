# Linked List

## 1. Linked List란?

Linked List는 한 Node에서 다른 Node를 가리키는 참조/포인터로 구성되어 있고,
마지막 참조가 Null을 가리키고 있다.

![linked-list]()

하나의 노드는 `integer`, `double`, custom object와 같은 데이터를 포함하고 있으며
다음 노드를 가리키는 참조변수를 포함하고 있다.

![linked-list2]()

```
class Node<T> {
    T data;
    Node nextNode;
}
```

- 연결 리스트는 단순하고 매우 일반적인 데이터 구조로 Stack, Queue 등의 다른 일반적인
데이터 유형을 구현하는 데 사용할 수 있다.
- 연결리스트 자체로는 데이터에 대한 랜덤 액세스를 허용하지 않으므로 인덱스를
사용할 수 없다.
- 리스트의 마지막 노드를 가져오거나, 지정된 데이터가 들어 있는 노드를 찾거나,
새 노드를 삽입할 위치를 찾는 등의 많은 기본 작업을 수행하려면 대부분 또는 전체
리스트의 요소를 순차적으로 검사해야만 한다.


## 2. Linked List 장점

## 3. Linked List 단점

## 4. Linkde List 연산

### 4.1 Linked List 삽입 연산

### 4.1 Linked List 삭제 연산

## 5. Linked Listd의 문제점

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

## 6.3 메모리

- Array의 경우 추가적으로 메모리가 필요하지 않다.
- Linked List는 참조값 때문에 추가적으로 메모리가 필요하다.

## 7. Linked List 구현