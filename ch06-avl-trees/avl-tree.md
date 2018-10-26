# AVL Tree

## 1. AVL Tree?

**AVL트리는 트리가 한쪽으로 치우쳐 자라나는 현상을 방지하여 트리 높이의 균형을
유지하는 이진탐색트리이다.** Balanced 이진탐색트리를 만들면 N개의 노드를 가진
트리의 높이가 O(logN)이 되어 탐색, 삽입, 삭제 연산의 수행시간이 O(logN)이 보장된다.

### 1.1 Linked List, Binary Search Tree, Balanced Binary Tree 비교

AVL 트리에 대해 알아보기 전에 3가지 자료구조의 차이점에 대해 알아보자.

- Linked List
    - 구현이 쉬움
    - 많은 포인터(참조)를 저장
    - O(N) 시간복잡도를 가짐
- Binary Search Tree
    - 탐색의 O(N) 시간복잡도를 O(logN) 시간복잡도로 줄임
    - Unbalanced Tree일 경우 탐색의 속도는 느려짐
- Balanced Binary Tree(AVL Tree, Red-Black Tree)
    - 균형을 이루도록 보장
    - 항상 O(logN)의 시간복잡도를 보장

예를 들어 이진탐색트리에 정렬된 배열[1, 2, 3, 4]를 차례로 저장한다고 가정하면
아래와 같다.

![bst](https://github.com/walbatrossw/java-data-structures/blob/master/ch06-avl-trees/img/bst.png?raw=true)

이렇게 이진탐색트리에 정렬된 배열을 저장하면, 결국 연결리스트가 되고, 시간복잡도는
O(logN)이 아닌 O(N)이 된다.

### 1.2 AVL Tree의 특성
- 이진탐색트리 연산 실행시간은 이진탐색트리의 높이에 따라 달라지는데 최상의 성능을
얻으려면 트리의 균형을 유지해야한다.
- AVL 트리에서 노드의 두 하위 트리의 높이는 최대 하나까지만 다르다.
- AVL 트리는 엄격하게 균형을 유지하기 때문에 Red-black 트리보다 더 빠른 성능을
가지지만 더 많은 작업이 필요하다.
- 특히 운영체제의 경우 이러한 자료구조에 의존한다.
- 대부분의 연산은 이진탐색트리와 동일하다.
- 모든 노드는 최대 2개의 자식노드를 가질수 있고, 왼쪽 자식노드는 부모 노드보다 작고,
오른쪽 자식노드는 크다.
- 삽입 연산의 경우 이진탐색트리와 동일하지만 모든 삽입연산은 트리가 균형을 유지하는지
확인을 해야한다.
- 삭제, 최대/최소값 반환 연산 또한 마찬가지이다.

## 2. AVL Tree 연산

### 2.1 기본연산 - 탐색, 삽입

## 3. AVL Tree 구현