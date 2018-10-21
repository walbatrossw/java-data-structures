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

### 3.1