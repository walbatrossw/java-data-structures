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
- 이진탐색트리 연산 실행시간은 이진탐색트리의 높이에 따라 달라지는데 **최상의 성능을
얻으려면 트리의 균형을 유지해야한다.**
- AVL 트리에서 노드의 두 하위 트리의 높이의 차이가 **최대 1을 넘지 않는다.**
- AVL 트리는 엄격하게 균형을 유지하기 때문에 Red-black 트리보다 더 빠른 성능을
가지지만 **더 많은 작업이 필요하다.**
- 특히 운영체제의 경우 이러한 자료구조에 의존한다.
- 대부분의 **연산은 이진탐색트리와 동일하다.**
- 이진탐색트리와 동일하게 모든 노드는 최대 2개의 자식노드를 가질수 있고, 왼쪽
자식노드는 부모 노드보다 작고, 오른쪽 자식노드는 크다.
- 삽입 연산의 경우 이진탐색트리와 동일하지만 **모든 삽입연산은 트리가 균형을 유지하는지
확인을 해야한다.**
- 삭제, 최대/최소값 반환 연산 또한 마찬가지이다.

## 2. AVL Tree 연산

### 2.1 연산의 시간복잡도(Time Complexity)

AVL 트리의 기본연산은 이진탐색트리와 동일하지만 아래의 표를 보면 시간복잡도가 다르다.

|이진탐색트리|평균|최악|
|:---:|:---:|:---:|
|공간|O(N)|O(N)|
|삽입|O(logN)|O(N)|
|삭제|O(logN)|O(N)|
|탐색|O(logN)|O(N)|

|AVL트리|평균|최악|
|:---:|:---:|:---:|
|공간|O(N)|O(N)|
|삽입|O(logN)|**O(logN)**|
|삭제|O(logN)|**O(logN)**|
|탐색|O(logN)|**O(logN)**|

### 2.2 높이(Height)

AVL 트리는 노드의 높이를 알아야 모든 연산을 처리할 수 있기 때문에 높이에 대해서
알아보자.

![avl-tree-height1](https://github.com/walbatrossw/java-data-structures/blob/master/ch06-avl-trees/img/avl-tree-height1.png?raw=true)

노드의 높이는 leaf 노드까지 가장 긴 경로의 길이를 말한다.

- 20의 높이 : 2
- 40의 높이 : 1
- 10의 높이 : 0
- 30의 높이 : 0
- 50의 높이 : 0

이렇게 임의로 주어진 노드의 높이는 재귀호출을 통해 계산이 가능하다.

```
height = max(leftChild.height(), rightChild.height()) + 1
```

![avl-tree-height2](https://github.com/walbatrossw/java-data-structures/blob/master/ch06-avl-trees/img/avl-tree-height2.gif?raw=true)

AVL 트리의 연산 알고리즘은 노드의 높이를 항상 사용하기 때문에 높이를 가능한 작게
유지를 해야한다. 연산에서 높이를 매개변수로 저장하기 때문에 만약 높이가 높다면
변경되도록 수정되어야 한다.

- AVL 트리는 모든 노드의 왼쪽, 오른쪽 자식노드의 높이가 최대 +1, 최소 -1의 차이만
허용이 된다.


### 2.3 회전(Rotation)

AVL 트리에서 삽입, 삭제 연산을 수행할 때 트리의 균형을 유지하기 위해 LL-회전, RR-회전,
LR-회전, RL-회전연산이 사용된다. 각 회전연산은 두 종류의 기본적인 연산으로 구현된다.

- `rightRotate()` : 오른쪽 방향으로 회전
- `leftRotate()` : 왼쪽 방향으로 회전

`rightRotate()`은 왼쪽 방향의 서브트리가 높아서 불균형이 발생할 때 서브트리를
오른쪽 방향으로 회전하기 위한 메서드이고, `leftRotate()`는 오른쪽 방향의 서브트리가
높아서 불균형이 발생했을 때 왼쪽 방향으로 회전하기 위한 메서드이다.

![avl-tree-right-rotation]()

![avl-tree-left-rotation]()

위의 그림을 보면 오른쪽 또는 왼쪽 회전을 하더라도 중위 순회를 하면 노드를 순회하는
순서는 항상 같다. 즉, 회전을 통해 트리 구조의 불균형을 맞추는 작업만을 수행하는 것이다.

이제 구체적인 상황들을 통해 어떻게 회전을 수행하는지 알아보자.

#### 2.3.1 Case 1 : 왼쪽으로 트리가 치우쳐있을 경우

![avl-tree-rotation-case1-1]()

위의 그림을 보면 트리가 왼쪽으로 치우쳐있는데







#### 2.3.2

#### 2.3.3

#### 2.3.4


### 2.4


## 3. AVL Tree 구현
