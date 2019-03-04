> 본 글은 [Udemy의 자바 자료구조 강의](https://www.udemy.com/algorithms-and-data-structures/)를 듣고 개인적으로 
학습한 내용 복습하기 위해 작성된 글로 내용상 오류가 있을 수 있습니다. 오류가 있다면 지적 부탁 드리겠습니다.

# Red-Black Tree

## 1. Red-Black Tree?

**레드블랙 트리는 노드에 색을 부여하여 트리의 균형을 유지하며,** 탐색, 삽입, 삭제
연산의 수행시간이 각각 O(logN)의 시간복잡도를 갖는 매우 효율적인 자료구조이다.

### 1.1 Red-Black Tree의 특성

![red-black-tree](https://github.com/walbatrossw/java-data-structures/blob/master/ch07-red-black-trees/img/red-black-tree.png?raw=true)

레드블랙트리는 아래와 같은 5가지 속성을 만족해야한다.

1. 각각의 노드는 레드이거나 블랙이어야한다.
2. 루트노트는 항상 블랙이다.
3. 모든 leaf 노드(NIL 또는 NULL)는 항상 블랙이다.
4. 모든 레드노드는 두 개의 블랙 자식노드와 블랙 부모노드를 가진다.
즉, 레드 노드가 연속해서 나올 수 없고, 블랙노드는 상관없다.
6. 루트노드부터 leaf노드까지의 경로에 있는 블랙노드의 수는 모두 같다.

그리고 레드블랙트리는 연산을 수행할 때 아래와 같은 과정을 거친다.

- 새로 삽입되는 노드는 레드가 기본값이다.
- 이진탐색, AVL 트리와 동일하게 삽입연산을 수행하지만 삽입될 때마다 레드블랙트리의
규칙을 위반하는지 확인한다.
- 레드블랙트리의 규칙을 위반한 경우 트리의 균형을 맞추기 위해 회전을 수행하거나,
노드의 색을 변경한다.

## 2. Red-Black Tree 연산

### 2.1 삽입 후 회전, 색변경

레드블랙트리는 삽입 연산은 이진탐색, AVL 트리와 동일하지만 레드블랙의 속성을 위반할
경우가 발생했을 때 트리를 회전하거나 노드의 색을 변경한다. 아래의 4가지 상황을 통해
레드블랙트리가 어떻게 회전을 수행하고 노드의 색을 변경하는지 알아보자.

#### 2.1.1 Case 1 : 삽입된 노드의 삼촌노드가 레드인 경우 : 색변경 수행

![red-black-tree-case1-1](https://github.com/walbatrossw/java-data-structures/blob/master/ch07-red-black-trees/img/red-black-tree-case1-1.png?raw=true)

위의 트리를 보면 삽입된 노드(x)의 **삼촌노드가 레드이고, 삽입된 노드가 오른쪽
자식노드인 경우이고, 대칭으로는 삽입된 노드가 왼쪽 자식노드인 경우이다.**

![red-black-tree-case1-2](https://github.com/walbatrossw/java-data-structures/blob/master/ch07-red-black-trees/img/red-black-tree-case1-2.gif?raw=true)

이 경우 위와 같이 부모노드와 삼촌노드를 블랙노드로 변경하고, 루트노드와 삽입된 노드(x)의
위치를 변경한다. 이렇게 되면 레드블랙트리의 2번 속성인 루트노드는 항상 블랙노드라는 규칙을
위반하게 되는데 이것은 트리 전체를 재귀적으로 돌면서 다시 체크한다. 이는 마치 AVL트리에서
삽입을 수행하고 트리 전체를 순회하면서 높이에 따른 불균형이 발생했을 때 회전을 수행하는 것과
동일하게 생각하면 된다.

#### 2.1.2 Case 2 : 삽입된 노드의 삼촌노드가 블랙이고, 오른쪽 자식노드인 경우 : 회전 수행

![red-black-tree-case2-1](https://github.com/walbatrossw/java-data-structures/blob/master/ch07-red-black-trees/img/red-black-tree-case2-1.gif?raw=true)

위 트리를 보면 삽입된 노드(x)의 **삼촌노드가 블랙이고, 삽입된 노드가 오른쪽 자식노드인
경우이다. 그리고 대칭으로는 삽입된 노드가 왼쪽 자식노드인 경우다.**

![red-black-tree-case2-2](https://github.com/walbatrossw/java-data-structures/blob/master/ch07-red-black-trees/img/red-black-tree-case2-2.gif?raw=true)

이 경우 위와 같이 삽입된 노드(x)의 부모노드에서 왼쪽으로 회전을 수행한다. 대칭으로는
삽입된 노드(x)의 부모노드에서 오른쪽으로 회전을 수행한다. 회전은 AVL트리와 마찬가지로
동일하게 수행한다. 이것 또한 레드노드가 연속해서 나오게되어 여전히 규칙 4번을 위반하고
있는데 이것은 Case 3에서 어떻게 변경되는지 보자.

#### 2.1.3 Case 3 : 삽입된 노드의 삼촌노드가 블랙이고, 왼쪽 자식노드인 경우 : 회전수행, 색변경

![]()

위의 트리를 보면 삽입된 노드(x)의 **삼촌노드가 블랙이고, 삽입된 노드가 왼쪽 자식노드인
경우이고, 대칭으로는 삽입된 노드가 오른쪽 자식노드인 경우다.**

![]()

이 경우는 case 3의 회전을 수행한 모습과 동일한데 먼저 오른쪽으로 회전을 수행한다. 그리고나서
삽입된 노드의 할아버지노드를 레드로 변경한다.

#### 2.1.4 Case 4 : 삽입된 노드의 삼촌노드가 레드이고, 왼쪽 자식노드인 경우

## 3. Red-Black Tree 구현
