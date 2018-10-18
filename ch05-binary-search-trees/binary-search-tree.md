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

삽입 연산은 루트 노드부터 시작한다. 삽입하려는 데이터가 루트 노드보다 크면 오른쪽에
크기가 작으면 왼쪽에 서브 노드를 위치 시킨다.

![binary-search-tree-insert]()

```java
binarySearchTree.insert(12);
binarySearchTree.insert(4);
binarySearchTree.insert(5);
binarySearchTree.insert(20);
binarySearchTree.insert(1);
```

### 2.2 탐색

### 2.3 삭제

### 2.3 순회

