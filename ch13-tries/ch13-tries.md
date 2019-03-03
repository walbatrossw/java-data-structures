# Tries

## 1. HashMap 장단점

### 1.1 장점
- HashMap은 매우 효율적인 자료구조로 중요한 연산들에 O(1) 시간복잡도를 가진다.

### 1.2 단점
- HashMap은 정렬을 지원하지 않는다.
- Hash함수는 왼벽하지 않기 때문에 충돌이 발생하게 된다.

위의 단점을 보완할 수 있는 자료구조는 Trie로 HashMap에서 발생하는 충돌을 제거하고, 정렬을 지원한다.

## 2. Trie 기본 개념

![trie-pic1]()

- Tire / Radix Tree / Prefix Tree 라고 부른다.
- 배열을 통해 자료구조를 구현할 수 있다.
- key는 일반적으로 문자열(String)이다.
- Binary Search Tree와 달리 트리에 있는 노드는 지정된 노드와 연결된 키를 저장한다.
- 노드의 모든 하위 항목에는 해당 노드와 연결된 문자열의 공통 접두사가 있으며 루트 노드는 빈문자열을 저장한다.
- 값이 모든 노드에 저장되지 않고, 보통 마지막 노드(leaf node)에만 존재한다.

![trie-pic2]()

- 노드는 일반적으로 알파벳 수 만큼 하위노드를 가지고 있다. - 모든 노드에서 사용이 가능하도록 알파벳 사이즈 만큼의 상수를 미리 선언하는 것이 좋다.

```java
class Node {
  value;
  children[ALPHABET_SIZE] Node;
}
```

- 모든 노드들이 알파벳 수 만큼 하위노드를 가질 필요가 없을 경우가 존재하기 때문에 메모리 측면에서는 비효율적이다.

## 3. Trie 연산

### 3.1 삽입

Trie의 삽입 연산은 아래와 같이 이루어진다.

#### 3.1.1 "apple" 삽입

![trie-insert-apple]()

#### 3.1.2 "air" 삽입

![trie-insert-air]()

#### 3.1.3 "approve" 삽입

![trie-insert-approve]()

### 3.2 정렬

### 3.3 자동완성

## 4. Hashing과 Trie 비교