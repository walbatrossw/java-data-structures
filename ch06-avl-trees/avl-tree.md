# AVL Tree

## 1. AVL Tree?

**

### 1.1 Linked List, Binary Search Tree, Balanced Binary Tree 비교

AVL 트리에 대해 알아보기 전에 3가지 트리의 차이점에 대해 알아보자.

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

![bst]()

이렇게 이진탐색트리에 정렬된 배열을 저장하면, 결국 연결리스트가 되고, 시간복잡도는
O(logN)이 아닌 O(N)이 된다.

### 1.2 AVL Tree의 특성



## 2. AVL Tree 연산

## 3. AVL Tree 구현
