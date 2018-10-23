# Binary Search Tree(이진 탐색 트리)

## 1. Binary Search Tree?

**이진 탐색 트리는 이진탐색의 개념을 트리 형태의 구조에 접목한 자료구조이다.**

### 1.1 Binary Search?
이진 탐색은 정렬된 데이터의 중간에 위치한 항목을 기준으로 데이터를 두 부분으로 나누어
가며 특정 항목을 탐색하는 방법이다.

### 1.2 Tree?
배열이나 연결리스트는 데이터를 일렬로 저장하기 때문에 탐색 연산이 순차적으로 수행되어야
한다는 단점을 가진다. 배열은 미리 정렬해 놓으면 이진탐색을 통해 효율적인 탐색이 가능하지만
삽입이나 삭제 후에도 정렬상태를 유지해야 하므로 삽입이나 삭제를 하는데 O(N) 시간이 소요된다.
이러한 문제를 보완한 것이 계층적 자료구조인 트리(Tree)이다.

트리는 실제 트리를 거꾸로 세워 놓은 형태의 자료구조로 HTML, XML, 자바 클래스 계층구조,
운영체제의 파일 시스템 등에서 쓰인다.

트리의 구성요소는 아래와 같다.

![tree](https://github.com/walbatrossw/java-data-structures/blob/master/ch05-binary-search-trees/img/tree.png?raw=true)

- Root Node : 트리 최상위에 있는 노드
- Child Node : 노드 하위에 연결된 노드
- Degree : 자식노드의 수
- Parent Node : 노드 상위에 연결된 노드
- Leaf Node : 자식이 없는 노드
- Level : Root 노드가 레벨 1에 있고, 아래 층으로 내려가면서 레벨이 1씩 증가
- Height : 트리의 최대 레벨
- Key : 탐색에 사용되는 노드에 저장된 정보

다른 모든 노드는 Root 노드를 통해서 접근이 가능하기 때문에 다른 노드로 가는 경로가
여러가지라면 그것은 Tree 구조가 아니다.

### 1.3 Binary Search Tree 특성

![binary-search-tree](https://github.com/walbatrossw/java-data-structures/blob/master/ch05-binary-search-trees/img/binary-search-tree.png?raw=true)

- 모든 노드는 최대 2개의 자식 노드(왼쪽, 오른쪽)를 가질 수 있다.
- 왼쪽 노드는 부모 노드보다 작다
- 오른쪽 노드는 부모 노드보다 크다.
- 키를 정렬된 상태로 유지하기 때문에 조회 및 다른 연산 작업에서 이진 탐색의 원리를
사용할 수 있다.
- 작업량이 트리의 절반을 건너뛰기때문에 조회, 삽입, 삭제는 트리에 저장된 항목 수의
로그와 비례한다.
- 정렬되지 않은 배열에서 키로 항목을 찾는데 필요한 O(N)보다는 낫지만 HashTable보다는
느리다.


## 2. Binary Search 연산

### 2.1 삽입

삽입 연산은 루트 노드부터 시작한다. 삽입하려는 데이터가 루트 노드의 데이터를 기준으로
크기가 크면 오른쪽, 작으면 왼쪽으로 자식 노드에 위치한다.

![binary-search-tree-insert](https://github.com/walbatrossw/java-data-structures/blob/master/ch05-binary-search-trees/img/binary-search-tree-insert.gif?raw=true)

```java
binarySearchTree.insert(12);
binarySearchTree.insert(4);
binarySearchTree.insert(5);
binarySearchTree.insert(20);
binarySearchTree.insert(1);
```

### 2.2 탐색


탐색 연산은 탐색하려는 데이터가 루트 노트보다 크면 오른쪽, 작으면 왼쪽 순으로 탐색하려는
데이터를 찾을 때까지 탐색 연산을 수행한다.

![binary-search-tree-find](https://github.com/walbatrossw/java-data-structures/blob/master/ch05-binary-search-trees/img/binary-search-tree-find.gif?raw=true)

```java
binarySearchTree.find(5);
```

가장 작은 노드를 찾을 경우에는 최대한 왼쪽으로 이동하면된다.

![binary-search-tree-find-smallest](https://github.com/walbatrossw/java-data-structures/blob/master/ch05-binary-search-trees/img/binary-search-tree-find-smallest.png?raw=true)

```java
binarySearchTree.find(1);
```

가장 큰 노드를 찾을 경우에는 최대한 오른쪽으로 이동하면 된다.

![binary-search-tree-find-largest](https://github.com/walbatrossw/java-data-structures/blob/master/ch05-binary-search-trees/img/binary-search-tree-find-largest.png?raw=true)

```java
binarySearchTree.find(20);
```

### 2.3 삭제

Binary Search Tree의 삭제 연산은 아래와 같이 3개의 경우의 수가 존재한다.

1. 제거할 노드가 leaf 노드인 경우
2. 제거할 노드가 하나의 자식 노드를 가진 경우
3. 제거할 노드가 2개의 자식 노드를 가진 경우

제거할 노드가 leaf 노드일 경우는 아래와 간단하게 제거하기만 하면 된다.

![binary-search-tree-remove-leaf-node](https://github.com/walbatrossw/java-data-structures/blob/master/ch05-binary-search-trees/img/binary-search-tree-remove-leaf-node.gif?raw=true)

```java
binarySearchTree.remove(5);
```

제거할 노드가 하나의 자식 노드를 가진 경우는 아래와 같이 참조값을 변경하기만 하면 된다.

![binary-search-tree-remove-single-child](https://github.com/walbatrossw/java-data-structures/blob/master/ch05-binary-search-trees/img/binary-search-tree-remove-single-child.gif?raw=true)

```java
binarySearchTree.remove(1);
```

제거할 노드가 2개의 자식 노드를 가진 경우 왼쪽 하위 트리에서 가장 큰 항목 또는 오른쪽
하위 트리에서 가장 작은 항목을 찾아 서로의 위치를 바꾸고, 노드를 제거한다.

![binary-search-tree-remove-two-child](https://github.com/walbatrossw/java-data-structures/blob/master/ch05-binary-search-trees/img/binary-search-tree-remove-two-child.png?raw=true)

왼쪽 하위 트리에서 가장 큰 항목을 찾아 제거했을 경우

![binary-search-tree-remove-two-child-left](https://github.com/walbatrossw/java-data-structures/blob/master/ch05-binary-search-trees/img/binary-search-tree-remove-two-child-left.gif?raw=true)

오른쪽 하위 트리에서 가장 큰 항목을 찾아 제거했을 경우

![binary-search-tree-remove-two-child-right](https://github.com/walbatrossw/java-data-structures/blob/master/ch05-binary-search-trees/img/binary-search-tree-remove-two-child-right.gif?raw=true)

```java
binarySearchTree.remove(32);
```

### 2.3 순회

이진탐색트리에서 수행되는 기본 연산들은 트리를 순회하면서 이루어지는데 이진탐색트리의
순회 방식은 다음과 같이 3가지로 나뉜다.

- In-order traversal : 중위 순회
- Pre-order traversal : 전위 순회
- Post-order traversal : 후위 순회

중위 순회는 왼쪽 하위 트리부터 루트 노드, 오른쪽 하위 트리 순으로 반복적으로 방문한다.

![in-order-traversal](https://github.com/walbatrossw/java-data-structures/blob/master/ch05-binary-search-trees/img/in-order-traversal.gif?raw=true)

전위 순회는 루트 노드부터 왼쪽 하위 트리, 오른쪽 하위 트리 순으로 반복적으로 방문한다.

![pre-order-traversal](https://github.com/walbatrossw/java-data-structures/blob/master/ch05-binary-search-trees/img/pre-order-traversal.gif?raw=true)

후위 순회는 왼쪽 하위 트리부터 오른쪽 하위트리, 루트 노드 순으로 반복적으로 방문한다.

![post-order-traversal](https://github.com/walbatrossw/java-data-structures/blob/master/ch05-binary-search-trees/img/post-order-traversal.gif?raw=true)


## 3. Binary Search Tree 구현

### 3.1 클래스 작성

아래와 같이 `Node`, `Tree`, `BinarySearchTree` 클래스와 인터페이스를 작성해준다.

```java
// 노드 클래스
public class Node<T> {

    private T data;             // 노드 데이터
    private Node<T> leftChild;  // 왼쪽 하위 노드
    private Node<T> rightChild; // 오른쪽 하위 노드

    // 생성자
    public Node(T data) {
        this.data = data;
    }

    // getter, setter, toString()
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return this.data.toString();
    }
}
```

```java
// 트리 인터페이스
public interface Tree<T> {

    public void insert(T data); // 삽입
    public T getMinValue();     // 최소값
    public T getMaxValue();     // 최대값
    public void traversal();    // 순회
    public void delete(T data); // 삭제

}
```

```java
// 이진 탐색 트리 클래스
public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root; // 루트 노드
    
        // 삽입
        @Override
        public void insert(T data) {
            
        }
        
        // 최소값 반환
        @Override
        public T getMinValue() {
            return null;
        }
        
        // 최대값 반환
        @Override
        public T getMaxValue() {
            return null;
        }
        
        // 순회 : 중위, 전위, 후위
        @Override
        public void traversal() {
    
        }
        
        // 삭제
        @Override
        public void delete(T data) {
    
        }
}
```

### 3.2 삽입

삽입 연산은 아래와 같다.

```java
// 삽입
@Override
public void insert(T data) {
    // 루트노드가 null 이면 루트 노드 삽입
    if (root == null) {
        root = new Node<>(data);
    // 아니면 하위노드에 삽입
    } else {
        insertNode(data, root);
    }
}
```

```java
// 삽입
private void insertNode(T newData, Node<T> node) {
    // 새로운 데이터가 기존의 데이터보다 작으면 : 왼쪽 하위노드
    if (newData.compareTo(node.getData()) < 0) {
        // 왼쪽 하위노드가 존재하면 하위노드에 삽입하기 위해 재귀호출
        if (node.getLeftChild() != null) {
            insertNode(newData, node.getLeftChild());
            // 왼쪽 하위노드가 없다면 노드를 생성, 상위노드의 왼쪽 하위노드에 설정
        } else {
            Node<T> newNode = new Node<>(newData);
            node.setLeftChild(newNode);
        }
        // 새로운 데이터가 기존의 데이터보다 크거나 같으면 : 오른쪽 하위노드
    } else {
        // 오른쪽 하위 노드가 존재하면 하위 노드에 삽입하기 위해 재귀호출
        if (node.getRightChild() != null) {
            insertNode(newData, node.getRightChild());
            // 오른쪽 하위 노드가 없다면 노드를 생성, 상위노드의 오른쪽 하위 노드에 설정
        } else {
            Node<T> newNode = new Node<>(newData);
            node.setRightChild(newNode);
        }
    }

}
```

### 3.3 최소 / 최대 값 반환

```java
// 최소값 반환
@Override
public T getMinValue() {
    if (root == null) {
        return null;
    }
    return getMin(root);
}

// 최대값 반환
@Override
public T getMaxValue() {
    if (root == null) {
        return null;
    }
    return getMax(root);
}
```

```java
// 최소값 : 가장 왼쪽에 위치한 노드가 최소값을 가지고 있다.
private T getMin(Node<T> node) {
    // 가장 왼쪽에 위치한 노드를 찾을 때까지 재귀호출
    if (node.getLeftChild() != null) {
        return getMin(node.getLeftChild());
    }
    return node.getData();
}

// 최대값 : 가장 오른쪽에 위치한 노드가 최대값을 가지고 있다.
private T getMax(Node<T> node) {
    // 가장 오른쪽에 위치한 노드를 찾을 때까지 재취호출
    if (node.getRightChild() != null) {
        return getMax(node.getRightChild());
    }
    return node.getData();
}
```

### 3.4 순회

```java
// 순회 : 중위, 전위, 후위
@Override
public void traversal() {
    if (root != null) {
        inOrderTraversal(root);
        System.out.println();
        preOrderTraversal(root);
        System.out.println();
        postOrderTraversal(root);
        System.out.println();
    }
}
```

```java
// 중위 순회
private void inOrderTraversal(Node<T> node) {
    if (node.getLeftChild() != null) {
        inOrderTraversal(node.getLeftChild());
    }
    System.out.print(node + " --> ");
    if (node.getRightChild() != null) {
        inOrderTraversal(node.getRightChild());
    }
}

// 전위 순회
private void preOrderTraversal(Node<T> node) {
    System.out.print(node + " --> ");
    if (node.getLeftChild() != null) {
        preOrderTraversal(node.getLeftChild());
    }
    if (node.getRightChild() != null) {
        preOrderTraversal(node.getRightChild());
    }
}

// 후위 순회
private void postOrderTraversal(Node<T> node) {
    if (node.getLeftChild() != null) {
        preOrderTraversal(node.getLeftChild());
    }
    if (node.getRightChild() != null) {
        preOrderTraversal(node.getRightChild());
    }
    System.out.print(node + " --> ");
}
```


### 3.5 삭제

```java
// 삭제
@Override
public void delete(T data) {
    if (root != null) {
        root = delete(root, data);
    }
}
```

```java
// 삭제
private Node<T> delete(Node<T> node, T data) {

    if (node == null) {
        return node;
    }

    // 삭제할 데이터가 현재 노드의 데이터보다 작으면 왼쪽 하위노드 탐색
    if (data.compareTo(node.getData()) < 0) {
        // 삭제 재귀 호출
        node.setLeftChild(delete(node.getLeftChild(), data));
    // 삭제할 데이터가 현재 노드의 데이터보다 크면 오른쪽 하위노드 탐색
    } else if (data.compareTo(node.getData()) > 0) {
        // 삭제 재귀 호출
        node.setRightChild(delete(node.getRightChild(), data));
    // 삭제할 데이터가 현재 노드의 데이터와 같으면 삭제
    } else {
        // 하위 노드가 없는 leaf 노드이면
        if (node.getLeftChild() == null && node.getRightChild()== null) {
            System.out.println("removing a leaf node...");
            return null;
        }
        // 왼쪽 하위노드가 null 이면 : 오른쪽 하위 노드만 있다면
        if (node.getLeftChild() == null) {
            System.out.println("removing the right child...");
            Node<T> tempNode = node.getRightChild();
            node = null;
            return tempNode;
        // 오른쪽 하위노드가 null 이면 : 왼쪽 하위 노드만 있다면
        } else if (node.getRightChild() == null) {
            System.out.println("removing the left child...");
            Node<T> tempNode = node.getLeftChild();
            node = null;
            return tempNode;
        }
        // 하위노드가 2개인 경우
        System.out.println("removing item with two children...");
        // 왼쪽의 하위 노드중에서 가장 큰 노드 탐색
        Node<T> tempNode = getPredecessor(node.getLeftChild());
        // 삭제하려는 노드와 왼쪽 하위노드에서 가장 큰 노드와 swap
        node.setData(tempNode.getData());
        // 삭제 재귀 호출
        node.setLeftChild(delete(node.getLeftChild(), tempNode.getData()));
    }

    return node;
}

// 왼쪽 하위노드에서 가장 큰 노드 탐색
private Node<T> getPredecessor(Node<T> node) {
    if (node.getRightChild() != null) {
        return getPredecessor(node.getRightChild());
    }
    System.out.println("Predecessor : " + node);
    return node;
}
```

