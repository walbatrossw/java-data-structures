> 본 글은 [Udemy의 자바 자료구조 강의](https://www.udemy.com/algorithms-and-data-structures/)를 듣고 개인적으로 
학습한 내용 복습하기 위해 작성된 글로 내용상 오류가 있을 수 있습니다. 오류가 있다면 지적 부탁 드리겠습니다.

# Queue

## 1. Queue?

### 1.1 Queue의 특징

- 삽입과 삭제가 양끝에서 각각 수행되는 자료구조
- 기본 연산 : enqueue(), dequeue(), shock()
- FIFO(First In First Out) : 선입선출 구조
- Dynamic array, Linked List로 구현이 가능
- BFS 알고리즘 구현에 중요

### 1.2 Queue의 Enqueue 연산

Enqueue 연산은 새로운 항목을 Queue의 끝에 추가하면 된다.

![queue-enqueue](https://github.com/walbatrossw/java-data-structures/blob/master/ch04-queues/img/queue-enqueue.gif?raw=true)

```java
queue.enqueue(10);
queue.enqueue(4);
queue.enqueue(20);
```

### 1.3 Queue의 Dequeue 연산

Dequeue 연산은 Queue의 첫번째 항목부터 제거하면 된다.

![queue-dequeue](https://github.com/walbatrossw/java-data-structures/blob/master/ch04-queues/img/queue-dequeue.gif?raw=true)

```java
queue.dequeue();
queue.dequeue();
```

## 2. Queue Implementation : Linked List

```java
public class Node<T extends Comparable<T>> {

    private T data;
    private Node<T> nextNode;

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
        return data.toString();
    }
}
```

```java
public class Queue<T extends Comparable<T>> {

    private Node<T> firstNode;
    private Node<T> lastNode;
    private int count;

    // Queue 공백 확인
    public boolean isEmpty() {
        return this.firstNode == null;
    }

    // Queue 사이즈
    public int size() {
        return this.count;
    }

    // O(1) 시간 복잡도
    public void enqueue(T newData) {
        this.count++;
        Node<T> oldLastNode = this.lastNode;
        this.lastNode = new Node<>(newData);
        this.lastNode.setNextNode(null);

        // Queue가 비어있으면
        if (isEmpty()) {
            this.firstNode = this.lastNode;
        // Queue가 비어있지 않으면
        } else {
            oldLastNode.setNextNode(this.lastNode);
        }
    }

    // O(1) 시간 복잡도
    public T dequeue() {
        this.count--;

        T dataToDequeue = this.firstNode.getData();
        this.firstNode = this.firstNode.getNextNode();

        if (isEmpty()) {
            this.lastNode = null;
        }
        return dataToDequeue;
    }
}
```

```java
public class App {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println(queue.size());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
```

```
5
1
2
3
```

## 3. Queue의 활용

- 리소스가 여러 쓰레드에 공유되는 경우 대기열에 저장 : CPU scheduling
- 두 프로세스 간에 비동기식으로 데이터가 전송되는 경우 : IO buffer
