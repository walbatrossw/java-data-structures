# Binary Heaps(이진힙)

## 1. Priority Queue(우선순위큐)란?

이진힙을 알아보기에 앞서 우선순위큐에 대해 알아보자.

우선순위큐눈 가장 높은 우선순위를 가진 항목에 접근하거나 해당 항목을 삭제하는 연산과 임의의 우선순위를
가진 항목을 삽입하는 연산을 지원하는 자료구조이다. 스택, 큐는 일종의 우선순위큐이다.

우선순위큐의 특징은 아래와 같다.
- 모든 항목에는 추가 속성이 있는데 이것을 우선순위 값(priority value)라고 한다.
- 우선순위 큐에서는 우선순위가 높은 요소는 우선순위가 낮은 요소보다 먼저 처리된다.
- 우선순위 큐는 일반적으로 일반적으로 힙으로 구현되기도 하지만 자체 균형트리(self balancing tree)로도
구현될 수 있다.

## 2. Heap이란?

### 2.1 Heap의 기본 개념

Heap은 완전 이진 트리로서 부모의 우선순위가 자식의 우선순위보다 높은 자료구조이다. 이진트리와 달리 상위 노드보다 작은 값을 왼쪽 하위 노드에 큰 값을 오른쪽 하위 노드에 놓지 않는다. 즉, 삽입되는 데이터 순서대로 왼쪽, 오른쪽 하위노드에 위치시킨다.

![binary-heap-complete-binary-tree](https://github.com/walbatrossw/java-data-structures/blob/master/ch10-binary-heaps/img/binary-heap-complete-binary-tree.gif?raw=true)

이진힙은 Max Heap, Min Heap 2가지 종류가 있다.

![max-heap-min-heap](https://github.com/walbatrossw/java-data-structures/blob/master/ch10-binary-heaps/img/max-heap-min-heap.png?raw=true)

- Max Heap : 상위 노드의 키 >= 하위 노드의 키, 최상위 키가 루트 노드
- Min Heap : 상위 노드의 키 <= 하위 노드의 키, 최하위 키가 루트 노드

### 2.2 Array로 Heap표현

완전 이진 트리는 1차원 배열로 구현할 수 있는데 아래의 그림은 최대 힙을 나타낸 것으로 배열의 인덱스를 루트 노드부터 하위노드까지 차례로 채워나간 것을 확인할 수 있다.

![max-heap-array-presentation]()

그리고 위의 그림에서 볼 수 있듯이 상위노드의 인덱스를 통해 하위노드들의 인덱스를 계산하는 방법은 아래와 같다.

```
왼쪽 하위노드의 인덱스 = 부모노드의 인덱스 * 2 + 1
오른쪽 하위노드의 인덱스 = 부모노드의 인덱스 * 2 + 2
```

### 2.3 Heap의 연산

#### 2.2.1 삽입

heap에 데이터를 삽입하고 heap속성을 충족하는지 확인한 뒤 위반할 경우 heap 속성을 충족하도록 재구성을 하게 된다.

![max-heap-insert]()

#### 2.2.2 삭제

삭제하려는 항목을 제거한 뒤 그 자리에 마지막 항목을 놓고 다시 heap 속성이 충족되는지 확인하고 재구성을 한다.

![max-heap-remove]()

#### 2.2.3 Heapsort

## 3. Heap 구현 코드
